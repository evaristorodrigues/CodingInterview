class LinkedList{

  constructor(value){

    this.head ={
      value:value,
      next : null
    }
    
    this.tail = this.head;
    this.length = 1;

  }

  append(value){
    const newNode = {
      value : value,
      next : null
    }
    this.tail.next = newNode;
    this.tail= newNode;    
    this.length++;
    return this;
  }

  prepend(value){
    const newNode = {
      value : value,
      next : this.head
    }
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
      next : null
    };

    const leader = this.traverseToIndex(index -1);
    const holdingPointer = leader.next;
    leader.next = newNode;
    newNode.next = holdingPointer;
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
    const leader = this.traverseToIndex(index - 1);
    const holdingPointer = leader.next;
    leader.next = holdingPointer.next;
    this.length--;
    return this.printList();

  }

  reverse(){   
    if(this.head.next === null){
      return this.printList();
    }   
    //Crio uma variavel para representar o 1º elemento
    let firts = this.head;
    //Faço com que o Tail seja o primeiro elemento
    this.tail =firts;
    //Começo a iterar pelo segundo elemento
    let currentNode = firts.next;
    while(currentNode){
     //Crio uma variavel auxiliar para representar o proximo elemento 
     let temp = currentNode.next;
     //Faço com que o segundo elemento aponto para o primeiro
     currentNode.next = firts;  
     //Faço com que o primeiro elemento seja o segundo Node 
     firts = currentNode;
     //Faço com que o proximo Node corrente seja o temp que guardava o terceiro
     currentNode = temp;
   }
   //Faço com que o Head q é o tail aponte para null
   this.head.next= null;
   //Faço com que o head seja realmente o primeiro node
   this.head = firts;
   return this.printList();
  }
}

a = new LinkedList(10);
a.append(11);
a.append(12);
a.append(13);
a.append(14);
a.append(16);
a.prepend(9);
a.insert(15,6);
//a.remove(2);