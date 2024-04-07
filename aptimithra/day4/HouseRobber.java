package aptimithra.day4;

/**
 * HouseRobber
 */
import java.util.*;

public class HouseRobber {
    public static int rob(int[] nums){
        if(nums == null  || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],dp[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            
        }
        return dp[nums.length-1];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] moneyStr = sc.nextLine().split(",");
        int nums[] = new int[moneyStr.length];
        for(int i=0;i<moneyStr.length;i++){
            nums[i]=Integer.parseInt(moneyStr[i]);
        }
        System.out.println(rob(nums));



    }
}