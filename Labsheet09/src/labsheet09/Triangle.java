/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet09;

/**
 *
 * @author ganin
 */
public class Triangle extends Shape implements Polygon{
    private Point a,b,c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
     @Override
    public boolean isPolygon() {
        return true;
    }

    @Override
    public double calculateCirc() {
        double l1 = Math.sqrt(Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
        double l2 = Math.sqrt(Math.pow(b.getX()-c.getX(), 2) + Math.pow(b.getY()-c.getY(), 2));
        double l3 = Math.sqrt(Math.pow(c.getX()-a.getX(), 2) + Math.pow(c.getY()-a.getY(), 2));
        
        return l1+l2+l3;
    }
    @Override
    
    public double calculateArea(){
       return (((a.getX()*(b.getY()-c.getY())) + (b.getX()*(c.getY()-a.getY())) +  (c.getX()*(a.getY()- b.getY())))/2) ;
    }
}
