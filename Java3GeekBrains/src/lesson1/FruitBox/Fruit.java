package FruitBox;

public class Fruit {

    private String name;
    private float weigth;
    private int count;

    public Fruit(String name, float weigth,int count){
        this.name = name;
        this.weigth = weigth;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public float getWeigth() {
        return weigth;
    }

    public int getCount() {
        return count;
    }

    public void showFruit(){
        System.out.println("name = " +getName()+ " weigth = " +getWeigth()+ " count = " +getCount());
    }
}
