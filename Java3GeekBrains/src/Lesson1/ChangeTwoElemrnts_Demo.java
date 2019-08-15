package Lesson1;

public class ChangeTwoElemrnts_Demo {

    public static void main(String[] args) {
        //Строки
        String[] s = {"a", "b", "c", "d", "e"};
        ChangeTwoElemrnts<String> str1 = new ChangeTwoElemrnts<String>(s);
        str1.arrayShow();
        str1.change(0,4);
        str1.arrayShow();
        System.out.println();

        //Числа
        Integer[] integ = {1,2,3,4,5};
        ChangeTwoElemrnts<Integer> int11 = new ChangeTwoElemrnts<Integer>(integ);
        int11.arrayShow();
        int11.change(0,4);
        int11.arrayShow();
        System.out.println();

        //пример класса с двумя полями
        Man[] manArray = {new Man("Вася", 15), new Man("Петя", 17),new Man("Коля", 22),
                new Man("Анна", 28),new Man("Мария", 52)};
        ChangeTwoElemrnts<Man> man = new ChangeTwoElemrnts<Man>(manArray);
        for (Man m: manArray){
            m.arrayShow();
        }
        System.out.println();
        man.change(0,4);
        for (Man m: manArray){
            m.arrayShow();
        }
    }
}
