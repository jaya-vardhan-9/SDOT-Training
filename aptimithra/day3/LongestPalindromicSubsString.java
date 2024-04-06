package aptimithra.day3;

import java.util.*;
class  lengthOfLongestSubString{
    public static String longestPalindrome(String s) {
        String preprocessed = preProcess(s);
        int[] p = new int[preprocessed.length()];
        int center = 0, right = 0;

        for (int i = 1; i < preprocessed.length() - 1; i++) {
            int mirror = 2 * center - i;
            
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (preprocessed.charAt(i + 1 + p[i]) == preprocessed.charAt(i - 1- p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
            center = i;
            right = i + p[i];
            }
        }
          
        int maxLen = 0, bestCenter = 0;

        for (int i = 1; i < preprocessed.length() - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                bestCenter = i;
            }
        }
        return s.substring((bestCenter - maxLen) / 2, (bestCenter + maxLen) / 2);
    }

    private static String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^'); 

        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }

        sb.append("#$"); 
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = longestPalindrome(input);
        System.out.println(result);
        scanner.close(); 
    }
}
