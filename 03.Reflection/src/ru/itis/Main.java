package ru.itis;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        Class aClass0 = Component.class;
        Class<?> aClass2 = Component.class;
//        Class<Component> aClass1 = Component.class;
        //  Class<?> aClass2 = Class.forName("C:\\Users\\fastrapier\\Desktop\\Java\\03.Reflection\\src\\ru\\itis\\Component");

        Field[] fields = aClass2.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder modifiers = new StringBuilder();

            int modifiersCodes = field.getModifiers();
            if (Modifier.isFinal(modifiersCodes)) {
                modifiers.append("FINAL");
                modifiers.append(" ");
            }
            if (Modifier.isPublic(modifiersCodes)) {
                modifiers.append("PUBLIC");
                modifiers.append(" ");
            }
            if (Modifier.isPrivate(modifiersCodes)) {
                modifiers.append("PRIVATE");
                modifiers.append(" ");
            }
            if (Modifier.isStatic(modifiersCodes)) {
                modifiers.append("STATIC");
                modifiers.append(" ");
            }
            System.out.println(modifiers.toString() + field.getType() + " " + field.getName());
        }
        Method methods[] = aClass2.getMethods();
        for (Method method : methods) {
            StringBuilder modifiers = new StringBuilder();

            int modifiersCodes = method.getModifiers();
            if (Modifier.isFinal(modifiersCodes)) {
                modifiers.append("FINAL");
                modifiers.append(" ");
            }
            if (Modifier.isPublic(modifiersCodes)) {
                modifiers.append("PUBLIC");
                modifiers.append(" ");
            }
            if (Modifier.isPrivate(modifiersCodes)) {
                modifiers.append("PRIVATE");
                modifiers.append(" ");
            }
            if (Modifier.isStatic(modifiersCodes)) {
                modifiers.append("STATIC");
                modifiers.append(" ");
            }
            StringBuilder argsOfMethod = new StringBuilder();
            StringBuilder parametersOfMethod = new StringBuilder();

            Parameter[] parameters = method.getParameters();

            for (Parameter parameter : parameters) {
                parametersOfMethod.append(parameter.getType().getSimpleName()).append(" ")
                        .append(parameter.getName())
                        .append(",");
            }
            System.out.println(modifiers.toString() + method.getReturnType().getSimpleName() + method.getName()
                    + "(" + parametersOfMethod.toString() + ")");
        }
//      Constructor constructors[] = aClass2.getConstructors();

        //Object object = aClass2.newInstance();

        Constructor<Component> costructor = (Constructor<Component>) aClass2.getConstructor(int.class, int.class);
        Component component = costructor.newInstance(15, 20);
        System.out.println(component.getPublicField());

        Method method = aClass2.getMethod("getSumOfFields", int.class);
        Object result = method.invoke(component, 100);
        System.out.println(result);
    }

}

