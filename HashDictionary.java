package dict;

/**
 * @author Robert Payne
 * class ITCS 3112-001
 * date 2/5/2014
 */
public class HashDictionary implements Dictionary {
	private LinkedListDictionary[] hashTable = new LinkedListDictionary[5000];
/**
 * Constructor
 * Initializes the HashDictionary	
 */
	public HashDictionary(){
		for(int i = 0; i < 5000; i++)					//initialize each of the LinkedListDictionaries in 
			hashTable[i] = new LinkedListDictionary();	//the hash to represent the buckets
	}
/**
 * Inserts a key and object pair into the HashDictionary
 * @param	key	the key of the key/object pair
 * @param	value the object of the key/object pair
 */
	@Override
	public void put(String key, Object value) {
		if(key == null || value == null)	//return from an invalid input request
			return;
		hashTable[hashCode(key)].put(key, value);
	}
/**
 * Removes the key/object from the HashDictionary
 * @param key of the object to be removed
 */
	@Override
	public Object remove(String key) {
		return hashTable[hashCode(key)].remove(key);
	}
/**
 * Gets the object associated with the key
 * @param key the key of the object to be retrieved
 */
	@Override
	public Object get(String key) {
		return hashTable[hashCode(key)].get(key);
	}
/**
 * Formats the HashDictionary as a string that starts with '['
 * and the key/objects are separated by ", " and ends with a ']'
 */
	@Override
	public String toString() {
		String hashString = new String("[");
		String temp = new String();
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i].toString().length() > 2){
				temp = hashTable[i].toString().substring(1, hashTable[i].toString().length()-1);
				temp += ", ";
				hashString+=temp;
			}
		}
		if(hashString.length() > 2)
			hashString = hashString.substring(0, hashString.length() - 2);
		hashString += "]";
		return hashString;
	}
//Generates a hash index based on the key of the key/object pair
//by adding the characters of the key together and modding by 5000
//to make sure that index will be in bounds
	private static int hashCode(String key){
		int hashCode = 0;
		for(int i = 0; i < key.length(); i++)
			hashCode += key.charAt(i);
		return hashCode % 5000;
	}

}
