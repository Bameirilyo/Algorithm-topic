# RGB字符串排序

将输入的乱序R\G\B字符串按RRRGGGBBB方式排序

````Java
import java.util.Scanner;

public class StringSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] a = str.toCharArray();
        fun(a,str.length());
        for (int i = 0; i < str.length(); i++){
            System.out.print(a[i]);
        }
    }
    public static void fun(char a[], int n) {
        int i = -1;
        while (a[i+1] == 'R') {
            i++;
        }
        int j = n;
        while (a[j-1] == 'B') {
            j--;
        }
        int p = i+1;
        while (p < j) {
            if (a[p] == 'R') {
                i++;
//                swap(a[p], a[i]);
                char temp = a[p];
                a[p] = a[i];
                a[i] = temp;
                while (a[i+1] == 'R') {
                    i++;
                }
                if (a[p] == 'B') {
                    continue;
                }
            } else if (a[p] == 'B') {
                j--;
//                swap(a[p], a[j]);
                char temp2 = a[p];
                a[p] = a[j];
                a[j] = temp2;
                while (a[j-1] == 'B') {
                    j--;
                }
                if (a[p] == 'R') {
                    continue;
                }
            }
            p++;
        }
    }
}

````
