// iterators for well defined structure

// python range function use iterator
// iterator ==> give collection of object  
// enumeration of iterator (first done)
// saperate give all integers

// two process in python
// following sequence
// one for enumeration
// one for loop
// for i in range(1, n) --> enumeration
//   print(i)           --> loop part 

// but in c++ both process happens together 
// for(int i=0; i<n; i++){
//      printf(i);
// }

// overloading in java is strict

// overloading and polymorphism  and encapsulation

// overloading in c++
// preorder  
// for(t = my-iter.start(t); t< my-iter.end(t); t++){
//      cout<<t<<endl;
// }


// rust have iterator , loop over collection of object

// iteration <--> recurrsion
// recurrsion --> if allow function call || if no loop allowed

// functional programming language --> recurrsion | no side effect(no assignment operator)
// slow as more stacks and context switching | assess 2n times stack
// int sum(i){
//     if(i>0){
//         return sum(i-1)+i
//     }
// }

// imparative  --> iteration | has side effect(assignment operator needed)
// fast (as just change one variable and also need to fetch memory)
// sum = 0;
// for(int i=0; i<n; i++){
//     sum += i;
// }


// tail recurrsion
// recurrsion happens at the end of function 
// no more context as if function execute then it will throw the previous function context  
// and just put new function context

// lazy computation in functional programming; 
// don't evaluate function until it is needed
// like in fibonacci series f(1) it is called more times
// but only one time calculated

// unreachable statement can be detected by compiler
// but in some cases not able to detect in rust
// as this problem is undecideable 
// optimization is hueristic with guaranty


fn main() {
    let a = [10, 20, 30, 40, 50];
    for element in  1..10 {
        println!("{}",element);
    } 

    for element in (1..10).rev(){
        println!("{}",element);
    }        

    for i in a {
        println!("{}",i);
    }

    for i in 1..a.len(){
        println!("{}",a[i]);
    }
}
