import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @author John C. Pace  
 * @version 01/30/2020
 */
public class Problem107Page134
{
    /*
     *  returns an array of all months with a Friday the 13th in Calendar order
     *        Use the following Strings for each Month
     *        "Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"
     *
     *  Please note:  The objective of this program is to use the formula presented in the book.
     *      
     *  The tester test long ago years (like year 1, 2, etc.) which may differ from actual Friday the 13ths
     *     
     *  More on Leap Years (According to wikipedia):
     *        Every year that is exactly divisible by four is a leap year,
     *        except for years that are exactly divisible by 100,
     *        butd these centurial years are leap years if they are exactly divisible by 400.
     *        For example, the years 1700, 1800, and 1900 were not leap years, but the years 1600 and 2000 were
     */
    public static String[] findFriday13(int year)
    {
        String[] ans = {null, "Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        List<String> chosenMonths = new ArrayList<String>();
        for(int i = 1; i <ans.length;i++){
            int currentDay = day_of_the_week(year, i, 13);
            System.out.println("The 13th of " + ans[i] + "Will be on Day " + currentDay);
            if(currentDay == 5){
                System.out.println("The Month of " + ans[i] + " Has a Friday the 13th.");
                chosenMonths.add(ans[i]);}
        }
        String repl[] = new String[chosenMonths.size()];
        for(int i = 0; i < chosenMonths.size(); i++){
            repl[i] = chosenMonths.get(i);
        }
        System.out.println("The finished List: ");
        for(int i = 0; i < repl.length; i++){
            System.out.println(repl[i] + ",");}
        return repl;
    }

    public static int day_of_the_week(int y, int m, int d) 
    { 
        // array with leading number of days values 
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 

        // if month is less than 3 reduce year by 1 
        if (m < 3) 
            y -= 1; 

        return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7; 
    } 
    /**
     * For more information look up Day Algorithm and Sakomoto's Algorithm
     */

}