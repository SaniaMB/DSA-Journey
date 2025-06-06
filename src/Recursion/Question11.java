package Recursion;

public class Question11 {
    public static void movingX(String str , int n ,int l, char[] str2 , int xCount){

        if( n == str.length()){
            for(int i = str.length() - xCount; i < str.length(); i++){
                str2[i] = 'x';
            }
            System.out.println(str2);
            return;
        }

        if(str.charAt(n) == 'x')
            movingX(str,n+1,l,str2,xCount+1);
        else {
            str2[l] = str.charAt(n);
            movingX(str, n + 1, l + 1, str2, xCount);
        }

    }
    public static void main(String[] args) {

        // Move all 'x' to the end of the string
        // str2 += str.charAt(n) gives O(n^2) TC

        String str = "axbxxd";
        char[] str2 = new char[str.length()];

        movingX(str,0,0,str2,0);


    }
}
