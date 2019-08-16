package FruitBox;

import java.util.ArrayList;

public class BoxFruit_Demo {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addToBox(new Apple("Golden", 10));
        appleBox.addToBox(new Apple("Granny", 5));
        appleBox.addToBox(new Apple("RedStar", 1));
        ArrayList<Apple> ar = appleBox.getAr();
        for (Apple a: ar){
            a.showFruit();
        }
    }


}
