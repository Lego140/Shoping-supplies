import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class shoppingList {
    public static ArrayList<ArrayList<String>> pShoppingList = new ArrayList<>();
    public static void generateShoppingList(){
        /*
        for (int i = 0; i< storageClass.pfoodsArray.size();i++){
            if (storageClass.pfoodsArray.get(i).get(3) == "T"){
                pShoppingList.add(storageClass.pfoodsArray.get(i));
            }
        }

         */

        /////////////  NO CLUE HOW TO DO THIS BUT I WANT TO MAKE IT SO IF THEY ARE DUPLICATE NAMES IN SHOPINGLIST IT COMBINES THEM AND CHANGES THE QUANTITY PART OF THE VARIBLE
        boolean hasDuplicates = false;
        ArrayList<String> flattenedList = new ArrayList<String>();
        for (ArrayList<String> row : pShoppingList) {
            for (String item : row) {
                if (flattenedList.contains(item)) {
                    hasDuplicates = true;
                    break;
                } else {
                    flattenedList.add(item);
                }
            }
        }

        if (hasDuplicates) {
            System.out.println("The 2D ArrayList contains duplicate data.");

        } else {
            System.out.println("The 2D ArrayList does not contain duplicate data.");
        }




        System.out.println("|| Shoping List ||");
        for (int l=0;l< flattenedList.size();l++){
            System.out.println(flattenedList.get(l));
        }

    }

    public static void writeShopingList() throws IOException {

        String filePath = "C:\\Users\\woranath\\IdeaProjects\\Shopping list challenge\\src\\shopinglist.csv";

        // create a new file object
        File csvFile = new File(filePath);


        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filePath, true));


        //            String result = pfoodsArray.get(r).toString().replaceAll("[\\[\\]]", "");
        //            csvWriter.write(pfoodsArray.get(i).get(o)+",");
        //String result = pfoodsArray.get(0).toString().replaceAll("[\\[\\]]", "");

        // add data to the CSV file on the next line
        String result = null;
        for (int i =0; i < pShoppingList.size();i++){
            for (int o = 0; o< 4;o++){
                result = pShoppingList.get(i).toString().replaceAll("[\\[\\]\\s]", "");

            }
            csvWriter.write(result+",");
            csvWriter.newLine();
        }

        csvWriter.close();


    }



}
