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
