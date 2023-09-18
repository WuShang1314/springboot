package cn.lzy.configbean;

public class Course {

    private int time;
    private String courseName;

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "time=" + time +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}