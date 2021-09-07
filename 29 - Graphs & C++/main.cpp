#include <iostream>
#include "MyClass.h"

using namespace std;

int main()
{
   MyClass rectangle(10, 10);    
   cout << rectangle.getArea() << endl; 
   
   return 0;
}

