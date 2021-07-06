package ru.itis;

public class Component {
    private int privateField;
    public int publicField;
    public static final String staticField = "FINAL";

    public Component(int privateField, int publicField) {
        this.privateField = 10;
        this.publicField = 10;
    }

    public int getPrivateField() {
        return privateField;
    }

    public int getPublicField() {
        return publicField;
    }

    public void publicMethod() {
        System.out.println(privateField + " " + publicField);
    }

    private boolean privateMethod() {
        return this.privateField == this.publicField;
    }

    public int getSumOfFields(int a) {
        return a + this.privateField + this.publicField;
    }

    public static int methodWithArgs(int a, int b, int c) {
        return a + b + c;
    }
}
