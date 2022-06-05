package kz.ClassesAndInterfaces;

public class Ingredient {
    private String name;
    private Type type;

    public Ingredient(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public Type getType(){
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setToShredder()
    {
        //System.out.println("This ingredient was set to shredded");
        this.setType(Type.SHREDDED);
    }

    public boolean isShredded(){
        return this.type == Type.SHREDDED;
    }



}

