import java.util.*;
import java.math.*;

public class MatissaExponentConverter
{
    /*
     *  Convert the parameter val to its m-bit matissa and e-bit exponent
     *  with one space seperating the matissa and the exponent
     *  
     *  return "np" if the conversion is not possible
     * 
     * preconditions:  -???? >  val  > ????
     * 
     *         see the student tester for sample input/output
     *         
     *   if val == 0, return a mantDigit = 000...000 and exponent = 000....0
     */
    public static String toMatissaExponent(double val, int m, int e)
    {
        String ans = val + "";
        long wholepart = (long) val;
        double fraction = Math.abs((val - (wholepart)));
        System.out.println("Value:\t"+val+"\nWhole Part\t"+wholepart+"\nFraction:\t"+fraction);
        String rightSide = "";
        int factor = -1;
        String mantissa = "";
        String exp = "";
        BigDecimal moveableValue;
        if(val == 0){

            for(int i = 0; i < m; i++){
                mantissa+= "0";}
            for(int i = 0; i < e; i++){
                exp+="0";}
            return mantissa + " " + exp;
        }
        if(val > 0){
            System.out.println("Value is greater than 0"); 
        }
        else{
            System.out.println("Value is less than 0");
        }

        while(fraction != 0){
            if((fraction - Math.pow(2,factor)) < 0){
                System.out.println(Math.pow(2,factor) + "" + "\t Was too big");
                rightSide+="0";}
            else{
                System.out.println(Math.pow(2,factor) + "" + "\t Either fit, or was smaller than target.");
                rightSide+="1";
                fraction -= Math.pow(2,factor);
            }
            factor--;
        }
        rightSide = rightSide;
        System.out.println("The Binary Conversion of the Fraction\t"+fraction+"Is now converted to the Binary Rep:\t"+rightSide);
        String wholeNumber = Long.toBinaryString(wholepart);
        ans = wholeNumber + "." + rightSide;
        System.out.println(ans);
        /*
         * Next Part is dedicated to moving the decimal and find the exponent 
         */
        moveableValue = new BigDecimal(ans);
        System.out.println("New Moveable Value: " + moveableValue);
        int expo = 4;
        moveableValue = moveableValue.movePointLeft(expo);

        ans = moveableValue + ""; 
    
        System.out.println("Moved Decimal Point is:\t"+moveableValue);
        // Need to figure out a way to substring through the new values and try to figure out how to count how many 0s exist
        
        return ans;
    }

    public static boolean allZeros(String val, int sub1){
        return val.substring(0,sub1).contains("1");

    }

    /*
     *    converts the mantDigit-exponent string to its equivalent real number
     *    
     *    precondition: str contains one space seperating the matissa from the exponent 
     *t
     * 
     *         see the student tester for sample input/output
     */
    public static double toDouble(String str)
    {
        double mantDigit=0;
        double exp=0;
        for(int x=0; x<str.indexOf(" "); x++)
        {
            if(str.substring(x,x+1).equals("1") && x==0)
                mantDigit-=1;
            else if(str.substring(x,x+1).equals("1"))
                mantDigit+=Math.pow(2,-x);
        }
        str=str.substring(str.indexOf(" ")+1);
        for(int x=0; x<str.length(); x++)
        {
            if(str.substring(x,x+1).equals("1") && x==0)
                exp+= -Math.pow(2,str.length()-1);
            else if(str.substring(x,x+1).equals("1"))
                exp+=Math.pow(2,str.length()-1-x);
        }
        return mantDigit*Math.pow(2,exp);
    }

    public static String toDecimalBinary(String num)
    {
        String ans="";
        int temp=Integer.parseInt(num);
        int count=(int)Math.pow(2, -num.length());
        Stack<Integer> s=new Stack<Integer>();
        for(int x=count; x>=0; x-=Math.pow(2, -x))
        {
            if(temp-Math.pow(2, -x)>=0)
            {
                temp-=Math.pow(2, -x);
                s.push(1);
            }
            else
                s.push(0);
        }
        while(s.size()>0)
            ans+=s.pop();
        return ans;
    }

}
