import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class storageClass {
    static ArrayList<String> firstLayerData = new ArrayList<>();
    static List<List<String>> twoLayerListArray = new ArrayList<>();
    static int currentRow = 0;

    public static ArrayList<ArrayList<String>> pfoodsArray = new ArrayList<>();
    public static ArrayList<String> row = new ArrayList<>();

 
    public static void csvScanner() throws IOException{
        String filePath  = System.getProperty("user.dir").replace("\\", "\\\\");
        filePath = filePath+"\\\\src\\\\Book1.csv";

        //notification.generateExpList();
        FileReader file = new FileReader(filePath);
        Scanner sc = new Scanner(file);
        int p = 0;
        for (int n = 0; n<pfoodsArray.size();n++){
            pfoodsArray.remove(n);
            n = n-1;
        }

        while (sc.hasNextLine()){
            String values[] = sc.nextLine().split(",");
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(values));


            pfoodsArray.add(row);
            p++;
        }

        for (int j = 0;j<pfoodsArray.size();j++){
            for(int l = 0;l < notification.pExpArray.size();l++){

                if (pfoodsArray.get(j).get(1) == notification.pExpArray.get(l).get(1)){
                    pfoodsArray.remove(j);

                }


            }

        }



        //System.out.println(pfoodsArray);







    }


    public static void writeCSV() throws IOException{


        String filePath  = System.getProperty("user.dir").replace("\\", "\\\\");
        filePath = filePath+"\\\\src\\\\Book1.csv";
        // create a new file object
        File csvFile = new File(filePath);


        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(csvFile, true));


        //            String result = pfoodsArray.get(r).toString().replaceAll("[\\[\\]]", "");
        //            csvWriter.write(pfoodsArray.get(i).get(o)+",");
        //String result = pfoodsArray.get(0).toString().replaceAll("[\\[\\]]", "");

        // add data to the CSV file on the next line
        String result = "";
        String fresult [] ={"","","",""};

        for (int i =0; i < pfoodsArray.size();i++){
            result = pfoodsArray.get(i).toString().replaceAll("[\\[\\]\\s]", "");
            csvWriter.write(result+",");
            csvWriter.newLine();
        }


        /*
        for (int i =0; i < pfoodsArray.size();i++){

            for (int o = 0; o< 4;o++){
                //result = pfoodsArray.get(i).toString().replaceAll("[\\[\\]\\s]", "");
                //fresult [o] = pfoodsArray.get(i).get(o);
                csvWriter.write(pfoodsArray.get(i).get(o)+",");
            }
            //System.out.println(fresult);
            //csvWriter.writeNext(fresult+",");
            csvWriter.newLine();
        }

         */





        //firstLayerData.clear();
        csvWriter.close();

    }

    public static void inputFoods() throws IOException{
        firstLayerData.clear();


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

        System.out.println("| Successful input |");



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // disallow invalid dates like Feb 30
        String exp2 = "d";
        exp2 = sc.nextLine();
        System.out.print("Enter a date in the format yyyy-MM-dd: ");

        while ((!sc.hasNext("\\d\\d\\d\\d-\\d\\d-\\d\\d"))){
            System.out.print("Invalid input. Please enter Exspiary date of the item in YYYY-MM-dd\nif it is a digit day ex the 4th do 04 instead: ");

            sc.next();
        }
        exp2 = sc.nextLine();



        //String currentYear = (Date() + " ").toString().substring(24, 28);

        //System.out.println(year);
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
        test[2]= exp2 ;
        test[3] = "F";

        for (int b= 0; b<4;b++) {
            firstLayerData.add(test[b]);

            //pfoodsArray.get(pfoodsArray.size()+1).add(test[b]);
            //System.out.println(firstLayerData);
        }
        pfoodsArray.add(firstLayerData);
        System.out.println(pfoodsArray);
        System.out.println(firstLayerData);




        currentRow++;





        }



        public static void removeItems() throws IOException {
            Scanner sc = new Scanner(System.in);
            String naming[] = {"categorie: ", "Item name: ", "EXP date (YYYY-MM-dd): ", "In your shopping list (F - false | T - True): "};
            System.out.println("|| Remove Items ||\nThis is whats in you storage right now: ");
            //System.out.println(pfoodsArray);
            int identification = 1;


            System.out.println("--------------- No." + identification + " ---------------");

            for (int i = 0; i < pfoodsArray.size(); i++) {
                for (int m = 0; m < 4; m++) {
                    System.out.print(naming[m]);
                    System.out.println(pfoodsArray.get(i).get(m) + " ");
                }


                identification++;

                System.out.println("--------------- No." + identification + " ---------------");
            }
            System.out.println("delete nothing back to menu");
            System.out.println("------------------------------------");


            System.out.println("|| Input NO. you want to remove from storage ||");


            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number that is more then " + identification + " : ");
                sc.next();
            }
            int remove = sc.nextInt();

            while (remove < 1 || remove > identification) {
                System.out.print("Invalid input. Please enter a number that is more then " + identification + " : ");
                remove = sc.nextInt();
            }

            remove = remove - 1;
            //String []deleted ={""};

            ArrayList<String> deleted = new ArrayList<String>();
            boolean keepGoing = false;
            for (int i = 0; i < pfoodsArray.size(); i++) {
                if (remove == (identification)) {


                } else if ((i == remove) && (remove != identification)){
                    deleted.add(pfoodsArray.get(i).get(0));
                    deleted.add(pfoodsArray.get(i).get(1));
                    deleted.add(pfoodsArray.get(i).get(2));
                    deleted.add("1");
                    pfoodsArray.remove(i);
                    keepGoing = true;

                }
            }
            if (keepGoing == true){
                System.out.println("------------ Deleted item ------------");

                for (int m = 0; m < 3; m++) {
                    System.out.print(naming[m]);
                    System.out.println(deleted.get(m) + " ");
                }
                System.out.println("--------------------------------------");

                //System.out.println("------------ Deleted item ------------ \n" + deleted + "\n------------------------------------- ");


                 boolean loop = true;
                 while (loop) {
                     System.out.println("Would you like to put this item in your Shopping list (Yes or No) : ");
                     String yn = sc.nextLine().trim();

                     if (yn.equalsIgnoreCase("Yes") || yn.equalsIgnoreCase("No")) {
                    // valid input, do something
                         deleted.remove(3);
                         deleted.remove(2);
                         deleted.add("1");
                         //System.out.println("TES TESTES "+deleted);
                         if (yn.equalsIgnoreCase("Yes")){
                             shoppingList.pShoppingList.add(deleted);
                         }
                         break;
                    } else {
                    // invalid input, ask user to try again
                    System.out.println("Invalid input, please try again.");
                    }

                }
        }








    }

    public static void clearCSV(){

        String csvFilePath = "C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv";

        try {
            FileWriter writer = new FileWriter(csvFilePath, false);
            writer.write("");  // write an empty string to clear the file
            writer.close();
            //System.out.println("CSV file cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewStorage() throws IOException {
        String naming[] = {"categorie: ","Item name: ","EXP date (YYYY-MM-dd): ","In your shopping list (F - false | T - True): "};
        System.out.println("----------------------------------\nThis is whats in you storage right now\n----------------------------------");
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
        notification.notificationForStuffAlreadyExpired();

    }






}








