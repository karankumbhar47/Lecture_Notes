
fn main() {

    let mut s1:String = String::from("hello world");
    string(&mut s1);
    println!("{}",s1);
}

fn string(s:&mut String){
    s.push_str(" from me");
    println!("{}",s); 
}
