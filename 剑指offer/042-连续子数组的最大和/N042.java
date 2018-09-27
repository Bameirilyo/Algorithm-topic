public class N042 {
    public int getMaxSum(int[] arr){
        int res = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
