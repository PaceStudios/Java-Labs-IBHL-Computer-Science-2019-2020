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
     *   if val == 0, return a mantissa = 000...000 and exponent = 000....0
     */
    public static String toMatissaExponent(double val, int m, int e)
    {
        String expression = "";
        int matissaLength = m;
        int exponentLength = e;
        double manipulatedValue = 0;
        String valVal = val + "";
        String leftOfDecimal = "";
        String rightOfDecimal = "";
        System.out.println("Length of Double value in Val: " + valVal.length());

        System.out.println("The number 0.625 converted to Binary is: " + convertRealNumbers(0.625));
        int i = 0;
        while(!valVal.substring(i,i+1).equals(".")){
            leftOfDecimal += valVal.substring(i,i+1);
            i++;
        }
        System.out.println("Value of I is:" + i);
        System.out.println("The length of the Original String is: " + valVal.length());
        rightOfDecimal = valVal.substring(i, valVal.length());
        System.out.println("Value Right of the Decimal before Conversion = " + rightOfDecimal);
        rightOfDecimal = convertRealNumbers(Integer.parseInt(rightOfDecimal));
        System.out.println("Value Right of the Decimal following conversion: " + rightOfDecimal);
        System.out.println("Value Currently left of the Decimal: " + leftOfDecimal);
        System.out.println("Print Expression: " + leftOfDecimal);

        return expression;
    }

    public double convertNegative(double friend){
        return -1;
    }

    public static String convertRealNumbers(double num){
        if (num >= 1 || num <= 0) 
            return "ERROR"; 

        StringBuilder binary = new StringBuilder(); 
        binary.append("."); 

        while (num > 0) 
        { 
            /* Setting a limit on length: 32 characters, 
            If the number cannot be represented 
            accurately in binary with at most 32 
            character  */
            if (binary.length() >= 32) 
                return "ERROR"; 

            // Multiply by 2 in num to check it 1 or 0 
            double r = num * 2; 
            if (r >= 1) 
            { 
                binary.append(1); 
                num = r - 1; 
            } 
            else
            { 
                binary.append(0); 
                num = r; 
            } 
        } 
        return binary.toString(); 
    }

    /*
     *    converts the mantissa-exponent string to its equivalent real number
     *    
     *    precondition: str contains one space seperating the matissa from the exponent 
     *
     * 
     *         see the student tester for sample input/output
     */
    public static double toDouble(String str)
    {
        return Math.random();
    }
}