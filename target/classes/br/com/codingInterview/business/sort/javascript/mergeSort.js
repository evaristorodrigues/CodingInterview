const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function mergeSort (array) {

  if (array.length === 1) {
    return array;
  }
    // Split Array in into right and left
  let left = array.slice(0,(array.length/2));
  let right = array.slice((array.length/2),array.length);

  return merge(
    mergeSort(left),
    mergeSort(right)
  )

}

function merge(left, right){
  if(left === undefined){
    return right;
  }
  if(right === undefined){
    return left;
  }
  let concated = left.concat(right);
   for(let i=1; i < concated.length; i++){
    for(let j = i; j > 0; j--){
      if(concated[j] < concated[j -1]){
        let aux = concated[j];
        concated[j] = concated[j -1];
        concated[j -1] = aux;        
      }
    }
  }
  return concated;
}

const answer = mergeSort(numbers);
console.log(answer);



//Teacher answer

const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function mergeSort (array) {
  if (array.length === 1) {
    return array
  }
  // Split Array in into right and left
  const length = array.length;
  const middle = Math.floor(length / 2)
  const left = array.slice(0, middle) 
  const right = array.slice(middle)
  // console.log('left:', left);
  // console.log('right:', right);

  
  return merge(
    mergeSort(left),
    mergeSort(right)
  )
}

function merge(left, right){
  const result = [];
  let leftIndex = 0;
  let rightIndex = 0;
  while(leftIndex < left.length && 
        rightIndex < right.length){
     if(left[leftIndex] < right[rightIndex]){
       result.push(left[leftIndex]);
       leftIndex++;
     } else{
       result.push(right[rightIndex]);
       rightIndex++
    }
  }  
   console.log(left, right)
   debugger;
  return result.concat(left.slice(leftIndex)).concat(right.slice(rightIndex));
}


const answer = mergeSort(numbers);
console.log(answer);