class Node {
  constructor(value){
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

class BinarySearchTree {
  constructor(){
    this.root = null;
  }
  insert(value){
    let newNode = new Node(value);
    if(this.root === null){
       this.root = newNode;
    }
    this.traverseAdd(this.root, newNode);
    
  }
  lookup(value){
    if(this.root !== null ){
      return this.traverseLookup(this.root, value);
    }
 

  }
  traverseAdd(node, newNode){
       if(newNode.value === node.value){
         return node;
       }
       if(newNode.value > node.value){
           if(node.right === null){
             node.right = newNode;
           }else{
             this.traverseAdd(node.right, newNode);
           }
       }else if(node.left === null){
              node.left = newNode;
       }else{
          this.traverseAdd(node.left, newNode);
       }
  }//terminar o lookup
  traverseLookup(node, value){
    console.log(node.value +" "+ value + " - "+ (value === node.value));
       if(value === node.value){
         return node;
       }
       if(value > node.value){
           console.log("validate right");
           if(node.right === null){
            return null;
           }else{
             return this.traverseLookup(node.right, value);
           }
       }else if(node.left === null){
              return null;
       }else{
          return this.traverseLookup(node.left, value);
       }
  }

  
}

const tree = new BinarySearchTree();
tree.insert(9)
tree.insert(4)
tree.insert(6)
tree.insert(20)
tree.insert(170)
tree.insert(15)
tree.insert(1)
JSON.stringify(traverse(tree.root))

//     9
//  4     20
//1  6  15  170

function traverse(node) {
  const tree = { value: node.value };
  tree.left = node.left === null ? null : traverse(node.left);
  tree.right = node.right === null ? null : traverse(node.right);
  return tree;
}





