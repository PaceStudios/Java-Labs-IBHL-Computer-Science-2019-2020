import java.util.*;
import java.math.*;

public class MatissaExponentConverter
{
    /*
     *  Convert the paramyStringter val to its m-bit matissa and e-bit exponent
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
    public static String toMatissaExponent2(double val, int m, int e)
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
    public static double toDouble2(String str)
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

    public static String toDecimalBinary2(String num)
    {
        String ans="";
        int tempVal=Integer.parseInt(num);
        int count=(int)Math.pow(2, -num.length());
        Stack<Integer> s=new Stack<Integer>();
        for(int x=count; x>=0; x-=Math.pow(2, -x))
        {
            if(tempVal-Math.pow(2, -x)>=0)
            {
                tempVal-=Math.pow(2, -x);
                s.push(1);
            }
            else
                s.push(0);
        }
        while(s.size()>0)
            ans+=s.pop();
        return ans;
    }

    public static String toMatissaExponent(double val, int mBits, int eBits)
    {
        String myString = "";


        if(val == 0.0)
        {
            for(int i=0; i<mBits; i++)
            {
                myString += "0";
            }
            myString += " ";
            for(int i=0; i<eBits; i++)
            {
                myString += "0";
            }
            return myString;
        }

        //convert on the left side of the decimal
        //is it negative or not
        double exp = Math.floor((Math.log(Math.abs(val))/Math.log(2)) + 1);
        val /= Math.pow(2, exp);
        if(val < 0)
        {
            val = 1 - Math.abs(val);
            myString += "1";
        }
        else
        {
            myString += "0";
        }

        double tempVal = 0.5;
        for(int i=1; i<mBits; i++)
        {
            if(val == 0.0)
                myString += "0";
            else
            {
                if((val-tempVal)>=0){
                    myString += "1";
                    val -= tempVal;
                }else
                    myString += "0";
            }
            tempVal /= 2;
        }

        if(val!=0)
        {
            return "np";
        }
        myString += " ";
        tempVal = Math.pow(2, eBits-1);
        if(exp < 0)
        {
            exp = tempVal + exp;
            myString += "1";
        }
        else
            myString += "0";
        for(int i=1; i<eBits; i++)
        {
            tempVal /= 2;
            if(exp == 0.0)
                myString += "0";
            else
            {
                if((exp-tempVal)>=0){
                    myString += "1";
                    exp -= tempVal;
                }else
                    myString += "0";
            }
        }
        if(exp!=0){
            return "np";
        }
        return myString;
    }

    /**
     * Converts mantissa exponent in string form separated by one space into a decimal in double form
     */
    public static double toDouble(String str)
    {
        String[] myString = str.split(" ");
        double ans = -1 * Double.parseDouble(myString[0].substring(0, 1));
        for(int i=1; i<myString[0].length(); i++)
        {
            ans += Double.parseDouble(myString[0].substring(i, i+1))*Math.pow(2, -1*i);
        }
        double exp = -1*Double.parseDouble(myString[1].substring(0, 1))*Math.pow(2, myString[1].length()-1);
        for(int j=1; j<myString[1].length(); j++)
        {
            exp += Double.parseDouble(myString[1].substring(j, j+1))*Math.pow(2, myString[1].length()-j-1);
        }
        return ans * Math.pow(2, exp);
    }
}
