package it;

/**
 * 有序数组从小到大 二分查找
 */
public class code_0925 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 9};
        int num = 5;
        System.out.println(find(nums, num));
    }

    private static boolean find(int[] nums, int num) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l=0;
        int r= nums.length-1;
        while (l<=r){
            int mid= (l+r)/2;
            if(nums[mid]==num){
                return true;
            }else if(nums[mid]<num){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return false;
    }


}
