/*
* Expressions --> anything combination of multiple Expressions using function;
* Expressions --> variable , constant
* Operation --> +,-,*,/,[], this are also function with special consideration;
* function --> fun(a,b) 
* operator --> a + b ==> +(a,b); [plus function taking two argument]
* function is called prefix(function), infix(operator) 
* prefix form --> more logical // userd for function
* infix form --> more natural // used for operator
* postfix form --> postscript language used it  // latex , pdf
*
* precedence and associative rules in language  --> how to bind function to params
*                                               --> which one binds closer to which one
*                                               --> only for infix, postfix and prefix already have
*                                               it
*
*  --> all languages have nearly same precedence rule, associative
*  --> ada language ==> comparator operator --> >=, <=, <, <, &&  ==> same level
*                                           --> - , +        ==> same level
*                                           --> a > b && c < d // makes no sense in ada
*                                           --> so C put different level for & and comparator operator 
*                                           --> use paran for no confusion 
* --> - "=" has different meaning than other operator (different implemenation)
*     - imprative programming language(C, C++, java)
*     - procedural call
*     - change the context , affect statement after it(side effect --> change in value of variable
*     change below variable values) 
*           --> a =2;
*           --> a = b + c; 
*               d = 2 * a;  // here d has different value than above
*               a = d;
* --> pure functional programming (haskle) --> don't use assignment operator , list allow some 
* --> impirative --> python allow some functional, c (don't allow any functional programming)
* haskle, list, python , C
*  operator ==> left --> expr
*               right --> expr
*  assignment ==> left = right
*                 a = 2 + 3 (a == point to memory location)
*                 2 + 3 = a
*                 b = a(pointing to value of a)
*                 a has different meaning in left and right
*                left --> name, expr, l-value , memory location
*                right --> const, expr, any other thing , r-value
*                (f(a) + 3) --> c[1] = 2;
* l-value --> different implemenation affect languages
*         --> in case of C
*               a = 2; --> a = 2
*               b = a; --> b = 2 --> b = 5
*               c = b + a; c = 4
*               b = 5
*         --> but in python 
*              a --> 2 <-- b  ==> a--> 2, b --> 5(as integer are immutable)
*              c --> 4
*              (but different in heap memory allocation)
* shallow copying and deep copying 
*                                              
* java --> operator overloading --> must be implemenated as Object 
*                               --> a = 2
*                               --> to put it in java we should (Integer)2 (now we don't need in
*                               updated version) 
*
* a[fun(i)] = a[fun(i)] + 2;(some side effect)
*       --> if fun is static and counting how many times index changes
*       --> at this statement this counts twice but it is changes only one time
*       --> on position way
*           i = fun(i) 
*           a[i] = a[i] + 2;
*       --> another possible way
*           a[fun(i)] += 2;
*
* componet wise assignment
*   a, b = c, d
* implicit assignment
*   i++;
* side effects 
*  a = i++; (different vlaues of a)
*  a = ++i;
* plus is returning result 
* also assignment have some return value 
*       a = 2 ;
*           --> =(a,2) --> return value is 2
*       a = b = c = 0 
*
*       a - f(b) - c*d  (means left side is c*d not c*d will computed first)
*               --> matters if you compute which subtrati/on 
*               --> some language not specify the order 
*               --> then order depends on compiler
*
*/  
