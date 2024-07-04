package prefix_trie;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("goal");
        trie.insert("goat");
        trie.insert("sun");
        trie.insert("sunday");
        trie.insert("sunlight");
        trie.insert("moon");
        trie.insert("milk");
        System.out.println(trie.startsWith("sun"));
        System.out.println(trie.search("sunbox"));
        System.out.println(trie.search("moon"));
        System.out.println(trie.startsWith("me"));
    }
}
