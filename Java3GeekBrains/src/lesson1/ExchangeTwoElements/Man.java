package lesson1.ExchangeTwoElements;

public class Man{
    String name;
    int age;

    public Man(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void  arrayShow(){
            System.out.print(this.getName() + "/" + this.getAge() + "  ");
        }

}
