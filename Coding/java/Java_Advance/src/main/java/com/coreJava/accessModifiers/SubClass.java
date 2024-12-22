package com.coreJava.accessModifiers;

import com.coreJava.Random.SuperClass;

public class SubClass extends SuperClass {

    interface InnerSubClass {
        void someRandomMethod();
    }

    

    public String publicVar = "public-var";
    String defaultVar = "default-var";
    protected String protectedVar = "protected-var";
    private String privateVar = "private-var";

    public SubClass() {
    }

    public String getPublicVarS() {
        return publicVar;
    }

    public void setPublicVarS(String publicVar) {
        this.publicVar = publicVar;
    }

    public String getDefaultVarS() {
        return defaultVar;
    }

    public void setDefaultVarS(String defaultVar) {
        this.defaultVar = defaultVar;
    }

    public String getProtectedVarS() {
        return protectedVar;
    }

    public void setProtectedVarS(String protectedVar) {
        this.protectedVar = protectedVar;
    }

    public String getPrivateVarS() {
        return privateVar;
    }

    public void setPrivateVarS(String privateVar) {
        this.privateVar = privateVar;
    }

    public void main(String[] args) {
        publicVarS = "child public too";
        // defaultVarS = "child default var";
        protectedVarS = "child protected var";
        // only private var of parent no available

        SiblingClass siblingClass = new SiblingClass();
        siblingClass.publicVar = "sibling public var";
        siblingClass.protectedVar = "sibling protected var";
        siblingClass.defaultVar = "sibling default var";
    }

}
