package com.ljc.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("student")
public class Student {

    @XStreamAlias("name")
    @XStreamAsAttribute
    private String studentName;

    @XStreamOmitField
    private int type;

    @XStreamImplicit
    private List<Note> nodes = new ArrayList<Note>();

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Note> getNodes() {
        return nodes;
    }

    public void setNodes(List<Note> nodes) {
        this.nodes = nodes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", nodes=" + nodes +
                '}';
    }

    public void addNote(Note note) {
        nodes.add(note);
    }
}
