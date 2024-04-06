package aptimithra.day3;

import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        String input=scn.nextLine();
        String[] ea=input.split("\\s+");
        
        int[] elements=new int[ea.length];
        
        for(int i=0;i<ea.length;i++){
            elements[i]=Integer.parseInt(ea[i]);
        }
        
        generatePermutations(elements,0);
        scn.close();
    }

    private static void generatePermutations(int[] nums,int start){
        if(start==nums.length-1){
            printArray(nums);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            generatePermutations(nums,start+1);
            swap(nums,start,i);
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void printArray(int[] nums) {

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
   }
   

