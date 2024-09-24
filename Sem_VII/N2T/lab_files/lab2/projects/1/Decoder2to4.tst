load Decoder2to4.hdl,
output-file Decoder2to4.out,
compare-to Decoder2to4.cmp,
output-list a b q0 q1 q2 q3;

set a 0, set b 0, eval, output;
set a 0, set b 1, eval, output;
set a 1, set b 0, eval, output;
set a 1, set b 1, eval, output;

