package com.gradimut.poseidonbuget.sql;

public final class Database {
    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "poseidon.db";

    public final class UserTable {
        // User table name
        public static final String TABLE_USER = "users";

        // User Table Columns names
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_USER_EMAIL = "user_email";
        public static final String COLUMN_USER_PASSWORD = "user_password";

        // Create table
        public static final String CREATE_QUERY =
                "CREATE TABLE IF NOT EXISTS " + UserTable.TABLE_USER + " ( "
                        + UserTable.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + UserTable.COLUMN_USER_EMAIL + " TEXT, "
                        + UserTable.COLUMN_USER_NAME + " TEXT, "
                        + UserTable.COLUMN_USER_PASSWORD + " TEXT)";


    }


}
