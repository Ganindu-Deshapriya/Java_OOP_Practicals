/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet09;

/**
 *
 * @author ganin
 */
public class Rectangle extends Shape implements Polygon{
    private Point topLeftPoint;
    public double width,height;

    public Rectangle(Point topLeftPoint, double width, double height) {
        this.topLeftPoint = topLeftPoint;
        this.width = width;
        this.height = height;
    }
    
    
     @Override
    public boolean isPolygon() {
        return true;
    }

    @Override
    public double calculateCirc() {
        return  2*(width+height);
    }
    @Override
    
    public double calculateArea(){
       return width*height;
    }
    
}
