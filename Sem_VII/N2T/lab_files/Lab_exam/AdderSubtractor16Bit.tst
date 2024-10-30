load AdderSubtractor16Bit.hdl;
output-file AdderSubtractor16Bit.out;
compare-to AdderSubtractor16Bit.cmp;
output-list A%B1.16.1 B%B1.16.1 Op%B1.1.1 Sum%B1.16.1 ;

set A %B0000000000000000, set B %B0000000000000000, set Op 0, eval, output;  
set A %B0000000000000001, set B %B0000000000000001, set Op 1, eval, output;  
set A %B1111111111111111, set B %B0000000000000001, set Op 0, eval, output;  
set A %B1111111111111111, set B %B0000000000000001, set Op 1, eval, output;  
set A %B0000000000001111, set B %B0000000000000100, set Op 1, eval, output;  
set A %B1000000000000000, set B %B0000000000000001, set Op 1, eval, output;   
