public class N010 {
    //斐波那契
    public static long fib(int n){
        int[] arr ={1,2};
        if (n < 2){
            return arr[n];
        }
        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

    //青蛙跳台阶问题
    public static long solution(int n){
        int[] arr ={1,2};
        if (n < 2){
            return arr[n];
        }
        long fib1 = 1;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

}
