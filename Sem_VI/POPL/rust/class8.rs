//impirative programming lang  <==> sequencing, assignment operator
//
//Sequencing 
//      --> sequence of instruction
//      --> top instruction need not execute first
//          like on top some other function and then main function starts 
//      --> within block one execute one after another from top to bottom
//      --> arbitary ordering ==> prolong
//      --> in functional programming 
//          two way --> one not follow sequencing
//      --> executable file will execute 
//      --> pipeline  
//              --> single core cpu 
//              --> control unit,
//              --> take instruction, execute and then next inststruction
//              --> has some limit (RAM memory fetching) --> can't be decreased
//              --> more instruction at same time(fetching, register maniculation, different
//              functionality) 
//              --> here also hit limit (pipelineing)  
//              --> some vars in memory(slower fetching) and some in register(faster executation)
//              --> so while fetching memory start execucating next fast instruction
//                  1. if(a < 3){
//                  2.    i++;
//                  3. }
//                  4. else{
//                  5.    i+=2;
//                  6. }
//
//                  while doing 1 , start 2 if 1 is satisfy then 2 will continue, ohterwise discard
//                  result of 2 (cpu shuffling if no crash, and discard if clases occours)
//              --> compiler do shuffling if no clash , and discard if clashes (for single thread
//              program) 
//      --> in assembly only goto available 
//      --> late assembler instruction call available
//      --> come out of whole context (exception handling)
//             --> unsure how to come out  
//             --> come out just throwing execption
//      --> PCB (stack, heap, stack pointer)  
//             --> save context while calling another function, program counter
//             --> go new place execute everything
//             --> while return, store return value and pop stack pointer and restore context;   
//             --> so while call function , context will be stacked (stacktrace)
//      --> some languages need to have else although you have multiple if, else if; 
//             --> in rust if is statement
//             --> shortcircuiting of expression with && or || operator
//                      --> if(i>0 || 3/i > 2)
//                      --> check only if i>0 if is true no need to check 3/i>2
//      --> loops ()
//
