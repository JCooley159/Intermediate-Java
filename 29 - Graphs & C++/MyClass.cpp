#include "MyClass.h"

MyClass::MyClass(int w, int h)
{
    width = w;
    height = h;
}


int MyClass::getWidth()
{
    return width;
}

int MyClass::getHeight()
{
    return height;
}

int MyClass::getArea()
{
    return width*height;
}