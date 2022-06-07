package java_algorithms_homework2;

public class MyArray {
    private int size;
    private int[] array;

    MyArray() {
        this.array = new int[16];
        this.size = 0;
    }

    MyArray(int size) {
        this.array = new int[size];
        this.size = 0;
    }

    MyArray(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    void display (){
        System.out.print("[");
        if (this.size != 0){
            for (int i = 0; i<this.size-1; i++)
                System.out.print(this.array[i] + "; ");
            System.out.print(this.array[this.size-1]);
        }
        System.out.println("]");
    }

    int getValue (int index) {

        try{
            if (index>=this.size)
                throw new ArrayIndexOutOfBoundsException();
            return this.array [index];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Недопустимое значение index.");
        }
        return 0;
    }

    void setValue (int value, int index){
        try{
            if (index>=this.size)
                throw new ArrayIndexOutOfBoundsException();
            this.array[index] = value;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Недопустимое значение index.");
        }
    }

    public int getSize() {
        return size;
    }

    void addEnd (int value){
        if (array.length == this.size){
            increase();
        }
        this.array[this.size++] = value;
    }

    void addBegin (int value){
        if (array.length == this.size){
            increase();
        }
        for (int i = 0; i<this.size; i++)
            array[this.size-i] = array [this.size-i-1];
        array[0] = value;
        this.size++;
    }

    /**
     * Метод вставляет элемент по индексу index со значением value
     со смещением исходных элементов массива вправо (shift the tail).
     * @param value
     * @param index
     */
    void addIndex (int value, int index){
        if (array.length<=index)
            increase(index);
        else if (array.length == this.size)
            increase();
        if (index<this.size){
            for (int i = 0; i<this.size-index; i++)
                array[this.size-i] = array [this.size-i-1];
            array[index] = value;
            this.size++;
        } else{
            this.array [index] = value;
            this.size = index + 1;
        }
    }

    boolean deleteIndex (int index){
        for (int i = index; i<this.size; i++){
            if (i == this.size-1){
                this.array [i] = 0;
                this.size=this.size-1;
                return true;
            }
            this.array [i] = this.array [i+1];
        }
        return false;
    }

    boolean deleteValue (int value){
       for (int i = 0; i<this.size; i++){
           if (this.array[i] == value){
               deleteIndex(i);
               return true;
           }
       }
       return false;
    }

    /**
     * Метод удаляет из массива все элементы, равные заданному значению value
     * @param value
     * @return true - элементы, с заданным значением value были в исходном массиве, false - не были.
     */
    boolean deleteValueAll (int value){
        boolean flag = false;
        for (int i = 0; i<this.size; i++){
            if (this.array[i] == value){
                deleteIndex(i);
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Метод удаляет из массива все элементы.
     * @return true
     */
    boolean deleteAll(){
        this.array = new int[16];
        this.size = 0;
        return true;
    }

    private void increase(){
        int [] arrayOld = this.array;
        this.array = new int [this.array.length*2];
        for(int i = 0; i<arrayOld.length; i++)
            this.array[i] = arrayOld [i];
    }

    private void increase(int indexLast){
        int [] arrayOld = this.array;
        this.array = new int [(indexLast +1)*2];
        for(int i = 0; i<arrayOld.length; i++)
            this.array[i] = arrayOld [i];
    }

    boolean searchLinear (int value){
        for (int i = 0; i<this.size; i++)
            if (this.array[i]==value)
                return true;
        return false;
    }

    boolean searchBinary (int value){
        int low = 0;
        int high = this.size-1;
        int mid;
        while (low<=high){
            mid = (low+high)/2;
            if (value == this.array[mid])
                return true;
            else if (value>this.array[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }

    void swam (int x, int y){
        int z = this.array[x];
        this.array[x] = this.array[y];
        this.array[y] = z;
    }

    /**
     * Метод поиска пузырьком (улучшенная).
     * Сложность O(N^2). Худшее количество действий (N-1)+(N-2)+(N-3)...+1
     *  (например, для пяти элементов, количество действий 11).
     *
     */
    void sortBubble(){
        for (int i = 0; i<this.size-1;i++){
            // flag в положении false фиксирует момент, когда пройдя по всему массиву
            // не было ни одной необходимости поменять соседние элементы местами,
            // что свидетельствует о том, что массив отсортирован.
            boolean flag = false;
            for (int j = 0; j<this.size-1-i; j++){
                // для каждой последующей итерации во внутреннем цикле уменьшается на единицу количество
                // рассматриваемых элементов, т.к. в конце массива собираются "тяжелые" элементы в отсортированном порядке.
                if (this.array[j] > this.array[j+1]){
                    swam (j, j+1);
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    /**
     * Сортировка выбором.
     * Сложность O(N^2).
     */
    void sortSelect(){
        for (int i = 0; i<this.size; i++){
            int min = i;
            for (int j = i+1; j < this.size; j++){
                if (this.array[j]<this.array[min]){
                    min = j;
                }
            }
            swam(i,min);
        }
    }

    /**
     * Сортировка вставкой.
     * Сложность O(N^2).
     */
    public void sortInsert(){
        for (int i = 1; i<this.size; i++){
            int temp = this.array[i];
            int move = i;
            while (move>0 && temp<=this.array[move-1]){
                this.array[move] = this.array[move-1];
                move--;
            }
            this.array[move] = temp;
        }
    }

    /**
     * Сортировка подсчетом с созданием промежуточного нового массива arrayNew, в который складываются
     в отсортированном порядке элементы из исходного массива.
     */
    public void sortCountingVar1 (){
        int [] arrayNew = new int [this.size];
        int score = 0;
        int min;
        while (score<arrayNew.length){
            // находим значение минимального элемента в массиве this.array
            min = this.array[0];
            for (int i = 0; i<this.size; i++)
                if(min > this.array[i])
                    min = this.array[i];
            // перемещаем все элементы с минимальным значение из массива this.array в массив arrayNew
            for (int i = 0; i<this.size; i++)
                if (this.array[i] == min){
                    arrayNew[score] = min;
                    score++;
                    deleteIndex(i);
                }
        }
        // перезаписываем массив  this.array в отсортированном виде
        this.array=arrayNew;
        this.size=arrayNew.length;
    }

    /**
     * Сортировка подсчетом путем перемещения подсчитанных элементов, начиная с самых минимальных, в начало массива
     */
    public void sortCountingVar2 (){
        int score = 0;
        while (score<this.size){
            // находим значение минимального элемента в неотсортированной части массива this.array
            int min = this.array [score];
            for (int i = score; i<this.size; i++){
                if(min > this.array[i])
                    min = this.array[i];
            }
            // перемещаем все элементы с минимальным значение из неотсортированной части массива this.array в отсортированную
            for (int i = 0; i<this.size; i++){
                if (this.array[i] == min){
                    score++;
                    deleteIndex(i);
                    addIndex(min,score-1);
                }
            }
        }
    }

}
