use std::mem;

fn main(){
    // tuple composite data type
    // implemented as struct 
    // access it by dot operator 
    // tuple knows size by type of member
    //
    let b:bool = false; 
    let j = ("abcede",b);
    let i = ("abcede", b, b);
    let (x,y) = j;

    println!("size of tuple : {}",mem::size_of_val(&j));
    println!("align of tuple : {}\n",mem::align_of_val(&j));

    println!("size of first element : {}",mem::size_of_val(&j.0));
    println!("align of first element : {}\n",mem::align_of_val(&j.0));

    println!("size of second element : {}",mem::size_of_val(&j.1));
    println!("align of second element : {}\n",mem::align_of_val(&j.1));


    // get this error by type equivalance , compatability
    //let (x,y,z) = j;
    //let (x,) = j;
    
    // don't care about element except first one
    let (x,..) = j;
    // don't care about number of elements in tuple
    let (x,..) = i;
    // care about number element in tuple
    let (x,_,_) = i;
    //let (_,_,_) = j;
    println!("element string = {}",j.0);
    println!("element x = {}\n",x);
    //println!("element string = {}",j.2);
    
    //struct 
    struct Point3d {
        x:i32, 
        y:i32, 
        z:i32,
        a:bool
    }

    let newPoint =  Point3d{x:5, y:7, z:8, a:true};

    println!("size of struct Point3d: {}",mem::size_of_val(&newPoint));
    println!("align of struct Point3d: {}\n",mem::align_of_val(&newPoint));

    println!("new point x = {}",newPoint.x);
    println!("size of x : {}",mem::size_of_val(&newPoint.x));
    println!("align of x : {}\n",mem::align_of_val(&newPoint.x));

    println!("new point y = {}",newPoint.y);
    println!("new point z = {}\n",newPoint.z);


    // struct is not mutable
    //newPoint.x = 5;

    let mut point =  Point3d{x:5, y:7, z:8, a:true};
    // whole members are mutable
    // some part is mutable and some part in immutable is not possible
    point.x = 4;

    let ref_X = &mut point.x;
    //let ref_Y = &mut newPoint.x;
    println!("value of point x = {}",point.x);
    //println!("value of ref point x = {}",ref_X);
    
    // initialize only one var
    let mut onlyX = Point3d{x:6,y:8,z:8,a:true};
    onlyX.a = false;
    onlyX.y = 0;
    onlyX.z = 5;

    //println!("new onlyX x = {}",newPoint.x);

}
