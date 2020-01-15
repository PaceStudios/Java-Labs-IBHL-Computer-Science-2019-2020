
import java.lang.String;

public class StudentABMysterySolverTest extends junit.framework.TestCase
{
	public void testMystery10()
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mystery10_0";

/*
 *       You may assume that the first number is always less than second number
 */		
		
		String input="1 3 5";
		assertEquals(problemMsg, "33333", obj.mystery10(input));

		input="2 5 3";
		assertEquals(problemMsg, "400", obj.mystery10(input));

		input="5 6 6";
		assertEquals(problemMsg, "833333", obj.mystery10(input));

		input="7 9 11";
		assertEquals(problemMsg, "77777777777", obj.mystery10(input));

		input="1 19 4";
		assertEquals(problemMsg, "0526", obj.mystery10(input));

		input="5 7 9";
		assertEquals(problemMsg, "714285714", obj.mystery10(input));

		input="3 5 7";
		assertEquals(problemMsg, "6000000", obj.mystery10(input));

		input="100 200 6";
		assertEquals(problemMsg, "500000", obj.mystery10(input));
	
		input="1 2 3";
		assertEquals(problemMsg, "500", obj.mystery10(input));
	}

	public void testMysteryPreFix()
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryPreFix";
		String input="* + 5 5 - 6 3";
		assertEquals(problemMsg, "30", obj.mysteryPreFix(input));
	}

	public void testMysteryPostFix()
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryPostFix";
		String input="5 3 +";
		assertEquals(problemMsg, "8", obj.mysteryPostFix(input));
	}

	public void testMysteryP()  // prime numbers
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryP";
		String input="5";
		assertEquals(problemMsg, "2 3 5 7 11", obj.mysteryP(input));
	}

	public void testMysteryS()  // sorts numbers in ascending order
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryS";
		String input="2 4 17 25 33 44 89";
		assertEquals(problemMsg, "2 4 17 25 33 44 89"
			                             , obj.mysteryS(input));
	}

	public void testMysteryS01()  // sorts numbers in ascending order
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryS";
		String input="33 17 4 25 2 89 44";
		assertEquals(problemMsg, "2 4 17 25 33 44 89"
			                             , obj.mysteryS(input));
	}


	public void testMysteryC()
	{
		MysterySolver4AB obj=new MysterySolver4AB();
		String problemMsg="Problem with: mysteryC";
		String input="21 5";
		assertEquals(problemMsg, "OUTPUT:\n21\n"
		                        + "1211\n"
		                        + "111221\n"
		                        + "312211\n"
		                        + "13112221\n"
		                        + "1113213211", obj.mysteryC(input));
	}
}