
public interface Shape {
    void draw();
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        // draw a rectangle
    }
}

public class Circle implements Shape {
    @Override
    public void draw() {
        // draw a circle
    }
}

// decorator based abstract default behavior
public abstract class ShapeDecorator implements Shape {
    protected Shape shapeToBeDecorated;

    public ShapeDecorator(Shape shapeToBeDecorated){
        this.shapeToBeDecorated = shapeToBeDecorated;
    }

    public void draw(){
        shapeToBeDecorated.draw();
    }
}

// add on decorator behavior
public class BorderShapeDecorator extends ShapeDecorator {

    public BorderShapeDecorator(Shape shapeToBeDecorated) {
        super(shapeToBeDecorated);
    }

    @Override
    public void draw() {
        shapeToBeDecorated.draw();
        // extedned behavior
        setBorder(shapeToBeDecorated);
    }

    private void setRedBorder(Shape shapeToBeDecorated){
        // add border to shapeToBeDecorated
    }
}

// Client side:

    public static void main(String[] args) {

        Shape circleTobeDecorated = new Circle();
        // default behavior
        circleTobeDecorated.draw();

        // external behavior extension
        Shape circleWithBorder = new BorderShapeDecorator(circleTobeDecorated);
        // circle with border
        circleWithBorder.draw();
    }