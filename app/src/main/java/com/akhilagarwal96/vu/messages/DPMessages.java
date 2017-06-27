package com.akhilagarwal96.vu.messages;

/**
 * Created by Adm on 27-Jun-17.
 */

public class DPMessages {

    String faculty_name;
    String faculty_messages;

    public DPMessages(String faculty_name, String faculty_messages) {
        this.faculty_name = faculty_name;
        this.faculty_messages = faculty_messages;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_messages() {
        return faculty_messages;
    }

    public void setFaculty_messages(String faculty_messages) {
        this.faculty_messages = faculty_messages;
    }
}
