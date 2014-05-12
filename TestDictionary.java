package dict;
/**
 * @author Robert Payne
 * class ITCS 3112-001
 * date 2/5/2014
 */
public class TestDictionary {
	
	public static void main(String[] args) {
		LinkedListDictionary testPutLLD = new LinkedListDictionary();
		LinkedListDictionary testRemoveLLD = new LinkedListDictionary();
		LinkedListDictionary testGetLLD = new LinkedListDictionary();
		LinkedListDictionary testToStringLLD = new LinkedListDictionary();
		HashDictionary testPutHD = new HashDictionary();
		HashDictionary testRemoveHD = new HashDictionary();
		HashDictionary testGetHD = new HashDictionary();
		HashDictionary testToStringHD = new HashDictionary();
		
		System.out.println("_____________________________________");
		System.out.println("[LinkedListDictionary TESTS]");
		System.out.println("_____________________________________");
		System.out.println("PUT TEST PASS: \t\t" + putTest(testPutLLD));
		System.out.println("REMOVE TEST PASS: \t" + removeTest(testRemoveLLD));
		System.out.println("GET TEST PASS: \t\t" + getTest(testGetLLD));
		System.out.println("TOSTRING TEST PASS: \t" + toStringTest(testToStringLLD));
		System.out.println("_____________________________________");
		System.out.println("[HashDictionary TESTS]");
		System.out.println("_____________________________________");
		System.out.println("PUT TEST PASS: \t\t" + putTest(testPutHD));
		System.out.println("REMOVE TEST PASS: \t" + removeTest(testRemoveHD));
		System.out.println("GET TEST PASS: \t\t" + getTest(testGetHD));
		System.out.println("TOSTRING TEST PASS: \t" + toStringTest(testToStringHD));


	}
	
	private static boolean putTest(Dictionary dict){
		String testString = new String("[Key3:Value3]");
		dict.put(null, null);
		dict.put("Key1", null);
		dict.put(null, "Value2");
		dict.put("Key3", "Value3");
		if(dict.toString().equals(testString))
			return true;
		else
			return false;
	}
	private static boolean removeTest(Dictionary dict){
		String testString = new String("[Key6:Value6]");
		dict.remove(" ");			//remove from an empty dictionary
		dict.put("Key3", "Value3");	//put values into the dictionary
		dict.put("Key4", "Value4");
		dict.put("Key5", "Value5");
		dict.remove("Key99");		//try to remove an object that's not in the dict.
		dict.remove("Key4");		//remove the middle element
		dict.remove("Key3");		//remove the head element with size of 2
		dict.remove("Key5");		//remove the head with size 1
		dict.put("Key6", "Value6");	//put 2 more values in the dictionary
		dict.put("Key7", "Value7");	
		dict.remove("Key7");		//remove the tail element
		if(dict.toString().equals(testString))		//test the list against what should be there
			return true;
		else
			return false;
	}
	private static boolean getTest(Dictionary dict){
		dict.put("Key4", "Value4");		//put values into the dictionary
		dict.put("Key5", "Value5");
		dict.put("Key3", "Value3");
		dict.put("Key6", "Value6");
		dict.put("Key7", "Value7");
		
		//test to see if the keys are in the dictionary
		if(!dict.get("Key3").toString().equals("Value3"))
			return false;
		if(!dict.get("Key4").toString().equals("Value4"))
			return false;
		if(!dict.get("Key5").toString().equals("Value5"))
			return false;
		if(!dict.get("Key6").toString().equals("Value6"))
			return false;
		if(!dict.get("Key7").toString().equals("Value7"))
			return false;
		//test to see if the right return value if the key is not in the dictionary
		if(dict.get("Key234") != null)
			return false;

		return true;
	}
	private static boolean toStringTest(Dictionary dict){
		if(!dict.toString().equals("[]"))
			return false;
		if(!dict.toString().equals("[]"))
			return false;
		dict.put("Key3", "Value3");
		dict.put("Key4", "Value4");
		dict.put("Key5", "Value5");
		if(!dict.toString().equals("[Key3:Value3, Key4:Value4, Key5:Value5]"))
			return false;
		return true;
	}

}
