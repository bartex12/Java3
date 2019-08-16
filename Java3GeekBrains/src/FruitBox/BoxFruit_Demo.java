package FruitBox;

public class BoxFruit_Demo {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>("appleBox");
        appleBox.addToBox(new Apple("Golden", 10));
        appleBox.addToBox(new Apple("Granny", 5));
        appleBox.addToBox(new Apple("RedStar", 1));
        appleBox.showBox();

        Box<Orange> orangeBox = new Box<>("orangeBox");
        orangeBox.addToBox(new Orange("GrandOrange", 5));
        orangeBox.addToBox(new Orange("SuperOrange", 12));
        orangeBox.addToBox(new Orange("OrangeStar", 4));
        orangeBox.showBox();

        //*************** Сравнение веса коробок ************

        if (appleBox.compare(orangeBox)){
            System.out.println(" Коробки одинакового веса");
        }else {
            System.out.println(" Коробки не одинакового веса");
        }
        System.out.println();

        //******************* Заполняем коробку и пересыпаем в неё  orangeBox *********************
        Box<Orange> orangeBox2 = new Box<>("orangeBox2");
        orangeBox2.addToBox(new Orange("GrandOrange", 3));
        orangeBox2.addToBox(new Orange("SuperOrange", 5));
        orangeBox2.showBox();
        orangeBox2.exchangeBox(orangeBox);

        Box<Apple> appleBox2 = new Box<>("appleBox2");
        appleBox2.addToBox(new Apple("Golden", 3));
        appleBox2.addToBox(new Apple("Granny", 4));
        appleBox2.showBox();

        //АПЕЛЬСИНЫ К ЯБЛОКАМ ПЕРЕСЫПАТЬ НЕ ПОЛУЧИТСЯ, так как разные типы данных
        //appleBox2.exchangeBox(orangeBox2);  // не компилируется, так как разные типы данных

        appleBox.exchangeBox(appleBox2);

    }
}
