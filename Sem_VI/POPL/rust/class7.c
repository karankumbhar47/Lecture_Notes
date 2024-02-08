#include <stdatomic.h>
#include <stdio.h>
#include <stdbool.h>

int main(int argc, char *argv[])
{
  int a = 7;
  if (a=3) {
    // common mistake
    // here  a=3 statement will return value 3 
    // and 3 is not zero, so it is considered as true
    printf("%d",a);
  }
  else{
    printf("none");
  }


  if(true){
    printf("always");
  }
  return 0;
}
