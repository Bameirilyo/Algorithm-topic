# 从一个字符串中找出字典序最大子序列

## 说明：

字典序最大(不是递增)，例如 tt>t、sa>s、xe>xba

例：

字符串test的字典序最大子序列为tt

字符串abcde的字典序最大子序列为e

## 思路：

从后向前找，最后一个字符肯定包含在内，前面的字符大于后面的字符才能保证字典序最大；所以，从后往前找时，遇到比最后一个大的字符，留下当作倒数第二个字符，继续找到比倒数第二个字符大的当作第三个字符。。。。。。时间复杂度O(n)

````Java
import java.util.Scanner;

public class MaxString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ch = str.toCharArray();
        char[] chars = new char[50];
        for(int i = 0; i<ch.length;i++){
            int max = 0;
            int id = 50;
            for(i=ch.length-1;i>=0;i--) {
                if(ch[i] >= max) {
                    chars[--id] = ch[i];
                    max = ch[i];
                }
            }
            for(i=id;i<50;i++) {
                System.out.print(chars[i]);
            }
        }
    }
}

````
