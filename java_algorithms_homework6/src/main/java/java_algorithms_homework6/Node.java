package java_algorithms_homework6;

public class Node {
    final private int item;
    public Node  leftChild;
    public Node  rightChild;

    public Node(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    public void display(){
        System.out.println(item);
    }

}
