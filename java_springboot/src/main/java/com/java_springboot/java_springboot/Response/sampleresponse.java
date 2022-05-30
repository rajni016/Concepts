package com.java_springboot.java_springboot.Response;
// in previous cases we sent the response to front end by return method of string (e.g.public String test get(), return "")
//this class is pojo class
public class sampleresponse {
    public String getMessage() {
        return message;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public String getOurresponse() {
        return ourresponse;
    }

    public void setOurresponse(String ourresponse) {
        this.ourresponse = ourresponse;
    }

    String ourresponse;
}
