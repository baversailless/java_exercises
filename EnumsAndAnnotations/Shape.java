package kz.EnumsAndAnnotations;

//@ArithmeticAnnotation(isCorrect = false, correctOperationToApply = Operation.MULTIPLY)
public class Shape {
    private int dimension;

    public Shape(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void calculateArea() {
        System.out.println(dimension + 100);
    }


}
