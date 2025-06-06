package Recursion;

public class Question9 {

    static int first = -1;
    static int last = -1;

    public static void findOccurrence(String str , int n , char e){

        if(n == str.length()){
            System.out.println("First Occurrence is at : " + first );
            System.out.println("Last Occurrence is at : " + last);
            return;
        }

        if(str.charAt(n) == e) {
            if (first == -1) {
                first = n;
            }
            last = n;
        }

        findOccurrence(str,n+1,e);

    }
    public static void main(String[] args) {
        // Find the first and the last occurrence of an element in the string
        String str = "abaacdaefaah";
        char e ='a';    // Find occurrence of a
        findOccurrence(str,0,e);
    }
}
