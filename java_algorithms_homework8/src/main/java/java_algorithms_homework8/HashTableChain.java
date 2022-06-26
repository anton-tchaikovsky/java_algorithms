package java_algorithms_homework8;

public class HashTableChain {
    private final LinkedList[] hashArr;
    private final int arrSize;

    public HashTableChain(int size){
        this.arrSize = size;
        hashArr = new LinkedList[arrSize];
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] == null)
            hashArr[hashVal] = new LinkedList();
        hashArr[hashVal].insertFirst(item);
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] == null)
            return null;
        else
            return hashArr[hashVal].find(new Item(key));
    }

    public Item delete (int key){
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] == null)
            return null;
        else return hashArr[hashVal].delete(new Item(key));
    }

    /** Метод выводит в консоль элементы, сохраненные в HashTableChain.
     * При этом элементы с одинаковым значением hashFunc () выводятся в одну строку.
     *
     */
    public void display(){
        for(int i=0;i<arrSize;i++){
            if(hashArr[i] !=null){
                hashArr[i].display();
                System.out.println();
            } else {
                System.out.println("***");
            }
        }
    }



}
