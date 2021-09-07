#include "Circle.h"

Circle::Circle()
{
    radius = 1;
}

double Circle::getRadius()
{
    return radius;
}

void Circle::setRadius(double r)
{
    radius = r;
}

double Circle::getArea()
{
    return 3.14159 * getRadius() * getRadius();
}


double Circle::getCircumference()
{
    return 2 * 3.14159 * getRadius();
}
