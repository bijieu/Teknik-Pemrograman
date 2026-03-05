public class Rectangle extends Shape {
    private double length;
    private double widht;

    public Rectangle (double l, double w){
        super("Rectangle");
        length = l;
        widht = w;
    }

    public double area(){
        return length * widht; 
    }

    public String toString(){
        return super.toString() + " of lenght " + length + " and widht " + widht;
    }
}
