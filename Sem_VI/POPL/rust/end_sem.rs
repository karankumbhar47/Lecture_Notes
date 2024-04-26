use std::fs::File;
use std::io::Read;
/** Rust
 * if / else if / for / while / function
 * array in rust
 * multidimention array
 * array slicing
 * reference
 * pointers
 * procedures
 */

/** Python
 * file io (read ,wirte , seek, close)
 * defualt param (list)
 * try except
 *
 *  CPP
 * mutliple arg
 * multiple return
 * function pass
 * varargs
 * try catch
 */
// Struct example
struct Person {
    name: String,
    age: u32,
}

// Union example
union IntOrFloat {
    int_value: i32,
    float_value: f32,
}
fn get_value() {
    println!("hello");
}

fn get_values() -> (i32, f64, char) {
    // Simulated values
    let int_value = 42;
    let float_value = 3.14;
    let char_value = 'A';

    // Return a tuple containing the values
    (int_value, float_value, char_value)
}

fn print_function(value: i32) {
    println!("{}", value);
}

fn apply(array: [i32; 4], f: fn(i32)) {
    let mut i = 0;
    loop {
        if i == array.len() {
            break;
        }
        f(array[i]);
        i = i + 1;
    }
}
/*
 * componet wise assignment
 *   a, b = c, d
 * implicit assignment
 *   i++;
 */

fn printAndChange(s: &mut String) {
    s.push_str(" from function");
    println!("{}", s);
}

fn main() {
    let mut s1 = String::from("hello1 s1");
    let n = 3;
    let r = &n;
    let _e: *const i32 = &n;

    println!("r {}", r);
    println!("n {}", n);
    // println!("e {}",e);

    let _p = get_value();
    // println!("{}",p);

    if *r == n {
        println!("correct");
    }

    let array = [1, 2, 3, 4];
    apply(array, print_function);

    let (int_result, float_result, char_result) = get_values();

    println!("Integer value: {}", int_result);
    println!("Float value: {}", float_result);
    println!("Character value: {}", char_result);

    let mut a = 8;
    let b = *take_ref(&mut a);
    a = 6;
    println!("value: {}", a);
    println!("value: {}", b);

    if let Ok(contents) = read_file_contents("example.txt") {
        println!("File contents: {}", contents);
    } else {
        eprintln!("Error reading file");
    }

    // let avg = if credit>0 {
    //     marks/credit
    // }
    // else{
    //     0
    // };

    let a = 4;
    if a > 4 || a == 5 {
        println!("if");
    } else if a < 3 {
        println!("else if");
    } else {
        println!("else");
    }

    // 'counting: loop {
    //     println!("again {}", i);
    //     loop {
    //         println!("again {}", i);
    //         if i == 2 {
    //             break 'counting;
    //         }
    //         i = i + 1;
    //     }
    // }
    // let c = 0;
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

    let a = [10, 20, 30, 40, 50];
    for element in 1..10 {
        println!("{}", element);
    }

    for element in (1..10).rev() {
        println!("{}", element);
    }

    for i in a {
        println!("{}", i);
    }

    for i in 1..a.len() {
        println!("{}", a[i]);
    }

    // let ran = 0..10 + 10..20;
    // println!(ran);

    let l: i32 = a[2] + 5;
    println!("{l}");

    //struct
    struct Point3d {
        x: i32,
        y: i32,
        z: i32,
        a: bool,
    }

    let newPoint = Point3d { x: 5, y: 7, z: 8, a: true };

    // Union usage
    let mut value = IntOrFloat { int_value: 42 };
    unsafe {
        println!("Int value: {}", value.int_value);
        value.float_value = 3.14;
        println!("Float value: {}", value.float_value);
        println!("Int value: {}", value.int_value);
    }
}

//--> so while fetching memory start execucating next fast instruction

fn take_ref(a: &mut i32) -> &mut i32 {
    *a = 9;
    a
}

fn read_file_contents(filename: &str) -> Result<String, std::io::Error> {
    let mut file = File::open(filename)?;
    let mut contents = String::new();
    file.read_to_string(&mut contents)?;
    Ok(contents)
}

//                      if compatability ==>
//                      Explicit conversion  --> casting
//                      Implicit conversion  --> coergion
