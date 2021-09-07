#include <iostream>
#include "Square.h"
using namespace std;

int main()
{
   cout << "Hello World" << endl; 
   Square s1;
   Square s2;
   
   s1.setSide(4);
   s2.setSide(5);
   
   cout << "Square 1 area = " << s1.getArea() << endl;
   cout << "Square 2 area = "<< s2.getArea() << endl;
   
   return 0;
}

