public class N058 {

    /**
     * 方法一
     * @param str
     * @return
     */
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



    /**
     * 方法二
     * @param str
     */
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
