package hello;

import org.springframework.data.repository.PagingAndSortingRepository;

@RepositoryRestResource
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
