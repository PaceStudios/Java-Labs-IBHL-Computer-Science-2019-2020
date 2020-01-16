import java.util.*;
import java.lang.Math;
/**
 * Discrete Math 
 * 
 * Problem64, Page105.
 *
 * @author  
 * @version (a version number or a date)
 */
public class Problem64Page105
{
    /*
     *  1 <= num < ????
     */
    public static int evaluate_J(int num)
    {

        int t = 2;
        while(t < num){
            t*=2;
        }
        t/=2;
        int j = num - t;
        return 2*j+1;
    }
}