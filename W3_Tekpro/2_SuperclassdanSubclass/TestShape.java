public class TestShape {
    public static void main(String[] args) {

        // Test constructor kosong
        Shape s1 = new Shape();
        System.out.println(s1);

        // Test constructor dengan parameter
        Shape s2 = new Shape("red", false);
        System.out.println(s2);

        // Test setter
        s1.setColor("blue");
        s1.setFilled(false);

        // Test getter
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());

        System.out.println(s1);

        Circle c1 = new Circle();
        System.out.println(c1);

        Circle c2 = new Circle(5.0, "blue", true);
        System.out.println(c2);

        System.out.println("Area: " + c2.getArea());
        System.out.println("Perimeter: " + c2.getPerimeter());

        Rectangle r1 = new Rectangle();
        System.out.println(r1);

        Rectangle r2 = new Rectangle(4.0, 6.0, "yellow", true);
        System.out.println(r2);

        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());

        Square sq = new Square(5.0, "purple", true);
        System.out.println(sq);

        System.out.println("Area: " + sq.getArea());
        System.out.println("Perimeter: " + sq.getPerimeter());

        sq.setWidth(8);
        System.out.println("After setWidth(8): " + sq);
    }

}
