/*    implewment (almost) ALL the methods in this class.
 * 
 *    But first, you need to finish implementing the OrderedPair class
 *    
 *    The first tester provided test the OrderedPair class methods equals and hashCode
 *    which I believe are important methods that you may use or I use in the tester when I create
 *    a HashSet.  This tester method is only for your benefit as it is not included the stipulator tester.
 */


import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
public class FunctionsChapter3Style
{

   public FunctionsChapter3Style(Set<String> d, Set<String> co)
   {
      /*   build your own constructor   */
   }

   public FunctionsChapter3Style(Set<String> d, Set<String> co, Set<OrderedPair> r)
   {
      /*   build your own constructor   */
   }

/*
 *    Not test.
 *    
 *    I admit that I did use this method a couple of times.
 *    It came in very handy and SHORTEN my code and GREATLY simplified some methods
 *    I will let you figure out which ones and how
 *    
 *    returns a String of the form: [(a,b), (c,d), ...(v,w)]
 */
   public String getRelString()
   {
      return "";
   }

/*
 *    replaces the current relation instance variable with op
 *    
 *    YES - this method gets used in the my (stipulator) tester
 */
   public void setRelation(Set<OrderedPair> op)
   {
//      Add your own code
   }

/*
 *    returns the current relation instance variable 
 */
   public Set<OrderedPair> getRelation()
   {  
      return new HashSet<OrderedPair>();
   }

/*
 *    retruns the number of Order Pairs in the relation
 */
   public int size()
   {
      return (int)(Math.random() * 9999);
   }

/*
 *    returns true if the array of Order Pairs forms a function
 *    returns false otherwise
 */
   public boolean isFunction()
   {

      return Math.random() < 0.5;
   }

/* 
 *    A function f from X to Y is said to be one to one if 
 *    for each y in Y, there is at most one x in X with f(x) = y
 *
 *    returns true if array of order Pairs is a function and the function is one to one
 *    returns false otherwise
 */
   public boolean isOneToOne()
   {
      return Math.random() < 0.5;
   }

/*
 *    A function from X to Y is said to be onto if
 *    the range of f == Y
 *
 *    returns true if array of order Pairs is a function and the function is onto
 *    returns false otherwise
 */
   public boolean isOnTo()
   {
      return Math.random() < 0.5;
   }

/*
 *     returns true if the array of order Pairs is a function and the function is bijective
 *              that is both one to one and onto
 *     returns false otherwise
 */
   public boolean isBijective()
   {
      return isOneToOne() && isOnTo();
   }

/*
 *   precondition:  getRelation() and op (the parameter) are both functions.  
 *                  Domain of op is a subset of coDomain of getRelation()
 *   
 *   returns a new FunctionsChapter3Style Object.
 *   The domain of new FunctionsChapter3Style Object is this.domain
 *   The coDomain is opCoDomain (the paramenter)
 *   
 *   The new function is the composition op( this.getRelation (this.domain) )
 */
   public FunctionsChapter3Style composition(Set<OrderedPair> op, Set<String> opCoDomain)
   {
      FunctionsChapter3Style ans = new FunctionsChapter3Style(opCoDomain, opCoDomain, new HashSet<OrderedPair>() );

      return ans;
   }

/*
 *   precondition:  rel is a function.
 *   rel does not have to be both 1-1 and onto
 *   the inverse does not need to be a function
 */
   public OrderedPair[] getInverse()
   {
      OrderedPair[] ans = new OrderedPair[10];
      
      return ans;
   }

/*
 * A relation is reflexive if (x, x) in R for every x in X
 * 
 *       returns true if the current relation is reflexive
 *       returns false otherwise
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
 *       returns true if the current relation is reflexive
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
      return isSymmetric() && isReflexive() && isTransitive();
   }

/*
 * 
 *    returns true is the relation is an Partially Order
 *    returns false otherwise
 */
   public boolean isPartiallyOrder()
   {
      return isAntiSymmetric() && isReflexive() && isTransitive();
   }

/*
 *      not tested.
 *      Not sure why it is here.  I think I needed/used this functionality more than once,
 *      and therefore created a helper method
 */
   public ArrayList<OrderedPair> getRel(String s)
   {
      ArrayList<OrderedPair> ans = new ArrayList<OrderedPair>();

      return ans;
   }
}