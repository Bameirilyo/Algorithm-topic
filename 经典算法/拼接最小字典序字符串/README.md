# 拼接最小字典序字符串

## 题目
给定一个字符串类型的数组strs。找到一种拼接顺序，使得将所有字符串拼接起来组成的大字符串是所有可能性中字典序最小的，并返回这个大字符串。

举例：

strs=[“abc”,”de”]。可以拼成”abcde”,也可以拼成”deabc”,但前者字典顺序更小，所以返回“abcde”

strs=[“b”,”ba”]. 可以拼成“bba”和“bab”，后者字典序小，返回后者“bab”

如果字符串数组长度为n，则这道题的最优解的时间复杂度O(N*logN).实质是一种排序的实现，排序的结果就是拼接的顺序

````Java
import java.util.*;

public class Prior {
    public String findSmallest(String[] strs, int n) {
        // 这里使用插入排序
        for (int i = 1; i < strs.length; i++) {
            // 当前需要排序的元素
            String target = strs[i];
            // j标记当前位置
            int j = i;
            while(j>0 && (target+strs[j-1]).compareTo(strs[j-1]+target) < 0){
                strs[j] = strs[j-1];
                j--;
            }
            strs[j] = target;
        }
        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }

    //方法二，使用Arrays.sort()方法
    public String findSmallest2(String[] strs, int n) {
        if(strs == null){
            return null;
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String str1first = str1 + str2;
                String str2first = str2 + str1;
                return str1first.compareTo(str2first);
            }
        };
        Arrays.sort(strs, c);
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < n; i++){
            str.append(strs[i]);
        }
        return str.toString();
    }
}
````
