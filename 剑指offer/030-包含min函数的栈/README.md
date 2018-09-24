# 030-包含min函数的栈

## 思路：
用两个List分别保存数据和最小值的索引值，push了与最小值相同的元素时，不需要动mins中的元素，pop出的元素索引如果不是mins栈顶元素，mins也不出栈。获取最小值时，直接获取mins栈顶元素作为索引去data数组中找到相应的数。

时间复杂度O(1),空间复杂度O(n)。

```Java
import java.util.ArrayList;
import java.util.List;

public class N030 {
    private List<Integer> data = new ArrayList<>();
    private List<Integer> mins = new ArrayList<>();

    public void push(int num) throws Exception{
        data.add(num);
        if (mins.size() == 0){
            //如果mins为空，初始化mins，把索引0放进去
            mins.add(0);
        }else {
            //辅助栈mins push最小值的索引
            int min = getMin();
            if (num < min){
                mins.add(data.size() - 1);
            }
        }
    }

    public int pop() throws Exception{
        if (data.size() == 0){
            //栈空，抛出异常
            throw new Exception("栈为空");
        }
        //pop时先获取索引
        int popIndex = data.size() - 1;
        //获取mins栈顶元素，它是最小值的索引
        int minIndex = mins.get( mins.size() - 1);
        //如果pop出去的索引就是最小值索引，mins出栈
        if (popIndex == minIndex){
            mins.remove(mins.size() - 1);
        }
        return data.remove(data.size() - 1);
    }

    public int getMin() throws Exception{
        if (data.size() == 0){
            //栈空，抛出异常
            throw new Exception("栈为空");
        }
        //获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }

}
```