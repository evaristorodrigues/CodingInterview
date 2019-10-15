class MyArray{
   constructor(){
     this.length =0;
     this.data={};
   }

   //we have to implement some validations


   //return the item passed as parameter in the method
   get(index){
    return this.data[index];

   }


 //Add another element in the las position of the array
   push(item){
     this.data[this.length] = item;
     this.length ++;
     return this.length;
   }

//Remove the last element of the array
   pop(){
     const lastItem = this.data[this.length - 1 ];
     delete this.data[this.length -1];
     this.length--;
     return lastItem;
   }

// remove the element passed as parameter
   delete(index){
     const item = this.data[index];
     this.shiftItems(index);
     return item;
   }

// shift the element to the right to remove the element passed as parameter
   shiftItems(index){
     for(let i = index; i < this.length - 1 ; i++){  
         this.data[i] = this.data[i+1];
     }
     delete this.data[this.length -1];
    this.length--;
   }

}

  const myArray = new MyArray();
  myArray.push("Hi");
  myArray.push("You");
  console.log(myArray);