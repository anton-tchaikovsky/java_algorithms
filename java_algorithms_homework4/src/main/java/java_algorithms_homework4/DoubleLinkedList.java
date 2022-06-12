package java_algorithms_homework4;

public class DoubleLinkedList <T> {
    private DoubleLink <T> first;
    private DoubleLink <T> last;

    public DoubleLinkedList(){
        first = null;
        last = null;
    }

    /**
     * Метод проверяет, пустой ли список.
     * @return true - список пустой, false - список не пустой.
     */
    public boolean isEmpty() {
        return (first == null || last == null); // Проверка "или" необходима для корректной работы
    }                                           // методов deleteFirst и deleteLast.

    /**
     * Метод вставляет объект link в начало списка.
     * @param link
     */
    public void insertFirst(T link){
        DoubleLink <T> newLink = new DoubleLink<>(link);
        newLink.setNext(first);
        newLink.setPrev(null);
        if (isEmpty())
            last = newLink;
        else
            first.setPrev(newLink);
        first = newLink;
    }

    /**
     * Метод вставляет объект link в конец списка.
     * @param link
     */
    public void insertLast (T link){
        DoubleLink <T> newLink = new DoubleLink<>(link);
        newLink.setNext(null);
        newLink.setPrev(last);
        if (isEmpty())
            first = newLink;
        else
            last.setNext(newLink);
        last = newLink;
    }

    /**
     * Метод осуществляет поиск объекта searchNode путем перебора объектов списка от first к last.
     * @param searchNode
     * @return искомый объект или null, если такого объекта нет в списке.
     */
    public T find (T searchNode){
        DoubleLink <T> findNode = new DoubleLink<>(searchNode);
        DoubleLink <T> current = first;
        while (current!=null){
            if (current.getValue().equals(findNode.getValue()))
                return current.getValue();
            else
                current = current.getNext();
        }
        return null;
    }

    /**
     * Метод осуществляет поиск объекта searchNode путем перебора объектов списка от last к first.
     * @param searchNode
     * @return искомый объект или null, если такого объекта нет в списке.
     */
    public T findReverse (T searchNode){
        DoubleLink <T> findNode = new DoubleLink<>(searchNode);
        DoubleLink <T> current = last;
        while (current!=null){
            if (current.getValue().equals(findNode.getValue()))
                return current.getValue();
            else
                current = current.getPrev();
        }
        return null;
    }

    /**
     * Метод удаляет первый объект в списке.
     * @return первый объект в списке или null, если список пуст.
     */
    public T deleteFirst (){
        if (isEmpty())
            return null;
        DoubleLink <T> temp = first;
        first = first.getNext();
        if (isEmpty())
            last = null;
        else
            first.setPrev(null);
        return temp.getValue();
    }

    /**
     * Метод удаляет последний объект в списке.
     * @return последний объект в списке или null, если список пуст.
     */
    public T deleteLast (){
        if (isEmpty())
            return null;
        DoubleLink <T> temp = last;
        last = last.getPrev();
        if (isEmpty())
            first = null;
        else
            last.setNext(null);
        return temp.getValue();
    }

    /**
     * Метод осуществляет поиск объекта searchNode и удаляет его из списка.
     * @param searchNode
     * @return удаляемый объект или или null, если такого объекта нет в списке.
     */
    public T delete (T searchNode){
        if (isEmpty())
            return null;
        DoubleLink <T> deleteNod = new DoubleLink<>(searchNode);
        DoubleLink <T> current = first;
            while (!current.getValue().equals(deleteNod.getValue())){
                if (current.getNext()==null)
                    return null;
                current = current.getNext();
            }
        if(current == first)
            return deleteFirst();
        else if (current == last)
            return deleteLast();
        else{
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            return current.getValue();
        }
    }

    public DoubleLink <T> getFirst (){
        return first;
    }

    public void setFirst (DoubleLink <T> newFirst){
        first = newFirst;
    }

    public DoubleLink <T> getLast (){
        return last;
    }

    public void setLast (DoubleLink <T> newLast){
        last = newLast;
    }

    /**
     * Метод выводит в консоль объекты списка в порядке от first к last.
     */
    public void display () {
        DoubleLink <T> current = first;
        while (current!=null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    /**
     * Метод выводит в консоль объекты списка в порядке от last к first.
     */
    public void displayReverse () {
        DoubleLink <T> current = last;
        while (current!=null){
            System.out.println(current.getValue());
            current = current.getPrev();
        }
    }

    /**
     * Метод создает итератор текущего списка.
     * @return итератор текущего списка.
     */
    public DoubleLinkIterator <T> getIterator(){
        return new DoubleLinkIterator <T>(this);
    }
}
