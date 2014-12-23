/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Konst
 */
public class Calculator {

    public List<Operation> list;
    
    public Calculator() throws IOException, InstantiationException, IllegalAccessException {
      list = new ArrayList<>(loadHandlers());
    }
    
    

    public String[] getOperations() {
        String[] operations = new String[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            operations[i] = list.get(i).getOperationSign();
        }
        return operations;
    }

    public Double perform(String op, Double a, Double b) throws Exception {
        for (Operation o : list) {
            if (o.getOperationSign().equals(op)) {
                if (b == 0 && op.equals("/")) {
                    throw new ArithmeticException("EXCEPTION: Division by zero");
                }
                return o.perform(a, b);
            }
        }
        return null;
    }

    public final Collection<Operation> loadHandlers() throws IOException, InstantiationException, IllegalAccessException {
        Collection<ClassInfo> classes = ClassPath.from(Operation.class.getClassLoader()).getTopLevelClasses("com.mycompany.calculator.operations");

        ImmutableList.Builder<Operation> handlers = ImmutableList.<Operation>builder();

        for (ClassInfo classInfo : classes) {
            Class<?> clazz = classInfo.load();
            if ( ! Operation.class.isAssignableFrom(clazz)) {
                continue;
            }

            // fitler out non instantiable types
            if (Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
                continue;
            }

            handlers.add((Operation) clazz.newInstance());
        }

        return handlers.build();
    }
}
