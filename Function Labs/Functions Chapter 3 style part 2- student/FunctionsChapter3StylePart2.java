/*    implewment (almost) ALL the methods in this class.
 * 
 *    
 *    This project is based on Chapter 3, section 5, Matrices of Relations
 *    
 *    Good luck
 *    
 *    You may assume all matrices will be square matrices
 */

import java.util.*;
import java.lang.Math;
/**
 *
 * @John C. Pace   
 * @02/25/2020
 */
public class FunctionsChapter3StylePart2
{
    private int[][] relationMatrix;
    /*  add your own instance variables 
     *    You may assume all matrices in this problem will be square matrices n=unless stated otherwise
     *    that is r.length == r[m].length for all m:  0 <= m < r.length
     *    
     *    isReflexive does NOT assume a square matrix
     */

    public FunctionsChapter3StylePart2(int[][] r)
    {
        relationMatrix = r;
    }

    public int getNumRows()
    {
        return relationMatrix.length;
    }

    public int getNumCols()
    {
        return relationMatrix[0].length;
    }

    /*
     *    replaces the current relation instance variable with r
     *    
     *    YES - this method gets used in the my (stipulator) tester
     */
    public void setRelation(int[][] r)
    {
        relationMatrix = r;
    }

    /*
     *    returns the current relation instance variable 
     */
    public int[][] getRelation()
    {  
        return relationMatrix;
    }

    /*
     *    retruns the number of Order Pairs in the relation
     *      that is, the number of one's (1) in the Matrix
     */
    public int getSize()
    {
        int count = 0;
        for(int i = 0; i < relationMatrix.length; i ++){
            for(int j = 0; j <relationMatrix[0].length; j++){
                count+= relationMatrix[i][j];
            }
        }
        return count;
    }

    /*
     *    You may NOT assume all matrices in this problem will be square matrices
     *    that is r.length may NOT equal r[m].length for all m:  0 <= m < r.length
     *
     *    f is a function if
     *       for each x in X, there is exactly one y in Y with (x,y) in f
     *    returns true if the matrix forms a function
     *    returns false otherwise
     */
    public boolean isFunction()
    {
        int count = 0;
        for(int i = 0; i < relationMatrix.length; i ++){
            count = 0;
            for(int j = 0; j <relationMatrix[i].length; j++){
                if(relationMatrix[i][j] == 1){
                    count++;
                }
            }
            if(count != 1){
                return false;}
        }
        return true;
    }

    /* 
     *    You may NOT assume all matrices in this problem will be square matrices
     *    that is r.length may NOT equal r[m].length for all m:  0 <= m < r.length
     *
     *    A function f from X to Y is said to be one to one if 
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    returns true if the matrix is a function and the function is one to one
     *    returns false otherwise
     */
    public boolean isOneToOne()   // column sum is one for every column
    {
        if (!isFunction()) return false;
        int count = 0;
        for(int i = 0; i < relationMatrix.length; i ++){
            count = 0;
            for(int j = 0; j <relationMatrix[i].length; j++){
                count += relationMatrix[j][i];
            }
            if(count != 1){
                return false;}
        }
        return true;
    }

    /*
     *    You may NOT assume all matrices in this problem will be square matrices
     *    that is r.length may NOT equal r[m].length for all m:  0 <= m < r.length
     *
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    returns true if the matrix is a function and the function is onto
     *    returns false otherwise
     */
    public boolean isOnTo()    // column sum > 0 for all columns
    {
        if (!isFunction()) return false;
        for(int j = 0; j < relationMatrix[0].length; j++){  
            int count = 0;
            for(int i = 0; i < relationMatrix.length; i++){
                count += relationMatrix[i][j];
            }
            if(!(count > 0)) return false;
        }
        return true;
    }

    /*
     *    You may NOT assume all matrices in this problem will be square matrices
     *    that is r.length may NOT equal r[m].length for all m:  0 <= m < r.length
     *
     *     returns true if the matrix is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective()
    {
        return (isFunction() && isOneToOne() && isOnTo());
    }

    /*
     *   precondition:  comp is a function.
     *   
     *   returns a new FunctionsChapter3StylePart2 Object.
     *   The domain of the new Object is this.domain
     *   The coDomain of the new Object is comp.coDomain
     *   
     *   The new function is the composition: b o relation = b ( relation )
     *   
     *   See the tester for more information
     */
    public FunctionsChapter3StylePart2 composition(int[][] comp)
    {
        int[][] a = new int[relationMatrix.length][comp[0].length];

        for(int i = 0; i < relationMatrix.length; i++){
            for(int j = 0; j < relationMatrix[0].length; j++){
                if(relationMatrix[i][j] > 0){
                    for(int k = 0; k < comp[0].length; k++){
                        if(comp[j][k] > 0){
                            a[i][k] = 1;
                        }
                    }
                }
            }
        }
        return new FunctionsChapter3StylePart2(a);
    }

    /*
     *   ALERT:  Not the inverse of the matrix, but the function inverse (or matrix transposed)
     * 
     *   precondition:  relation is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public int[][] getInverse()    // not the inverse of the matrix, but function inverse!!!!!
    {
        int[][] inverse = new int[relationMatrix.length][relationMatrix[0].length];
        System.out.println(Arrays.deepToString(relationMatrix));
        System.out.println(Arrays.deepToString(inverse));
        for(int i = 0; i < inverse.length; i++){
            for(int k = 0; k < inverse[0].length; k++){
                inverse[k][i] = relationMatrix[i][k];
            }
        }
        return inverse;
    }

    /*
     * A relation is reflexive if (x, x) in R for every x in X
     * 
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     *       
     *       You shuld NOT assume the matrix is a square matrix.  If the matrix is not a square, return false
     */
    public boolean isReflexive()
    {
        if(relationMatrix.length != relationMatrix[0].length)
            return false;
        for(int i = 0; i < relationMatrix.length; i++){
            if(relationMatrix[i][i] != 1){
                return false;
            }
        }
        return true;
    }

    /*
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     * 
     *       returns true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric()
    {
        for(int i = 0; i < relationMatrix.length; i++){
            for(int j = 0; j < relationMatrix[i].length; j++){
                if(relationMatrix[i][j] != relationMatrix[j][i])
                    return false;
            }
        }
        return true;
    }

    /*
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     * 
     *    returns true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric()
    {
        for(int i = 0; i < relationMatrix.length; i ++){
            for(int k = 0; k < relationMatrix[i].length; k++){
                System.out.println(relationMatrix[i][k] + "");
                if(i != k && (relationMatrix[i][k] > 0 && relationMatrix[k][i] > 0))
                    return false;
            }
        }
        return true;
    }

    /*
     *       A relation is transitive:
     *       if (a,b) and (b,c) then (a,c)
     * 
     *       returns true if the current relation is transitive
     *       returns false otherwise
     */
    public boolean isTransitive()
    {
        Matrix trans = new Matrix();
        int[][]squaredMatrix = new int[relationMatrix.length][relationMatrix[0].length];
        squaredMatrix = trans.product(relationMatrix, relationMatrix);
        for(int i = 0; i < relationMatrix.length; i++){
            for(int j = 0; j < relationMatrix[i].length; j++){
                if(squaredMatrix[i][j] > 0)
                    squaredMatrix[i][j] = 1;
                if(squaredMatrix[i][j] != relationMatrix[i][j])
                    return false;
            }
        }
        return true;
    }

    /*
     *    returns true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation()
    {
        return (isSymmetric() && isTransitive() && isReflexive());
    }

    /* 
     *    returns true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder()
    {
        return (isAntiSymmetric() && isTransitive() && isReflexive());
    }

    /* 
     *     look at the tester
     *
     *    returns [[a, c, ....d], [...], ...[]]
     */
    public String toString()
    {
        return Arrays.deepToString(relationMatrix);
    }
}