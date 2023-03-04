
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class main {
    static boolean menuLoop = true;

    public static void callMenue() throws IOException{
        Scanner sc = new Scanner(System.in);
        int width = 100;
        int height = 20;
        System.out.println("---------------------------------------------------------------------------------------------------");

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Menue", 10, 10);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(" \nthe Storage system that will never make you foget to buy your supplies and never eat exspirred food again. \nAlways have healthy safe food to eat.");

        System.out.println(" \n----------------------------------------------\nPick a operation below\n----------------------------------------------");
        System.out.println("1. Input foods to system \n ");
        System.out.println("2. Remove foods to system \n ");
        System.out.println("3. Check what foods are in your system currently \n ");
        System.out.println("4. Input foods to shopping list \n ");
        System.out.println("5. Remove foods from shopping list \n ");
        System.out.println("6. Generate and Check whats in your shopping list \n ");



        System.out.println("\n----------------------------------------------\nNotifications\n----------------------------------------------");

        notification.notificaionForAboutToExpired();

        // Atony input you notification funtion here @@@@@

        //idealy it should print out something like
        // Item name will exspire in No.days  no.hours hours

        while (!sc.hasNextInt()) {
            System.out.print("Invalid input Please enter a number 1 to 6 from: \n1. Input foods to system \n2. Remove foods to system \n3. Check what foods are in your system currently \n4. Input foods to shopping list \n5. Remove foods from shopping list \n6. Generate and Check whats in your shopping list \n");
            sc.next();
        }
        int menuePick = sc.nextInt();

        while (menuePick < 1 || menuePick > 6) {
            System.out.print("Invalid input Please enter a number 1 to 6 from: \n1. Input foods to system \n2. Remove foods to system \n3. Check what foods are in your system currently \n4. Input foods to shopping list \n5. Remove foods from shopping list \n6. Generate and Check whats in your shopping list \n");
            menuePick = sc.nextInt();
        }

        switch (menuePick){
            case 1 : inputFoodLoop(); break;
            case 2 : {
                storageClass.csvScanner();
                storageClass.removeItems();
                storageClass.clearCSV();
                storageClass.writeCSV();
                shoppingList.writeShopingList();
                break;
            }
            case 3 :  storageClass.viewStorage(); break;
            case 4 : {
                shoppingList.scanShoppingList();
                shoppingList.viewShoppingList();
                shoppingList.inputShoppingList();
                shoppingList.clearShoppingList();
                shoppingList.writeShopingList();
                break;
            }
            case 5: {
                shoppingList.scanShoppingList();
                shoppingList.removeShoppingList();
                shoppingList.clearShoppingList();
                shoppingList.writeShopingList();
                break;
            }
            case 6: {
                shoppingList.scanShoppingList();
                shoppingList.viewShoppingList();
            }


        }


        while (true) {
            System.out.println("would you like to close the system?\nYes or no: ");
            String yn = sc.nextLine().trim();

            if (yn.equalsIgnoreCase("Yes") || yn.equalsIgnoreCase("No")) {
                if (yn.equalsIgnoreCase("No")){
                    menuLoop = false;
                }
                break;
            } else {
                // invalid input, ask user to try again
                System.out.println("Invalid input Enter yes or no");
            }

        }

    }

    public static void inputFoodLoop() throws IOException{
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
    }


    public static void main(String[] args) throws IOException {
        storageClass.csvScanner();
        shoppingList.scanShoppingList();
        notification.generateExpList();

        while (menuLoop == true) {
            callMenue();

        }
        System.out.println("-------------------------- \nSystem closed\n-------------------------- ");




    }

}
