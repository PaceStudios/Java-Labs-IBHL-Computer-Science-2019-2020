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
 * @author  
 * @version (a version number or a date)
 */
public class FunctionsChapter3StylePart2
{
/*  add your own instance variables 
 *    You may assume all matrices in this problem will be square matrices n=unless stated otherwise
 *    that is r.length == r[m].length for all m:  0 <= m < r.length
 *    
 *    isReflexive does NOT assume a square matrix
 */

   public FunctionsChapter3StylePart2(int[][] r)
   {
/*   build your own constructor   */
   }

   public int getNumRows()
   {
      return -1;
   }

   public int getNumCols()
   {
      return -1;
   }

/*
 *    replaces the current relation instance variable with r
 *    
 *    YES - this method gets used in the my (stipulator) tester
 */
   public void setRelation(int[][] r)
   {
      /*  add some code  */
   }

/*
 *    returns the current relation instance variable 
 */
   public int[][] getRelation()
   {  
      return new int[10][2];
   }

/*
 *    retruns the number of Order Pairs in the relation
 *      that is, the number of one's (1) in the Matrix
 */
   public int getSize()
   {
      return -1;
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
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
      int[][] cTemp = new int[11][3];
      FunctionsChapter3StylePart2 ans = new FunctionsChapter3StylePart2(cTemp);

      return ans;
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
      return new int[7][13];
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
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
      return Math.random() < 0.5;
   }

/*
 *    returns true is the relation is an Equivalence Relation
 *    returns false otherwise
 */
   public boolean isEquivalenceRelation()
   {
      return Math.random() < 0.5;
   }

/* 
 *    returns true is the relation is an Partially Order
 *    returns false otherwise
 */
   public boolean isPartiallyOrder()
   {
      return Math.random() < 0.5;
   }

/* 
 *     look at the tester
 *
 *    returns [[a, c, ....d], [...], ...[]]
 */
   public String toString()
   {
      return "";
   }
}