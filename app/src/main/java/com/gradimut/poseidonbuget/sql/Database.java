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

    public final class Budget {
        // Budget table name
        public static final String TABLE_NAME = "budgets";

        // Budget Table Columns names
        public static final String COLUMN_BUDGET_ID = "budget_id";
        public static final String COLUMN_BUDGET_NAME = "budget_name";
        public static final String COLUMN_BUDGET_AMOUNT = "budget_amount";
        public static final String COLUMN_DATETIME = "created_at";
        public static final String COLUMN_USER_ID = "user_id";

        // Create table
        public static final String CREATE_QUERY =
                "CREATE TABLE IF NOT EXISTS " + Budget.TABLE_NAME + " ( "
                        + Budget.COLUMN_BUDGET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Budget.COLUMN_BUDGET_NAME + " TEXT, "
                        + Budget.COLUMN_BUDGET_AMOUNT + " TEXT, "
                        + Budget.COLUMN_DATETIME + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                        + Budget.COLUMN_USER_ID + " INTEGER)";
    }

    public final class Items {
        // Budget table name
        public static final String TABLE_NAME = "items";

        // Budget Table Columns names
        public static final String COLUMN_ITEM_ID = "item_id";
        public static final String COLUMN_ITEM_NAME = "item_name";
        public static final String COLUMN_PRIORITY = "item_priority";
        public static final String COLUMN_BUDGET_ALLOCATE = "budget_allocate";
        public static final String COLUMN_BUDGET_ID = "budget_id";
        public static final String COLUMN_USER_ID = "user_id";

        // Create table
        public static final String CREATE_QUERY =
                "CREATE TABLE IF NOT EXISTS " + Items.TABLE_NAME + " ( "
                        + Items.COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Items.COLUMN_ITEM_NAME + " TEXT, "
                        + Items.COLUMN_PRIORITY + " TEXT, "
                        + Items.COLUMN_BUDGET_ALLOCATE + " TEXT, "
                        + Items.COLUMN_BUDGET_ID + " INTEGER, "
                        + Items.COLUMN_USER_ID + " INTEGER)";
    }


}