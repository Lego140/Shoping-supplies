import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class notification {

    public static ArrayList<ArrayList<String>> pExpArray = new ArrayList<>();
    static ArrayList<String> row = new ArrayList<>();
    private static Integer[] addElement(Integer[] arr, int element, int position) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(position, element);
        list.remove(6);
        return list.toArray(arr);
    }
    public static void  generateExpList() {
        String[] tempList= {"","","",""};
        for (int i = 0; i < storageClass.pfoodsArray.size(); i++) {
                if ((((timeMannager.dateToSecond(storageClass.pfoodsArray.get(i).get(2))) - (timeMannager.dateToSecond("-1"))) < 0)) {
                    //categorrie name expDate howlongexpfor
                    for(int u= 0; u<3;u++){
                        tempList [u] =  storageClass.pfoodsArray.get(i).get(u);
                    }
                    //tempList[3] = String.valueOf(  timeMannager.secondToDate   ((timeMannager.dateToSecond(storageClass.pfoodsArray.get(i).get(2))) - (timeMannager.dateToSecond("-1"))));
                    tempList[3] = timeMannager.secondToDate((timeMannager.dateToSecond(storageClass.pfoodsArray.get(i).get(2))) - (timeMannager.dateToSecond("-1")));
                    ArrayList<String> row = new ArrayList<String>(Arrays.asList(tempList));
                    pExpArray.add(row);
            }
        }
    }

    public static void notificationForStuffAlreadyExpired() throws IOException {
        storageClass.csvScanner();
        String naming[] = {"categorie: ","Item name: ","EXP date (YYYY-MM-dd): ","time its been expired for: "};
        System.out.println("----------------------------------\nItems already exspired\n----------------------------------");
        for (int k=0; k< pExpArray.size();k++){
            System.out.println("-----------------------------------------");
            for (int m=0;m<4;m++) {
                System.out.print(naming[m]);
                System.out.println(pExpArray.get(k).get(m) + " ");
            }
            System.out.println("-----------------------------------------");

        }
    }
    public static void notificaionForAboutToExpired() throws IOException {
        storageClass.csvScanner();
        //need to make it so everytime this function is called it printeds the top most expired part.
        Integer[] soonToDie = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < storageClass.pfoodsArray.size(); i++) {
            for (int k = 0; k < 5; k++) {
                if ((timeMannager.dateToSecond(storageClass.pfoodsArray.get(soonToDie[k]).get(2)) - (timeMannager.dateToSecond("-1")) < (timeMannager.dateToSecond(storageClass.pfoodsArray.get(i).get(2))) - (timeMannager.dateToSecond("-1"))) && ((timeMannager.dateToSecond(storageClass.pfoodsArray.get(i).get(3))) - (timeMannager.dateToSecond("-1")) > 0)) {
                    soonToDie = addElement(soonToDie, i, k);
                    break;
                }
            }
        }
        System.out.println("|Soon To Expire|");
        for (int i = 1; i <= 5; i++) {
            String month, days, hour, minute, second;
            int year;
            year = Integer.valueOf(storageClass.pfoodsArray.get(soonToDie[1]).get(2).substring(0, 4));
            month = storageClass.pfoodsArray.get(soonToDie[i]).get(2).substring(5, 7);
            days = storageClass.pfoodsArray.get(soonToDie[i]).get(2).substring(8, 10);
            hour = storageClass.pfoodsArray.get(soonToDie[i]).get(2).substring(11, 13);
            minute = storageClass.pfoodsArray.get(soonToDie[i]).get(2).substring(14, 16);
            second = storageClass.pfoodsArray.get(soonToDie[i]).get(2).substring(17, 19);
            System.out.println("A " + storageClass.pfoodsArray.get(soonToDie[i]).get(1) + " in the " + storageClass.pfoodsArray.get(soonToDie[i]).get(0) + " will expire in " + year + " years " + month + " month " + days + " days " + hour + " hours " + minute + " minutes and " + second + " seconds");
        }
    }
}



