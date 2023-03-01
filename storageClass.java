import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class storageClass {

    public static void csvScanner() throws IOException{
        ArrayList<ArrayList<String>> foods = new ArrayList<>();

        FileReader file = new FileReader("C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv");
        Scanner sc = new Scanner(file);
        //System.out.println(sc.nextLine());
        int p=0;

        while (sc.hasNextLine()){
            String values[] = sc.nextLine().split(",");
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(values));
            foods.add(row);
            p++;
        }

        String [][] foodsArray=new String[p][];
        for (int i =0; i< p;i++){
            ArrayList<String> row = foods.get(i);
            foodsArray[i] = row.toArray(new String[row.size()]);
        }

        for (int y=0; y<p;y++){
            for (int o=0; o < 3;o++){
                System.out.println(foodsArray[y][o]);
            }
        }

        public static void csvInputer;(){

        }


    }





}



