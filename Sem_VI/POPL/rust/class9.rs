// turing machine --> any algorithm
// if , switch codition , loop (needet to implement all language) 
// loop --> jump and condition
// jump --> next n instruction , go to previous instruction

// switch case(compact way to implement if else)

// in c language
// break is extra than if else
// data structure (stored in table with int data type)
// int, char(short int) , use symbol table

// some language
// allow ranges



fn main() {
    let c = 0;
    // switch(c):
    //     case 1 :{
    //         println!("hello world!");
    //     }
    //     case 0 :{
    //         println!("hello world!");
    //     }
    //     default : {
    //         println!("hello world!");
    //     }
    let mut i= 0;  

    // infinite loop
    // loop {
    //     println!("again");
    // }

    // let result = loop {
    //     println!("again {}",i);
    //     i= i + 1;
    //     if i == 10 {
    //         //break; 3 // after semicolor return type should be ()
    //         // we can't 
    //         break 3;
    //     }
    //
    // }; // put semicolon to end statement
    //println!("result {}",result);
    
    // here counting is label where to exit the loop
     'counting : loop {
            println!("again {}",i);
            loop {
                println!("again {}",i);
                if i ==2 {
                    break 'counting;
                }
            i= i + 1;
             
        }
    }


    
}


// loop (expr)
// by defualt infinite loop
// initial value, final value/ condition, step , break statement ;
// scope of declared variable inside for loop only
// space and lines not matters

// how t
