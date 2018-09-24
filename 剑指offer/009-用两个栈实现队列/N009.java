import java.util.Stack;

public class N009 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //入队
    public void push(int node){
        stack1.push(node);
    }

    //出队
    public int pop() throws Exception {
        if (stack1 == null && stack2== null){
            throw new Exception("队列为空");
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
