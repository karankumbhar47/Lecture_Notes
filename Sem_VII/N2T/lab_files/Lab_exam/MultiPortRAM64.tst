// Test script for MultiPortRAM64

load MultiPortRAM64.hdl,
output-file MultiPortRAM64.out,
compare-to MultiPortRAM64.cmp,
output-list in%D1.16.1 address%D2.6.2 load%D2.2.2 out%D1.16.1;

// Test Case 1: Write to Port A
set in %B0000000000000000, // input data for Port A
set address %B000000, // address for Port A
set load %B01, // Load signal for Port A
tick,
output;
tock,
output;

// Test Case 2: Read from Port A
set load %B11, // No load signal
tick,
output;
tock,
output;

// Test Case 3: Write to Port B
set in %B0000000000001111, // input data for Port B
set address %B000001, // address for Port B
set load %B10, // Load signal for Port B
tick,
output;
tock,
output;

// Test Case 4: Read from Port B
set load %B01, // No load signal
tick,
output;
tock,
output;