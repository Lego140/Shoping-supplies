import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class storageClass {

    public static void csvScanner() throws IOException{
        List<String[]> everything = new ArrayList<String[]>();

        FileReader file = new FileReader("Book1.csv");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            everything.add(new String[]{"","","",""});
        }



        for (String[] row : everything){
            Log.i(Tag,row[0]);
        }

    }
}



