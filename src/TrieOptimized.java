import java.util.Stack;

class Node {
    char c;
    Node[] children = new Node[26];
    boolean isLeaf;

    public Node() {
    }

    public Node(char c) {
        this.c = c;
    }
}

public class TrieOptimized {

    private Node root;

    public TrieOptimized() {
        root = new Node();
    }

    /**
     * @param children
     * @param character
     * @return
     */
    private boolean contains(Node[] children, char character) {
        if (children[character - 'a'] != null && children[character - 'a'].c == character)
            return true;

        return false;
    }

    /**
     * @param c
     * @return
     */
    private int index(char c) {
        return c - 'a';
    }

    /**
     * @param word
     */
    public void insert(String word) {
        Node[] children = root.children;

        char[] arr = word.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {

            char c = arr[i];
            Node n;

            if (contains(children, c)) {
                n = children[index(c)];
            } else {
                n = new Node(c);
                children[index(c)] = n;
            }

            children = n.children;

            if (i == arr.length - 1) {
                n.isLeaf = true;
            }
        }

    }

    /**
     * @param key
     * @return
     */
    public boolean search(String key) {
        Node n = searchHelper(key);

        if (n != null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @param key
     * @return
     */
    private Node searchHelper(String key) {

        Node[] children = root.children;
        Node n = null;

        char[] arr = key.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (contains(children, c)) {
                n = children[index(c)];
            } else {
                return null;
            }

            children = n.children;

        }

        if (n.isLeaf)
            return n;
        else
            return null;
    }

    /**
     *
     */
    public void walk() {
        dfsWalkRecursiveHelper(root, new StringBuilder());
        dfsWalkIterativeHelper(root, new Stack<Node>());
    }

    /**
     * @param node
     * @param s
     */
    private void dfsWalkRecursiveHelper(Node node, StringBuilder s) {
        if (node.isLeaf) {
            System.out.println(s.toString());
        }


        for (int i = 0; i < node.children.length; i++) {
            Node n = node.children[i];
            if (n != null) {
                char c = n.c;
                s.append(c);
                dfsWalkRecursiveHelper(n, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }


    /**
     * @param node
     */
    private void dfsWalkIterativeHelper(Node node, Stack<Node> stack) {

        for (int i = 0; i < node.children.length; i++) {
            Node n = node.children[i];
            if (n != null)
                stack.push(n);
        }
    }

}
