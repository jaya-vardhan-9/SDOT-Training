package aptimithra.day3;

import java.util.*;



class lengthOfLongestSubString {
    public static int lols(String s) {
        if (s == null || s.length() == 0) {
        return 0;
        }

        int n = s.length();
        int maxLength = 0;
        int start = 0;

        HashMap <Character, Integer> charIndexMap = new HashMap<>();
        
        for (int end = 0; end < n; end++) {
            if (charIndexMap.containsKey(s.charAt(end))) {
                start = Math.max(start, charIndexMap.get(s.charAt(end)) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            charIndexMap.put(s.charAt(end), end);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = lols(input);
        System.out.println( result);
        scanner.close();
    }
}