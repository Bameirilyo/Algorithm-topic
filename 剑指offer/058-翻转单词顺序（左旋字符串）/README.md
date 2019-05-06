# 058-翻转单词顺序

##题目
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

### 方法一：
```Java
public class N058 {
    public static String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length; i >0;i--){
            sb.append(a[i-1]);
            if(i > 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
```

### 方法二：
```Java
public class N058 {
    private static void reverseSentence(String str) {
        if(str==null)
            return;
        char[] arr=str.toCharArray();
        reverse(arr,0,arr.length-1);
        int start=0;
        int end=0;
        for(char i=0;i<arr.length;i++){
            if(arr[i]==' '){
                reverse(arr, start, end);
                end++;
                start=end;
            }else if(i==arr.length){
                end++;
                reverse(arr, start, end);
            }else{
                end++;
            }
        }
        for(char c:arr){
            System.out.print(c);
        }
    }
    private static void reverse(char[] arr,int start,int end) {
        for(int i=start,j=end;i<=j;i++,j--){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}
```

# 左旋字符串

##题目
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。

````Java
public class N0582 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb1 = new StringBuilder(str.substring(0, n));
        StringBuilder sb2 = new StringBuilder(str.substring(n, str.length()));
        sb2.append(sb1);
        return sb2.toString();
    }
}
````
