class Pair{
    int value;
    int min;
    Pair(int value,int min){
        this.value=value;
        this.min=min;
    }
}
class MinStack {
    Stack<Pair>stack;
    
    
    public MinStack() {
        stack=new Stack<>();
        
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(new Pair(value,value));

        }else{
            int currMin=Math.min(value,stack.peek().min);
            stack.push(new Pair(value,currMin));
        }
       
         
        
    }
    
    public void pop() {
        stack.pop();
        
        
    }
    
    public int top() {
        return stack.peek().value;
       
        
    }
    
    public int getMin() {
        return stack.peek().min;
       
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */