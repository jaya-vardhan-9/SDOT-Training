import java.util.Stack;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
class longestparenthesis{
    
    static int lvp(String str){
        int n=str.length();
        Stack<Integer> stk=new Stack<>();
        stk.push(-1);
        int result=0;
        for (int i=0;i<n;i++)
        {
            if(str.charAt(i) == '(' )
            {
                stk.push(i);
            }
        else
        {
            if(!stk.isEmpty())
            {
                stk.pop();
            }
            if(!stk.isEmpty())
            {
                result=Math.max(result,i-stk.peek());
            }
            else{
                stk.push(i);
            }
        }
        }
    return result;
        
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        System.out.println(lvp(s1));
    }
}
