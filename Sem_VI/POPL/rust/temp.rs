
fn main() {

    let mut s1:String = String::from("hello world");
    string(&mut s1);
    println!("{}",s1);

    let mut a:i32 = 0;
    loop {
        a+=1;
        println!("infinite loop");
        if a==2 {
            break;
        }
    }

    'loopName :loop{
        a += 1; 
        if a == 5 {
            break 'loopName;
        }
    }

    let i = 0;
    for i in 1..10{
        println!("for loop {}",i);
    }

     
    let c = 1;
    match c{
         1=>{
            println!("case 1");
        }
        2=>{
            println!("case 2");
        }
        _=>{
            println!("case default");
        }
    }

    if a ==5 {
        println!("in if statement");
    }
    else{
        println!("in else statement");
    }

    let str = String::from("karan");
    println!("{}",lenString(str));


    let x = 9;
    let tuple = (x, "karan", true);
    let tup_0 = tuple.0;
    println!("tup_0 {}",tup_0);
    let boolVar = tuple.2;
    println!("tup_2 {}",boolVar);

    union MyUnion{
        numInt:i32,
        numFloat:f32
    };

    struct MyStruct{
        var1:i32,
        var2:bool,
        var3:String 
    }

    let s:String = String::from("heap");
    let obj = MyStruct{var1:32, var2:true, var3:s};
}

fn string(s:&mut String){
    s.push_str(" from me");
    println!("{}",s); 
}

fn lenString(s:String) -> usize{
    return s.len();
}
