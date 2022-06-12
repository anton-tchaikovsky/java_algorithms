package java_algorithms_homework4;

public class DoubleLinkIterator <T> {
    private DoubleLinkedList <T> list;
    private DoubleLink <T> current;

    public DoubleLinkIterator(DoubleLinkedList<T> list) {
        this.list = list;
        resetToFirst ();
    }

    /**
     * Метод перемещает итератор в начало списка.
     */
    public void resetToFirst (){
        current = list.getFirst();
    }

    /**
     * Метод перемещает итератор в конец списка.
     */
    public void resetToLast (){
        current = list.getLast();
    }

    /**
     * Метод перемещает итератор к следующему объекту списка.
     */
    public void nextLink(){
        current = current.getNext();
    }

    /**
     * Метод перемещает итератор к предыдущему объекту списка.
     */
    public void previousLink(){
        current = current.getPrev();
    }

    /**
     * Метод определяет, находится ли итератор в конце списка (true - в конце, false - не в конце).
     */
    public boolean atLast(){
        return (current.getNext() == null);
    }

    /**
     * Метод определяет, находится ли итератор в начале списка (true - в начале, false - не в начале).
     */
    public boolean atFirst(){
        return (current.getPrev() == null);
    }

    /**
     * Метод возвращает объект, на который указывает итератор.
     * @return
     */
    public T getCurrent() {
        return current.getValue();
    }

    /**
     * Метод вставляет объект link на позицию за итератором.
     * @param link
     */
    public void insertAfter(T link){
        if (list.isEmpty() || current == list.getLast())
            list.insertLast(link);
        else{
            DoubleLink <T> newLink = new DoubleLink <T>(link);
            newLink.setNext(current.getNext());
            newLink.setPrev(current);
            current.getNext().setPrev(newLink);
            current.setNext(newLink);
        }
    }

    /**
     * Метод вставляет объект link на позицию перед итератором.
     * @param link
     */
    public void insertBefore(T link){
        if (list.isEmpty() || current == list.getFirst())
            list.insertFirst(link);
        else{
            DoubleLink <T> newLink = new DoubleLink <T>(link);
            newLink.setNext (current);
            newLink.setPrev(current.getPrev());
            current.getPrev().setNext(newLink);
            current.setPrev(newLink);
        }
    }

    /**
     * Метод удаляет объект из списка, на который указывает итератор.
     * @return удаляемый объект или null, если список пуст.
     */
    public T deleteCurrent (){
        if (list.isEmpty())
            return null;
        if (current == list.getLast()){
            resetToFirst();
            return list.deleteLast();
        } else if (current == list.getFirst()){
            current = current.getNext();
            return list.deleteFirst();
        } else {
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            DoubleLink <T> temp = current;
            current = current.getNext();
            return temp.getValue();
        }

    }

}
