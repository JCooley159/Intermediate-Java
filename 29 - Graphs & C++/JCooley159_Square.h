#ifndef SQUARE_H
#define SQUARE_H
class Square
{
    private:
        double side;
    public:
        Square();
        double getSide();
        void setSide(double s);
        double getArea();
        double getPerimeter();

};
#endif