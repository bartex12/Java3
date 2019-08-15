package Lesson1;

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

    public void  arrayShow(){
        for (int i = 0; i< obj.length; i++){
            System.out.print(this.obj[i] + " ");
        }
        System.out.println("");
    }

}
