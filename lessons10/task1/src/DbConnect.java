import java.sql.*;

/**
 * Created by adm on 22.05.2017.
 */
public class DbConnect {
    private String bddriver = "org.sqlite.JDBC";
    Connection dbConnection;
    Statement statement;
    String nameDB = "USERAUTORIZE";


// проверяем наличие драйвера

    public void dBCheck() {
        try {
            Class.forName(bddriver);
        } catch (ClassNotFoundException e) {
            System.out.println("SQL JDBC Driver NOT FOUND!");
        }
    }
//конектимся к драйверу

    public Connection getDBConnection() {
        try {
            String urlDB = "jdbc:sqlite:lessons10/task1/db/TestHomeWork.sqlite"; //путь к бд
            dbConnection = DriverManager.getConnection(urlDB);
            statement = dbConnection.createStatement();

        } catch (SQLException e) {
            System.out.println("DB NOT FOUND!!!" + e.getMessage());
        }
        return dbConnection;
    }


    //создаем тайбл с столбцами
    public void createDbUserTable() throws SQLException {

        try {

            String qForCreateTable = "CREATE TABLE " + nameDB + "("
                    + "USERNAME text(20) NOT NULL, "
                    + "EMAIL text(70) NOT NULL, "
                    + "PASS text(10) NOT NULL)";
            // SQL запрос
            statement.execute(qForCreateTable);
            System.out.println("Table " + nameDB + " is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //add new user
   public void createNewUserDbTable(String insertSQL) throws SQLException {

        String insertTableSQL = "INSERT INTO " + nameDB +
                "(USERNAME, EMAIL,PASS) " + "VALUES ";

        // System.out.println(insertTableSQL+ insertSQL); // проверка запроса
        // System.out.println(insertTableSQL+ insertSQL); // проверка запроса


        statement.executeUpdate(insertTableSQL
                + insertSQL);


    }

    //поиск по БД

    public String findByDbTable(String s) throws SQLException {

        String s1 = "SELECT * FROM " + nameDB + " WHERE EMAIL = '" + s + "'";
        ResultSet resultSet = statement.executeQuery(s1);
       // System.out.println(s1); // проверка запроса
        while (resultSet.next()) {
            if (s.equals(resultSet.getString("EMAIL"))) {
                return "пользователь существует";
            }


        }
        return s;
    }
}


