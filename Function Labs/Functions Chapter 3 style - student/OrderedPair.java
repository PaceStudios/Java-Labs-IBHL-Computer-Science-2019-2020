import java.util.*;
import java.lang.Math;
/**
 *
 * @author  John C. Pace
 * @version (02/13/20)
 */
public class OrderedPair
{
    private String x;
    private String y;

    public OrderedPair(String x1, String y1)
    {
        x = x1;
        y = y1;
    }

    public String getX() { return x; }

    public String getY() { return y; }

    /*
     *    If you want to compare two OrderedPair objects for equality,
     *    you need to correctly implement this method
     */
    public boolean equals(Object obj)
    {
        OrderedPair temp = (OrderedPair) (obj);
        if (temp.getX()==x && temp.getY()==y)
        {
            return true;
        }
        return false;
    }

    /*
     *     Not tested
     *     
     *     If you are going to use a HashMap, You MUST (I think) reimplement this method
     */
    public int hashCode()
    {
        int part1, part2;
        char p1, p2;
        p1 = x.charAt(0);
        p2 = y.charAt(0);
        part1 = Character.getNumericValue(p1);
        part2 = Character.getNumericValue(p2);
        return part1 + part2;
    }

    /*
     *     Not tested
     *     
     *     However, I did used this method in getRelationString
     *     AND it was a helpful tool when used in conjunction with the getRelationString
     *     method which GREATLY simplified and shorten the code in some methods
     */
    public String toString()
    {
        return "("+ getX() + "," + getY() + ")";
    }
}