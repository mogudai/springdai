package it;
/**
 *
 * 选择排序  从索引值开始遍历整个数组，依次找到最小值，互换位置
 * */
public class code_0924_02 {

    public static void main(String[] args) {
        int[] nums = {4,1,9,7,25,33,46,57,34,28,14,18};
        for (int i = 0; i < nums.length; i++) {
            int minVlaueIndex=i;
            for (int j = i+1; j < nums.length ;j++) {
                minVlaueIndex = nums[j]<nums[minVlaueIndex]?j:minVlaueIndex;
            }
            swap(nums,i ,minVlaueIndex);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +"  ");
        }
    }

    private static void swap(int[] arr, int i, int minVlaueIndex) {
        int temp = arr[minVlaueIndex];
        arr[minVlaueIndex]=arr[i];
        arr[i]=temp;
    }
}
