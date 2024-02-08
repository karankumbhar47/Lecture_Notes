// type conversion

// long int --> 8 bytes
// int      --> 4 bytes

// which four bytes should copy
// depend on machine

// Big Endian
// Little Endian

// union u {
//     int i;
//     char c[4]
// }
// c[0] c[1] c[2] c[3]
// u.i = 23456;
// stored in reverse order
// u.c[0]
// u.c[1]
// u.c[2]
// u.c[3]

// Explicit
// Implicit (cohesion) --> do something by combiler in backend (conversion)
//                     --> causes some bug
// *((int *) &float)   --> interpreted as int in c

// ragne operation
// 0..10
//   +
// 10..20
//   =
// 30..20

// universal compatible pointer type
// c    --> void pointer
// java --> object
// c#   --> object
// rust --> default type (not compatible to other type)

// array name derived from pointer subset of int pointer

// haskle
// f: a -> b[]
// g: t[] --> t[]
// x[] --> b