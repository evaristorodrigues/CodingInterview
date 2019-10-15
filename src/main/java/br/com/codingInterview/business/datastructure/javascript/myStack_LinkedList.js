class Node{
  constructor(value){
    this.value = value;
    this.next = null;
  }
}


class Stack{

     constructor(){
       this.top = null;
       this.bottom = null;
       this.length =0;
     }

     peek(){
      return this.top;
     } 
     push(value){
       const newNode = new Node(value);
       if(this.length ===0){
         this.top = newNode;
         this.bottom = newNode;
       }else{
         const holdingPointer = this.top;
         newNode.next = holdingPointer;
         this.top = newNode
       }
       this.length++;       
      return this;
     }
     pop(){
        if(!this.top){
          return null;
        }

        if(this.top === this.bottom){
          this.bottom = null;
        }      
        this.top = this.top.next;        
        this.length--;
        return this;
     }
}

let myStack = new Stack();
myStack.push('Paquerar');
myStack.push('Ficar');
myStack.push('Namorar');
myStack.push('Noivar');
myStack.push('Casar');
myStack.peek();
