package Lesson1;

import java.util.ArrayList;

public class ChangeTwoElemrnts<T>{

    //класс для перестановки двух элементов массива с элементами обобщённого типа

    T[] obj;

    public ChangeTwoElemrnts( T... obj){
            this.obj = obj;
        }

    public T[] change(int el1, int el2){
        T temp = this.obj[el1];
        obj[el1] = obj[el2];
        obj[el2] = temp;
        temp = null;
        return obj;
    }

    public ArrayList<?> toArrayList(T[] array){
        ArrayList<T> ar = new ArrayList<>();
        for (T t: array){
            ar.add(t);
        }
        return ar;
    }

    public void  arrayShow(){
        for (int i = 0; i< obj.length; i++){
            System.out.print(this.obj[i] + " ");
        }
        System.out.println("");
    }

}
