package Lesson2.lesson2_Console;

import Lesson2.lesson2_CreateTable.DB_Service;

public class lesson2_ConsoleDemo {
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

        //********* Закрываем соединение с базой ************
        DB_Service.disconnect();
    }
}
