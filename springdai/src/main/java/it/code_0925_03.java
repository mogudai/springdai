package it;

/**
 * 有序数组找到 = num 最左的位置
 */
public class code_0925_03 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 9};
        int num = -1;
        System.out.println(mostLeftNoLessNumIndex(nums, num));
    }

    private static int mostLeftNoLessNumIndex(int[] nums, int num) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
