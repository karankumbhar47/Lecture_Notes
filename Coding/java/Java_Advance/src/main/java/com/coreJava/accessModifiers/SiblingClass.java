package com.coreJava.accessModifiers;

import com.coreJava.accessModifiers.SubClass.InnerSubClass;

public class SiblingClass implements InnerSubClass{
    public String publicVar = "public-var";
    String defaultVar = "default-var";
    protected String protectedVar = "protected-var";
    private String privateVar = "private-var";

    public SiblingClass() {}

    public String getPublicVar() {
        return publicVar;
    }

    public void setPublicVar(String publicVar) {
        this.publicVar = publicVar;
    }

    public String getDefaultVar() {
        return defaultVar;
    }

    public void setDefaultVar(String defaultVar) {
        this.defaultVar = defaultVar;
    }

    public String getProtectedVar() {
        return protectedVar;
    }

    public void setProtectedVar(String protectedVar) {
        this.protectedVar = protectedVar;
    }

    public String getPrivateVar() {
        return privateVar;
    }

    public void setPrivateVar(String privateVar) {
        this.privateVar = privateVar;
    }
    
    public static void main(String[] args) {
             
    }

    @Override
    public void someRandomMethod() {
        throw new UnsupportedOperationException("Unimplemented method 'someRandomMethod'");
    }

}
