package hello;

import org.metaworks.multitenancy.persistence.BeforeSave;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

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
public class Clazz implements BeforeSave{

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

    @OneToMany(mappedBy = "clazz")
    //@JoinColumn(name="cid")
    List<ClazzDay> clazzDays;
        public List<ClazzDay> getClazzDays() {
            return clazzDays;
        }
        public void setClazzDays(List<ClazzDay> clazzDays) {
            this.clazzDays = clazzDays;
        }



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


    @PrePersist
    public void beforeSave() {

        checkAvailabilityAndSetInstructor();

    }

    private void checkAvailabilityAndSetInstructor() {
        if(getInstructor()!=null){
            SharedCalendarService sharedCalendarService = Application.applicationContext.getBean(SharedCalendarService.class);

            if(getClazzDays()==null)
                throw new RuntimeException("Instructor can be mapped after adding class days for this class.");

            for(ClazzDay clazzDay : getClazzDays()){

                List<ClazzDay> schedules = sharedCalendarService.getSchedules(clazzDay.getDate(), getInstructor());

                if(schedules!=null && schedules.size() > 0){
                    throw new RuntimeException("Instructor " + getInstructor().getFirstName() + " already have another class for that time slot.");
                }

            }

            //set instructor if available time slot
            for(ClazzDay clazzDay : getClazzDays()){

                clazzDay.setInstructor(getInstructor());

            }

        }
    }
}
