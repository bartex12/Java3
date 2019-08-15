package Lesson1;

import java.util.ArrayList;

public class ChangeTwoElemrnts_Demo {

    public static void main(String[] args) {
        //Строки
        String[] s = {"a", "b", "c", "d", "e"};
        ChangeTwoElemrnts<String> str1 = new ChangeTwoElemrnts<String>(s);
        str1.arrayShow();
        str1.change(0,4);
        str1.arrayShow();
        System.out.println();

        //*******************************************************************
        //Числа
        Integer[] intArray = {1,2,3,4,5};
        ChangeTwoElemrnts<Integer> intChange = new ChangeTwoElemrnts<Integer>(intArray);
        intChange.arrayShow();
        intChange.change(0,4);
        intChange.arrayShow();
        System.out.println();

        System.out.println("ArrayList<Integer> включает элементы");
        ArrayList<?> arrayListInt = intChange.toArrayList(intArray);
        for (int i = 0; i< arrayListInt.size(); i++){
            System.out.print(((Integer) arrayListInt.get(i)).toString() + " ");
        }
        System.out.println();

//**************************************************************************
        //пример класса с двумя полями
        System.out.println();
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
        System.out.println();
        System.out.println();

        System.out.println("ArrayList<Man> включает элементы");
        ArrayList<?> arrayList = man.toArrayList(manArray);
        for (int i = 0; i< arrayList.size(); i++){
            System.out.print(((Man)arrayList.get(i)).getName() + "-" + ((Man)arrayList.get(i)).getAge() + " ");
        }
        System.out.println();

    }
}
