package lesson2_CreateTable;

public class Lesson2_Demo {
    public static void main(String[] args) {

        //********* Подключаемся к базе и создаём таблицу ************
        DB_Service.connect();
        DB_Service.createTableProducts();
        System.out.println();

        //********* Заполняем таблицу 10000 строками  ************
       DB_Service.clearTableProducts();
       DB_Service.insertManyProd();
        System.out.println();

        //*************** Запускаем консольное приложение  ************
        DB_Service.consoleApp();

//
//        try {
//            DB_Service.disconnect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
