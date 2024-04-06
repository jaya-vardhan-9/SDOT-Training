package aptimithra.day3;

import java.util.*; 


class generateParenthesis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> result = Gp(n);
            for(String parenthesis:result){
            System.out.println(parenthesis);
        }
    }

    public static List<String> Gp(int n){
        List<String> combinations = new ArrayList<>();
        GpisHelper(combinations,"",0,0,n);
        return combinations;
    }

    private static void GpisHelper(List<String> combinations,String current,int
        open,int close,int n){
        if(current.length()==2*n){
        combinations.add(current);
        return;
    }

    if(open<n){
    GpisHelper(combinations,current+"(",open+1,close,n);
    }

    if(close<open){
    GpisHelper(combinations,current+")",open,close+1,n);
    }
 }

}