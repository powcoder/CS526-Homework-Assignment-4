https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Modified from SinglyLinkedList
 * Manages Car objects
 */

public class CarLinkedList {
  //---------------- nested Node class ----------------
  /**
   * This node stores only a Car object
   */
	
  private static class Node {

    /** The element stored at this node */
    private Car element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(Car e, Node n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     */
    public Car getElement() { return element; }

    /**
     * Returns the node that follows this one.
     */
    public Node getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     */
    public void setNext(Node n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of CarLinkedList
  /** The head node of the list */
  private Node head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public CarLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   */
  public Car first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   */
  public Car last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   */
  public void addFirst(Car e) {                // adds element e to the front of the list
    head = new Node(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   */
  public void addLast(Car e) {                 // adds element e to the end of the list
    Node newest = new Node(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   */
  public Car removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    Car answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }

  /**
   * Removes and returns the element with given VIN.
   * Returns null if the list is empty or the car with the VIN does not exist
   */
  public Car remove(String VIN){
	  
	// you need to implement this method
	
  }
  
  

  // Reads cars from an input file and stores them in a CarLinkedList
  public static void readCars(CarLinkedList carList) throws FileNotFoundException {
		
	  	Scanner carListScanner = new Scanner (new File("car_info.txt"));
		String aCar;
		String VIN;
		String make;
		int year;
		int price;
		
		while (carListScanner.hasNext()){
			aCar = carListScanner.nextLine();
			Scanner carScanner = new Scanner(aCar);
			VIN = carScanner.next();
			make = carScanner.next();
			year = carScanner.nextInt();
			price = carScanner.nextInt();
			
			Car c = new Car(VIN, make, year, price);
			carList.addLast(c);
		}
	}
  
  // print all cars in the list
  public static void printAllCars(CarLinkedList carList) {
	  Node current = carList.head;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
		System.out.println();
  }
  
  public static void main(String[] args) {
		
		CarLinkedList carList = new CarLinkedList();
		try {
			readCars(carList);
		}
		catch (FileNotFoundException e){
			System.out.println("Input file not found.");
		}
		
		System.out.println("Print all cars");
		System.out.println("The number of cars in the list = " + carList.size());
		printAllCars(carList);
		System.out.println();
		
		// Test remove method
		
		Car removedCar;
		String VIN = "V123ABC";
		removedCar = carList.remove(VIN);
		if (removedCar == null) {
			System.out.println("The car with VIN " + VIN + " does not exist");
		}
		else {
			System.out.println("Print all cars after removing the car with VIN = " + VIN);
			System.out.println("The number of cars in the list = " + carList.size());
			printAllCars(carList);
		}
		System.out.println();
		
		VIN = "V333CAT";
		removedCar = carList.remove(VIN);
		if (removedCar == null) {
			System.out.println("The car with VIN " + VIN + " does not exist");
		}
		else {
			System.out.println("Print all cars after removing the car with VIN = " + VIN);
			System.out.println("The number of cars in the list = " + carList.size());
			printAllCars(carList);
		}
		System.out.println();
		
		VIN = "VSTU444";
		removedCar = carList.remove(VIN);
		if (removedCar == null) {
			System.out.println("The car with VIN " + VIN + " does not exist");
		}
		else {
			System.out.println("Print all cars after removing the car with VIN = " + VIN);
			System.out.println("The number of cars in the list = " + carList.size());
			printAllCars(carList);
		}
		System.out.println();
		
		VIN = "VXYZ999";
		removedCar = carList.remove(VIN);
		if (removedCar == null) {
			System.out.println("The car with VIN " + VIN + " does not exist");
		}
		else {
			System.out.println("Print all cars after removing the car with VIN = " + VIN);
			System.out.println("The number of cars in the list = " + carList.size());
			printAllCars(carList);
		}
		System.out.println();
  }

}  
  
