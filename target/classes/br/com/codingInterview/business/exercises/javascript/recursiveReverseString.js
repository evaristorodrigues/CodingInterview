//Implement a function that reverses a string using iteration...and then recursion!

//iteration

function reverseString(str) {
  let reverse = '';
 for( let i = 0 ; i < str.length; i ++){
     reverse+= reverse.charAt((str.length - 1) - i);
 }
  return reverse;
}

function reverseString(str) {
  if(str.length<=1){
    return str;
  }
    let reverse = str.charAt(str.length -1);
    return reverse + reverseString(str.substring(0,str.length -1));
}

reverseString('yoyo mastery')
//should return: 'yretsam oyoy'