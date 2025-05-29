package Basics;
public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        String reversed = "";

        // Loop from last character to first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i); // append character one by one
        }

        System.out.println(reversed);
    }
}
/*
// Problem: Reverse a String

public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed);
    }
}

 */