package Trie;
import static Trie.TrieImplementation.*;

public class StartsWithProb {
    public static boolean solution(String prefix){
        Node curr = root;
        int len = prefix.length();
        for(int i = 0; i < len; i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
    String[] words = {"apple","app","mango","man","women"};
    String prefix = "app";

    for (String word : words)
        insert(word);

    System.out.println(solution(prefix));

    }
}
