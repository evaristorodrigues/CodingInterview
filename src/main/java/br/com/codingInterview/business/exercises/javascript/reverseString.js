

// My way to create de reverse

function reverse(str){
if(!str || str.length < 2 || typeof str !== 'string'){

  return 'Thats not good, please pass a String to be reversed'
}  
let string = '';
 for(let i = str.length-1; i >= 0 ;  i-- ){
   string += str[i];
 }
return string;
}



//Teacher way

function reverse2(str){
if(!str || str.length < 2 || typeof str !== 'string'){

  return 'Thats not good, please pass a String to be reversed'
}  

const backwards = [];
const totalItems = str.length - 1;
for(let i = totalItems; i >= 0 ;  i-- ){
  backwards.push(str[i]);
 }
 console.log(backwards);
return backwards.join('');
}


//Advanced way using javascript
function reverse3(str){
  return str.split('').reverse().join('');
}


//Most advanced way
const reverse4 = srt => [...srt].reverse().join('');