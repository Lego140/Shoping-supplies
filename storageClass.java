import java.io.*;
import java.util.Scanner;
public class storageClass {

    public void csvScanner(){
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv"));
            sc.useDelimiter(",");   //sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                System.out.print(sc.next());  //find and returns the next complete token from this scanner
            }
            sc.close();  //closes the scanner
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



