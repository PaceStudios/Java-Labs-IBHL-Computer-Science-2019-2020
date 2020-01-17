import java.util.*;

/*    for all methods - you get 
StringTokenizer strTok = new StringTokenizer(input);
Stack<?????> s = new Stack<??????>();
Queue<?????> q = new LinkedList<?????>();
plus one other Object

plus a String only to return the result
 */     

public class MysterySolverII implements MysterySolverInterfaceII
{
    public String mystery6(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String s = "";
        int count = 0;
        s = "";
        while(strTok.hasMoreElements())
        {
            count += Integer.parseInt(strTok.nextToken());
            s += count + " ";
        }
        return s.substring(0, s.length()-1);
    }

    public String mystery7(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Queue<Integer> req = new LinkedList<Integer>();
        String str = "";
        int count = 0;
        str = "";
        while(strTok.hasMoreElements())
        {
            count += Integer.parseInt(strTok.nextToken());
            req.add(count);
            while(count>0)
            {
                str += req.peek() + " ";
                count--;
            }
            str = str.substring(0, str.length()-1) + "\n";
            count = req.poll();
        }
        return str.substring(0, str.length()-1);
    }

    public String mystery8(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        int count = 0;
        while(strTok.hasMoreElements())
        {
            count += Integer.parseInt(strTok.nextToken());
        }
        strTok = new StringTokenizer(input);
        str += count;
        while(strTok.hasMoreElements())
        {
            count -= Integer.parseInt(strTok.nextToken());
            if(strTok.hasMoreElements())
                str = count + " " + str;
        }
        return  str;
    }

    public String mystery9(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String evens = "";
        String odds = "";
        while(strTok.hasMoreElements())
        {
            String temp = strTok.nextToken();
            if(Integer.parseInt(temp)%2 == 0)
            {
                evens = temp + " " + evens;
            }
            else
            {
                odds += temp + " ";
            }
        }
        odds+=evens;
        return odds.substring(0, odds.length()-1);
    }

    public String mysteryF(String input)
    {

        Stack<Integer> fibBibNum = new Stack<Integer>();
        Queue<Integer> myqueue = new LinkedList<Integer>();
        String str = "";
        fibBibNum.push(1);
        if(Integer.parseInt(input) != 1){
            fibBibNum.push(1);
            if(Integer.parseInt(input) != 2)
            {
                input = "" + (Integer.parseInt(input)-2);
                myqueue.add(1);
                while(Integer.parseInt(input) > 0)
                {
                    myqueue.add(fibBibNum.peek());
                    fibBibNum.push(myqueue.poll()+myqueue.peek());
                    input = "" + (Integer.parseInt(input)-1);
                }
            }
        }
        while(!fibBibNum.empty())
        {
            str = fibBibNum.pop() + " " + str;
        }
        return str.substring(0, str.length()-1);
    }
}