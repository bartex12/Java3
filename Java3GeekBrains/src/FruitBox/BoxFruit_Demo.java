package FruitBox;

public class BoxFruit_Demo {

    public static void main(String[] args) {
        Apple[] ap  = {new Apple("Golden", 10),new Apple("Granny", 5),new Apple("RedStar", 1)};
        Box<Apple> appleBox = new Box<>("appleBox");
        appleBox.addToBoxArray(ap);
        //appleBox.addToBox(new Orange("RedStar", 1));  //НЕЛЬЗЯ ДОБАВИТЬ АПЕЛЬСИНЫ К ЯБЛОКАМ!
        appleBox.showBox();

        Orange[] or = {new Orange("GrandOrange", 5),new Orange("SuperOrange", 12),new Orange("OrangeStar", 4)};
        Box<Orange> orangeBox = new Box<>("orangeBox");
        //orangeBox.addToBox(new Apple("Golden", 10));  //НЕЛЬЗЯ ДОБАВИТЬ ЯБЛОКИ К АПЕЛЬСИНАМ!
        orangeBox.addToBoxArray(or);
        orangeBox.showBox();

        //*************** Сравнение веса коробок ************

        if (appleBox.compare(orangeBox)){
            System.out.println("  Коробки одинакового веса\n");
        }else {
            System.out.println("  Коробки не одинакового веса\n");
        }

        //******************* Заполняем коробку orangeBox2 и пересыпаем в неё всё из orangeBox *********************
        Orange[] or2 = {new Orange("GrandOrange", 3),new Orange("SuperOrange", 5)};
        Box<Orange> orangeBox2 = new Box<>("orangeBox2");
        orangeBox2.addToBoxArray(or2);
        orangeBox2.showBox();
        orangeBox2.exchangeBox(orangeBox);

        //Заполняем коробку appleBox2 и пересыпаем её в  appleBox
        Box<Apple> appleBox2 = new Box<>("appleBox2");
        appleBox2.addToBox(new Apple("Golden", 3));
        appleBox2.addToBox(new Apple("Granny", 4));
        appleBox2.showBox();

        //АПЕЛЬСИНЫ К ЯБЛОКАМ ПЕРЕСЫПАТЬ НЕ ПОЛУЧИТСЯ, так как разные типы данных
        //appleBox2.exchangeBox(orangeBox2);  // не компилируется, так как разные типы данных

        appleBox.exchangeBox(appleBox2);

    }
}
