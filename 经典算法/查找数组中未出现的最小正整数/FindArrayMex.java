public class FindArrayMex {
    public int findArrayMex(int[] A, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n){
                res[A[i]-1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == 0){
                return i+1;
            }
        }
        return n+1;
    }
}
