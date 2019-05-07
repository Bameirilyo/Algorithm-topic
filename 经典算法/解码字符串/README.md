# 解码字符串

## 题目：

给定一个经过编码的字符串，返回它解码后的字符串。 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = “3[a]2[bc]”, 返回 “aaabcbc”.

s = “3[a2[c]]”, 返回 “accaccacc”.

s = “2[abc]3[cd]ef”, 返回 “abcabccdcdcdef”.

## 思路：

1. 没有中括号时正常运算，将结果存入res中

2. 遇到左括号时将res及括号之前的数字分别压栈

3. 遇到右括号时将取出左括号之前的数字（stack中取出），并加上左括号前的运算结果res（stack中取出），并拼接字符串：

stack中存入的是遇到左括号时①括号之前计算结果res，②括号之前的数字

````Java
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        // 记录'['之前的数字
        Stack<Integer> countStack = new Stack<>();
        // 记录'['之前的运算结果
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        int curNum = 0;
        while (idx < s.length()){
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(s.charAt(idx)))
                    curNum = 10 * curNum
                            + (s.charAt(idx++) - '0');
            } else if (ch == '[') {
                resStack.push(res);
                res = "";// 注意
                // 此push可以放在上面的while循环中
                countStack.push(curNum);
                curNum = 0;// 注意
                idx++;
                // 取出计算结果，和数字
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
                // 字母
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}

````
