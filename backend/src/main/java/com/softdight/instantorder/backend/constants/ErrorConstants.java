package com.softdight.instantorder.backend.constants;

public class ErrorConstants {
    public static final String ERROR = "ERROR: ";
    public static final String NOT_ENOUGH_RIGHTS = ERROR + "You don't have enough rights to perform this operation";
    public static final String NOT_ENOUGH_RIGHTS_FOR_THIS_OBJECT = ERROR + NOT_ENOUGH_RIGHTS + " on this object";
    public static final String THIS_OBJECT_ID_ALREADY_EXIST_IN_DB = ERROR + "This object id already exist in the database";
    public static final String THIS_OBJECT_ID_IS_NOT_IN_DB = ERROR + "This object id is not present in the database";
}
