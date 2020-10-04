/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.LinkedList;

/**
 * @author evaristosrodrigues
 *
 */
abstract class Animal{
	
	protected String name;
    private int order;	
    
 public Animal(String name) {
	this.name = name;
 }

 public boolean isOlderThan(Animal animal) {
	 return this.order > animal.getOrder();
 }
public int getOrder() {
	return order;
}

public void setOrder(int order) {
	this.order = order;
}		
}
class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	
}
class Cat extends Animal{

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}

public class AnimalShelter {

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order =1;
	
	public void enqueue(Animal animal) {
       animal.setOrder(order++);
       if(animal instanceof Dog) {
    	   dogs.addLast((Dog)animal);
       }else {
    	   cats.addLast((Cat) animal); 
       }
     
	}
	public Animal dequeueCat() {
		return cats.poll();
	}
	public Animal dequeueDog() {
		return dogs.poll();
	}
	
	public Animal dequeueAny() {
     if(dogs.size() ==0) {
        return dequeueCat(); 
     }else if(cats.size() ==0) {
    	 return dequeueDog();
     }
     Dog dog = dogs.peek();
     Cat cat = cats.peek();
     
     if(dog.isOlderThan(cat)) {
    	 return dequeueDog();
     }else {
    	 return dequeueCat();
     }     
	}
    public boolean isEmpty() {
   	return cats.isEmpty() && dogs.isEmpty();
    }
	
	public static void main(String[] args) {
		Cat a1 = new Cat("Camila");
		Cat a2 = new Cat("Camila2");
		Cat a3 = new Cat("Camila3");
		Cat a4 = new Cat("Camila4");
		Cat a5 = new Cat("Camila5");

		
		
		Dog d1 = new Dog("Evaristo1");
		Dog d2 = new Dog("Evaristo2");
		Dog d3 = new Dog("Evaristo3");
		
		AnimalShelter as = new AnimalShelter();
		as.enqueue(a1);
		as.enqueue(a2);
		as.enqueue(d1);
		as.enqueue(d2);
		as.enqueue(a3);
		as.enqueue(a4);
		as.enqueue(d3);
		as.enqueue(a5);
		
		
		System.out.println(as.dequeueDog().name);
        System.out.println(as.dequeueCat().name); 
        
        while(!as.isEmpty()) {
        	System.out.println(as.dequeueAny().name);
        }	

	}

}
