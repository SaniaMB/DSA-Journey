package Recursion;

import java.util.HashSet;

public class Question14 {
    public static HashSet<String> set = new HashSet<>();
    public static void sequences(String str,int n, String newString){

        if(n == str.length()){
            set.add(newString);
            return;
        }

        // to be
        sequences(str,n+1, newString + str.charAt(n));

        //not to be
        sequences(str,n+1,newString);
    }
    public static void main(String[] args) {
        // print all the unique subsequences of a string
        String str = "aaa";

        sequences(str,0,"");
        System.out.println(set);
    }
}
