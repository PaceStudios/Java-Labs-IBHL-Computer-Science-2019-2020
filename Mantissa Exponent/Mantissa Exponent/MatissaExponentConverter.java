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
        String built = convertToBinary(val, m, e);
        System.out.println("A");
        System.out.println(built);
        String mantissa = "";
        String exp = "";
        int i = 0;
        while(built.charAt(i)!= ' ' && i < built.length()){
            mantissa+= built.substring(i,i+1);
            i++;
        }
        System.out.println("B");
        System.out.println("Mant:\t"+mantissa);
        exp = built.substring(mantissa.length()+1, built.length());
        System.out.println("Exp:\t"+exp);
        while(mantissa.length()!= m){
            if(val > 1){
                mantissa = "0" + mantissa;}
            else
            {
                mantissa = "1" + mantissa;
            }

        }
        System.out.println("C");
        System.out.println("Mantissa =\t"+mantissa);
        while(exp.length()!= m){
            if(val > 1){
                exp = "0" + exp;}
            else
            {
                exp = "1" + exp;
            }
        }
        System.out.println("Exp:\t" +exp);
        System.out.println("Mantissa and Exponent :\t"+mantissa+" "+exp);
        return mantissa + " " + exp;
    }

    public static String convertToBinary(double val, int m, int e){
        String ans = val + "";
        long wholepart = (long) val;
        double fraction = Math.abs((val - (wholepart)));
        System.out.println("Value:\t"+val+"\nWhole Part\t"+wholepart+"\nFraction:\t"+fraction);
        String rightSide = "";
        int factor = -1;
        String mantissa = "";
        String exp = "";
        BigDecimal moveableValue;
        rightSide = rightSide;
        System.out.println("The Binary Conversion of the Fraction\t"+fraction+"Is now converted to the Binary Rep:\t"+rightSide);
        String wholeNumber = Long.toBinaryString(wholepart);
        ans = wholeNumber + "." + rightSide;
        System.out.println(ans);
        moveableValue = new BigDecimal(ans);
        System.out.println("New Moveable Value: " + moveableValue);
        int expo = 0;
        if(val > 1){
            moveableValue = moveableValue.movePointLeft(wholeNumber.length());
            expo = wholeNumber.length();
            System.out.println("Moved Value:\t"+moveableValue);
            exp = Integer.toBinaryString(expo);
            System.out.println("Converted Exponent = " + exp);
        }
        else
        if(val < 1 && val > 0){
            int marker = 0;
            char c = rightSide.charAt(marker);
            expo = 0;
            System.out.println("The value directly right of the decimal is:" + c);
            while(c != '1' && marker < rightSide.length()){
                System.out.println("Current Exponent:\t"+expo);

                System.out.println("Current Char:\t"+c);
                marker++;
                c = ans.charAt(marker);
                expo--;
                System.out.println("New Char:\t"+c);
            }
            expo+= 1;
            moveableValue = moveableValue.movePointRight(expo);
            System.out.println("Moved Value: " + moveableValue);
            exp = Integer.toBinaryString(expo);
            System.out.println("Exponent is\t" +exp);
        }
        else
        {}
        mantissa = moveableValue + "";
        int i = 0;
        while(mantissa.charAt(i) != '.'){
            i++;
        }
        mantissa = mantissa.substring(0,i) + mantissa.substring(i);
        ans = mantissa+" "+exp;
        if(mantissa.length() > m){
            return "np";}
        if(exp.length() > e){return "np";}
        return ans;
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
