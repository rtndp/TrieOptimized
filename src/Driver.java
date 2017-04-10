
public class Driver {

    public static void main(String[] args) {
        TrieOptimized to = new TrieOptimized();
        to.insert("car");
        to.insert("card");
        to.insert("cards");
        to.insert("cord");
        to.insert("cold");
        to.insert("come");
        to.insert("comfort");
        to.insert("cash");
        to.insert("cam");


        /*System.out.println(to.search("ca"));
        System.out.println(to.search("car"));
        System.out.println(to.search("cars"));
        System.out.println(to.search("card"));
        System.out.println(to.search("cards"));
        System.out.println(to.search("CARDS"));
        System.out.println(to.search("Cards"));
        System.out.println(to.search("Cardz"));*/

        to.walk();
    }
}
