package stringutilseq.com;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsEg {

	public static void main(String[] args) {
		String nullString = null;
		String emptyString = "";
		String blankString = "\n \t   \n";

		System.out.println("*****Using isEmpty() method ****");
		//Worst Practice -1
		/*if(!nullString.isEmpty()) {
		    System.out.println("nullString isn't null");
		}*/
		
		//Best Practice -1
		if (StringUtils.isEmpty(nullString)) {
		    System.out.println("nullString is null");
		}

		if(StringUtils.isEmpty(emptyString)) {
		    System.out.println("emptyString is empty");
		}

		if(StringUtils.isBlank(blankString)) {
		    System.out.println("blankString is blank");
		}
		
		System.out.println("*****Using equals() method ****");
		//Worst practice -2
		//System.out.println(nullString.equals(null));
		//System.out.println(nullString.equals("string"));
		
		//Best Practice -2
		System.out.println(StringUtils.equals(nullString, null));
		System.out.println(StringUtils.equals(nullString, "string"));
		
		System.out.println("*****Using compare() method ****");
		System.out.println(StringUtils.compare(null, null));
		System.out.println(StringUtils.compare(null , "a"));
		System.out.println(StringUtils.compare("a", null));
		System.out.println(StringUtils.compare("a", "A"));
		System.out.println(StringUtils.compare("a", "a"));

		System.out.println("*****Using indexOf() N contains() method ****");
		String s = "Java is a general-purpose programming language";
		System.out.println(StringUtils.indexOf(s, "l"));
		System.out.println(StringUtils.indexOf(s, "lan"));
		System.out.println(StringUtils.indexOf(null, "a"));
		
		System.out.println(StringUtils.contains(null, "a"));
		System.out.println(StringUtils.contains(s, "Java"));
		System.out.println(StringUtils.contains(s, "Python"));
		System.out.println(StringUtils.contains(s, "pRoGrAmMinG"));
		
		
		System.out.println(StringUtils.substring("I Like Java", 4, 8));
		System.out.println(StringUtils.substring("I Like Java", -7));
		System.out.println(StringUtils.substring(null, 5));
		
		System.out.println("******split() *********");
		String csvString = "Id, Name, Age, Location";
    	
		System.out.println(Arrays.toString(StringUtils.split(csvString, ',')));
		//it returns null if the input is null
		System.out.println(Arrays.toString(StringUtils.split(null, '.')));
		System.out.println(Arrays.toString(StringUtils.split("", '.')));
		System.out.println("******join() *********");
		String[] myStr =  StringUtils.split(csvString, ',');
		System.out.println(StringUtils.join(myStr, ';'));
		
		System.out.println("******remove() *********");
		System.out.println(StringUtils.remove(null, 'a'));
		System.out.println(StringUtils.remove("", 'a'));
		System.out.println(StringUtils.remove("queued", 'u'));

		System.out.println(StringUtils.remove(null, "abc"));
		System.out.println(StringUtils.remove("", "abc"));
		System.out.println(StringUtils.remove("abc", null));
		System.out.println(StringUtils.remove("queued", "ue"));
		
		System.out.println("******replace() *********");
		String string = "a simple sentence";
		System.out.println(StringUtils.replace(string, "simple", "complicated"));
		
	}

}


