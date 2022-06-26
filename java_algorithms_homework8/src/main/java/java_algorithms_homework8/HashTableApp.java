package java_algorithms_homework8;

public class HashTableApp {
    public static void main(String[] args) {
        HashTableChain hashTable = new HashTableChain(20);
        for (int i = 0; i<11; i++){
            hashTable.insert(new Item((i+4)*i+35));
        }
        hashTable.display();
    }
}
