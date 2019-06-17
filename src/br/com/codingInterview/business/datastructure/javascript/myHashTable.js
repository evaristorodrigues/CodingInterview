class HashTable {
   constructor(size){

     this.data = new Array(size);
   }

// create the hash for the key
_hash(key){
  let hash = 0;
  for(let i = 0; i < key.length; i++){
    hash = (hash + key.charCodeAt(i) * i) % this.data.length
  }
   console.log(hash);
  return hash;
}

//add one element in the HashTable
set(key, element){
  let address = this._hash(key);
  //verify if exists elemet if not create the array
  if(!this.data[address]){
    this.data[address] = [];
  }
  this.data[address].push([key, element]);
}

get(key){
   let address = this._hash(key);
   const currentBucket = this.data[address];
   //can be more than one elemet in the same space in the //memory because the
   if(currentBucket){
        for(let i = 0; i < currentBucket.length; i++){       
          if(currentBucket[i][0] === key){
            return currentBucket[i][1];
          }
     }

   } 
}
   keys(){
     const keysElement = [];
     for( let i = 0; i < this.data.length; i++){
       if(this.data[i]){
          keysElement.push(this.data[i][0][0]);
       }
             
     }
     return keysElement;    
   }

}