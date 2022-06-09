package java_algorithms_homework3;

import java.util.Scanner;

import static java.lang.System.in;

public class CheckBracket {

    public static void main(String[] args) {
        System.out.println("Введите строку для проверки.");
        Scanner scan = new Scanner(in);
        String string = scan.nextLine();
        check (string);
    }

    /**
     * Метод проверяет правильность расстановки скобок (), {}, [] в строке string и
     * выводит соответствующую информацию в консоль.
     * @param string проверяемая строка.
     */
    public static void check (String string){
        // Создаем стек для символов из строки string.
        StackChar stack = new StackChar(string.length());
        boolean flag = true;
        // Проходим по все символам строки string.
        for (int i=0; i<string.length(); i++){
            switch(string.charAt(i)){
                // Если i-ый символ открывающяяся скобка, заносим его в стек.
                case '[':
                case '{':
                case '(':
                    stack.push(string.charAt(i));
                    break;
                // Если i-ый символ закрывающаяся скобка:
                // сравниваем i-ый символ с последним занесенным в стек значением и если они несоответствуют или
                // если стек пустой выводим сообщение об ошибке в консоль.
                case ']':
                case '}':
                case ')':
                    if (!stack.isEmpty()){
                        if ((string.charAt(i) == '}' && stack.pop() != '{') || (string.charAt(i) == ']' && stack.pop() !=
                        '[') || (string.charAt(i) == ')' && stack.pop() != '(')){
                            System.out.println("Не правильная скобка \"" +string.charAt(i)+"\" на позиции "+(i+1) + ".");
                            flag = false;
                        }
                    }
                    else {
                        System.out.println("Не правильная скобка \"" +string.charAt(i)+"\" на позиции "+(i+1) + ".");
                        flag = false;
                    }
                    break;
                default:
                    break;
            }
        }
        // Если стек остался не пустым, выводим сообщение об ошибке в консоль с указанием не закрытых скобок.
        while (!stack.isEmpty()){
            System.out.println("Скобка \"" + stack.pop() + "\" не закрыта.");
            flag = false;
        }
        // Если проверка не выявила ошибок, выводим соответствующее сообщение в консоль.
        if(flag)
            System.out.println("Все скобки расставлены верно.");
    }
}
