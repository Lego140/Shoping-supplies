import java.security.PrivateKey;
import java.util.Date;

public class timeMannager {

    private static Date getDate() {
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return new Date();
    }
    private static String addZero(int input){
        String output = String.valueOf(input);
        if (String.valueOf(input).length() == 1){
            output = "0"+input;
        }
        return output;
    }

    public static long dateToSecond(String value){
        String input,month,year,day,time;

        if (value != "-1"){
            input = value;
            month = input.substring(5,7);
            year = input.substring(0,4);
            time = "00:00:00";
            day = input.substring(9,10);
        }
        else {

            month = getDate().toString().substring(4, 7);
            year = (getDate() + " ").toString().substring(24, 28);
            time = getDate().toString().substring(11, 19);
            day = getDate().toString().substring(8, 10);
            switch (month) {
                case "Jan" : month = "01"; break;
                case "Feb" : month = "02"; break;
                case "Mar" : month = "03"; break;
                case "Apr" : month = "04"; break;
                case "May" : month = "05"; break;
                case "Jun" : month = "06"; break;
                case "Jul" : month = "07"; break;
                case "Aug" : month = "08"; break;
                case "Sep" : month = "09"; break;
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

    public static String secondToDate(long input) {
        int month=0,year,day= 0,hour, minute, second;

        year = (Integer.valueOf((int) input)/126230400)*4;
        input %= 126230400;
        year += (Integer.valueOf((int) input))/31536000;
        input %= 31536000;

        for (int i = 1; (input - day) > 0; i++){
            switch (i) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12: day = 2678400; break;
                case 4: case 6: case 9: case 11: day = 2592000; break;
                default: if (year%4 == 0) {day = 2505600;} else {day = 2419200;} break;
            }
            //System.out.println(input);
            input -= day;
            month = i;
        }
        month += 1;
        day = (Integer.valueOf((int) input))/86400;
        //System.out.println(day);
        input %= 86400;
        hour = (Integer.valueOf((int) input))/3600;
        input %= 3600;
        minute = (Integer.valueOf((int) input))/60;
        input %= 60;
        second = (Integer.valueOf((int) input));



        return (year + 1970) + "-"+ (addZero(month))+"-"+(addZero(day))+" "+(addZero(hour))+":"+(addZero(minute))+":"+(addZero(second));
    }
}
