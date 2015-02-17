package com.mentoring.epam.test.lesson71.exception;

/**
 * Created by Iurii_Galias on 1/28/15.
 */
public class ByNameException extends Exception { //Custom exception

    private String message;

    public ByNameException(String message){ //Constructor
        this.message = message;
    }

    public String getMsg(){
        return "[ByNameException]: There are no records with this name " + message + " !";
    }

}
