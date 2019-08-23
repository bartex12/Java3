package lesson2_Console;

import lesson2_CreateTable.DB_Service;

public class lesson2_ConsoleDemo {
    public static void main(String[] args) {

        //********* Подключаемся к базе ************
        DB_Service.connect();
        //*************** Запускаем консольное приложение  ************
        DB_Service.consoleApp();
    }
}
