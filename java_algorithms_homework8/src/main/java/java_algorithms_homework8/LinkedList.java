package java_algorithms_homework8;

public class LinkedList {
    private Link  first;
    private Link  last;

    public LinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(Item link){
        Link  newLink = new Link (link);
        newLink.setNext(first);
        if (isEmpty())
            last = newLink;
        first = newLink;
    }

    public void insertLast (Item link){
        if (isEmpty())
            insertFirst(link);
        else {
            Link  newLink = new Link (link);
            last.setNext(newLink);
            last = newLink;
        }
    }

    public Item deleteFirst (){
        Link  temp = first;
        first = first.getNext();
        if (isEmpty())
            last = null;
        return temp.getValue();
    }

    public Item deleteLast (){
        Link  temp = last;
        if (first.getNext() == null){
            first=null;
            last=null;
        } else {
            Link  current = first.getNext();
            Link  previous = first;
            while (current.getNext()!=null){
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
        }
        return temp.getValue();
    }

    public Link  getFirst (){
        return first;
    }

    public void setFirst (Link  newFirst){
        first = newFirst;
    }

    public Link  getLast (){
        return last;
    }

    public void setLast (Link  newLast){
        last = newLast;
    }

    public void display () {
        Link  current = first;
        while (current!=null){
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    public Item find (Item searchNode){
        Link  findNode = new Link(searchNode);
        Link  current = first;
        while (current!=null){
            if (current.getValue().equals(findNode.getValue()))
                return current.getValue();
            else
                current = current.getNext();
        }
        return null;
    }

    public Item delete (Item searchNode){
        Link  deleteNode = new Link(searchNode);
        Link  current = first;
        Link previous = first;
        if (current.getValue().equals(deleteNode.getValue())){
            first = current.getNext();
            if (isEmpty())
                last = null;
            return current.getValue();
        } else {
            current = current.getNext();
            while (current!=null){
                if (current.getValue().equals(deleteNode.getValue())){
                    previous.setNext(current.getNext());
                    if (previous.getNext()==null)
                        last = previous;
                    return current.getValue();
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        return null;
    }
}
