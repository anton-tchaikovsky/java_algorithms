package java_algorithms_homework3;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int items;

    public PriorityQueue(int i){
        maxSize = i;
        queue = new int[maxSize];
        items = 0;
    }

    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items == maxSize);
    }

    /**
     * Метод увеличивает размер массива queue, если он переполнен: количество
     * элементов items равно длинне массива queue - maxSize (в том числе, когда maxSize = 0).
     */
    private void increase () {
        // Если maxSize = 0, то создаем новый пустой массив queue размером 10.
        if (this.maxSize == 0) {
            this.maxSize = 10;
            this.queue = new int[this.maxSize];
        }
        // Если maxSize не равен 0, то увеличиваем размер массива queue в два раза.
        else {
            this.maxSize *= 2;
            // Создаем вспомогательный массив queueOld, который приравниваем текущему массиву queue.
            int [] queueOld = this.queue;
            this.queue = new int [this.maxSize];
            // Переносим в "расширенный" массив queue элементы из массива queueOld.
            System.arraycopy(queueOld, 0, this.queue, 0, queueOld.length);
        }
    }

    /**
     * Метод добавляет элемент i в очередь с учетом следующего приоритета:
     * наименьшие значения находятся справа в массиве queue и будут извлекаться первыми.
     * @param i добавляемый элемент.
     */
    public void insert(int i){
        // "Расширяем" массив queue, если необходимо.
        if(this.items == this.maxSize)
            increase();
        // Если очередь пустая, то вставляем значение i на позицию 0.
        if(items==0)
            queue[items++] = i;
            // Если очередь не пустая, то производим поиск позиции, в которую вставляем элемент i.
        else{
            for(int j=items-1; j>=0; j--){
                if( i > queue[j] ){
                    // Сдвигаем существующие элементы вправо, если они меньше i.
                    queue[j+1] = queue[j];
                    //Вставляем элемент i на позицию 0, если он больше всех существующих элементов (последняя итерация проверки).
                    if(j==0)
                        queue[j] = i;
                }
                else {
                    // Вставляем элемент i на позицию j+1, если элемент i меньше или равен существующему элементу с позиции j.
                    queue[j+1] = i;
                    break;
                }

            }
            items++;
        }
    }

    /**
     * Метод удаляет наиболее приоритетный (наименьший) элемент из очереди.
     * @return удаляемый элемент
     */
    public int remove(){
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[--items];
    }

    /**
     * Метод возвращает наиболее приоритетный (наименьший) элемент из очереди без его удаления.
     * @return наиболее приоритетный (наименьший) элемент
     */
    public long peek(){
        // Если очередь пустая, то бросаем ошибку.
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[items-1];
    }
}
