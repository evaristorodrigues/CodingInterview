function fibonacciBottomUp(n){
  let answer = [0,1];

  for(let i = 2; i<= n; i++){
    answer.push(answer[i-1]+answer[i-2] );
  }

  return answer[n];
}

fibonacciBottomUp(10);