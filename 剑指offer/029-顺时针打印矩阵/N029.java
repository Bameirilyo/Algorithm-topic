public class N029 {
    public void print(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        if (arr == null || rows <= 0 || columns <= 0){
            return ;
        }
        int start = 0;
        while (rows > 2 * start && columns > 2 * start){
            print(arr, rows, columns, start);
            start++;
        }
    }

    public void print(int[][] arr, int rows, int columns, int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左向右打印一行
        for (int i = start; i <= endX; i++){
            System.out.print(arr[start][i] + ",");
        }

        //从上到下打印一列
        if (start < endY){
            for (int i = start + 1; i <= endY; i++){
                System.out.print(arr[i][endX] + ",");
            }
        }

        //从右向左打印一行
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--){
                System.out.print(arr[endY][i] + ",");
            }
        }

        //从下到上打印一列
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start - 1; i--){
                System.out.print(arr[i][start] + ",");
            }
        }
    }
}
