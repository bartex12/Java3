package lesson2_CreateTable;

import java.sql.*;
import java.util.Scanner;

public class DB_Service {

   static Connection connection;
    static Statement statement;
    static ResultSet rs;
    static  PreparedStatement preparedStatement = null;
    static String[] ss = null;


    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:less2_SQLite.db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableProducts(){

    String createTable =" CREATE TABLE IF NOT EXISTS products \n" +
            " (\n" + " id\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
            "\t prodId\tINTEGER NOT NULL ,\n" +
            " title\tTEXT NOT NULL ,\n" +
            " cost\tREAL NOT NULL\n" +
            " );";

        try {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearTableProducts(){
        String clearTable = "DELETE from products";
        try {
            int clear = statement.executeUpdate(clearTable);
            System.out.println("Удалено строк: "+clear);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertManyProd(){

//        Для того, чтобы создать пакет, нам необходимо:
//        1 Создать экземпляр Statemnet, PreparedStatement, либо CallableStatement с помощью соответствующих методов.
//                2 Отключить функцию auto-commit, установив false в метод setAutoCommit().
//                3 Добавить необходимое количество SQL-запросов в “пакет” с помощью метода addBatch().
//                4 Выполнить все SQL-запросы в группе, используя метод executeBatch().
//                5 Сохранить изменения с помощью метода commit().

        try {
            connection.setAutoCommit(false); // 2 Отключем функцию auto-commit
            //1  Создаём экземпляр  PreparedStatement
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO products (prodId, title, cost) VALUES (?, ?, ?)");
            //preparedStatement.clearBatch();
            preparedStatement.clearParameters();
            //3 Добавляем необходимое количество SQL-запросов в “пакет” с помощью метода addBatch().
            for (int i = 1; i<=10000; i++){
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,"товар"+i);
                preparedStatement.setDouble(3,0.0f+i);
                preparedStatement.addBatch();
            }
            //4 Выполняем все SQL-запросы в группе, используя метод executeBatch().
            int[] update = preparedStatement.executeBatch();
            //5 Сохраняем изменения с помощью метода commit().
            connection.commit();
            System.out.println("Обновлено " + update.length + " строк ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consoleApp(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите запрос,например \n" +
                "(/цена товар123)\n" +
                "(/сменитьцену товар555 321)\n" +
                "(/товарыпоцене 100 110):\n ");
        System.out.print("*** Для выхода введите /exit \n");
        while (true){
            String s = in.nextLine();
            if (s.trim().startsWith("/")){
                ss = s.split(" ");
                if (ss[0].equals("/цена")){
                    if (ss.length==2){
                        selectCostWithTitle(ss[1]);
                    }else {
                        System.out.println("Некорректная команда. Попробуйте ещё раз.");
                    }
                }else if (ss[0].equals("/сменитьцену")){
                    if ((ss.length == 3)){
                        changetCostWithTitle(ss[2], ss[1]);
                        selectCostWithTitle(ss[1]);
                    }else {
                        System.out.println("Некорректная команда. Попробуйте ещё раз.");
                    }
                }else if(ss[0].equals("/товарыпоцене")){
                    if ((ss.length == 3)&&(Float.parseFloat(ss[2])>Float.parseFloat(ss[1]))){
                        try {
                            preparedStatement = connection.prepareStatement(
                                    "SELECT  title, cost FROM products where cost BETWEEN ? and ?");
                            preparedStatement.setFloat(1,Float.parseFloat(ss[1]));
                            preparedStatement.setFloat(2,Float.parseFloat(ss[2]));
                            rs = preparedStatement.executeQuery();
                            if (!rs.next()){
                                System.out.println("Такие товары отсутствуют");
                            }else {
                                System.out.println("Товары с ценами от " + ss[1] +" до " + ss[2]);
                                System.out.println("----------------------------");
                                do{
                                    String title = rs.getString("title");
                                    float cost = rs.getFloat("cost");
                                    System.out.println("товар: "+title + " Цена = " + cost);
                                }while (rs.next());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Некорректная команда. Попробуйте ещё раз.");
                    }
                    //System.out.println(" ss[0].equals(/товарыпоцене)");
                }else if(ss[0].equals("/exit")){
                    System.out.println(" Выход из приложения ");
                    return;
                }else {
                    System.out.println("Неизвестная команда. Попробуйте ещё раз.");
                }
            }else {
                System.out.println(" Строка должна начинаться с /");
            }
        }
    }

    public static void selectCostWithTitle(String title){
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT cost from products WHERE title = ?");
            preparedStatement.setString(1,title);
            rs = preparedStatement.executeQuery();
            if (!rs.next()){
                System.out.println("Такого товара нет");
            }else {
                int cost = rs.getInt("cost");
                System.out.println("Цена товара "+ss[1] + " = " + cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changetCostWithTitle(String cost, String title){
        try {
            preparedStatement = connection.prepareStatement(
                    " UPDATE products set cost = ? where title = ? ");
            preparedStatement.setFloat(1,Float.parseFloat(cost));
            preparedStatement.setString(2, title);
            int update = preparedStatement.executeUpdate();
            System.out.println("Обновлено строк: " + update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect()  {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
