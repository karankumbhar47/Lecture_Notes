package com.coreJava.Random;

public abstract class SuperClass {
    public String publicVarS = "public-var";
    String defaultVarS = "default-var";
    protected String protectedVarS = "protected-var";
    private String privateVarS = "private-var";

    public SuperClass() {
    }

    public String getPublicVarS() {
        return publicVarS;
    }

    public void setPublicVarS(String publicVar) {
        this.publicVarS = publicVar;
    }

    public String getDefaultVarS() {
        return defaultVarS;
    }

    public void setDefaultVarS(String defaultVar) {
        this.defaultVarS = defaultVar;
    }

    public String getProtectedVarS() {
        return protectedVarS;
    }

    public void setProtectedVarS(String protectedVar) {
        this.protectedVarS = protectedVar;
    }

    public String getPrivateVarS() {
        return privateVarS;
    }

    public void setPrivateVarS(String privateVar) {
        this.privateVarS = privateVar;
    }

    void leg(){
        System.out.println("I have super legs");
    }
}

