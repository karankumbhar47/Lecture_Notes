use std::mem;


fn main(){
    // statically allocated on stack
    // to put dynamic we should use vec![] 
    
    let arr:[i32;3] = [1,2,3];
    let n = arr[2];
    println!("{}",n);
    println!("size of arr {}",mem::size_of_val(&arr));
    println!("align of arr {}",mem::align_of_val(&arr));

    // no type cohesion by default
    let new_arr:[usize;3] = [1,2,3];

    // expr --> not for compiler(but even const expr)
    //let j:usize = new_arr[2]+5;
    //println!("value of j {}",j);

    //let m = new_arr[j];
    //println!("{}",m);

    // best type to work --> type inference

    // java and python --> interpreter
    // stoppin from illigal operation
    
    // not for c 
    // rust is in between
    
    // reference 16 byte and alignment is of 8
    let refi; 
    refi = &arr;
    println!("size of ref {}",mem::size_of_val(&refi));
    println!("align of ref {}",mem::align_of_val(&refi));

    // multi --> collection of single dimension array
    let mult = [[1,2,3],[2,3,4],[3,4,5]];
    let n  = mult[2];
    println!("n[1] is {}",n[1]);

    // string array of char
    let mut my_str = String::from("hello");
    // rect object
    // not similar to array
    // but you can use slice as array
    let mut slice = &my_str[1..2];
    slice[2] ='4';
    //let slice = &str[0..]; --> upto last
    // let slice = &str[..2]; --> from first
    println!("slice {}",slice);
    //println!("slice[2] {}",slice[2]);
    
}
