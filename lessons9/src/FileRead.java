import java.io.*;

/**
 * Created by adm on 15.05.2017.
 */
public class FileRead {
    public static String read(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }

        }



     catch(
    IOException e)

    {
        String msg = "File not Found! Enter valid filename!";
        throw new IllegalArgumentException(msg);
    }
            return sb.toString();

        }
    }

