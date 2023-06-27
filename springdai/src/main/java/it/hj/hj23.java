package it.hj;

import java.util.*;

/**
 * 删除字符串中出现次数最少的字符
 * <p>
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * <p>
 * 数据范围：输入的字符串长度满足
 * 1
 * ≤
 * �
 * ≤
 * 20
 * <p>
 * 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * <p>
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * <p>
 * 示例1
 * 输入：
 * aabcddd
 * 输出：
 * aaddd
 */
public class hj23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = next.toCharArray();
            HashSet set = new HashSet();
            for (int i = 0; i < chars.length; i++) {
                if (map.get(chars[i]) == null) {
                    map.put(new Character(chars[i]), new Integer(1));
                } else {
                    map.put(chars[i], map.get(chars[i]) + 1);
                }
            }
            int minCount = Integer.MAX_VALUE;
            for(int count: map.values()){
                minCount = Math.min(count,minCount);
            }
            StringBuffer sub = new StringBuffer();
            for(int j=0;j<next.length();j++){
                char b = next.charAt(j);
                if(map.get(b) > minCount){
                    sub.append(b);
                }
            }
            System.out.print(sub);
        }
    }
}
