package kz.EnumsAndAnnotations;

//@ArithmeticAnnotation(isCorrect = true, correctOperationToApply = Operation.MULTIPLY)
public class Rectangle extends Shape {
   private int side;

    public Rectangle(int dimension, int side) {
        super(dimension);
        this.side = side;
    }

    public void calculateArea() {
        System.out.println(getDimension()*side);
    }
}


