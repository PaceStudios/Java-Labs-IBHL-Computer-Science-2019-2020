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
        String repl = input;
        String values = input.replaceAll(" ", "");
        Stack<Double> Stack = new Stack<Double>(); 
        for (int j = values.length()-1; j >= 0; j--) { 
            if (isOperand(values.charAt(j))) 
            {
                System.out.println( (double)(values.charAt(j) - 48));
                Stack.push((double)(values.charAt(j) - 48)); 
            }

            else 
            { 
                double o1 = Stack.peek(); 
                Stack.pop(); 
                double o2 = Stack.peek(); 
                Stack.pop(); 

                switch (values.charAt(j)) { 
                    case '+': 
                    Stack.push(o1 + o2); 
                    break; 
                    case '-': 
                    Stack.push(o1 - o2); 
                    break; 
                    case '^': 
                    Stack.push(Math.pow(o1,o2)); 
                    break; 
                    case '*': 
                    Stack.push(o1 * o2); 
                    break; 
                    case '%': 
                    Stack.push(o1 % o2); 
                    break; 
                    case '/': 
                    Stack.push(o1 / o2); 
                    break; 

                } 
            } 
        } 
        int x = (int) Math.round(Stack.peek());
        return "" + x; 
    }

    public static Boolean isOperand(char possibleOperand) 
    { 
        // If the character is a digit 
        // then it must be an operand 
        if (!(possibleOperand >= 48 && possibleOperand <= 57)) 
        {
            return false; 
        }
        else
        {
            return true; 
        }
    } 

    public String mysteryPostFix(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Stack<Integer> topTom = new Stack<Integer>();
        String repl = "";
        while(strTok.hasMoreTokens()){
            char r = strTok.nextToken().charAt(0);
            if(Character.isDigit(r)){
                topTom.push(r-'0');
            }
            else
            {
                int firstVal = topTom.pop();
                int secondVal = topTom.pop();
                switch(r){
                    case '+':
                    topTom.push(secondVal + firstVal);
                    break;
                    case '-':
                    topTom.push(secondVal-firstVal);
                    break;
                    case'*':
                    topTom.push(secondVal * firstVal);
                    break;
                    case'/':
                    topTom.push(secondVal/firstVal);
                    break;
                }
            }

        }    
        return topTom.pop() + "";

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
        String repl = "";

        while (strTok.hasMoreTokens()){
            int a = Integer.parseInt(strTok.nextToken());
            System.out.println(a);
            total.add(a);
        }
<<<<<<< HEAD
        repl = ((double)(total.get(0))/(double)(total.get(1))) + "";
        System.out.println("Repl:" + repl);
        repl = repl.substring(2);
        System.out.println(repl);
        if(repl.length() < total.get(2)){
            for(int i = 1; i < total.get(2);i++){
=======
        String repl = ((double)(total.get(0))/(double)(total.get(1))) + "";
        repl = repl.substring(2);
        System.out.println(repl);
        if(repl.length() < total.get(2)){
            System.out.println(repl);
            while(repl.length() != total.get(2)){
>>>>>>> b3b11d9f9fc9838fb0460494107ba615e6486e84
                repl+="0";}
        }
        else
        {
<<<<<<< HEAD
            repl = repl.substring(0,total.get(2));
        }
        System.out.println("Current Value of Repl: " + repl);
=======
            System.out.println(repl);
            repl = repl.substring(0,total.get(2));
            System.out.println(repl);
        }
>>>>>>> b3b11d9f9fc9838fb0460494107ba615e6486e84
        return repl;
    }

    public String mysteryC(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String currentIteration = strTok.nextToken();
        String ans = "OUTPUT:\n" + currentIteration;
        int apple = Integer.parseInt(strTok.nextToken());
        for(int i = 0; i<apple; i++)
        {
            currentIteration = findMyButter(currentIteration);
            ans = ans + "\n"; 
            ans += currentIteration;
        }

        return ans;
    }

    public String findMyButter(String meganFox){
        StringBuilder result= new StringBuilder();
        char repeat= meganFox.charAt(0);
        meganFox+=meganFox.substring(1) + " ";
        int times= 1;

        for(char actual: meganFox.toCharArray()){
            if(actual != repeat){
                result.append(times + "" + repeat);
                times= 1;
                repeat= actual;
            }else{
                times+= 1;
            }
        }
        return result.toString();
    }
}