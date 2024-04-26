#include<iostream>

using  namespace std;

int main()
{
    int arr[2] = {1,2};
    try {
        printf("%d",arr[9]);
    }catch(runtime_error &e){
        cout<<"error is "<<e.what()<<endl;
    }
    return 0;
}