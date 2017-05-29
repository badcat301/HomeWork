import java.io.*;
import java.util.Scanner;

/**
 * Created by adm on 14.05.2017.
 */
public class FileWrite{
    public static void write(String fileName, String text)
    {

        File file = new File(fileName);

        try ( BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
            if(!file.exists()){
                file.createNewFile();
            }

            out.write(text);
       out.close();




        } catch(IOException e) {
            throw new RuntimeException(e);
        }


    }
}
