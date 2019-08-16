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
}
