package com.stateinformation.com;

public class StateException extends Exception{

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS,Method_INVATION_ISSUE,NO_SUCH_DELIMITER,
        NO_SUCH_FILED,NO_SUCH_FILE,NO_SUCH_File_TYPE,ILLEGAL_ACCESS,NO_ACCESS,OBJECT_CREATION_ISSUE,SOME_OTHER_FILE_ERROR
    }

    public ExceptionType type;

    public StateException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public StateException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public StateException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
