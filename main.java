
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class main {


    public static void main(String[] args) throws IOException {
        boolean keepInput = true;
        Scanner sc = new Scanner(System.in);

        while (true){
            storageClass.inputFoods();
            storageClass.writeCSV();
            System.out.println("Would you like to keep inputing? \n1. for yes \n2. for no ");
            while(!sc.hasNextInt()){
                System.out.println("Invalid input please enter 1 or 2: ");
                sc.next();
            }
            int keep = sc.nextInt();
            while (!(keep == 1 || keep == 2)) {
                System.out.print("Invalid input. Please enter 1 or 2: ");
                keep = sc.nextInt();
            }
            if (keep == 2){
                break;
            }


        }
        storageClass.writeCSV();
        storageClass.csvScanner();
        storageClass.removeItems();
        storageClass.clearCSV();
        storageClass.writeCSV();
        storageClass.csvScanner();
        shoppingList.generateShoppingList();

    }

}
