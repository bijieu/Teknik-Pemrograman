public class TestCylinder {
    public static void main(String[] args) {

    // Declare and allocate a new instance of cylinder
    // with default color, radius, and height
    Cylinder c1 = new Cylinder();
    System.out.println("Cylinder:"
    + " radius= " + c1.getRadius()
    + " height= " + c1.getHeight()
    + " base area =" + c1.getArea()
    + " volume=" + c1.getVolume());

    // Declare and allocate a new instance of cylinder
    // specifying height, with default color and radius
    Cylinder c2 = new Cylinder(10.0);
    System.out.println("Cylinder:"
    + " radius= " + c2.getRadius()
    + " height= " + c2.getHeight()
    + " base area =" + c2.getArea()
    + " volume =" + c2.getVolume());

    // Declare and allocate a new instance of cylinder
    // specifying radius and height, with default color
    Cylinder c3 = new Cylinder(2.0, 10.0);
    System.out.println("Cylinder:"
    + " radius= " + c3.getRadius()
    + " height= " + c3.getHeight()
    + " base area= " + c3.getArea()
    + " volume= " + c3.getVolume());

    // Declare and allocate a new instance of cylinder
    // specifying radius and height, color
    Cylinder c4 = new Cylinder(2.5, "pink", 8.0);
    System.out.println("Cylinder:"
    + " radius= " + c4.getRadius()
    + " height= " + c4.getHeight()
    + " color= " + c4.getColor()
    + " base area= " + c4.getArea()
    + " volume= " + c4.getVolume());

    System.out.println("Volume c4: " + c4.getVolume());
    System.out.println("Surface Area c4: " + c4.getArea());
    }
}
