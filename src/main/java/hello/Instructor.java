package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by uengine on 2018. 1. 6..
 *

 http localhost:8080/courses title="aaa" duration=5 maxEnrollment=5 minEnrollment=1
 http "http://localhost:8080/instructors" firstName="진영" lastName="장"
 http localhost:8080/clazzes course="http://localhost:8080/courses/1" instructor="http://localhost:8080/instructors/2"
 http localhost:8080/clazzes course="http://localhost:8080/courses/1"
 http "http://localhost:8080/clazzDays" clazz="http://localhost:8080/clazzes/3" date="2012-04-23T18:25:43.511Z" instructor="http://localhost:8080/instructors/2"

 */
@Entity
public class Instructor {

    @Id @GeneratedValue
    Long id;
    String firstName;
    String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
