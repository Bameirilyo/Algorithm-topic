# 004-二维数组中的查找

## 题目：
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

## 思路：
利用二维数组由上到下，由左到右递增的规律，
那么选取右上角或者左下角的元素a[row][col]与target进行比较，
当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
即col--；
当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
即row++。

```Java
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

```