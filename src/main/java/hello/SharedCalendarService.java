package hello;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

/**
 * Created by uengine on 2018. 1. 27..
 */

public interface SharedCalendarService {

    List<ClazzDay> getSchedules(Calendar calendar, Instructor instructor);

}
