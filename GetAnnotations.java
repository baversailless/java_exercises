package kz.dz13;

// cоздать программу, которая будет выводить все аннотации класса и суперкласса (или суперинтерфейса) в любой произвольной форме.
// название класса или интерфейса должно задаваться пользователем через интерфейс командной строки.
// класс может быть из стандартной библиотеки Java или пользовательский.
// аннотации объявленные над классом.


import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class GetAnnotations {
    public static void main(String[] args) throws ReflectiveOperationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name: ");
        String name = scanner.next();

        Class cl = Class.forName(name);
        Class superClass = cl.getSuperclass();
        Class superInterfaces[] = cl.getInterfaces();

        String modifiers = Modifier.toString(cl.getModifiers());
       if(modifiers.length() < 0){
            System.out.print(modifiers + " ");
        }

        System.out.println("Class: " + name);
        System.out.println("Annotation of the main class: ");
        printAnnotations(cl);
        System.out.println();
        if (superClass != null && superClass != Object.class){
            System.out.println("extends " + superClass.getName());
            System.out.println("Annotations of the super class: ");
            printAnnotations(superClass);
        }
        if(superInterfaces!=null){
            System.out.println("Annotations of the interfaces: ");
            printAnnotations(superInterfaces);

        }
    }

    private static void printAnnotations(Class cl){
        Annotation annotations[] = cl.getDeclaredAnnotations();
        for (Annotation annotation: annotations){
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }

    private static void printAnnotations(Class[] cl){
        for(Class cla : cl){
            printAnnotations(cla);
        }
    }
}
