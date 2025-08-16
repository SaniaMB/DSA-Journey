package Trie;
import static Trie.TrieImplementation.*;

public class WordBreakProb {

    public static boolean solve(String key) {
        if(key.isEmpty()) return true;

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0,i);
            String secPart = key.substring(i);

            if(searchTrie(firstPart) && solve(secPart))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] words = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesamsung";

        for (String word : words)
            insert(word);

        System.out.println(solve(key));
    }
}
