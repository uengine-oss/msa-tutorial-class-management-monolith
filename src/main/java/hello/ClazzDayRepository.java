package hello;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by uengine on 2018. 1. 27..
 */
public interface ClazzDayRepository extends PagingAndSortingRepository<ClazzDay, Long> {

    List<ClazzDay> findByDateAndInstructor(Calendar date, Instructor instructor);
}
