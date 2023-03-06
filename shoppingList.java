import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shoppingList {
    public static ArrayList<ArrayList<String>> pShoppingList = new ArrayList<>();

    public static void scanShoppingList() throws IOException{
        String filePath  = System.getProperty("user.dir").replace("\\", "\\\\");
        filePath = filePath+"\\\\src\\\\shopinglist.csv";

        FileReader file = new FileReader(filePath);
        Scanner sc = new Scanner(file);
        int p = 0;
        for(int r =0;r<pShoppingList.size();r++){
            pShoppingList.remove(r);
            r = r-1;
        }


        while (sc.hasNextLine()) {
            String values[] = sc.nextLine().split(",");
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(values));
            pShoppingList.add(row);
            p++;
        }






        }
    public static void clearShoppingList(){
        String filePath  = System.getProperty("user.dir").replace("\\", "\\\\");
        filePath = filePath+"\\\\src\\\\shopinglist.csv";

        String csvFilePath = filePath;

        try {
            FileWriter writer = new FileWriter(csvFilePath, false);
            writer.write("");  // write an empty string to clear the file
            writer.close();
            //System.out.println("Shopping list cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void generateShoppingList(){
        /*
        for (int i = 0; i< storageClass.pfoodsArray.size();i++){
            if (storageClass.pfoodsArray.get(i).get(3) == "T"){
                pShoppingList.add(storageClass.pfoodsArray.get(i));
            }
        }

         */




    }

    public static List<String> findDuplicateStrings(ArrayList<ArrayList<String>> pShoppingList) {
        List<String> duplicates = new ArrayList<>();
        List<String> uniqueStrings = new ArrayList<>();
        for (List<String> sublist : pShoppingList) {
            for (String str : sublist) {
                if (!uniqueStrings.contains(str)) {
                    uniqueStrings.add(str);
                } else {
                    if (!duplicates.contains(str)) {
                        duplicates.add(str);
                    }
                }
            }
        }
        return duplicates;
    }

    public static void writeShopingList() throws IOException {
        String filePath  = System.getProperty("user.dir").replace("\\", "\\\\");
        filePath = filePath+"\\\\src\\\\shopinglist.csv";

        // create a new file object
        File csvFile = new File(filePath);

        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filePath, true));

        // add data to the CSV file on the next line
        for (int i = 0; i < pShoppingList.size(); i++) {
            String result = pShoppingList.get(i).toString().replaceAll("[\\[\\]\\s]", "");
            csvWriter.write(result + ",");
            csvWriter.newLine();
        }

        csvWriter.close();
    }

    public static void viewShoppingList(){

        System.out.println("------------------------- Current shopping list -------------------------");

        String naming []= {"categorie: ","name: ","amount: "};

        for (int i = 0; i < pShoppingList.size();i++) {
            for (int m = 0; m < 3; m++) {
                System.out.print(naming[m]);
                System.out.println(pShoppingList.get(i).get(m) + " ");
            }

            System.out.println("-----------------------------------------");
        }

    }

    public static void inputShoppingList(){
        Scanner sc = new Scanner(System.in);



        System.out.println("-----------------------------------------\nInput items to shopping list\n-----------------------------------------");
        String categorySTR = "";
        System.out.println("What categorie is this item?\n1. Freezer\n2. Fridge\n3. Shelf\nEnter 1 or 2 or 3 ");

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



        System.out.println("input name of your item: ");
        while (sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter name: ");
            sc.next();
        }
        String name = sc.next();

        System.out.println("| Successful input |\nEnter amount: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter amount in numbers: ");
            sc.next();
        }
        String amount = sc.next();

        String add[] = {categorySTR,name,amount};

        ArrayList<String> firstLayerData = new ArrayList<>();
        for (int b= 0; b<3;b++) {
            firstLayerData.add(add[b]);
            //System.out.println(firstLayerData);
        }

        pShoppingList.add(firstLayerData);



    }

    public static void removeShoppingList(){
        Scanner sc = new Scanner(System.in);
        String naming[] = {"categorie: ", "Item name: ", "Amount: "};
        System.out.println("|| Remove Items in shopping list ||\nThis is whats in you shopping list right now: ");
        //System.out.println(pfoodsArray);

        int identification = 1;


        System.out.println("--------------- No." + identification + " ---------------");

        for (int i = 0; i < pShoppingList.size(); i++) {
            for (int m = 0; m < 3; m++) {
                System.out.print(naming[m]);
                System.out.println(pShoppingList.get(i).get(m) + " ");
            }


            identification++;

            System.out.println("--------------- No." + identification + " ---------------");
        }
        System.out.println("delete nothing back to menu");
        System.out.println("------------------------------------");



        System.out.println("|| Input NO. you want to remove from shopping list ||");


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
        for (int i = 0; i < pShoppingList.size(); i++) {
            if (remove == (identification)) {


            } else if ((i == remove) && (remove != identification)){
                deleted.add(pShoppingList.get(i).get(0));
                deleted.add(pShoppingList.get(i).get(1));
                deleted.add("1");
                pShoppingList.remove(i);
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




            }
    }








}
