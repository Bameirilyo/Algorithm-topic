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
