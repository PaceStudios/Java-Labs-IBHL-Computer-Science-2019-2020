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
        int[][] symMat = m;
        for(int i = 0; i < symMat.length; i++){
            for(int k = 0; k < symMat[0].length;k++){
                symMat[i][k] = symMat[k][i];
            }
        }
        return symMat;
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