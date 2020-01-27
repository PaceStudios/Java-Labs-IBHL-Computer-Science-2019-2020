import java.util.*;
import java.lang.Math;
/**
 * Discrete Math 
 * 
 * Problem 8, 9 and 11, Page114.
 * Friday the 13.
 *
 * @author  
 * @version (a version number or a date)
 */
public class ProblemsPage114
{
    public static int problem_8(int n)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(0);
        while(list.size() <= n){
            list.add(list.get((list.size()/3)) + list.size());
        }
        return list.get(list.size()-1);
    }

    public static int problem_9_10(int n)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        while(list.size() <= n){
            list.add(list.get(list.size()/2)+(list.size())*(list.size()));
        }
        return list.get(n);
    }

    public static int problem_11_13(int n)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        while(list.size() <= n){
            list.add(4+list.get(list.size()/2) + list.size());
        }
        return list.get(n);
    }
}