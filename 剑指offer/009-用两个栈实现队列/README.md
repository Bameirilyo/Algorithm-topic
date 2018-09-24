# 009-用两个栈实现队列
## 思路：
1. 入队操作：把元素压入stack1中即可；
2. 出队操作：stack2不为空时，弹出栈顶操作即可；stack2为空时，将stack1中的元素逐个弹出并压入stack2中，再弹出栈顶元素即可。
```Java
import java.util.Stack;

public class N009 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    
    public void push(int node){
        stack1.push(node);
    }
    
    public int pop() throws Exception {
        if (stack1 == null && stack2== null){
            throw new Exception("栈为空");
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
```
