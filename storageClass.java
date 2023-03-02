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

    public static ArrayList<ArrayList<String>> pfoodsArray = new ArrayList<>();
    public static ArrayList<String> row = new ArrayList<>();

 
    public static void csvScanner() throws IOException{
        FileReader file = new FileReader("C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv");
        Scanner sc = new Scanner(file);
        int p = 0;

        while (sc.hasNextLine()){
            String values[] = sc.nextLine().split(",");
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(values));
            pfoodsArray.add(row);
            p++;
        }

        System.out.println(pfoodsArray);

        for (int d=0; d<p; d++) {
            ArrayList<String> row = pfoodsArray.get(d);
            //row.set(0, row.get(0).substring(2, pfoodsArray.get(d).length()));
            //row.set(3, row.get(3).substring(1, 2));
            //row.set(1, row.get(1).substring(1,pfoodsArray.get(d).length()));
            //row.set(2, row.get(2).substring(1,pfoodsArray.get(d).length()));

            //row.set(0, row.get(0).substring(0));
            //row.set(1, row.get(1).substring(1));
            //row.set(2, row.get(2).substring(1));
            //row.set(3, row.get(3).substring(1, 2));



        }






    }


    public static void writeCSV() throws IOException{

        String filePath = "C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv";

        // create a new file object
        File csvFile = new File(filePath);


        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filePath, true));


        //            String result = pfoodsArray.get(r).toString().replaceAll("[\\[\\]]", "");
        //            csvWriter.write(pfoodsArray.get(i).get(o)+",");
        //String result = pfoodsArray.get(0).toString().replaceAll("[\\[\\]]", "");

        // add data to the CSV file on the next line
        String result = null;
        for (int i =0; i < pfoodsArray.size();i++){
            for (int o = 0; o< 4;o++){
                result = pfoodsArray.get(i).toString().replaceAll("[\\[\\]\\s]", "");

            }
            csvWriter.write(result+",");
            csvWriter.newLine();
        }

        for (int i =0; i < twoLayerListArray.size();i++){

            result = twoLayerListArray.get(i).toString().replaceAll("[\\[\\]\\s]", "");
            csvWriter.write(result+",");

            csvWriter.newLine();
        }


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



        public static void removeItems() throws IOException{
            Scanner sc = new Scanner(System.in);
            String naming[] = {"categorie: ","Item name: ","EXP date (YYYY-MM-dd): ","In your shopping list (F - false | T - True): "};
            System.out.println("|| Remove Items ||\nThis is whats in you storage right now: ");
            //System.out.println(pfoodsArray);
            int identification = 1;


            System.out.println("--------------- No."+identification+" ---------------");

            for (int i = 0; i < pfoodsArray.size();i++){
                for (int m=0;m<4;m++) {
                    System.out.print(naming[m]);
                    System.out.println(pfoodsArray.get(i).get(m) + " ");
                }

                
                identification++;
                
                System.out.println("--------------- No."+identification+" ---------------");
            }

            System.out.println("|| Input NO. you want to remove from storage ||");


            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number that is more then "+identification+" : ");
                sc.next();
            }
            int remove = sc.nextInt();

            while (remove < 1 || remove > identification) {
                System.out.print("Invalid input. Please enter a number that is more then "+identification+" : ");
                remove = sc.nextInt();
            }

            remove = remove-1;
            //String []deleted ={""};

            ArrayList<String> deleted = new ArrayList<String>();

            for (int i = 0; i < pfoodsArray.size(); i++) {
                if (i == remove) {;
                    deleted.add(pfoodsArray.get(i).get(0));
                    deleted.add(pfoodsArray.get(i).get(1));
                    deleted.add("1");
                    deleted.add("T");
                    pfoodsArray.remove(i);

                }
            }


            System.out.println("------------ Deleted item ------------ \n"+deleted+"\n------------------------------------- ");


            boolean loop= true;
            while (loop) {
                System.out.println("Would you like to put this item in your Shopping list (Yes or No) : ");
                String yn = sc.nextLine().trim();

                if (yn.equalsIgnoreCase("Yes") || yn.equalsIgnoreCase("No")) {
                    // valid input, do something
                    shoppingList.pShoppingList.add(deleted);
                    break;
                } else {
                    // invalid input, ask user to try again
                    System.out.println("Invalid input, please try again.");
                }

            }







    }

    public static void clearCSV(){

        String csvFilePath = "C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv";

        try {
            FileWriter writer = new FileWriter(csvFilePath, false);
            writer.write("");  // write an empty string to clear the file
            writer.close();
            System.out.println("CSV file cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}








