package com.Integrative.IntegrativeWork.Util;

public class Util {
    public static java.sql.Date utilDateToSQLDate(java.util.Date utilDate) {
        long miliseconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(miliseconds);
        return sqlDate;
    }
}
