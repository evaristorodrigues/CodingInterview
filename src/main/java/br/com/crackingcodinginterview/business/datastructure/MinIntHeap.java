/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

import java.util.Arrays;

/**
 * @author evaristosrodrigues
 *
 */
public class MinIntHeap {

    int capacity;
    int size;
    int[] items;
    
    public MinIntHeap() {
		this.capacity = 10;
		this.size=0;
		this.items = new int[this.capacity];
	}
    
    public  void add(int item) {
    	ensureExtraCapacity();
    	this.items[size]= item;
    	size++;
    	heapifyUp();
    }
    
    private void heapifyUp() {
		int index = size -1;
		while(hasParent(index) && parent(index) > this.items[index]) {
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}		
	}

	public int peek() {
    	if( size ==0) {
    		throw new IllegalStateException();
    	}else {
    		return this.items[0];
    	}
    	
    }
    public int pool() {
    	if(size ==0) {
    		throw new IllegalStateException();
    	}
    	int item = this.items[0];
    	this.items[0]= this.items[size -1];
    	size --;
    	heapifyDown();    	
    	return item;
    }
    private void heapifyDown() {
		int index = 0;
		while( hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(smallerChildIndex)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if(this.items[index] < this.items[smallerChildIndex]) {
				break;
			}else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
		
	}

	private void swap( int indexOnde , int indexTwo) {
    	int temp = this.items[indexOnde];
    	this.items[indexOnde] = this.items[indexTwo];
    	this.items[indexTwo] = temp;
    } 
    
    private void ensureExtraCapacity() {
    	if( size == capacity) {
    		this.items = Arrays.copyOf(this.items, capacity*2);
    		capacity*=2;
    	}
    }
    
    private int getLeftChildIndex(int parentIndex) {
    	return 2 * parentIndex +1;
    }
	private int getRightChildIndex( int parentIndex) {
		return 2 * parentIndex + 2;
	}
	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}
	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}
	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >=0;
	}
	private int leftChild(int parentIndex) {
		return this.items[getLeftChildIndex(parentIndex)];
	}
	private int rightChild(int parentIndex) {
		return this.items[getRightChildIndex(parentIndex)];
	}
	private int parent(int childIndex) {
		return this.items[getParentIndex(childIndex)];
	}
	public  static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
