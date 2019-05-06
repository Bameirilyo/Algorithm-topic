# 012-矩阵中的路径
## 题目：
请设计一个函数，用来推断在一个矩阵中是否存在一条包括某字符串全部字符的路径。路径能够从矩阵中随意一格開始。每一步能够在矩阵中间向左、右、上、下移动一格。假设一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

举例分析

比如在以下的3*4的矩阵中包括一条字符串”bcced”的路径。

但矩阵中不包括字符串“abcb”的路径，因为字符串的第一个字符b占领了矩阵中的第一行第二格子之后，路径不能再次进入这个格子。

a b c e

s f c s

a d e e

## 解题思路:
这是一个能够用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。假设矩阵中某个格子的字符为ch，那么这个格子不可能处在路径上的第i个位置。假设路径上的第i个字符不是ch。那么这个格子不可能处在路径上的第i个位置。假设路径上的第i个字符正好是ch。那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其它格子都有4个相邻的格子。反复这个过程知道路径上的全部字符都在矩阵中找到相应的位置。

因为回朔法的递归特性，路径能够被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后。在与第n个字符相应的格子的周围都没有找到第n+1个字符。这个时候仅仅要在路径上回到第n-1个字符。又一次定位第n个字符。

因为路径不能反复进入矩阵的格子。还须要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。

当矩阵中坐标为（row,col）的格子和路径字符串中下标为pathLength的字符一样时。从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下标为pathLength+1的字符。

假设4个相邻的格子都没有匹配字符串中下标为pathLength+1的字符，表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不对，我们须要回到前一个字符(pathLength-1)，然后又一次定位。

一直反复这个过程，直到路径字符串上全部字符都在矩阵中找到合适的位置。

```Java
/**
用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归
*/
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }
 
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
```
