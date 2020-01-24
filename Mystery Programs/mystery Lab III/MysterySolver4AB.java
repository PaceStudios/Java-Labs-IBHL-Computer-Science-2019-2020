import java.util.*;

/*    for all methods - you get 
StringTokenizer strTok = new StringTokenizer(input);
Stack<?????> s = new Stack<??????>();
Queue<?????> q = new LinkedList<?????>();
plus one other Object

plus a String only to return the result
 */     

public class MysterySolver4AB implements MysterySolverInterface4AB
{
    /*
     *   required operators for PreFix and Post are:
     *     *, /, +, -, % and ^ (exponent)
     */
    public String mysteryPreFix(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        /*  Stack<?????> s = new Stack<??????>();
        Queue<?????> q = new LinkedList<?????>();
        plus one other Object
         */     
        return "";
    }

    public String mysteryPostFix(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        /*  Stack<?????> s = new Stack<??????>();
        Queue<?????> q = new LinkedList<?????>();
        plus one other Object
         */     
        return "";
    }

    public String mysteryP(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        List<Integer> primeNumbers = new ArrayList<Integer>();
        String response = "";
        int t = Integer.parseInt(strTok.nextToken());
        int k = 2;
        while(primeNumbers.size() < t){

            if(isPrime(k)){
                primeNumbers.add(k);}
            k++;
        }
        for(int i = 0; i < primeNumbers.size(); i++){
            response += " ";
            response += primeNumbers.get(i);
        }
        return response.substring(1);
    }

    public boolean isPrime(int a){
        for(int i = 2; i <= a/2 ; i++){
            if(a%i == 0)
                return false;
        }
        return true;
    }

    public String mysteryS(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        List<Integer> sort = new ArrayList<Integer>();
        String response = "";
        while(strTok.hasMoreTokens()){
            sort.add(Integer.parseInt(strTok.nextToken()));
        }
        Collections.sort(sort);
        for(int i = 0; i < sort.size(); i++){
            response += " ";
            response += sort.get(i);}
        return response.substring(1);
    }

    /*
     *    See tester for sample input - output
     *    
     *    You may assume the first int < second int.
     *    
     *    You may assume all three ints will be greater than 0
     *    Divides the first number by the second number, third
     */  

    public String mystery10(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        List<Integer> total = new ArrayList<Integer>();
        while (strTok.hasMoreTokens()){
            total.add(Integer.parseInt(strTok.nextToken()));
        }
        String repl = ((double)(total.get(0))/(double)(total.get(1))) + "";
        repl = repl.substring(2);
        System.out.println(repl);
        if(repl.length() < total.get(2)){
            System.out.println(repl);
            while(repl.length() != total.get(2)){
                repl+="0";}
        }
        else
        {
            System.out.println(repl);
            repl = repl.substring(0,total.get(2));
            System.out.println(repl);
        }
        return repl;
    }

    public String mysteryC(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        /*  Stack<?????> s = new Stack<??????>();
        Queue<?????> q = new LinkedList<?????>();
        plus one other Object
         */     
        return "";
    }
}