////给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
////
//// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
////
//// 你可以按任意顺序返回答案。
////
////
////
//// 示例 1：
////
////
////输入：nums = [2,7,11,15], target = 9
////输出：[0,1]
////解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
////
////
//// 示例 2：
////
////
////输入：nums = [3,2,4], target = 6
////输出：[1,2]
////
////
//// 示例 3：
////
////
////输入：nums = [3,3], target = 6
////输出：[0,1]
////
////
////
////
//// 提示：
////
////
//// 2 <= nums.length <= 10⁴
//// -10⁹ <= nums[i] <= 10⁹
//// -10⁹ <= target <= 10⁹
//// 只会存在一个有效答案
////
////
//// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
////
//// Related Topics 数组 哈希表 👍 15277 👎 0
//


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 两数之和
 *
 * @author DY
 * @date 2022-09-09 19:57:51
 */
public class P1_TwoSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1_TwoSum().new Solution();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(arr);
        System.out.println(lists);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            System.out.println(1);
            return null;
        }

        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                one:
                for (int j = 0; j < nums.length; j++) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    // 满足要求的第三个数 《nums[j+1]
                    int three = 0 - nums[i] - nums[j];
                    for (int k = 0; k < nums.length; k++) {
                        if (nums[k] == three && i != j && j != k && i != k) {
                            integers.add(nums[i]);
                            integers.add(nums[j]);
                            integers.add(nums[k]);
                            for (List<Integer> is : lists) {
                                if (is.indexOf(integers.get(0)) != -1 && is.indexOf(integers.get(1)) != -1) {
                                    continue one;
                                }
                            }
                            lists.add(integers);
                            continue one;
                        }
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
