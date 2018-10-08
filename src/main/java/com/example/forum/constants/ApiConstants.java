/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.constants;

public final class ApiConstants {

    public static final String API_URI_DELIMETER = "/";

    public static final class User {
        public static final String CONTROLLER_MAPPING = "user";
        public static final String REGISTRATION = "registration";
    }

    public static final class Forum {
        public static final String CONTROLLER_MAPPING = "forum";
        public static final String VIEW = "view";
        public static final String TEMPLATES_VIEW = API_URI_DELIMETER + CONTROLLER_MAPPING + API_URI_DELIMETER + VIEW;
    }

    public static final class Subject {
        public static final String CONTROLLER_MAPPING = "subject";
        public static final String CREATE = "create";
        public static final String DELETE = "delete/{subjectId}";
        public static final String PATH_VIEW = "{subjectId}";
        public static final String VIEW = "view";
        public static final String TEMPLATES_CREATE = CONTROLLER_MAPPING + API_URI_DELIMETER + CREATE;
        public static final String TEMPLATES_VIEW = CONTROLLER_MAPPING + API_URI_DELIMETER + VIEW;
    }

    public static final class Message {
        public static final String CONTROLLER_MAPPING = "message";
        public static final String CREATE = "create";
        public static final String DELETE = "delete/{messageId}";
        public static final String PATH_CREATE = CREATE + API_URI_DELIMETER + "{subjectId}";
    }
}
