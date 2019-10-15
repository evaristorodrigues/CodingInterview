function findFactorialRecursive(number) {

  var answer = number; 
  var next = number - 1;

  if(next >1){
    answer = answer * findFactorialRecursive(next) ;
  } 
  //code here
  return answer ;
}

function findFactorialRecursive2(number) {
  var answer = number; 
  var next = number - 1;
  if(next <2){
    return number;
  } 
  return answer * findFactorialRecursive(next);
}

function findFactorialIterative(number) {
 var answer = number;
  for(var i = number - 1; i > 0; i-- ){
    answer = answer*i;
  }
  //code here
  return answer;
}