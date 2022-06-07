package java_algorithms_homework2;

public class ArraysForSearchAndSort {
    public static void main(String[] args) {
        MyArray arr1 = new MyArray();
        MyArray arr2 = new MyArray();
        MyArray arr3 = new MyArray();
        MyArray arr4 = new MyArray();
        MyArray arr5 = new MyArray();
        for (int i = 0; i<10000; i++){
            arr1.addEnd((int)(Math.random()*100));
            arr2.addEnd((int)(Math.random()*100));
            arr3.addEnd((int)(Math.random()*100));
            arr4.addEnd((int)(Math.random()*100));
            arr5.addEnd((int)(Math.random()*100));
        }

        int x = 100;

        long start = System.currentTimeMillis();
        arr1.sortBubble();
        long finish = System.currentTimeMillis();
        System.out.println("Время сортировки пузырьком составляет " + (finish-start) + " миллисекунд.");

        start = System.currentTimeMillis();
        arr2.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println("Время сортировки методом выбора составляет " + (finish-start) + " миллисекунд.");

        start = System.currentTimeMillis();
        arr3.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println("Время сортировки методом вставки составляет " + (finish-start) + " миллисекунд.");

        start = System.currentTimeMillis();
        arr4.sortCountingVar1();
        finish = System.currentTimeMillis();
        System.out.println("Время сортировки методом подсчета (вариант 1) составляет " + (finish-start) + " миллисекунд.");

        start = System.currentTimeMillis();
        arr5.sortCountingVar2();
        finish = System.currentTimeMillis();
        System.out.println("Время сортировки методом подсчета (вариант 2) составляет " + (finish-start) + " миллисекунд.");

        start = System.nanoTime();
        arr1.searchLinear(x);
        finish = System.nanoTime();
        System.out.println("Время линейного поиска заведомо отсутствующего числа составляет " + (finish-start) + " наносекунд.");

        start = System.nanoTime();
        arr2.searchBinary(x);
        finish = System.nanoTime();
        System.out.println("Время бинарного поиска заведомо отсутствующего числа составляет " + (finish-start) + " наносекунд.");



    }
}

