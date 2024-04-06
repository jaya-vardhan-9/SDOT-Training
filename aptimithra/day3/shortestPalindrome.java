package aptimithra.day3;

import java.util.Scanner;

public class shortestPalindrome {
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String input=sc.nextLine();
    sc.close();
    String shortpalindrome=shortpalindrome(input);
    System.out.println(" "+shortpalindrome);
 }
    public static String shortpalindrome(String s){
        int i=0, j=s.length()-1;
        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
            i++;
            }
        j--;
        }
        if(i==s.length()){
            return s;
        }
        StringBuilder sb=new StringBuilder(s.substring(i)).reverse();
        return sb.toString()+s;
    }
}

