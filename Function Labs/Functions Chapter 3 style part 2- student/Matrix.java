
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
import java.util.*;
public class Matrix
{
    // All methods will be static methods

    /**
     *    Matrix multiplication
     * 
     * @return     matrix x times matrix y 
     */
    public static int[][] product(int[][] x, int[][] y)
    {
        int[][] ans = new int[x.length][y[0].length];
        int xRow = x.length;
        int xCol = x[0].length;// this is the correct dimension
        int yRow = y.length;
        int yCol = y[0].length;
        for(int i = 0 ; i < xRow; i++){
            for(int j = 0; j < yCol; j++){
                for(int m = 0; m < xCol; m++){

                    ans[i][j] += x[i][m] * y[m][j];
                    System.out.println(ans[i][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}
