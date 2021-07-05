public class Component {
    private int privateField;
    public int publicField;

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

    public int getSumOfFields() {
        return this.privateField + this.publicField;
    }
}
