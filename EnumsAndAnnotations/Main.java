package kz.EnumsAndAnnotations;

public class Main {

    public static void check(Shape shape) {
        Class<? extends Shape> aClass = shape.getClass();
        if(aClass.isAnnotationPresent(ArithmeticAnnotation.class)) {
            ArithmeticAnnotation annotation = aClass.getAnnotation(ArithmeticAnnotation.class);
            if(!annotation.isCorrect()) {
                Operation operation = annotation.correctOperationToApply();
                System.out.println(operation.action(shape.getDimension(), 5));
            }
            else {
                shape.calculateArea();
            }
        }
        else {
            shape.calculateArea();
        }
    }

    public static void main(String[] args) {
        Shape shape1 = new Shape(5);
        Rectangle rectangle1 = new Rectangle(7, 9);

        check(shape1);
        check(rectangle1);

    }


}
