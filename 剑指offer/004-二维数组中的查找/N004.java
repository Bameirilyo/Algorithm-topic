public class N004 {
    public boolean Find(int[][] array,int target) {
        int row = 0;
        int col = array[0].length-1;
        while(row <= array.length-1 && col >= 0){
            if(target == array[row][col]) {
                return true;
            } else if(target > array[row][col]){
                row++;
            } else{
                col--;
            }
        }
        return false;
    }
}
