# 最大不相交区间

## 题目
数轴上有n个区间[Ai,Bi]，要求选择尽量多的区间，并使得这些区间不存在交集。

## 思路
贪心策略，按照B1<=B2<=B3……的方式进行排序，然后从前向后遍历区间，每当遇到可以加入集合的区间，就把它加入集合。（集合代表解的集合）

```Java
   import java.util.Arrays;
   import java.util.Comparator;
   import java.util.Scanner;
   import java.util.Stack;
   
   //最大不相交区间问题
   public class zuiDaBuXiangJiaoQuJian {
       private static class Zone{
           int left;
           int right;
           public Zone(){
           }
       }
   
       public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           Zone z[] = new Zone[n];
           for(int i = 0;i < z.length;i++){
               z[i] = new Zone();
           }
   
           for(int i = 0;i < z.length; i++){
               z[i].left = in.nextInt();
               z[i].right = in.nextInt();
           }
           //按照zone.b进行排序
           Arrays.sort(z, new Comparator<Zone>() {
               @Override
               public int compare(Zone z1, Zone z2) {
                   return z1.right - z2.right;
               }
           });
           Stack<Zone> stack  = new Stack<>();
           int i = 1;
           Zone key = z[0];
           stack.push(z[0]);
           while(i < z.length){
               if(key.right < z[i].left){      //注意开闭区间，开区间为<=，闭区间为<
                   stack.push(z[i]);
                   key = z[i];
               }
               i++;
           }
           for(Zone zone : stack){
               System.out.println(zone.left + "," +zone.right);
           }
           System.out.println(stack.size());
       }
   }
```
