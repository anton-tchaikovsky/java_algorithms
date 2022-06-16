package java_algorithms_homework5;

import java.util.Arrays;

public class KnightIsMoveRec {
    static int fieldSizeX = 8; // Размерность игрового поля (столбцы)
    static int fieldSizeY = 8; // Размерность игрового поля (строки)
    static final int DOT_EMPTY = 0; // Символ пустой ячейки
    static int [] [] field; // Игровое поле;
    static int [] [] tableMove = new int [8] [2]; // Таблица ходов конем
    static int score = 1; // Номер хода

    /**
     * Создание массива игрового поля и заполнение его символами пустой ячейки
     */
    static void createField (){
        field = new int[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++){
            Arrays.fill(field[i], DOT_EMPTY);
        }
    }

    /**
     * Отрисовка игрового поля
     */
    static void drawField () {
        // Шапка игрового поля

        for (int i= 0; i < fieldSizeX; i++ ){
            System.out.printf("%3d", i);
        }
        System.out.println();

        // Тело игрового поля
        for (int y= 0; y < fieldSizeY; y++ ){
            System.out.print(y + "|");
            for (int x= 0; x < fieldSizeX; x++ ) {
                System.out.printf("%2d|", field[y][x]);
            }
            System.out.println();
        }
    }

    /**
     * Запуск программы по прохождению конем игрового поля.
     * Проверяется, попадают ли начальные координаты в игровое поле.
     * Проверяется, возможно ли обойти конем все поле, если возможно - выводится результат прохождения всего поля конем.
     * @param startY начальные координаты
     * @param startX начальные координаты
     */
    static void startKnightIsMove (int startY, int startX){
        createField ();
        if (!checkingMove (field,startY, startX))
            System.out.println("Некорректные стартовые координаты.");
        else {
            if (knightIsMove (field, startY, startX, 1))
                drawField();
            else
                System.out.println("Всё поле не может быть пройдено конем.");
        }
    }

    /**
     * Проверка, допустим ли ход конем: попадает ли ход в игровое поле и не занята ли ячейка предыдущими ходами.
     * @param field текущее игровое поле
     * @param Y координаты хода
     * @param X координаты хода
     * @return
     */
    static boolean checkingMove (int [] [] field, int Y, int X){
        if (Y<0 || Y>fieldSizeY-1 || X<0 || X>fieldSizeX-1)
            return false;
        return field[Y][X] == 0;
    }

    /**
     * Метод генерирует координаты следующего хода, по координатам текущего хода и заданному варианту хода varMove.
     * @param Y текущие координаты
     * @param X текущие координаты
     * @param varMove вариант хода
     * @return сгенерированные координаты хода ввиде массива из двух элементов Y и X
     */
    static int [] getMove (int Y, int X, int varMove){
        tableMove[0][0] = Y-2; tableMove[0][1] = X-1;
        tableMove[1][0] = Y-2; tableMove[1][1] = X+1;
        tableMove[2][0] = Y-1; tableMove[2][1] = X-2;
        tableMove[3][0] = Y-1; tableMove[3][1] = X+2;
        tableMove[4][0] = Y+1; tableMove[4][1] = X-2;
        tableMove[5][0] = Y+1; tableMove[5][1] = X+2;
        tableMove[6][0] = Y+2; tableMove[6][1] = X-1;
        tableMove[7][0] = Y+2; tableMove[7][1] = X+1;
        int[] getMove = {tableMove[varMove][0], tableMove[varMove][1]};
        return  getMove;
    }

    /**
     * Обход поля конем.
     * @param field текущее поле
     * @param Y текущие координаты
     * @param X текущие координаты
     * @param score номер текущего хода
     * @return true - все поле пройдено конем, false - все поле не возможно пройти конем (дла маленьких размеров полей)
     */
    static boolean knightIsMove (int [] [] field, int Y, int X, int score){
        field [Y][X] = score;

        // Проверка заполнено ли полностью поле.
        if (score==fieldSizeY*fieldSizeY)
            return true;

        // Осуществление выбора возможного варианта хода через метод checkingMove (ход возможен) и
        // через рекурсию метода knightIsMove (последующие ходы возможны)
        for (int i = 0; i<tableMove.length;i++){
            if (checkingMove (field, getMove(Y, X, i)[0],getMove(Y, X, i)[1]))
                if (knightIsMove(field, tableMove[i][0],tableMove[i][1], score+1))
                    return true;
        }
        // Если ход не возможен, обнуляем его.
        field [Y][X] = 0;
        return false;
    }

    public static void main(String[] args) {
        startKnightIsMove(0,0);
    }
}
