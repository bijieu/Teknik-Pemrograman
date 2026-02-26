//The Circle class models a circle with a radius and color.
public class Circle { 
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color;

    // Constructs (overloaded)
    // Constructs a Circle instance with default value for radius and color */
    public Circle() { 
        radius = 1.0;
        color = "red";
    }

    // Constructs a Circle instance with the given radius and default color
    public Circle(double r) { 
        radius = r;
        color = "red";
    }

    // Constructs a Circle instance with the default radius and given color
    public Circle(String c) { 
        radius = 1.0;
        color = c;
    }

    // Constuctor a Circle instance with the given radius and given color
    public Circle(double r, String c){
        radius = r;
        color = c;
    }

    // Getter color
    public String getColor(){
        return color;
    }

    // Setter color
    public void setColor (){
        this.color = color;
    }

    /** Returns the radius */
    public double getRadius() {
        return radius;
    }

    // Returns the area of this Circle instance 
    public double getArea() {
        return radius * radius * Math.PI;
    }

    //Return a self-descriptive string of this instance in the form of
    // Circle[radius=?,color=?]
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}