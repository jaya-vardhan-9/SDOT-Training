package aptimithra.day3;

import java.util.*;



public class longestHappyPrefix{

    public static String  longerprefix(String s){
        int n = s.length();
        int lps[] = new int[n];
        int len =0,i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int longerprefixlength=lps[n-1];
        return s.substring(0,longerprefixlength);

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longerprefix(s));

    }
}