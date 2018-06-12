/*
 * Nhi Tuong CSC3410 MW 
 * 
 * 
 */
public class testarray {

	public static void main(String[] args) throws Exception{
		
		
		//Problem 1.	Test initial capacity of array.
		Arraylist initest = new Arraylist();
		initest.getCapacity();
		
		
		//Problem 2.	Test custom capacity of array.
		Arraylist test = new Arraylist(20);
		test.getCapacity();
		System.out.println("Arraylist size is:" + initest.getSize());
		
		//				Test size is empty initially & isEmpty return true.
		System.out.println("Arraylist size is:" + test.getSize());
		System.out.println(test.isEmpty());
		
		//problem 3.	Test adding all type of objects to the end of the array.
		test.add("Nhi");
		test.add('c');
		test.add(true);
		test.add(1);
		test.add(2.2);
		
		/*				Checking if size is correctly added. Size 5.
		*Problem 5.		Algorithm is according to input that's not zero - based indexing.
		*				Where the getting the first array would be consider getting index 1 instead of
		*				instead of calling index 0. 
		*				Testing the get method to handle out of bound indexes. 
		*Problem 6.		Get the number of elements in the array.
		*/
		
		
		System.out.println("Arraylist size is:" + test.getSize());
		for(int i = 1; i <= test.getSize(); i++){
			System.out.print(test.get(i) + " ");
		}
		System.out.println(" ");
		System.out.println(" ");
		
		/*Problem 4		Adding an object at a certain index. Making sure its 
		*				replacing the correct index.
		*				Test to see if it will handle out of bound indexes. 
		*/
		test.add(3, false);
		test.add(1,"nhi");
		test.add(5,2.6);
		
		System.out.println("print out 1 error when adding out of bound. ");
		test.add(14,'c'); 
		
		
		
		
		System.out.println(" ");
		System.out.println("Test if replacements were successful");
		
		for(int i = 1; i <= test.getSize(); i++){
			System.out.print(test.get(i) + " ");
		}
		System.out.println(" ");
		
		System.out.println("Arraylist size is:" + test.getSize());
		System.out.println(" ");
		
		/*
		 * Problem 7. 	Check to see if arraylist is empty.
		 */
		System.out.println(test.isEmpty()); // not empty
		System.out.println(initest.isEmpty()); // print out empty
		
		/*
		 * Problem 8.	Check to see if an object exist in an array.
		 * 
		 */
		
		System.out.println(test.isIn("b")); // should be false
		//printing out zero based indexing for arraylist
		System.out.println(test.isIn("a")); // should be true at index 0
		System.out.println(test.isIn('c')); // should be true at index 2
		System.out.println(test.isIn("hi"));
		
		/*
		 * Problem 9. 	Find the first occurrence of an object in the arraylist
		 */
		System.out.println(" ");
		test.add(3, 1);
		System.out.println("location is at index: " + test.find("a"));
		System.out.println("location is at index: " + test.find(1));
		System.out.println("location is at index: " + test.find("nhi"));
		
		/*
		 * Problem 10. Removing an object.
		 */
		System.out.println(" ");
		test.remove("hi");
		System.out.println(test.isIn("hi"));
		System.out.println(test.getSize());
		System.out.println(" ");
		/*
		 *  Test doubling an array once size = capacity
		 *  Test if array will not increment array is full.
		 *  Test if array will increment if adding to a full array.
		 */
		
		Arraylist doubleMe = new Arraylist(3);
		doubleMe.add(1);
		doubleMe.add(2);
		doubleMe.add(3);
		doubleMe.add(4);
		System.out.println(doubleMe.getSize());
		doubleMe.getCapacity();
		doubleMe.add(1);
		doubleMe.add(2);
		System.out.println(doubleMe.getSize());
		doubleMe.getCapacity();
		doubleMe.add(2);
		System.out.println(doubleMe.getSize());
		doubleMe.getCapacity();
		
		
		/*
		 * PROBLEM 4. 		When inserting a value within existing index of the array; Rather than replacing.
		 */
		for(int i = 1; i <= doubleMe.getSize(); i++){
			System.out.print(doubleMe.get(i) + " ");
		}
		System.out.println(" ");
		doubleMe.addInsert(2, 10);
		for(int i = 1; i <= doubleMe.getSize(); i++){
			System.out.print(doubleMe.get(i) + " ");
		}
		System.out.println(" ");
		System.out.println(doubleMe.getSize());
		doubleMe.addInsert(10, 10); //print error
		/*
		 * Test to check if addInsert will double if capacity is reacted. 
		 */
		doubleMe.addInsert(2, 10);
		doubleMe.addInsert(2, 10);
		doubleMe.addInsert(2, 10);
		doubleMe.addInsert(2, 10);
		doubleMe.addInsert(2, 10);
		System.out.println(doubleMe.getSize());
		doubleMe.getCapacity();
		for(int i = 1; i <= doubleMe.getSize(); i++){
			System.out.print(doubleMe.get(i) + " ");
		}
	}
}
