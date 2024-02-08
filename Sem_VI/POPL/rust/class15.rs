// type --> space or size, alignment (mesured in bytes)
// size      -->  
// alignment -->  
//           --> alignment is 2 (store at only even memory location)
//           --> alignment is 1 (store at any place)
//           --> alignment are always power or 2
//           --> 
use std::mem;

fn main(){
    let b:bool = false;
    let j:u32 = 32;
    println!("int 32 requries {} bytes",mem::size_of_val(&j));
    println!("bool require {} byte",mem::size_of_val(&b));
    // size of val --> bytest to store variable j
    
    // store text in rust 
    // single char
    let c:char = 'a';
    let c1:char = '😁';
    let int_of_char:i32 = c1 as i32;
    println!("char require {} bytes",mem::size_of_val(&c));
    println!("char1 {}",c1);
    println!("char to int {}",int_of_char);
    println!("int 32 of char require {} bytes",mem::size_of_val(&int_of_char));
    // char support all unicode so takes 4 bytes (but in c, it takes 1 byte)
   
    // char and unsigned int 32 (of same size in rust)
    // char --> unsigned int ==> always correct
    // unsigned int --> char ==> not always correct
    // valid pattern for char --> 0x0000
    
    // String is of dynamic nature(dynamic size)
    // not array (but slicing) 
    // access string by pointer
    // not instanstious (string of name j (not possible))
    // as var need some fix size
    // but string have dynamic size
    // "abc" is string and string is pointer to this string
    let string:&str = "abc";
    println!("string reference requires {} bytes",mem::size_of_val(&string));

    let _float:f64 = 32.0;
    println!("float requires {} bytes",mem::size_of_val(&_float));

    let _float:f64 = 2.0 + 32.0; //--> only valid
    // let float:f64 = 2 + 32.0; 
    // let float:f64 = 32.0 + 2;
    
    // add float to int
    // type casting 
    

    // composite type 
    // struct --> enum
    //        --> tuple 
    //              --> anonymous struct 
    //              --> no names to var
    //              --> way to access them is by index
    let tuple = ("string",j);
    println!("tuple requires size {} bytes",mem::size_of_val(&tuple));
    println!("tuple align {} ",mem::align_of_val(&tuple));

    println!("tuple first size {} bytes",mem::size_of_val(tuple.0)); // as tuple.0 is pointer to string
    println!("tuple first  align {} bytes",mem::align_of_val(tuple.0)); // as tuple.0 is pointer to string
    println!("tuple second size {} bytes",mem::size_of_val(&tuple.1)); // as tuple.0 is pointer to string
    println!("tuple second align {} bytes",mem::align_of_val(&tuple.1)); // as tuple.0 is pointer to string
    // stirng start at any position in memory
    
    println!("tuple first ref size {} bytes",mem::size_of_val(&tuple.0)); // as &tuple.0 is reference to
    println!("tuple first ref align {} bytes",mem::align_of_val(&tuple.0)); // as &tuple.0 is reference to
                                                                      // reference 
    // raw pointer in c (not safe to use)
    // raw pointer (segmentation fault, no memory safety)
    println!("tuple second ref size {} bytes",mem::size_of_val(&tuple.1));
    println!("tuple second ref align {} bytes",mem::align_of_val(&tuple.1));
    //              --> rust bye addressible as bool is byte
    //        --> struct
    //        --> union

}   
