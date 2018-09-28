# 029-顺时针打印矩阵

## 题目：
输入一个矩阵，按照从外向里以顺时针的顺序依次打印。

|  1 |  2 |  3 |  4 |
|  5 |  6 |  7 |  8 |
|  9 | 10 | 11 | 12 |
| 13 | 14 | 15 | 16 |

则依次打印出数字：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10

## 思路：
1. 打印矩阵第一圈的左上角坐标是(0,0),第二圈的左上角坐标是(1,1)；所以每次选取坐标(start,start)作为一圈循环的起点；
2. 对于5*5的矩阵，最后一圈只有一个数字，坐标为(2,2),发现5>2*2;对于6*6的矩阵，最后一圈有4个数字，左上角坐标仍为(2,2),发现6>2*2成立;所以循环继续的条件为col>2*start && row>2*start;
3. 打印一圈分为以下四步：1.从左向右打印一行、2.从上到下打印一列、3.从右向左打印一行、4.从下到上打印一列；每一步根据起始坐标和终止坐标用一个循环打印出一行或一列。
4. 注意特殊情况：最后一圈可能只有一行、只有一列、一个数字的情况；打印一圈时第一步一定存在；如果只有一行，则不用第二步，因此打印第二步的前提条件是终止行号大于起始行号；
打印第三步的前提条件是圈内至少有两行两列，即“终止行号大于起始行号”与“终止列号大于起始列号”；
打印第四步的前提条件是圈内至少有三行两列，即“终止行号比起始行号至少大2”与“终止列号大于起始列号”；

```Java
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
```


