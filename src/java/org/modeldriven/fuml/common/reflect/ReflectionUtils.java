package org.modeldriven.fuml.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtils {

    @SuppressWarnings("unchecked")
    public static Method findMethod(Class target, String name, Class arg) throws NoSuchMethodException {
        return findMethod(target.getMethods(), name, arg);
    }

    @SuppressWarnings("unchecked")
    public static Method getMethod(Class target, String name, Class arg) throws NoSuchMethodException {
        Method method = findMethod(target.getMethods(), name, arg);
        if (method == null)
            throw new NoSuchMethodException(target.getName() + "." + name);
        return method;
    }

    @SuppressWarnings("unchecked")
     public static Method findMethod(Method[] methods, String name, Class arg) {
        for (int i = 0; i < methods.length; i++) {
            if (!methods[i].getName().equals(name))
                continue;
            Class[] types = methods[i].getParameterTypes();
            if (types != null && types.length == 1) {
                if (types[0].isAssignableFrom(arg))
                    return methods[i];
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Object instanceForName(String qualifiedName) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException,
            InstantiationException {
    	Object[] args = new Object[0];
    	Class[] types = new Class[0];
        return instanceForName(qualifiedName, args, types);
    }

    @SuppressWarnings("unchecked")
    public static Object instanceForName(String qualifiedName, Object[] args, Class[] types) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException,
            InstantiationException {
        Class targetClass = Class.forName(qualifiedName);
        int mods = targetClass.getModifiers();
        if (Modifier.isAbstract(mods))
            throw new RuntimeException("attempt to instantiate abstract class, " + qualifiedName);
        if (!Modifier.isPublic(mods))
            throw new RuntimeException("attempt to instantiate non-public class, " + qualifiedName);
        Constructor defaultConstructor = targetClass.getConstructor(types);
        Object object = defaultConstructor.newInstance(args);
        return object;
    }
    
}
