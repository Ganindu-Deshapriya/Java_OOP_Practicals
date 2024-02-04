/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet09;

/**
 *
 * @author ganin
 */
public class Circle extends Shape{
    private Point center;
    public int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }
    
    @Override
    public boolean isPolygon() {
        return false;
    }

    @Override
    public double calculateCirc() {
        return 2*Math.PI * radius;
    }
    @Override
    
    public double calculateArea() {
       return Math.PI * radius*radius; 
    }
}
