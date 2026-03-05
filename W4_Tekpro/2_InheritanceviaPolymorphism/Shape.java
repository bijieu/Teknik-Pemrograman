public abstract class Shape {
    protected String ShapeName;

    public Shape(String name){
        ShapeName = name;
    }

    public abstract double area();
    public String toString(){
        return ShapeName;
    }
}
