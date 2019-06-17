
//My solution
const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function insertionSort(array) {
 const length = array.length;
  for(let i=1; i <= length; i ++ ){
    if(array[i] < array[i -1]){
      if(i > 1){
        traverse(array,i, array[i] );
      }else{
        let aux = array[i] ;
        array[i] = array[i -1];
        array[i -1] = aux;        
      }
    }

  }

  function traverse(array, position, value){     
     for(let i=0; i < position; i ++ ){
        if(array[i] > value){
          shiftArray(array,i,position, value);
          break;
        }
     } 
  }
  function shiftArray(array,start,end, value){
        for(let i=end; i > start; i -- ){
          array[i] = array[i-1];
        }  
        array[start] = value;
  }
  
}

insertionSort(numbers);
console.log(numbers);


//Teacher solution
const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function insertionSort(array) {
  const length = array.length;
	for (let i = 0; i < length; i++) {
		if (array[i] < array[0]) {
      //move number to the first position
      array.unshift(array.splice(i,1)[0]);
    } else {
      // only sort number smaller than number on the left of it. This is the part of insertion sort that makes it fast if the array is almost sorted.
      if (array[i] < array[i-1]) {
        //find where number should go
        for (var j = 1; j < i; j++) {
          if (array[i] >= array[j-1] && array[i] < array[j]) {
            //move number to the right spot
            array.splice(j,0,array.splice(i,1)[0]);
          }
        }
      }
    }
	}
}

insertionSort(numbers);
console.log(numbers);



const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];
function insertionSort(array) {
let temp;
for(let i = 1; i < array.length; i++){
  for(let j = i; j > 0; j --){
    if( array[j] < array[j-1]){
      temp = array[j];
      array[j] = array[j-1];
      array[j-1] = temp;
    }
  }
}
}  

insertionSort(numbers);
console.log(numbers);