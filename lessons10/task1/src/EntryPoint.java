import javax.print.DocFlavor;
import java.sql.*;
import java.util.Scanner;
import java.util.StringJoiner;

import static java.awt.SystemColor.text;

/**
 * Created by adm on 21.05.2017.
 */
public class EntryPoint {





    public static void main(String[] args) throws SQLException {





        System.out.print("If you want to Sign up Enter - 1." + "\n" + "If you want to Sign in Enter - 2." + "\n");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        DbConnect dbConnect = new DbConnect();

        dbConnect.getDBConnection();
        try {
            dbConnect.createDbUserTable();
        } catch (SQLException e) {
            System.out.println("Connection is false"+e.getMessage());
        }
        switch (num) {
            case 1:
                System.out.println("Enter the Name:");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                System.out.println("Enter the Email:");
                String email = sc.nextLine();
                System.out.println("Enter the Password:");
                String pass = sc.nextLine();

if(!email.equals(dbConnect.findByDbTable(email))) {

    String newUsers = "('" + name + "', '" + email + "', '" + pass + "')";
    dbConnect.createNewUserDbTable(newUsers);
    dbConnect.getDBConnection().close();

    }


                break;

           case 2:
               Scanner scSignIn= new Scanner(System.in);
               System.out.println("Enter the Email:");
               String emailSignIn= scSignIn.nextLine();
               System.out.println("Enter the Password:");
               String passSignIn=  scSignIn.nextLine();

                break;

       }
    }



}

