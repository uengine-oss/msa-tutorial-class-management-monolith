package hello;

import javax.persistence.*;

/**
 * Created by uengine on 2018. 1. 6..
 *
 * create table clazz(
 *    id primary key,
 *    states int,
 *    cid references (Course(id)),
 *    iid references (Instructor(id))
 * )
 *
 */
@Entity
public class Clazz {

    @Id
    @GeneratedValue
    Long id;
    String states;
    int evaluationRate;

    @ManyToOne
    @JoinColumn(name="cid")
    Course course;

    @ManyToOne
    @JoinColumn(name="iid")
    Instructor instructor;

//    @ManyToOne
//    @JoinColumn(name="pre_cid")
//    Course prerequisteCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public int getEvaluationRate() {
        return evaluationRate;
    }

    public void setEvaluationRate(int evaluationRate) {
        this.evaluationRate = evaluationRate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


}
