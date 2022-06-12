package java_algorithms_homework4;

public class DoubleLink <T> {
    private T link;
    private DoubleLink<T> next;
    private DoubleLink<T> prev;

    public DoubleLink(T link){
        this.link = link;
    }

    public DoubleLink<T> getNext() {
        return next;
    }

    public DoubleLink<T> getPrev() { return prev; }

    public void setNext (DoubleLink<T> next) { this.next = next; }

    public void setPrev(DoubleLink<T> prev) {this.prev = prev; }

    public T getValue(){
        return link;
    }
}
