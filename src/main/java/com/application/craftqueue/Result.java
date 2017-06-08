package com.application.craftqueue;

public class Result {
    
    private String result;
    
    public void positive() {
        this.result = "true";
    }
    
    public void negative() {
        this.result = "false";
    }
    
    public String getResult() {
        return this.result;
    }
}
