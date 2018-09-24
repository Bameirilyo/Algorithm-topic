public class N015 {
    public static int numberOfOne(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
