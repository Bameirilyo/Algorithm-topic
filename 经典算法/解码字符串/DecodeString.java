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
