`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:17:31 04/27/2022 
// Design Name: 
// Module Name:    q3 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module q3(
  input [3:0] a,
  input [3:0] b,
  output reg [6:0] s,
  output reg [4:0] c,
  output [3:0] out
  );
  
assign out=4'b0010;

assign out_1=4'b0100;

assign s=a+b;
always @(a+b)
begin
if a[3]+b[3]=0 c=
	
case(a+b)
4'b0000: s=7'b0000001;//0
4'b0001: s=7'b1001111;//1
4'b0010: s=7'b0010010;///2
4'b0011: s=7'b0000110;//3
4'b0100: s=7'b1001100;//4
4'b0101: s=7'b0100100;//5
4'b0110: s=7'b0100000;//6
4'b0111: s=7'b0001111;//7
4'b1000: s=7'b0000000;//8
4'b1001: s=7'b0000100;//9
4'b1010: s=7'b0001000;//10
4'b1011: s=7'b1100000;//11
4'b1100: s=7'b0110001;//12
4'b1101: s=7'b1000010;///13
4'b1110: s=7'b0110000;//14
4'b1111: s=7'b0111000;//15
c: s=6'b1100010;
default: s=7'b1111111;
endcase
end



endmodule


