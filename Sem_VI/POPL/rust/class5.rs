/* 
* referencing --> one var two name
*
* s1 --> "hello" <-- s2 // in rust not allowed 
* rust s2--> s1 --> "hello" is allowed

 
 overloading --> same name different object 
*/

fn print(s:&mut String){
    //println!("s --> {}",s);
    s.push_str(" world");
}

fn main() {
    let mut a = 8;
    let mut p = &mut a; // reference
    println!("{}",p);
    //println!("{}",a);
    let q = 9;
    // to change p make p mutable
    // *p = q; // deference
    let mut refq = & q;
    println!("q = {}",q);
    println!("p = {}",p);
    println!("refq = {}",refq);

    let mut s1 = String::from("hello");
    //let r1 = &mut s1; // avoid dangling reference (what consist in s1 will be ensure)
    let r1 = &mut s1; // avoid dangling reference (what consist in s1 will be ensure)
    // let r2 = &s1; // avoid dangling reference (what consist in s1 will be ensure)
    // print(r1);
    
    *r1 = String::from("!!!");
    println!("r1 --> {}",r1);// r1 is immutable and s1 is mutable
    s1 = String::from(" heap");
    // println!("r2 --> {}",r2);// r1 is immutable and s1 is mutable
    println!("s1 --> {}",s1);
    // //r1 consist address, but nobody wants to see address so instead of using *r1 in rust we
    //generally use r1, but r1 consist address when no way to know the address in rust 
    //in lua r1 is similar to *r1
    // rust only reference to s1 object 
    // not reference to any variable of  s1 object in rust but in c it is possible
    //
    // dangling reference not used then allowed
    //
    //let mut s1 = String::from("hello");
    //let r1 = &mut s1;  // one mutable reference
    //let r2 = & s1;  // not allowed if one of is already mutable reference
    ////print(r1);
    ////s1.push_str(" world");
    //println!("r1 --> {}",r1);// r1 is immutable and s1 is mutable
    //println!("s1 --> {}",r2);
    
    //let mut r1 => r1 can point to another reference
    // let r1 = &mut s1 // immutable reference variable used to change object at reference
}
