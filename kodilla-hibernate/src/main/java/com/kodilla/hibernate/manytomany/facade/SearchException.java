package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {

    public static String ERR_COMPANY_NOT_EXIST = "Company with the given name doesn't exist.";
    public static String ERR_EMPLOYEE_NOT_EXIST = "Employee with the given name doesn't exist.";

    public SearchException(String message) {
        super(message);
    }
}
