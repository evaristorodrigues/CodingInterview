const numbers = [0,99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 500];

function selectionSort(array) {
  let length = array.length;
  for( let i = 0; i < length -1; i ++){
    let shorterPosition = i;
    for(let j =i+1; j < length;  j++){
      if(array[shorterPosition] > array[j]){
        shorterPosition = j;
      }
    }
    let aux = array[i];
    array[i] = array[shorterPosition];
    array[shorterPosition] =aux;
  }
}

selectionSort(numbers);
console.log(numbers);