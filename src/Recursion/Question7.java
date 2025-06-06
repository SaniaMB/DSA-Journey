package Recursion;

public class Question7 {
    /*
    using String Builder:
    public static void revString(String str, int n, StringBuilder sb) {
    if (n == 0)
        return;

    sb.append(str.charAt(n - 1)); // O(1)
    revString(str, n - 1, sb);
}
     */
    public static void revString(String str, int n){

        if(n == 0){
            System.out.println(str.charAt(n));
            return;
        }

        System.out.print(str.charAt(n));

        revString(str ,n-1 );

    }
    public static void main(String[] args) {
        // Print string in reverse

        String str = "abcd";

       /*  for( int i = str.length() - 1; i >=0 ; i-- ){
            System.out.println(str.charAt(i));
        }   */

        revString(str,str.length()-1);

        /*
             StringBuilder sb = new StringBuilder();

              revString("hello", 5, sb);

             System.out.println(sb.toString()); // prints "olleh"

         */
    }
}
