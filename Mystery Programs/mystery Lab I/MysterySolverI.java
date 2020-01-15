import java.util.*;

/*    for all methods - you get 
StringTokenizer strTok = new StringTokenizer(input);
Stack<?????> s = new Stack<??????>();
Queue<?????> q = new LinkedList<?????>();
plus one other Object

plus a String only to return the result
 */     

public class MysterySolverI implements MysterySolverInterfaceI
{

    public String mystery1(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Stack<String> s = new Stack<String>();
        Queue<Integer> q = new LinkedList<Integer>();
        String str = new String();
        while(strTok.hasMoreTokens()){
            s.push(strTok.nextToken());
        }
        while(!(s.empty())){
            str+= " ";
            str+= s.pop();
        }

        return str.substring(1);
    }

    public String mystery2(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        String str = new String("");
        while(strTok.hasMoreTokens()){
            Integer x = Integer.parseInt(strTok.nextToken());
            if(x%2 == 0){
                q.add(x);
            }
            else
            {
                s.push(x);
            }
        }
        while(!(s.empty())){
            str += " ";
            str += s.pop();
        }
        while(!(q.isEmpty())){
            str+= " ";
            str+= q.remove(); 

        }

        return str.substring(1);
    }

    public String mystery3(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        /*  Stack<?????> s = new Stack<??????>();
        Queue<?????> q = new LinkedList<?????>();
        plus one other Object

         */ 
        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        String str = "";
        while(strTok.hasMoreTokens()){
            int n = Integer.parseInt(strTok.nextToken());
            s.push(n * n);
        }
        while(!(s.empty())){
            str+= " ";
            str+= s.pop();

        }

        return str.substring(1);
    }

    public String mystery4(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> a = new ArrayList<Integer>();

        String str = "";
        while(strTok.hasMoreTokens()){
            int n = Integer.parseInt(strTok.nextToken());
            a.add(n);

        } 
        int product = 1;
        for(int i = 0; i < a.size(); i++){
            product *= a.get(i);
            s.push(product); 
        }
        while(!(s.empty())){
            str+= " ";
            str+= s.pop();

        }
        return str.substring(1);
    }

    public String mystery5(String input)
    {
        String o = mystery4(input);
        StringTokenizer strTok = new StringTokenizer(o);
        Stack<String> s = new Stack<String>();
        String str = "";
        while(strTok.hasMoreTokens()){
            s.push(strTok.nextToken());
        }
        while(!(s.empty())){
            str+= " ";
            str+= s.pop();
        }
        return str.substring(1);
    }
}