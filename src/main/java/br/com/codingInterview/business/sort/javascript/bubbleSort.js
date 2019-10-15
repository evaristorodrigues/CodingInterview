const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function bubbleSort(array) {
 for( let i = 0; i < numbers.length - 1; i++){
  var aux =i+1;
  for( let j = 0; j < (numbers.length -aux); j++){
    if(numbers[j] > numbers[j+1]){
      var a =  numbers[j+1];
      numbers[j+1] = numbers[j];
      numbers[j] =  a;
    }
  }
 }
}

bubbleSort(numbers);
console.log(numbers);