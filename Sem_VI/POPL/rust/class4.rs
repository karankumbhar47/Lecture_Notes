fn print(s:&String){
    println!("{}",s);
}

fn main() {
    //string are allocated in heap
    let mut s1 = String::from("hello1");
    let mut s2 = String::from("hello1");
    let mut i1 = i32::from(23);
    //allocated in heap
    //can't have different pointer pointing to same memory location
    //let s2 = s1; // create the link of s2 and points to link of s1; and deletes the memory for s1;
    // you can't user s1 anymore
    {
        let s2 = String::from("hello");
        println!("{}, World!",s2);
        //let s3 = String::from("hello1");
    }

    //println!("{}, World!",s2);
    //as scope of s2 is completed it will free the memory of variable s2
    //in case of java, python their is garbage collector 
    // 
    //
    println!("{}",s1);
    println!("{}",&s1);
    let mut r1 =  s1;
    println!("{}",r1);
    r1 = s2;
    //println!("{}",s1);
    // //ref is not deleted as it is created in stack
    // print(r1);
    // print!("{},world",r1);
    // println!("{}, World!",s1);
    //
    // //integer stored in stack
    // //floating point, boolean
    let a = 1;
    let b = a;
    println!("{},{}",a,b);
    //imutable ref: won't change in original operand
    //bydefult imutable ref
}
