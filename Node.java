package dict;
/**
 * @author Robert Payne
 * class ITCS 3112-001
 * date 2/5/2014
 */
public class Node{
	private Object value;
	private Node childObj;
	private Node parentObj;
	private String key;
/**
 * Constructor
 * Sets the attributes to null
 */
	Node(){
		value = null;
		childObj = null;
		parentObj = null;
		key = null;
	}
/**
 * Constructor
 * @param obj	stores the reference of an object
 * @param key	stores the key of the object
 */
	Node(Object obj, String key){
		this.value = obj;
		this.key = key;
		childObj = null;
		parentObj = null;
	}
/**
 * Constructor
 * @param obj	stores the reference of an object
 * @param parent	stores the reference of the parent node
 * @param key	stores the key of the object
 */
	Node(Object obj, Node parent, String key){
		this.value = obj;
		this.key = key;
		childObj = null;
		parentObj = parent;
	}
/**
 * Adds a reference to a child node
 * @param newChild	stores the reference of the child node
 */
	public void addChild(Node newChild){
		childObj = newChild;
	}
/**	 
 * Gets the child of the node
 * @return returns the child node
 */
	public Node getChild(){
		return childObj;
	}
/**
 * Gets the parent of the node
 * @return returns the parent node
 */
	public Node getParent(){
		return parentObj;
	}
/**
 * Stores a reference of a child node
 * @param child the child node to be stored
 */
	public void setChild(Node child){
		childObj = child;
	}
/**
 * Stores a reference of a parent node
 * @param parent the parent node to be stored
 */
	public void setParent(Node parent){
		parentObj = parent;
	}
/**
 * Returns the object stored in the node
 * @return the object stored in the node
 */
	public Object getObject(){
		return value;
	}
/**
 * Returns the key of the node
 * @return the key as a String
 */
	public String getKey(){
		return key;
	}
/**
 * Returns the key and object represented in the "key:object" format
 */
	public String toString(){
		return key + ":" + value;		
	}
}