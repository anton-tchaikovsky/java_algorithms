package java_algorithms_homework3;

public class StackChar {
    private int maxSize;
    private char[] stack;
    private int top;

    public StackChar(int size){
        this.maxSize = size;
        this.stack = new char[this.maxSize];
        this.top = -1;
    }

    public int getTop() {
        return top;
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }

    public void push(char i){
        this.stack[++top] = i;
    }

    public char pop(){
        return this.stack[top--];
    }


    public char peek(){
        return this.stack[this.top];
    }

}
