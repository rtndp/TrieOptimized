import java.util.Stack;

class Node {
    char c;
    Node[] children = new Node[26];
    boolean isLeaf;

    //You can store a contact object instead of a String
    String word;

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
                n.word = word;
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
     * A public method to walk the trie
     */
    public void walk() {
        dfsWalkRecursiveHelper(root);
        System.out.println("");
        dfsWalkIterativeHelper(root);
    }

    /**
     * @param node
     */
    private void dfsWalkRecursiveHelper(Node node) {
        if (node.isLeaf) {
            System.out.println(node.word);
        }


        for (int i = 0; i < node.children.length; i++) {
            Node n = node.children[i];
            if (n != null) {
                dfsWalkRecursiveHelper(n);
            }
        }
    }


    /**
     * @param node
     */
    private void dfsWalkIterativeHelper(Node node) {

        Stack<Node> stack = new Stack<Node>();

        for (int i = node.children.length - 1; i >= 0; i--) {
            Node n = node.children[i];
            if (n != null)
                stack.push(n);
        }


        while (!stack.isEmpty()) {
            Node t = stack.pop();


            if (t.isLeaf) {
                System.out.println(t.word);
            }

            for (int i = t.children.length - 1; i >= 0; i--) {
                Node c = t.children[i];
                if (c != null) {
                    stack.push(c);
                }
            }
        }
    }

}
