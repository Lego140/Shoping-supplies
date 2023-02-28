import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class timeMannager {

    public static Date getDate() {
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        return currentDate;
    }

    public static long dateToSecond(String value){
        String input,month,year,day,time;

        if (value !="-1"){
            input = value;
            month = input.substring(5,7);
            year = input.substring(0,4);
            time = input.substring(11,19);
            day = input.substring(9,10);
        }
        else {

            month = getDate().toString().substring(4, 7);
            year = (getDate() + " ").toString().substring(24, 28);
            time = getDate().toString().substring(11, 19);
            day = getDate().toString().substring(8, 10);
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
        }
        //String fullgetdate = year+"-"+month+"-"+day+" "+time;

        //System.out.println(fullgetdate);
        String Final = year+"-"+month+"-"+day+" "+time;

        //String seconds = ft.format(input);
        //int inputYear = input.substring(0,5);
        //System.out.println(seconds);



        Date t = getDate();
        Date Fcurrentdate = getDate();

        long start = System.currentTimeMillis();

        //from 1970-00-00 00:00:00
        int days = 0;
        int fyear = (Integer.valueOf(year)-1970);
        days = (fyear / 4) * 1461;
        days += (fyear % 4) * 365;

        int fmonth = Integer.valueOf(month)-1;

        switch (fmonth) {
            case 1: days += 31; break;
            case 2: days += 59; break;
            case 3: days += 90; break;
            case 4: days += 120; break;
            case 5: days += 151; break;
            case 6: days += 181; break;
            case 7: days += 212; break;
            case 8: days += 243; break;
            case 9: days += 273; break;
            case 10: days += 304; break;
            case 11: days += 334; break;
            default: days += 0;
        }

        days += Integer.valueOf(day);
        int hours = days*24 + Integer.valueOf(time.substring(0,2));
        long minutes = hours*60 + Integer.valueOf(time.substring(3,5));
        long seconds = minutes*60 + Integer.valueOf((time+" ").substring(6,8));
        //System.out.println(seconds);


        /*
        try{
            t = ft.parse(input);
            Fcurrentdate = ft.parse(Final);
            //seconds = ft.parse(Final);
            //System.out.println(t);

        }catch (ParseException e){
            System.out.println("no");
        }
        //getDate();
        //System.out.println(ft.format(getDate()));
        //etDate() = ft.format(currentdate);

        int result = t.compareTo(Fcurrentdate);



        System.out.println(result);
        System.out.println(Final);
        */


        return seconds;
    }

    public static String secondToDate() {

        return "";
    }
}
