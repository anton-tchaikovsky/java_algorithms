package java_algorithms_homework1;

public class EasyAlgorithms {

    public static void main(String[] args) {
        int number = 56, degreeOfNumber = 9;
        int begin = 0, end = 100;

        System.out.printf("Число %d в степени %d равно %e.\n", number, degreeOfNumber, degree(number,degreeOfNumber));

        System.out.printf("Число %d в степени %d равно %e.\n", number, degreeOfNumber, degreeEven(number,degreeOfNumber));

        System.out.printf("Сумма чисел в диапазоне от %d до %d включительно равна %d.\n", begin, end, sum(100,0));
    }

    /**
     * Метод возводит целочисленное число number в целочисленную степень degreeOfNumber (в том в числе отрицательную).
     * @param number задаваемое число
     * @param degreeOfNumber задаваемая степень
     * @return результат возведения числа number в степень degreeOfNumber
     */
    static double degree (int number, int degreeOfNumber){
        if (degreeOfNumber == 0)
            return 1;
        double result = number;
        for (int i = 2; i<=Math.abs(degreeOfNumber); i++) result *= number;
        if (degreeOfNumber>0)
            return result;
        else
            return 1/result;
        }

    /**
     * Метод возводит целочисленное число number в целочисленную степень degreeOfNumber (в том числе в отрицательную)
     с использованием свойства четной степени.
     * @param number задаваемое число
     * @param degreeOfNumber задаваемая степень
     * @return результат возведения числа number в степень degreeOfNumber
     */
    static double degreeEven (int number, int degreeOfNumber){
        if (degreeOfNumber == 0)
            return 1;
        else if (degreeOfNumber > 0){
            double result = number;
            if (degreeOfNumber%2 != 0){
                for (int i = 2; i <= degreeOfNumber; i++) result *= number;
            }
            else {
                result = degreeEven(number * number, degreeOfNumber / 2);
            }
            return result;
        }
        else {
            return 1 / degreeEven (number, Math.abs(degreeOfNumber));
        }
    }

    /**
     * Метод определяет сумму чисел, в том числе отрицательных, в диапазоне от begin до end включительно,
     как в прямом (begin<end), так и в обратном (begin>end) порядке.
     * @param begin задаваемое начало диапазоне
     * @param end задаваемый конец диапазона
     * @return сумма чисел в диапазоне
     */
    static int sum (int begin, int end){
        if (begin == end)
            return begin;
        else if (begin<end)
            return (sum(begin, end-1) + end);
        else
            return (sum (end, begin-1) + begin);
    }

}
