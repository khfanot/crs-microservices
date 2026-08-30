package vn.edu.crs.courseservice.service;

import org.springframework.stereotype.Service;
import vn.edu.crs.courseservice.entity.Course;
import vn.edu.crs.courseservice.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Lấy tất cả môn học
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Lấy môn học theo ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay mon hoc"));
    }

    // Thêm môn học
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Sửa môn học
    public Course updateCourse(Long id, Course courseDetails) {

        Course course = getCourseById(id);

        course.setTenMonHoc(courseDetails.getTenMonHoc());
        course.setSoTinChi(courseDetails.getSoTinChi());
        course.setSoChoToiDa(courseDetails.getSoChoToiDa());
        course.setSoChoConLai(courseDetails.getSoChoConLai());

        return courseRepository.save(course);
    }

    // Xóa môn học
    public void deleteCourse(Long id) {

        Course course = getCourseById(id);

        courseRepository.delete(course);
    }
}