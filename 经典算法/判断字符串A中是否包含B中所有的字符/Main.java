import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        //注：此题的输入为ABCD51NB;NB51，用分号分隔两个字符串
        String[] strs = inputStr.split(";");
        boolean k = compareStrings(strs[0],strs[1]);
        System.out.println(k);
    }

    public static boolean compareStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int acount=0,bcount=0;
        while (acount<a.length && bcount<b.length) {
            if (a[acount]==b[bcount]) {
                acount++;
                bcount++;
            }else {
                acount++;
            }
        }
        if (bcount == b.length) {
            return true;
        } else {
            return false;
        }
    }
}
