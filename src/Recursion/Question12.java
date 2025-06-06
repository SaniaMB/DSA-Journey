package Recursion;

public class Question12 {
    public static boolean[] map = new boolean[26];
    private static void removeDuplicate(String str, int n ,String newString){

        if(n == str.length()){
            System.out.println(newString);
            return;
        }

       char currChar = str.charAt(n);

       if(map[currChar- 'a'])
           removeDuplicate(str,n+1,newString);
       else{
           newString += currChar;
           map[currChar-'a'] = true;
           removeDuplicate(str,n+1,newString);
       }

    }

    public static void main(String[] args) {
        // Remove duplicates in a String
        // "abbccda" -> "abcd"

        String str = "abbccda";
        char[] str2 = new char[str.length()];

        removeDuplicate(str,0,"");


    }
}
