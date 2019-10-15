class DoublyLinkedList{

  constructor(value){

    this.head ={
      value:value,
      next : null,
      previous:null
    }
    
    this.tail = this.head;
    this.length = 1;

  }

  append(value){
    const newNode = {
      value : value,
      next : null,
      previous:null
    };
    this.tail.next = newNode;
    newNode.previous = this.tail;
    this.tail= newNode;    
    this.length++;
    return this;
  }

  prepend(value){
    const newNode = {
      value : value,
      next : this.head,
      previous: null
    };
    this.head.previous =newNode;
    this.head= newNode;
    this.length++;

    return this;  
  }

  printList(){
   const array =[];
   let currentNode = this.head;
   while(currentNode !== null){
     array.push(currentNode.value);
     currentNode = currentNode.next;
   }
   return array;
  }

  insert(value, index){

    if(index === 0){
      this.prepend(value);
      return this.printList();
    }else if( index >= this.length){
      this.append(value);
      return this.printList();
    }

    const newNode = {
      value : value,
      next : null,
      previous:null
    };

    const holdingPointer = this.traverseToIndex(index);
    const leader = holdingPointer.previous;
    leader.next = newNode;
    newNode.next = holdingPointer;
    newNode.previous =leader;
    holdingPointer.previous = newNode;
    this.length++;    
    return this.printList();
  }
  traverseToIndex(index){
    let counter = 0;
    let currentNode = this.head;

    while(counter !== index){
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }

  remove(index){

    if(index === 0){
      this.head = this.head.next;
      this.length--;
      return this.printList();
    }
    if(index > this.length -1 ){
      return 'Indice Invalido';
    }
    const holdingPointer = this.traverseToIndex(index);
    const leader = holdingPointer.previous;
    const next = holdingPointer.next
    leader.next = next ;
    if(next !==null){
       next.previous = leader;
     }
    this.length--;
    return this.printList();

  }

 }
}

a = new DoublyLinkedList(10);
a.append(11);
a.append(12);
a.append(13);
a.append(14);
a.append(15);
a.prepend(9);
a.insert(14.4,6);
a.remove(2);