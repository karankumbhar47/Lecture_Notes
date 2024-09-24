// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/2/Multiplier3x3.tst

load Multiplier3x3.hdl,
output-file Multiplier3x3.out,
compare-to Multiplier3x3.cmp,
output-list a%B1.3.1 b%B1.3.1 out%B1.6.1;

set a %B000,
set b %B000,
eval,
output;

set b %B001,
eval,
output;

set a %B001,
set b %B001,
eval,
output;

set b %B010,
eval,
output;

set a %B010,
set b %B010,
eval,
output;

set b %B100,
eval,
output;

set a %B011,
set b %B101,
eval,
output;

set a %B101,
set b %B110,
eval,
output;

