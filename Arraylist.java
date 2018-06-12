/*
 * Nhi Tuong 
 * 
 * Purpose:			To be able to create and manipulate an arraylist data structure that accepts any object.
 * 
 * Solution: 		Creating a class object that consist of an object array that accept an int parameter to determine the capacity.
 * 					Implementing field variables to store values that will be called in multiple methods. 
 * 					Then create multiple methods to manipulate the field variables by implementing for loops to perform specific algorithm to get
 * 					desire outputs. 
 *  			
 *Data Structure: 	Arraylist  
 *  
 *How to use: 		Nothing is needed to execute this program. Everything that test each methods are located in the
 *					main class that uses system.out.print to output the results. The only thing to keep in mind are the
 *					notes/comments added in the main class. No input are needed.   
 *  
 *Purpose of each class: 	The Arraylist class is made to store an object to the array. It also implement functions you can
 *							perform to the Arraylist object by calling the corresponding name, followed by the arraylist name in 
 *							main class. The testarray class is created to test the Arraylist class to make sure and double check
 *							that each methods are performing correctly. How the testarray does this is by printing out all the 
 *							results of the methods called and creating an arraylist object itself. 
 *  
 */
public class Arraylist {

	/*
	 * Field Variables
	 */
	
	private int size; //current size of the list
	private int capacity; 
	static final int initialcapacity = 10;
	Object[] ArraylistObject; //stores objects

	
	/* 
	 * Constructors for Arraylist
	 */
	public Arraylist(){
		this(initialcapacity);
		capacity = initialcapacity;
	}
	
	public Arraylist(int capacity){
		this.capacity = capacity;
		ArraylistObject = new Object[capacity];
		size = 0;
		
	}
	
	/*
	 * Methods to manipulate Arraylist
	 */
	
	
	/*
	 * Precondition: 	Must have a valid object in the parameter
	 * Postcondition:	Object array will increase in size by 1 and index [size - 1] will store
	 * 					the object in the parameter.
	 * invariant: 		capacity if size != capacity. 
	 */
	public void add(Object o){
		//adds value to the end of array
		if (size == capacity) {
			int tempCap = capacity * 2;
			int tempSize = 0;
			Object[] temp = new Object[tempCap];
			for (int i = 0; i < capacity; i++){
				temp[i] = ArraylistObject[i];
				tempSize++;
				
			}
			ArraylistObject = temp;
			size = tempSize;
			capacity = tempCap;
			ArraylistObject[size] = o;
			size++;

			
		} else {
		ArraylistObject[size] = o;
		size++;
		}
	}
	
	
	/*
	 * Precondition:	parameter must consist of a valid int index that index > 0 && index <= size and object.
	 * Postcondition:	if index does not meet the condition. A System.print message will execute.
	 * 					else if index does meet, the array will replace the object at an existing index. if index - 1 ==
	 * 					size, it will add and increase the size like the normal add function.
	 * Invariant:		Array capacity. Array size does not change unless [index - 1] == size;
	 */
	public void add(int index, Object o){
		//adds value at a certain index in 
		ArraylistObject[index - 1] = o;
			if (index - 1 < 0 || index - 1 > size){
				System.out.println("Index is out of bound. Please select another index");
			}
			else if (index - 1 == size){
			size++;
			} 
			
		}			
	/*
	 * Precondition:	parameter must consist of a valid int index that index - 1 > 0 && index - 1 <= size and object.
	 * Postcondition:	if index does not meet the condition. A System.print message will execute.
	 * 					else if index does meet, the array will insert the object at an existing index. 
	 * 					it will add and increase the size like the normal add function.
	 * Invariant:		
	 */
	public void addInsert(int index, Object o){
		if (size == capacity) {				//check if needed to increase capacity. 
											//Using a temp[] to copy ArraylistObject and adding object
											//then renaming temp back to ArraylistObject. 
			int tempCap = capacity * 2;
			int tempSize = 0;
			Object[] temp = new Object[tempCap];
			for (int i = 0; i < capacity; i++){
				temp[i] = ArraylistObject[i];
				tempSize++;
				
			}
			ArraylistObject = temp;
			size = tempSize;
			capacity = tempCap;			//replace value w/ new value;
		}
		
		int addLocation = index - 1;
		if (addLocation < 0 || addLocation> size){
			System.out.println("Index is out of bound. Please select another index");
			
		} else{
		
		Object[] temp = new Object[size + 1];
		for ( int i = 0; i < addLocation ; i++){
			temp[i] = ArraylistObject[i];
		}
		for ( int i = index; i < size + 1; i++){
			temp[i] = ArraylistObject[i-1];
		}
		temp[addLocation] = o;
		size++;
		ArraylistObject = temp;
		
		}
		}
	

		
	/*
	 * Precondition:	needs index of int object
	 * Postcondition:	return object at index
	 * Invariant:		arraylistobject; size; capacity; objects;
	 */
	public Object get(int index) throws Exception{
		//get a value at an index
		//Check if index is valid
		Object empty = "Index is out of bound. Please select another index.";
		try {
		return ArraylistObject[index - 1];
			
		}	catch (Exception e){
			return empty;
		}
	
	}
	
	
	/*
	 * Precondition:	none.
	 * Postcondition:	return int value of the field variable size stored.
	 * Invariant:		array; size; capacity; objects;
	 */
	public int getSize(){
		//Return object's number of objects in array
		return size;
		
	}
	
	
	/*
	 * Precondition:	none. 
	 * Postcondition:	boolean value.
	 * Invariant:		array; size; capacity; objects;
	 */
	public boolean isEmpty(){
		//Return false if empty
		//logic: test all object in case arraylist contains null objects.
		boolean empty = true;
		for(int i = 0; i < size; i++){
			if (ArraylistObject[i] != null){
				empty = false;
				break;
				} 
			}
		System.out.print("Arraylist is empty: ");
		return empty;
		
	}
	
	
	/*
	 * Precondition:	need a valid object
	 * Postcondition:	boolean value
	 * Invariant:		array; size; capacity; objects;
	 */
	public boolean isIn(Object o){
		//Check to see a value exist in object
		boolean check = false;
		
		for (int i = 0; i < size ; i++){
			
			if (ArraylistObject[i].equals(o)){
				return true;
			}
			
			else {
			check = false;
			}
		}
		return check;

	}
	
	
	/*
	 * Precondition:	valid object
	 * Postcondition:	int value that correspond to position of object
	 * Invariant: 		array; size; capacity; objects;
	 */
	public int find(Object o){
		//needs to check if object exist first.
		int location = -1;
		
		for (int i = 0; i < size; i++){
			if (ArraylistObject[i].equals(o) == true){
			location = i + 1;
			break;
			} else if (location == -1 && i == size){
			location = -1;
			}
		}return location;
		
	}
		
	
	/*
	 * Precondition:	valid object
	 * Postcondition:	array without object declared in the parameter and size is decremented.
	 * Invariant:		capacity
	 */
	public void remove (Object o){
		//Remove the location of the first occurrence of an Object starting at 0
		int deleteLocation = 0;
		
		Object[] temp = new Object[size -1 ];
		for ( int i = 0; i < size ; i++){
			if (ArraylistObject[i] == o){
				ArraylistObject[i] = null;
				deleteLocation = i;
				
				break;
		
			}
		
		}
		for (int i = 0; i < deleteLocation; i++ ){
		temp[i] = ArraylistObject[i];
		}
		for (int i = deleteLocation; i < size - 1; i++){
			temp[i] = ArraylistObject[i +1];
		}
		ArraylistObject = temp;
		size--;
	}
	
	
	/*
	 * Precondition:	none.
	 * Postcondition:	output print statement + capacity value;
	 * Invariant:		array; size; capacity; objects;
	 */
	public void getCapacity(){
		System.out.println("Arraylist capacity is: " + capacity);
	}
	
	
}
