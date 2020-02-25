package com.deepz.test;

/**
 * created by zhangdingping on 2020/2/25
 */
public class Student implements Cloneable {

    private String name;

    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            Teacher teacher = this.teacher.clone();
            student.setTeacher(teacher);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;

    }

    class Teacher implements Cloneable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public Teacher clone() {

            Teacher teacher = null;
            try {
                teacher = (Teacher) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return teacher;
        }
    }
}
