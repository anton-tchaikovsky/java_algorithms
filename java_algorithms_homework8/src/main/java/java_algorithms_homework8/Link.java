package java_algorithms_homework8;

public class Link  {
    private Item link;
    private Link next;

    public Link(Item link){
        this.link = link;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Item getValue(){
        return link;
    }
}
