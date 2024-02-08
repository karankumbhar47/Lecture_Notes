// char is everywhere is of 1 byte
// int --> 4, 8 bit(depends on achitechure[32bit , 64bit, Arm])
// program compiled in different achitechure()
// compiler
// some lang.(java) change type size as per architechure

// RECORD :
//      --> composite type (multiple types combine)
//      --> recurrsive and nested
//      -->
// c --> struct
// struct atom {
//      char name[2];
//      int height;
//      float number;
//      struct another ano;
//      struct another1 {
//      ...
//      } ano1;
//}
// struct affinity{
//      char name[2];
//      int height;
//      float number;
// }
//
// java,python --> class
// c#, c++ --> struct , class

// visibility -->
// c++ --> struct(all vars by default public) and class(by default all vars should private) (but struct implemented as class)
// c#,rust --> struct and class (of different nature, no overlap in implementation)
//
// how to access the member of struct
// store correspondig offset to vars and add it to name of struct

// storing
// trade off in space and access time
// space waste  but access time is less
// size of struct == fix_size * no of members in struct
// --> * is may or may not occupy but x is always empty
//          --> | [*][*][x][x] |
//          --> | [*][*][*][*] |
//          --> | [*][*][*][x] |

// space efficient  but access time is more  (packed --> optimize for space)
// size of struct == summation of size of all members
// --> * is may or may not occupy but x is always empty
//          --> | [*][*] | [*][*]
//          -->   [*][*] | [*][*] |
//          --> | [*][*][*] | [ ]

fn main(){
    // take 1 byte of space(in c it is normal integer)
    let b:bool = true;  // 00000001
    let f:bool = false; // 00000000
    // b = 4;
    println!("{b}"); 
    println!("{f}"); 
    // in c converts zero ar not zero
    // in rust it is zero or one
    //
    // integer is unsigned and signed
    // u8
    // u16
    // u32
    // u64
    // u128
    
    // i8
    // i16
    // i32
    // i64
    // i128
    
    let i:u8 = -32; 

    
}
