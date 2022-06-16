package java_algorithms_homework5;

public class Degree {

    /**
     * Метод возводит целочисленное число number в целочисленную степень degreeOfNumber (в том в числе отрицательную).
     * @param number задаваемое число
     * @param degreeOfNumber задаваемая степень
     * @return результат возведения числа number в степень degreeOfNumber
     */
    static double degree (int number, int degreeOfNumber){
        if (degreeOfNumber == 0)
            return 1;
        else if (degreeOfNumber<0)
            return 1/degree(number,Math.abs(degreeOfNumber));
        else {
            return number*degree(number, degreeOfNumber-1);
        }
    }

    public static void main(String[] args) {
        int number = 5, degreeOfNumber = -1;
        System.out.printf("Число %d в степени %d равно %.2f.\n", number, degreeOfNumber, degree(number,degreeOfNumber));

    }
}
