import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
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
      
      return Math.random() < 0.5;
   }

/*
 *     Not tested
 *     
 *     If you are going to use a HashMap, You MUST (I think) reimplement this method
 */
   public int hashCode()
   {
      return (int)(Math.random() * 99999);
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