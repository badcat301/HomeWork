import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adm on 14.05.2017.
 */
public class EntryPoint {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.printf("If you want to create a file Enter - 1."+"\n"+"If you want to read the file Enter - 2."+"\n");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();




     switch (num){
         case 1:
             System.out.println("Enter the filename:");
             Scanner sc = new Scanner(System.in);
             String fileName = sc.nextLine();
             System.out.println("Enter the file text:");
             String fileText= sc.nextLine();
             FileWrite.write(fileName,fileText);
             break;

         case 2:
             System.out.println("Enter the filename you want to read:");
             Scanner fr = new Scanner(System.in);
             String fileRead = fr.nextLine();

                 System.out.println(FileRead.read(fileRead));


break;



     }


    }
}
