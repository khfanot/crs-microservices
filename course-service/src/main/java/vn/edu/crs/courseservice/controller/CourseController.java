package vn.edu.crs.courseservice.controller;

import org.springframework.web.bind.annotation.*;
import vn.edu.crs.courseservice.entity.Course;
import vn.edu.crs.courseservice.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // GET: lấy tất cả môn học
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET: lấy môn học theo ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // POST: thêm môn học
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // PUT: sửa môn học
    @PutMapping("/{id}")
    public Course updateCourse(
            @PathVariable Long id,
            @RequestBody Course course) {

        return courseService.updateCourse(id, course);
    }

    // DELETE: xóa môn học
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);

        return "Xoa mon hoc thanh cong";
    }
}