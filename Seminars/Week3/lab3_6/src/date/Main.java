package date;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

    }

    public static void printListOfAllFriday13(){
        Random random= new Random();
        random.nextInt(1900,2021);
        LocalDate date = LocalDate.of(year,1,13);
                while(date.getYear()==year){
                    if (date.getDayOfWeek()==dayOfWeek.FRIDAY){
                        System.out.println(date);
                    }
                    date=date.plusMonths(1);
                }
    }
}
