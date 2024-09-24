// This file is part of www.nand2tetris.org
// and the book "The Elements of Computg Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/2/CarryLookaheadAdder.tst

load CarryLookaheadAdder.hdl,
output-file CarryLookaheadAdder.out,
compare-to CarryLookaheadAdder.cmp,
output-list a%B1.4.1 b%B1.4.1 c sum%B1.4.1 cout;

set a %B0000,
set b %B0000,
set c 0,
eval,
output;

set b %B0001,
eval,
output;

set a %B0001,
eval,
output;

set b %B0010,
eval,
output;

set a %B0011,
eval,
output;

set b %B0100,
eval,
output;

set a %B0101,
set b %B0101,
eval,
output;

set a %B0110,
set b %B0110,
eval,
output;

set a %B1111,
set b %B1111,
set c 1,
eval,
output;

set a %B1010,
set b %B0101,
set c 1,
eval,
output;
