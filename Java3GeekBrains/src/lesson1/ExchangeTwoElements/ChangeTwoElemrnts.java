package ExchangeTwoElements;

import java.util.ArrayList;

    //класс с методом change() для перестановки двух элементов массива с элементами обобщённого типа
    // и метод toArrayList для преобразования массива в ArrayList

public class ChangeTwoElemrnts<T>{

    T[] obj;

    public ChangeTwoElemrnts( T... obj){
            this.obj = obj;
        }

    public T[] change(int el1, int el2){
        int size = obj.length;
        if (el1<size && el2<size){
            T temp = this.obj[el1];
            obj[el1] = obj[el2];
            obj[el2] = temp;
            temp = null;
            return obj;
        }else {
            obj = null;
            return obj;
        }
    }

    public ArrayList<T> toArrayList(T[] array){
        ArrayList<T> ar = new ArrayList<>();
        for (T t: array){
            ar.add(t);
        }
        return ar;
    }

    public void  arrayShow(){
        if (obj!=null){
            for (int i = 0; i< obj.length; i++){
                System.out.print(this.obj[i] + " ");
            }
            System.out.println("");
        }else {
            System.out.println("Ошибка! Индекс находится за пределами размера массива");
        }
    }
}
