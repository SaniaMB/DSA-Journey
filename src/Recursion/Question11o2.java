package Recursion;

public class Question11o2 {
        public static void moveXBothSides(String str, int i, int left, int right, char[] result) {
            if (i == str.length()) {
                System.out.println(result);
                return;
            }

            if (str.charAt(i) == 'x') {
                result[right] = 'x';
                moveXBothSides(str, i + 1, left, right - 1, result);
            } else {
                result[left] = str.charAt(i);
                moveXBothSides(str, i + 1, left + 1, right, result);
            }
        }

        public static void main(String[] args) {

            // Using two pointer approach  TC: O(n)

            String str = "axbxxd";
            char[] result = new char[str.length()];
            moveXBothSides(str, 0, 0, str.length() - 1, result);
        }
    }
