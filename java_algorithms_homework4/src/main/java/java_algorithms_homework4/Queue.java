package java_algorithms_homework4;

public class Queue <T> {
    private DoubleLinkedList <T> queue;

    public Queue (){
        queue = new DoubleLinkedList<T>();
    }

    public void insert (T item){
        queue.insertLast(item);
    }

    public T remove (){
        return queue.deleteFirst();
    }

    public T peek (){
        return queue.getFirst().getValue();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void display(){
        queue.display();
    }
}
