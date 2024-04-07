package aptimithra.day4;

import java.util.Scanner; 

public class editDistance { 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 
        String s1 = scanner.nextLine(); 
        String s2 = scanner.nextLine(); 
        int minOperations = calculateEditDistance(s1, s2); 
        System.out.println( minOperations); 
        scanner.close(); 

    } 


    private static int calculateEditDistance(String s1, String s2) { 
        int m = s1.length(); 
        int n = s2.length(); 
        int[][] dp = new int[m+1 ][n +1]; 
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0) { 
                    dp[i][j] = j; 
                } else if (j == 0) { 
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) { 
                    dp[i][j] = dp[i - 1][j - 1];
                } else { 
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]); 
                } 

            } 

        } 

        return dp[m][n]; 

    } 


    private static int min(int a, int b, int c) { 

        return Math.min(Math.min(a, b), c); 

    } 

} 