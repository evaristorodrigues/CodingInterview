class Stack{

     constructor(){
       this.top = null;
       this.bottom = null;
       this.length =0;
     }

     peek(){
      return this.top[this.length - 1];
     } 
     push(value){
      
       if(this.length ===0){
         this.top = [];
         this.top.push(value);
         this.bottom=value;
       }else{
         this.top.push(value);
       }
       this.length++;       
      return this;
     }
     pop(){
        if(!this.top){
          return null;
        }

        if(this.top[this.length-1] === this.bottom){
          this.bottom = null;
        }      
        this.top.pop();        
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
