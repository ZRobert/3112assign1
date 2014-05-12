package dict;
/**
 * @author Robert Payne
 * class ITCS 3112-001
 * date 2/5/2014
 */
public class LinkedListDictionary implements Dictionary {
	private Node head;		//head of the linked list
	/**
	 * Constructor
	 * Initializes the LinkedListDictionary	
	 */	
	public LinkedListDictionary(){
		head = null;
	}
	/**
	 * Inserts a key and object pair into the LinkedListDictionary
	 * @param	key	the key of the key/object pair
	 * @param	value the object of the key/object pair
	 */	
	@Override
	public void put(String key, Object value) {
		if(key != null && value != null){		//check for an invalid input request
			Node newNode = new Node(value, key);
			Node currentPosition = null;
			
			if(head == null){		//set the head if it is the first entry
				head = newNode;
			}else{					//traverse the list to put the new node at the end
				currentPosition = head;
				while(currentPosition.getChild() != null){
					currentPosition = currentPosition.getChild();
				}
				currentPosition.setChild(newNode);		//set the pointers to reference the child/parent nodes
				newNode.setParent(currentPosition);
			}
		
		} 
	}
	/**
	 * Removes the key/object from the LinkedListDictionary
	 * @param key of the object to be removed
	 */
	@Override
	public Object remove(String key) {
		Node currentPosition = head;
		
		if(head == null)	//handle a remove request on an empty list
			return null;
		
		while(currentPosition != null && !currentPosition.getKey().equals(key)){	//traverse the list
			if(currentPosition.getChild()!= null)							//until key is found or end of list
				currentPosition = currentPosition.getChild();
			else
				break;
		}
		if(currentPosition.getKey().equals(key)){
			if(currentPosition == head){
				if(currentPosition.getChild() != null){		//if the object is the head
															//but list is greater than 1
					head = currentPosition.getChild();
					head.setParent(null);
				}else{										//if the object is the head
															//and the list is size 1
					head = null;
				}
				return currentPosition;
			} else{											//if the object is has a
															//parent and child
				if(currentPosition.getChild() != null){
					currentPosition.getParent().setChild(currentPosition.getChild());
					currentPosition.getChild().setParent(currentPosition.getParent());
				}else{										//if the object has no child
					currentPosition.getParent().setChild(null);
				}
				return currentPosition.getObject();
			}
		}else{									//if not found return null
			return null;
		}
	}
	/**
	 * Gets the object associated with the key
	 * @param key the key of the object to be retrieved
	 */
	@Override
	public Object get(String key) {
		if(head == null)		//return from a request on an empty list
			return null;
		
		Node currentPosition = head;

		while(currentPosition != null && !currentPosition.getKey().equals(key)){	//traverse the list
			if(currentPosition.getChild() == null)						//until end of list or key is found
				return null;
			else
				currentPosition = currentPosition.getChild();
		}
		return currentPosition.getObject();
	}
	/**
	 * Formats the HashDictionary as a string that starts with '['
	 * and the key/objects are separated by ", " and ends with a ']'
	 */
	@Override
	public String toString() {
		
		if(head != null){
			String linkedList = new String("[" + head.toString());
			Node currentPosition = head.getChild();
			
			while(currentPosition != null){
				linkedList+=", " + currentPosition.toString();
				currentPosition = currentPosition.getChild();
			}
			linkedList+="]";
			return linkedList;
		}
		else
			return "[]";
	}
}
