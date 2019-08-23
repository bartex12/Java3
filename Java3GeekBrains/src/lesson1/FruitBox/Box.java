package lesson1.FruitBox;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> ar;
    String name;

    public Box(String name){
        ar = new ArrayList<>();
        this.name =name;
    }

    public void addToBox(T fruit){
        ar.add(fruit);
    }

    public void addToBoxArray(T... fruit){
        for (T t: fruit){
            ar.add(t);
        }
    }

    public ArrayList<T> getAr() {
        return ar;
    }

    public String getName() {
        return name;
    }


    public float getWeigth(){
        float weigth = 0f;
        for (T t: ar){
            weigth += t.getWeigth()*t.getCount();
        }
        System.out.println("Вес коробки " + this.getName() + "= " + weigth+ " условных единиц");
        return weigth;
    }


    public boolean compare(Box <?> box){
        boolean isEquel = Math.abs(this.getWeigth()-box.getWeigth())<0001;
        if (isEquel){
            System.out.println("  Коробки одинакового веса\n");
        }else{
            System.out.println("  Коробки не одинакового веса\n");
        }
        return isEquel;
    }


    public void showBox(){
        if (ar.size() == 0){
            System.out.println("В коробке " +this.getName() + " пусто\n");
        }else {
            System.out.println("В коробке " +this.getName() + " находятся: ");
            for (T t: ar){
                t.showFruit();
            }
            System.out.println();
        }
    }

    public void exchangeBox(Box<T> box){
        ArrayList<T> arBox = box.getAr();

        ar.addAll(arBox);
        arBox.clear();

        System.out.println("После пересыпания из  " +box.getName()+ "  в  "+ this.getName());

        this.showBox();
        box.showBox();
    }
}
