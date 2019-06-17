const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function quickSort(array, left, right){
 //debugger;
  if( right - left < 1){
    return;
  }

  let pivot =right;
  for(let i = left; i < right && i < pivot; i ++){
    if(array[i] > array[pivot]){
       let aux = array[pivot];
       array[pivot] = array[pivot - 1];
       array[pivot - 1] = aux;
       
       if( ( pivot - i) > 1){
          aux = array[i];
          array[i] = array[pivot];
          array[pivot] = aux;         
       }
       pivot --;
      

    }
  }
  console.log(array);
 
 let mid = Math.floor(( right - left) /2);
 quickSort(array,left,(left + mid)-1);
 quickSort(array,(right -mid) +1, right);
}


//Select first and last index as 2nd and 3rd parameters
quickSort(numbers, 0, numbers.length - 1);
console.log(numbers);