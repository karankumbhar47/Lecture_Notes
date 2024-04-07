fn main(){
    // mut can be assigned twice
    let mut name = 13;
    println!("Hello world {name}");
    //name = "Nothing"; 
    name = 7;

    //provide type floating 64 bit
    const pi:f64 = 3.14; 
    println!("This is const {pi}");

    fn first()->i64{
        println!("This is random function");
        return 55;
    }

    println!("{}{name}",first());

}
