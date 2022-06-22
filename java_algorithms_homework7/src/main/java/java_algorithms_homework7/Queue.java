package java_algorithms_homework7;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue (int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;

    }
    public boolean isEmpty(){
        return (items==0);
    }
    public boolean isFull(){
        return (items==maxSize);
    }
    public int size(){
        return items;
    }

    public void insert(int i){

        if(rear == maxSize-1)
            rear = -1;
        queue[++rear] = i;
        items++;
    }

    public int remove (){
        int temp = queue[front++];
        if(front == maxSize)
            front=0;
        items--;
        return temp;
    }

    public int peek(){
        return queue[front];
    }
}
