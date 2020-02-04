import java.util.*;

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
        String ans=""+val;
       double d = 3.5;
       long dbits = Double.doubleToLong
        long bits = Double.doubleToLongBits(val);
        System.out.println("Double to Binary value: " + bits);

        boolean negative = (bits & 0x8000000000000000L) != 0; 
        long exponent = bits & 0x7ff0000000000000L;
        long mantissa = bits & 0x000fffffffffffffL;
        System.out.println("negative: " + negative);
        System.out.println("exponent: " + Double.longBitsToDouble(exponent));
        System.out.println("mantissa: " + Double.longBitsToDouble(mantissa));
        return ans;
        /*
        if(val>0)
        {
        expNum=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf(".")))).length();
        ans="0"+ans;
        if(ans.length()>m)
        return "np";
        while(ans.length()<m)
        ans="0"+ans;
        exp=Integer.toBinaryString(expNum);
        if(exp.length()>e)
        return "np";
        while(exp.length()<e)
        exp="0"+exp;
        }
        else if(val<0)
        {
        ans=""+Math.abs(val);
        expNum=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf(".")))).length();
        ans=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf("."))))+toDecimalBinary(ans.substring(ans.indexOf(".")+1));
        ans="0"+ans;
        String temp="";
        for(int x=0; x<ans.length(); x++)
        {
        if(ans.substring(x,x+1).equals("1"))
        temp+="0";
        else
        temp+="1";
        }
        ans=Integer.toBinaryString((int)toDouble(temp)+1);
        if(ans.length()>m)
        return "np";
        while(ans.length()<m)
        ans="0"+ans;
        exp=Integer.toBinaryString(expNum);
        if(exp.length()>e)
        return "np";
        while(exp.length()<e)
        exp="0"+exp;
        }
        else if(val==0)
        {
        for(int x=0; x<m; x++)
        ans+="0";
        for(int x=0; x<e; x++)
        exp+="0";
        }

        return ans + " " + exp;
         */
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
