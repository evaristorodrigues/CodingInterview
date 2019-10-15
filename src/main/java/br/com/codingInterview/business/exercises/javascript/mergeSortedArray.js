//[0,3,4,31] , [4,6,30]

//My function to resolve the problem ( BAD SOLUTION)
function mergeSortedArray(a, b){

   let mergedArray = a;
   
   for(let i = 0; i < b.length; i++){
     mergedArray.push(b[i]);
   }

   for(let i = 0; i < mergedArray.length; i++){
      for(let j = i+1; j < mergedArray.length; j++){
          if(mergedArray[i] > mergedArray[j]){
            let tempValue = mergedArray[i];
            mergedArray[i] = mergedArray[j];
            mergedArray[j] = tempValue;
          }
      }  
   } 

return mergedArray;

}


//Teacher Solution

function mergeSortedArrays( array1, array2){
  
  const mergedArray = [];
  let itemArray1 = array1[0];
  let itemArray2 = array2[0];

  let positionArray1 = 1;
  let positionArray2 = 1;


  if(array1.length ===0){
    return array2;
  }

  if(array2.length ===0){
    return array1;
  }

  while( itemArray1 || itemArray2){

    if( !itemArray2 || itemArray1 < itemArray2){
      mergedArray.push(itemArray1);
      itemArray1 = array1[positionArray1];
      positionArray1 ++;
    }else{
      mergedArray.push(itemArray2);
      itemArray2 = array2[positionArray2];
      positionArray2 ++;
    }

  }

  return mergedArray;

}
