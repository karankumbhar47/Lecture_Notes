#include <stdio.h>
#include <stdlib.h>

int i = 0;
int x = 0;

void fun(int *j){
  // only one time execute below statement
  static int i = 0;
  *j += 1;
  i += 1;
  printf("%d, %d \n", i, *j);
}


void f2(){
  printf("%d",x);
}

void f1(){
  int x = 5;  
  f2();
}



int main()
{
    // int j = 0;
    // int *k;
    // {
    // k = malloc(sizeof(int));
    // }
    //
    // printf("int %d\n",*k);
    // free(k);
    // fun(&j);
    // fun(&j);
    // fun(&j);
    // printf("%d\n",i);
    // printf("%d\n",j);
    //
    f1();
    return 0;
}
