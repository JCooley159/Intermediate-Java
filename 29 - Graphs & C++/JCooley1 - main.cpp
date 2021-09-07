#include <iostream>
#include "Circle.h"

using namespace std;

int main()
{
    Circle c1;
    Circle c2;
    c1.setRadius(5);
    c2.setRadius(10);
    
    cout << "The area of Circle 1 is " << c1.getArea() << endl;
    cout << "The circumference of Circle 2 is " << c2.getCircumference() << endl;

    return 0;
}