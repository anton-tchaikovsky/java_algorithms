package java_algorithms_homework3;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque (int maxSize){
        this.maxSize = maxSize;
        this.deque = new int [this.maxSize];
        this.head = 0; // Исходные метки начала и конца очереди заданы нулевыми,
        this.tail = 0; // это учтено в алгоритмах методов класса Deque.
        this.items = 0;
    }

    public boolean isEmpty (){
        return (items==0);
    }

    public boolean isFull (){
        return (items == this.maxSize);
    }

    /**
     * Метод увеличивает размер массива deque, если он переполнен: количество
     * элементов items равно длинне массива deque - maxSize (в том числе, когда maxSize = 0).
     */
    private void increase (){
        // Если maxSize = 0, то создаем новый пустой массив deque размером 10.
        if (this.maxSize == 0){
            this.maxSize = 10;
            this.deque = new int [this.maxSize];
        }
        // Если maxSize не равен 0, то увеличиваем размер массива deque в два раза.
        else {
            this.maxSize *= 2;
            // Создаем вспомогательный массив dequeOld, который приравниваем текущему массиву deque.
            int [] dequeOld = this.deque;
            this.deque = new int [this.maxSize];
            // Переносим в "расширенный" массив deque элементы из массива dequeOld начиная с метки head включительно и
            // до конца массива dequeOld (этого достаточно если метка head = 0).
            System.arraycopy(dequeOld, this.head, this.deque, 0, dequeOld.length-this.head);
            // Переносим в "расширенный" массив deque элементы из массива dequeOld начиная с 0 и до метки tail включительно.
            if (this.head != 0){
                System.arraycopy(dequeOld, 0, this.deque, dequeOld.length-this.tail-1, this.tail+1);
                // Переопределяем значения меток head и tail для "расширенного" массива.
                this.head = 0;
                this.tail = dequeOld.length-1;
            }
        }
    }

    /**
     * Метод вставляет значение i в начало очереди.
     * @param i
     */
    public void insertHead (int i){
        // "Расширяем" массив deque, если необходимо.
        if(this.items == this.maxSize)
            increase();
        // Если очередь пустая, то вставляем значение i по метке head.
        // Значения меток head и tail при этом не изменяются.
        if (isEmpty())
            this.deque[this.head] = i;
        //Если очередь не пустая:
        else {
            // если метка head = 0, то переопределяем метку head в конец массива deque, т.к. слева места нет, и
            // вставляем значение i по переопределенной метке head.
            if(this.head == 0){
                this.head = this.maxSize-1;
                this.deque [this.head] = i;
            }
            // если метка head не равна 0, то переопределяем метку head на одну позицию влево и
            // вставляем значение i по переопределенной метке head.
            else {
                this.deque [--this.head] = i;
            }
        }
        // Увеличиваем количество элементов items в очереди.
        this.items++;
    }

    /**
     *  Метод вставляет значение i в конец очереди.
     * @param i
     */
    public void insertTail (int i){
        // "Расширяем" массив deque, если необходимо.
        if(this.items == this.maxSize)
            increase();
        // Если очередь пустая, то вставляем значение i по метке tail.
        // Значения меток head и tail при этом не изменяются.
        if (isEmpty())
            this.deque[this.tail] = i;
            //Если очередь не пустая:
        else {
            // если метка tail в конце массива deque переопределем ее как -1, т.к. справа места нет.
            if (this.tail == this.maxSize-1)
                this.tail = -1;
            // увеличиваем метку tail и записываем по ней значение i в массив deque.
            this.deque [++this.tail] = i;
        }
        // Увеличиваем количество элементов items в очереди.
        this.items++;
    }

    /**
     * Метод удаляет элемент с начала очереди.
     * @return удаляемый элемент.
     */
    public int removeHead (){
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        // Записываем в вспомогательную переменную temp значение начала очереди.
        int temp = this.deque[this.head];
        // Если в очереди больше одного элемента (если в очереди один элемент, то изменять метку head не надо):
        if (items > 1){
            // если метка head в конце массива deque переопределяем ее как 0, т.к. справа места нет.
            if (this.head == this.maxSize-1)
                this.head = 0;
            // иначе двигаем метку head вправо.
            else
                this.head++;
        }
        // Уменьшаем количество элементов в очереди.
        this.items--;
        return temp;
    }

    /**
     * Метод удаляет элемент с конца очереди.
     * @return удаляемый элемент.
     */
    public int removeTail () {
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        // // Записываем в вспомогательную переменную temp значение конца очереди.
        int temp = this.deque[this.tail];
        // Если в очереди больше одного элемента (если в очереди один элемент, то изменять метку head не надо):
        if(items > 1){
            // если метка tail = 0 передвигаем ее в конец массива deque, т.к. слева места нет,
            if (this.tail == 0)
                this.tail = this.maxSize-1;
            // иначе передвигаем метку tail влево.
            else
                this.tail--;
        }
        // Уменьшаем количество элементов в очереди.
        this.items--;
        return temp;
    }

    /**
     * Метод возвращает значение начала очереди.
     * @return
     */
    public int peekHead (){
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        return this.deque[this.head];
    }

    /**
     * Метод возвращает значение конца очереди.
     * @return
     */
    public int peekTail (){
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        return this.deque[this.tail];
    }

    public int getSize() {
        return items;
    }

}
