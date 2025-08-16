package Trie;

public class TrieImplementation {
    public static class Node{
        Node[] children;
        boolean endW;

        public Node(){
            this.children = new Node[26];  // a - z (256 if all characters)
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            this.endW = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){    // O(L)
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            if(i == word.length() - 1) curr.children[idx].endW = true;

            curr = curr.children[idx];
        }
    }

    public static boolean searchTrie(String key){
         Node curr = root;
        for(int i = 0; i < key.length(); i++){   // O(L)   L = Key Length
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null)
                return false;
            if(i == key.length() - 1 && !curr.children[idx].endW)
                return false;

            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"the","a","there","their","any"};
        for (String word : words) {
            insert(word);
        }
        System.out.println(searchTrie("their"));
        System.out.println(searchTrie("an"));
        System.out.println(searchTrie("thor"));
    }
}
