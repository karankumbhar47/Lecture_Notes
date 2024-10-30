load Majority.hdl;
output-file Majority.out;
compare-to Majority.cmp;
output-list a%B1.1.1 b%B1.1.1 c%B1.1.1 out%B1.1.1;

set a 0, set b 0, set c 0, eval, output;
set a 0, set b 0, set c 1, eval, output;
set a 0, set b 1, set c 0, eval, output;
set a 0, set b 1, set c 1, eval, output;
set a 1, set b 0, set c 0, eval, output;
set a 1, set b 0, set c 1, eval, output;
set a 1, set b 1, set c 0, eval, output;
set a 1, set b 1, set c 1, eval, output;
