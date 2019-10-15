

class Stack{

     constructor(){
       this.array=[];
     }

     peek(){
      return this.array[this.array.length -1];
     } 
     push(value){
       this.array.push(value);
       return this;
     }
     pop(){
        this.array.pop();
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
