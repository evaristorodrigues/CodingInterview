
let calc = 0
function fibonacci(){
   let cache= [];
   calc++;
   return function(n){ 
     calc++;
     if(cache[n] != null){
      return cache[n];
     }
     if(n < 2){
        cache[n] =n;
        return cache[n];
     }
     cache[n] = f(n - 1) + f(n -2);
      return cache[n];
    }
}

let f = fibonacci();
console.log(f(6));
console.log(calc);

