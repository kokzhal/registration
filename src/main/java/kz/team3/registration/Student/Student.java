package kz.team3.registration.Student;

public class Student {
    private String user_id;
    private String user_firstname;
    private String user_lastname;
    private String user_email;
    private String user_program;
    private int user_course;
    private String user_phone;
    private String role_id;
    private String bed_id;
    private String user_picture;

    public Student(String user_id, String user_firstname, String user_lastname, String user_email, String user_program, int user_course, String user_phone, String role_id, String bed_id, String user_picture) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_program = user_program;
        this.user_course = user_course;
        this.user_phone = user_phone;
        this.role_id = role_id;
        this.bed_id = bed_id;
        this.user_picture = user_picture;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_program() {
        return user_program;
    }

    public void setUser_program(String user_program) {
        this.user_program = user_program;
    }

    public int getUser_course() {
        return user_course;
    }

    public void setUser_course(int user_course) {
        this.user_course = user_course;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getBed_id() {
        return bed_id;
    }

    public void setBed_id(String bed_id) {
        this.bed_id = bed_id;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    @Override
    public String toString() {
        return "Student{" +
                "user_id='" + user_id + '\'' +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_program='" + user_program + '\'' +
                ", user_course=" + user_course +
                ", user_phone='" + user_phone + '\'' +
                ", role_id='" + role_id + '\'' +
                ", bed_id='" + bed_id + '\'' +
                ", user_picture='" + user_picture + '\'' +
                '}';
    }
}
