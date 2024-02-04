/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet09;

/**
 *
 * @author ganin
 */
public class Line extends Shape {
    
    public Point p1,p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    

    private double length(){
        int dx = p1.getX()-p2.getX();
        int dy = p2.getY()-p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
    @Override
    public boolean isPolygon() {
       return false;
    }

    @Override
    public double calculateCirc() {
        return length();
    }

    @Override
    public double calculateArea() {
        return 0;
    }
    
}
