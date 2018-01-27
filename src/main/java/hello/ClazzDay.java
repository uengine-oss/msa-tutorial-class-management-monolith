package hello;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by uengine on 2018. 1. 27..
 */
@Entity
public class ClazzDay {

    @Id
    @GeneratedValue
    Long id;
    Calendar date;
    int startTime;
    int endTime;

    @ManyToOne @JoinColumn(name="cid")
    Clazz clazz;

    @ManyToOne @JoinColumn(name="iid")
    Instructor instructor;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


}
