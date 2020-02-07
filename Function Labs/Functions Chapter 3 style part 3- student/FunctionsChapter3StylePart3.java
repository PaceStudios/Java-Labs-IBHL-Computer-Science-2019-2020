/*    implement ALL the methods in this class.
 * 
 *    
 *    This project is based on Chapter 3, section 5, Matrices of Relations
 *    
 *    Good luck
 */

import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
/*
 *    For this project, you may assume all int[][] have square dimensions
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
public class FunctionsChapter3StylePart3
{
/*
 *    add the fewest 1s to copy of matrix m so that the copy is reflexive 
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
   public static int[][] makeReflexive(int[][] m)
   {
      return new int[m.length][m[0].length];
   }

/*
 *    add the fewest 1s to copy of matrix m so that the copy is symmetric 
 *    
 *    Remember to not change the parameter!!!!!!!!!
*/
   public static int[][] makeSymmetric(int[][] m)
   {  
      return new int[m.length][m[0].length];
   }

/*
 *    add the fewest 1s to copy of matrix m so that the copy is transitive 
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
   public static int[][] makeTransitive(int[][] m)
   {
      return new int[m.length][m[0].length];
   }
}