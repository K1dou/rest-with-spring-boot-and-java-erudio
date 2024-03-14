package com.K1dou.restwithspringbootandjava.exception;

import java.util.List;

public class ExceptionResponseBean {

    private List<String>error;

    public ExceptionResponseBean(List<String> error) {
        this.error = error;
    }


    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }
}
