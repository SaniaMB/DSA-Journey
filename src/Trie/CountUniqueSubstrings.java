package Trie;
import java.util.ArrayList;
import java.util.List;
import static Trie.TrieImplementation.*;

public class CountUniqueSubstrings {
    static int count = 0;
    public static void countString(String str){
        Node curr = root;
        for(int i = 0; i < str.length(); i++){         // Counting Nodes while Constructing a Trie
            int idx = str.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
                count++;
            }
            curr = curr.children[idx];
        }
    }

    public static int method2(Node root){
        if(root == null) return 0;

        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null)
               count += method2(root.children[i]);
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";
        List<String> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            list.add(str.substring(i));
        }

        for(String word : list)
            countString(word);

        // Or

        for(String word : list)
            insert(word);         // First constructing the Trie

        System.out.println(list);
        System.out.println(count+1);
        System.out.println(method2(root));  // same result
    }
}
