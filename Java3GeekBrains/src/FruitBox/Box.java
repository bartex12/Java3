package FruitBox;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> ar;

    public Box(){
        ar = new ArrayList<>();
    }

    public void addToBox(T fruit){
        ar.add(fruit);
    }

    public ArrayList<T> getAr() {
        return ar;
    }

    public float getWeigth(){
        float weigth = 0f;
        for (T t: ar){
            weigth += t.getWeigth()*t.getCount();
        }
        System.out.println("Вес коробки = " + weigth+ " условных единиц");
        return weigth;
    }

    public boolean compare(Box <?> box){
        return this.getWeigth()==box.getWeigth();
    }


}
