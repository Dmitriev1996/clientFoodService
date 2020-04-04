package com.service.clientFoodService.exceptions;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 26.05.2019.
 */
public class InvalidDataException extends Exception{
    public final static String DIVIDER = ";";
    public final static String LOGICAL_ERROR_KEY = "";

    private Map<String, String> errorsMap = new HashMap<>();

    public Map<String, String> getErrorsMap() {
        return errorsMap;
    }


    public InvalidDataException(String message) {
        super(message);
        this.errorsMap = new HashMap<>();
        errorsMap.put("MESSAGE", message);
    }

    public InvalidDataException(String message, Map<String, String> errorsMap) {
        super(message);
        this.errorsMap = errorsMap;
    }


    public void addFieldError(String field, String description) {
        addError(field, description);
    }

    public void addLogicalError(String description) {
        addError(LOGICAL_ERROR_KEY, description);
    }


    public boolean hasErrors() {
        return !this.errorsMap.isEmpty();
    }


    private void addError(String key, String description) {
        String fullDescription = "";
        if (this.errorsMap.containsKey(key)) {
            fullDescription = this.errorsMap.get(key) + DIVIDER;
        }
        fullDescription += description;
        this.errorsMap.put(key, fullDescription);
    }

    @Override
    @Deprecated
    public String getMessage() {
        if (errorsMap.size() > 0) {
            return StringUtils.join(errorsMap.values(), "<br>");
        }
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getMessage();
    }
}
