#ifndef _SQUARE_
#define _SQUARE_

class Square
{
    private:
      double side;
      
     public:
     // no-arg constructor
     Square();
     
     // getter method for side
     double getSide() { return side;};
     
     //setter method
     void setSide(double s) { side = s;};
      
      // get area method
      double getArea();


};
#endif