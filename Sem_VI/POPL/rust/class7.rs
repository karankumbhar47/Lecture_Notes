// c, c++ --> return value
 
fn main() {
    // two type of sentence 
    // statement --> not return ,
    //          -->  let x=5; // only assign/bound 5 to x and not return
    //          --> fn main() --> statement, not experssion as not return anything
    //          --> let k = factorial(n,k); --> experssion
    //
    //let y = (let x=5);
    // experssion --> return value
    
    // let a = 7;
    // if(a=3){
    //     println!("{}", a);
    // }
    // else{
    //     println!("none");
    // }
    
    // anonymous function in javascript
    let x = {
        //create scope
        let y = 4;
        y+1 // value of scope is y+1 
        // value of statement
        // don't add semicolon to last return value
    } + 9; // as {} return a value we can use this in expression
    println!("x={x}");

    
    let k = getNum(3) + 3;
    // addition of integer 
    // so getNum() should also be an integer instead of it is () type
    // as getNum() is returning unit type
    // but getNum()-> i32 will return integer
    println!("k={k}");


    let marks = 100;
    let credit = 8;
    let a = 0;
    // if expr --> has return value
    let avg = if credit>0 {
        marks/credit
    }
    else{
        0
    };
    println!("avg={avg}");

    // //if statement  --> return () type
    // let avg = if credit>0 {
    //     a = marks/credit;
    // }
    // else{
    //     a= 0;
    // };
    // println!("avg={avg}");

    // //not allowed
    // // if expr --> has return value
    // let avg = if credit>0 {
    //     marks/credit //--> return float
    // }
    // else{
    //     0.43 //--> return integer
    // };
    // println!("avg={avg}");
    
 
    // not allowed
    // let avg = if credit=0 {
    //     a = marks/credit;
    // }
    // else{
    //     a= 0;
    // };
    // println!("avg={avg}");   

 
    // not allowed
    // let avg = if credit {
    //     a = marks/credit;
    // }
    // else{
    //     a= 0;
    // };
    // println!("avg={avg}");   

    //procedural --> side effect of assignment is needed // side effect driven
    //functional --> side effect not needed 

}

// need to specify the return type --> have some default return type [unit type]
// specify the type of all parameter --> no defualt type 
fn getNum(z:i32) -> i32{
    // return 6; // --> correct return type 
    // 6 + 1; // --> not correct as it is statement
    6 + 1  //--> correct return type, not stored 
    //print!("hello");   //--> last sentence should be return type
}
