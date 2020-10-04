/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

/**
 * @author evaristosrodrigues
 *
 */
public class SingleLinkedList<T> {
     private LinkedListNode<T> head;
     private LinkedListNode<T> tail;
     int size = 0;
      
      public void add(T value) {
    	  if(tail == null) {
    		  tail = new LinkedListNode<T>(value);
    		  head = tail;
    	  }else {
    		  LinkedListNode<T> node =new LinkedListNode<T>(value);
    		  tail.next = node;
    		  tail = node;
    	  }
    	  size++;
      }
      
      public void addFirst(T value) {
    	  if( head == null) {
    		  head = new LinkedListNode<T>(value);
    		  tail = head;
    	  }else {
    		  LinkedListNode<T> node = new LinkedListNode<T>(value);
    		  node.next = head;
    		  head = node;
    	  }
    	  size++;
      }
      
      public void remove(int position) {
    	  if( position > size-1 || head == null) {
    		  throw new ArrayIndexOutOfBoundsException();
    	  }
    	  if( position ==0) {
    		  head = head.next;
    		  return;
    	  }
    	  int count=1;
    	  LinkedListNode<T> current = head;
    	  while( count++ < position) {
    		  current = current.next;
    	  } 
    	  current.next = current.next.next;
    	  if( position == size - 1) {
    		  tail = current;
    	  }
    	  size --;
      }
      
      public T get(int position) {
    	  if( position > size - 1) {
    		  throw new ArrayIndexOutOfBoundsException(); 
    	  }
    	  if(position ==0) {
    		  return head.value;
    	  }
    	  LinkedListNode<T> current = head;
    	  int count=0;
    	  while( count++ <position) {
    		  current = current.next;
    	  }
    	  
    	  return current.value;
      }
      
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		System.out.println("Valor Inicial");
		for( int i =0; i < sll.size; i++) {
			System.out.println(sll.get(i));
		}
		
		System.out.println("Removendo 2 Elemento");
		sll.remove(2);
		System.out.println();
		for( int i =0; i < sll.size; i++) {
			System.out.println(sll.get(i));
		}
		System.out.println("Adicionando 10 no inicio e removendo 3 elemento");
		
		sll.addFirst(10);		
		sll.remove(3);
		
		for( int i =0; i < sll.size; i++) {
			System.out.println(sll.get(i));
		}		
		System.out.println("Adicionando 20");
		
		sll.add(20);
		for( int i =0; i < sll.size; i++) {
			System.out.println(sll.get(i));
		}	

	}

}

class LinkedListNode<T> {
	LinkedListNode<T> next;
	T value;
	public LinkedListNode(T value) {
		this.value = value;
	}
}
