package it;

/**
 * 冒泡排序  将大的值,往最后面排
 */
public class code_0924_03 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 9, 7, 25, 33, 46, 57, 34, 28, 14, 18};
        printArr(nums);
        System.out.println();
        boubbleSort(nums);
        printArr(nums);
    }

    private static void boubbleSort(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int minVlaueIndex) {
        int temp = arr[minVlaueIndex];
        arr[minVlaueIndex] = arr[i];
        arr[i] = temp;
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }
}
