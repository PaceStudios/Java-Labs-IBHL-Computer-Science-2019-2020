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
 * @John C. Pace  
 * @version 02/26/2020
 */
/*
 *    For this project, you may assume all int[][] have square dimensions
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
public class FunctionsChapter3StylePart3
{
    public static Matrix mat = new Matrix();
    public static MatrixPart2 mat2 = new MatrixPart2();	
    /*
     *    add the fewest 1s to copy of matrix m so that the copy is reflexive 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeReflexive(int[][] m)
    {
        int[][] reflexiveMatrix = m;
        for(int i = 0; i < reflexiveMatrix.length; i++){
            reflexiveMatrix[i][i] = 1;
        }
        return reflexiveMatrix;
    }

    /*
     *    add the fewest 1s to copy of matrix m so that the copy is symmetric 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeSymmetric(int[][] m)
    {  
        int[][] temp = new int[m.length][m[0].length];
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                temp[r][c] = m[r][c];
            }
        }
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                if(temp[r][c] == 0 && temp[c][r] != 0)
                    temp[r][c] = 1;
            }
        }
        return temp;
    }

    /*
     *    add the fewest 1s to copy of matrix m so that the copy is transitive 
     *    
     *    Remember to not change the parameter!!!!!!!!!
     */
    public static int[][] makeTransitive(int[][] m)
    {
        int[][] tranMat = m;
        int[][] sqrMat = mat.product(tranMat, tranMat);
        boolean theSame = mat2.haveSameNonZeros(tranMat, sqrMat);
        System.out.println("The regular matrix and it's square have the same non zeros: " + theSame);
        return tranMat;

    }
}