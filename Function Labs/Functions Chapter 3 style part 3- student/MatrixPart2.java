
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author John C. Pace
 * @version 02/26/2020
 */
public class MatrixPart2
{
    /*
     *     preCondition:  m.length == n.length
     *                    m[i].length == n[i].length, 0 <= i < m.length
     */
    public static boolean haveSameNonZeros(int[][] m, int[][] n)
    {
        for(int i = 0; i < m.length; i ++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] != 0 && n[i][j] == 0){
                    return false;

                }                
                else if(m[i][j] == 0 && n[i][j] != 0){
                return false;}
            }
        }
        return true;
    }
}