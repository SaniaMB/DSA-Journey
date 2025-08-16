package Trie;
import static Trie.TrieImplementation.*;

public class LongestWord {
    // Longest word with all prefixes
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
          if(root == null)
              return;

          for(int i = 0; i < 26; i++){
              if(root.children[i] != null && root.children[i].endW){
                  temp.append((char) (i +'a'));
                  if(temp.length() > ans.length())
                      ans = temp.toString();

              longestWord(root.children[i],temp );
              temp.deleteCharAt(temp.length() - 1);
              }
          }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(String word : words)
            insert(word);

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
