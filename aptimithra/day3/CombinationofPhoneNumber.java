package aptimithra.day3;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class CombinationofPhoneNumber {
    static String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void letterCombinations(String digits, String combination, List<String> result) {
        if (digits.length() == 0) {
            result.add(combination);
            return;
        }
        String letters = mapping[digits.charAt(0) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits.substring(1), combination + letters.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        List<String> result = new ArrayList<>();
        letterCombinations(digits, "", result);
        for (String combination : result) {
            System.out.print(combination + " ");
        }
    }
}
