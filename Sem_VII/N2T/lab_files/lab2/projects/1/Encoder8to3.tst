load Encoder8to3.hdl,
output-file Encoder8to3.out,
compare-to Encoder8to3.cmp,
output-list in%B8.8.8 out%B3.3.3;

set in %B00000001, eval, output;
set in %B00000010, eval, output;
set in %B00000100, eval, output;
set in %B00001000, eval, output;
set in %B00010000, eval, output;
set in %B00100000, eval, output;
set in %B01000000, eval, output;
set in %B10000000, eval, output;
