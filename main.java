
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class main {



    public static Date getDate() {
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        return currentDate;
    }

    /*
    public static Date compareDate(){

    }
    */ //yyyy-MM-dd hh:mm:ss

    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter exsperiry date (yyyy-MM-dd) : ");
        String input1 = sc.nextLine()+" 00:00:00";
        String input = args.length == 0 ? input1 : args[0];


        String month = getDate().toString().substring(4,7);
        String year = (getDate()+" ").toString().substring(24,28);
        String time = getDate().toString().substring(11,19);
        String day = getDate().toString().substring(8,10);

        switch (month) {
            case "Jan" : month = "1"; break;
            case "Feb" : month = "2"; break;
            case "Mar" : month = "3"; break;
            case "Apr" : month = "4"; break;
            case "May" : month = "5"; break;
            case "Jun" : month = "6"; break;
            case "Jul" : month = "7"; break;
            case "Aug" : month = "8"; break;
            case "Sep" : month = "9"; break;
            case "Oct" : month = "10"; break;
            case "Nov" : month = "11"; break;
            case "Dec" : month = "12";break;
            default: month = "0";
        }

        String Final = year+"-"+month+"-"+day+" "+time;

        //String seconds = ft.format(input);
        //int inputYear = input.substring(0,5);
        //System.out.println(seconds);



        Date t = getDate();
        Date Fcurrentdate = getDate();

        long start = System.currentTimeMillis();

        //from 1970-00-00 00:00:00

        int fyear = (Integer.valueOf(year)-1970)*12;

        int fmonth = Integer.valueOf(month)-1+fyear;

        int days;

        switch (Integer.valueOf(month)) {
            case 1: case 3: case 5: case 6: case 8: case 10: case 12: days = 31;
            case 4: case 7: case 9: case 11: days = 30;
            default: if (Integer.valueOf(year)%4 == 0) {days = 29;} else {days = 28;}
        }

        System.out.println(fyear);



        try{
            t = ft.parse(input);
            Fcurrentdate = ft.parse(Final);
            //seconds = ft.parse(Final);
            //System.out.println(t);

        }catch (ParseException e){
            System.out.println("no");
        }
        getDate();
        //System.out.println(ft.format(getDate()));
        //etDate() = ft.format(currentdate);

        int result = t.compareTo(Fcurrentdate);



        System.out.println(result);
        System.out.println(Final);

    }



}
