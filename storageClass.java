import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
            for (int o=0; o < 4;o++){
                System.out.println(foodsArray[y][o]);
            }
        }



    }

    public static void writeCSV(String foodsArray[][]) throws IOException{
        FileWriter write = new FileWriter("C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\Book1.csv");


    }

    public static void inputFoods() throws IOException{
        Scanner sc = new Scanner(System.in);


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
        //if (year< Integer.valueOf(getDate())){}

        /*
        while(sc.nextInt()>3||sc.nextInt()<1){
            System.out.print("!!! PLEASE ENTER VALID INPUT 1 or 2 or 3 !!! : ");
            sc.next();
            while (!sc.hasNextInt()){

                System.out.print("!!! PLEASE ENTER VALID INPUT 1 or 2 or 3 !!! : ");
                sc.next();
            }
        }



        category = sc.nextInt();

        //System.out.println("ur gay"+category);

        switch (category) {
            case 1:
                categorySTR = "Freezer";
                valid = true;
                break;
            case 2:
                categorySTR = "Fridge";
                valid = true;
                break;
            case 3:
                categorySTR = "Shelf";
                valid = true;
                break;
        }
        System.out.println(categorySTR);


        while (valid == false) {





            try {
                category = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("!!! PLEASE ENTER VALID INPUT 1 or 2 or 3 !!!");

            }



        }

         */
    }
}



