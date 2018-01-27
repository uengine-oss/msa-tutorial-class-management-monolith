package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by uengine on 2018. 1. 27..
 */
@Component
public class SharedCalendarServiceImpl implements SharedCalendarService {


    @Autowired
    ClazzDayRepository clazzDayRepository;

    @Override
    public List<ClazzDay> getSchedules(Calendar calendar, Instructor instructor) {
        List<ClazzDay> clazzDays = clazzDayRepository.findByDateAndInstructor(calendar, instructor);

        return clazzDays;
    }
}
