// Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

function fibonacciIterative(n){
  let current = 0;
  let previous = 0;
  let total = 0;
  for(let i =0; i <= n; i++){
      if(i === 0){
       previous = 0;
      }else if(i === 1){
        total = previous + 1;
        current = total;
      }else{
        total = previous + current;
        previous = current;
        current = total
      }
  }
  return current;
}

function fibonacciIterativeTeacher(n){
   let arr = [0,1];
   for(let i = 2; i < n +1; i++){
     arr.push(arr[i - 2] + arr[i - 1]);
   }
  return arr[n];
}
fibonacciIterativeTeacher(3)
fibonacciIterative(3);

function fibonacciRecursive(n) {
let valor = 0;
 if(n<=0){
   return 0;
 }
 if(n ===1){
   return n;
 } 

 return  fibonacciRecursive(n - 1) +  fibonacciRecursive(n - 2);
}

fibonacciRecursive(3)

