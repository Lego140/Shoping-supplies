import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class storageClass {
    static List<String> firstLayerData = new ArrayList<>();
    static List<List<String>> twoLayerListArray = new ArrayList<>();
    static int currentRow = 0;

 
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


        for (int d=0;d<p;d++) {
            foodsArray[d][0] =   foodsArray[d][0].substring(2, foodsArray[d][0].length());
            foodsArray[d][3] =   foodsArray[d][3].substring(1, 2);
            foodsArray[d][1] =   foodsArray[d][1].substring(1, foodsArray[d][1].length());
            foodsArray[d][2] =   foodsArray[d][2].substring(1, foodsArray[d][2].length());
        }

        for (int y=0; y<p;y++){
            for (int o=0; o < 4;o++){
                System.out.println(foodsArray[y][o]);
            }
        }
    }

    public static void writeCSV() throws IOException{

        String filePath = "C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv";

        // create a new file object
        File csvFile = new File(filePath);


        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filePath, true));



        // add data to the CSV file on the next line

        csvWriter.newLine();
        csvWriter.write(twoLayerListArray+",");
        twoLayerListArray.clear();
        firstLayerData.clear();
        csvWriter.close();


    }

    public static void inputFoods() throws IOException{


        Scanner sc = new Scanner(System.in);

        String test[] = {"d","w","w","t"};

        //foods.add(row);


        String categorySTR = "";


        System.out.println("| FOOD INPUT |" + "\nWhere are you storing the food?\n1. Freezer\n2. Fridge\n3. Shelf\nEnter 1 or 2 or 3 ");

        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number 1 2 or 3: ");
            sc.next();
        }
        int category = sc.nextInt();

        while (category < 1 || category > 3) {
            System.out.print("Invalid input. Please enter 1 2 or 3: ");
            category = sc.nextInt();
        }

        switch (category) {
            case 1:
                categorySTR = "Freezer";

                break;
            case 2:
                categorySTR = "Fridge";

                break;
            case 3:
                categorySTR = "Shelf";

                break;

            default: categorySTR = "bad";
        }

        System.out.println("| Successful input |\nEnter the name of your item: ");

        while (sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter name: ");
            sc.next();
        }
        String name = sc.next();

        System.out.println("| Successful input |\nEnter the Exspiary date of the item in YYYY-MM-dd: ");
        while (!sc.hasNext("\\d\\d\\d\\d-\\d\\d-\\d\\d")) {
            System.out.print("Invalid input. Please enter Exspiary date of the item in YYYY-MM-dd\nif it is a digit day ex the 4th do 04 instead: ");

            sc.next();
        }



        String exp = sc.next();
        //String currentYear = (Date() + " ").toString().substring(24, 28);
        int year = Integer.valueOf(exp.substring(0,4));
        System.out.println(year);
        //timeMannager.dateToSecond(exp);
        //System.out.println(timeMannager.dateToSecond(exp));
        //if (year< Integer.valueOf(getDate())){}

        /*
        test[0]=categorySTR;
        test[1]=name;
        test[2]=exp;
        test[3] = "F";
        String test2 [currentRow];
        ArrayList<String> row = new ArrayList<String>(Arrays.asList(test));
        for (int i =0; i< 4;i++){
            //ArrayList<String> row = test[i];
            test2[currentRow] = row.toArray(new String[]);
        }

         */

        test[0]=categorySTR;
        test[1]=name;
        test[2]=exp;
        test[3] = "F";


        for (int b= 0; b<4;b++) {
            firstLayerData.add(test[b]);
            System.out.println(firstLayerData);
        }
        twoLayerListArray.add(firstLayerData);




        currentRow++;





        }

        public

        public static void removethings(){
            System.out.println();
    }


    }




