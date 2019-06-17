function recurringCharacter(array){

  if(!array){

    return undefined;
  }

  if(array.length < 1){

    return undefined;
  }

let map = new Map();
for( let i = 0; i < array.length ; i++){
    
    if(map.has(array[i])){

      return array[i];
    }else{

      map.set(array[i], i);
    }
}

return undefined;

}

function recurringCharacter2(array){
  if(!array){

    return undefined;
  }

  if(array.length < 1){

    return undefined;
  }

  let map ={};
for( let i = 0; i < array.length ; i++){
    if(map[array[i]] !== undefined){
      return array[i];
    }else{
      map[array[i]]= i;
    }
}  
return undefined;

}

function recurringCharacterBad(array){

  if(!array){

    return undefined;
  }

  if(array.length < 1){

    return undefined;
  }

let values= [];
for( let i = 0; i < array.length ; i++){
  for( let j = i + 1; j < array.length ; j++){
    if(array[j] === array[i]){
      return array[i];
    }else{
       if(values[array[j]]){
         return array[j];
       }else{
         values[array[j]] =j;
       }
    }
  }  
 
}

return undefined;

}