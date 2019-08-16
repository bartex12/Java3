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
        //appleBox.getWeigth();

        System.out.println();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addToBox(new Orange("GrandOrange", 5));
        orangeBox.addToBox(new Orange("SuperOrange", 12));
        orangeBox.addToBox(new Orange("OrangeStar", 4));
        ArrayList<Orange> ar1 = orangeBox.getAr();
        for (Orange o: ar1){
            o.showFruit();
        }
        //orangeBox.getWeigth();

        System.out.println();

        if (appleBox.compare(orangeBox)){
            System.out.println(" Коробки одинакового веса");
        }else {
            System.out.println(" Коробки не одинакового веса");

        }
    }
}
