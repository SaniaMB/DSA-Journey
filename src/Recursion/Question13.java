package Recursion;

public class Question13 {
    public static void sequences(String str,int n, String newString){

       if(n == str.length()){
          System.out.println(newString);
            return;
        }

       // to be
        sequences(str,n+1,newString+str.charAt(n));

       //not to be
         sequences(str,n+1,newString);
    }

    public static void main(String[] args) {
        // print all the subsequences of a string

        String str = "abc";

        sequences(str,0,"");

    }
}
