/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labsheet09;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ganin
 */
public class Labsheet09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean flag = true;
        FileWriter fw = new FileWriter("shape_details.txt");
        int mainChoice;

        do {
            System.out.println("\n");
            System.out.println("1. input a shape");
            System.out.println("2. Print entered shape details");
            System.out.println("3. Exit the program");
            System.out.println("Enter your selection as a number");

            Scanner scan = new Scanner(System.in);
            mainChoice = scan.nextInt();

            switch (mainChoice) {
                case 1:
                    int choiceshape;
                    System.out.println("Select the shape");
                    System.out.println("1. Line");
                    System.out.println("2. Circle");
                    System.out.println("3. Triangle");
                    System.out.println("4. Rectangle");

                    choiceshape = scan.nextInt();
                    switch (choiceshape) {
                        case 1:
                            lineproperties(scan, fw);
                            break;
                        case 2:
                            circleproperties(scan, fw);
                            break;
                        case 3:
                            triangleproperties(scan, fw);
                            break;
                        case 4:
                            rectangleproperties(scan, fw);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 2:
                    loadDataFromFile("shape_details.txt");
                    break;

                case 3:
                    flag = false;
                    break;
                default:
                    System.err.println("Invalid input, try again");
            }

        } while (flag == true);
        fw.close();
    }

    private static void lineproperties(Scanner scan, FileWriter fw) throws IOException {
        int x1, y1, x2, y2;
        String writer;
        System.out.println("Enter point 1");
        System.out.println("X coordinates : ");
        x1 = scan.nextInt();
        System.out.println("Y coordinates : ");
        y1 = scan.nextInt();

        System.out.println("Enter point 2");
        System.out.println("X coordinates : ");
        x2 = scan.nextInt();
        System.out.println("Y coordinates : ");
        y2 = scan.nextInt();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Line line = new Line(p1, p2);

        System.out.println("The length is : " + line.calculateCirc() + " units");
        if (line instanceof Polygon) {
            System.out.println("This shape is a Polygon.");
        } else {
            System.out.println("This shape is not a Polygon.");
        }

        writer = "line," + x1 + "," + y1 + "," + x2 + "," + y2 + "\n";
        for (int i = 0; i < writer.length(); i++) {
            fw.write(writer.charAt(i));
        }
        fw.flush();

        System.out.println("Your input added to the file successfully");

    }

    private static void circleproperties(Scanner scan, FileWriter fw) throws IOException {
        int px, py, radius;
        String writer;

        System.out.println("Enter center point");
        System.out.println("X coordinates : ");
        px = scan.nextInt();
        System.out.println("Y coordinates : ");
        py = scan.nextInt();
        System.out.println("Enter radius : ");
        radius = scan.nextInt();

        Point center = new Point(px, py);
        Circle circle = new Circle(center, radius);

        System.out.println("The circumference is : " + circle.calculateCirc() + " units");
        System.out.println("The area is : " + circle.calculateArea() + " square units");
        if (circle instanceof Polygon) {
            System.out.println("This shape is a Polygon.");
        } else {
            System.out.println("This shape is not a Polygon.");
        }

        writer = "circle," + px + "," + py + "," + radius + "\n";
        for (int i = 0; i < writer.length(); i++) {
            fw.write(writer.charAt(i));
        }
        fw.flush();

        System.out.println("Your input added to the file successfully");

    }

    private static void triangleproperties(Scanner scan, FileWriter fw) throws IOException {
        int x1, x2, x3, y1, y2, y3;
        String writer;

        System.out.println("Enter point 1");
        System.out.println("X coordinates : ");
        x1 = scan.nextInt();
        System.out.println("Y coordinates : ");
        y1 = scan.nextInt();

        System.out.println("Enter point 2");
        System.out.println("X coordinates : ");
        x2 = scan.nextInt();
        System.out.println("Y coordinates : ");
        y2 = scan.nextInt();

        System.out.println("Enter point 3");
        System.out.println("X coordinates : ");
        x3 = scan.nextInt();
        System.out.println("Y coordinates : ");
        y3 = scan.nextInt();

        Point p3 = new Point(x3, y3);
        Point p2 = new Point(x2, y2);
        Point p1 = new Point(x1, y1);
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.println("The circumference is : " + triangle.calculateCirc() + " units");
        System.out.println("The area is : " + triangle.calculateArea() + " square units");
        if (triangle instanceof Polygon) {
            System.out.println("This shape is a Polygon.");
        } else {
            System.out.println("This shape is not a Polygon.");
        }

        writer = "triangle," + x1 + "," + y1 + "," + x2 + "," + y2 + "," + x3 + "," + y3 + "\n";
        for (int i = 0; i < writer.length(); i++) {
            fw.write(writer.charAt(i));
        }
        fw.flush();

        System.out.println("Your input added to the file successfully");

    }

    private static void rectangleproperties(Scanner scan, FileWriter fw) throws IOException {
        int tlpx, tlpy, width, height;
        String writer;

        System.out.println("Enter top left point");
        System.out.println("X coordinates : ");
        tlpx = scan.nextInt();
        System.out.println("Y coordinates : ");
        tlpy = scan.nextInt();

        System.out.println("Enter width : ");
        width = scan.nextInt();
        System.out.println("Enter height : ");
        height = scan.nextInt();

        Point topLeftPoint = new Point(tlpx, tlpy);
        Rectangle rectangle = new Rectangle(topLeftPoint, width, height);
        System.out.println("The circumference is : " + rectangle.calculateCirc() + " units");
        System.out.println("The area is : " + rectangle.calculateArea() + " square units");
        if (rectangle instanceof Polygon) {
            System.out.println("This shape is a Polygon.");
        } else {
            System.out.println("This shape is not a Polygon.");
        }

        writer = "rectangle," + tlpx + "," + tlpy + "," + width + "," + height + "\n";
        for (int i = 0; i < writer.length(); i++) {
            fw.write(writer.charAt(i));
        }
        fw.flush();

        System.out.println("Your input added to the file successfully");

    }

    private static void loadDataFromFile(String fileName) throws IOException {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Entered data");
            System.out.println("--------------------------------------------------------------------------------------");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                switch (data[0]) {
                    case "line":
                        int x1 = Integer.parseInt(data[1]);
                        int y1 = Integer.parseInt(data[2]);
                        int x2 = Integer.parseInt(data[3]);
                        int y2 = Integer.parseInt(data[4]);
                        System.out.println("Line: (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
                        break;
                    case "circle":
                        int px = Integer.parseInt(data[1]);
                        int py = Integer.parseInt(data[2]);
                        int radius = Integer.parseInt(data[3]);
                        System.out.println("Loaded Circle: Center(" + px + "," + py + "), Radius: " + radius);
                        break;
                    case "triangle":
                        int x1_tri = Integer.parseInt(data[1]);
                        int y1_tri = Integer.parseInt(data[2]);
                        int x2_tri = Integer.parseInt(data[3]);
                        int y2_tri = Integer.parseInt(data[4]);
                        int x3_tri = Integer.parseInt(data[5]);
                        int y3_tri = Integer.parseInt(data[6]);
                        System.out.println("Triangle: (" + x1_tri + "," + y1_tri + "), (" + x2_tri + "," + y2_tri + "), (" + x3_tri + "," + y3_tri + ")");
                        break;
                    case "rectangle":
                        int tlpx = Integer.parseInt(data[1]);
                        int tlpy = Integer.parseInt(data[2]);
                        int width = Integer.parseInt(data[3]);
                        int height = Integer.parseInt(data[4]);
                        System.out.println("Rectangle: Top Left point(" + tlpx + "," + tlpy + "), Width: " + width + ", Height: " + height);
                        break;
                    default:
                        System.err.println("Unknown shape type: " + data[0]);
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Data loaded from file successfully");
    }
}
