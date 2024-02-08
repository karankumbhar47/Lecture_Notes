#include <stdio.h>

int i = 0;

void fun(int *j){
  // only one time execute below statement
  static int i = 0;
  *j += 1;
  i += 1;
  printf("%d, %d \n", i, *j);
}

int main()
{
    int j = 0;
    fun(&j);
    fun(&j);
    fun(&j);
    printf("%d\n",i);
    printf("%d\n",j);
    return 0;
}
