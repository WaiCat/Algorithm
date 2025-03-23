package Algorithm.LeetCode;

import java.util.Arrays;

public class SquaresofaSortedArray {

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[left] * nums[left] > nums[right] * nums[right]) {
                res[i] = nums[left] * nums[left];
                left++;
            }else{
                res[i] = nums[right] * nums[right];
                right--;
            }
        }

        left = 0;
        right = res.length - 1;
        while (left < right) {
            int temp = res[left];
            res[left++] = res[right];
            res[right--] = temp;
        }

        return res;
    }
}
