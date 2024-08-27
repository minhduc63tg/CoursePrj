/*
 * @ (#) CourseList.java   1.0   8/24/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.se1;
/*
 * @description: This class represents a list of courses
 * @author: Le Minh Duc
 * @version: 1.0
 * @created: 8/24/2024 9:30 PM
 */

public class CourseList {
    private Course[] courses;
    private int count = 0;
    /**
     * Description: Constructor with parameters
     * @param n The length of the course list
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of the course list must be greater than 0.");
        }
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getCount() {
        if(count<0){
            throw new IllegalArgumentException("count must be greater than 0");
        }
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    /**
     * Description: Add a course to the list
     * @param course The course to be added
     * @return true if the course is added successfully, false otherwise
     */
    public boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }
        // Check if course already exists
        if (isExists(course)) {
            return false;
        }
        // Check if the array is full
        if (count == courses.length) {
            return false;
        }
        courses[count++] = course;
        return true;
    }
    /**
     * Description: Check if the course already exists in the list
     * @param course The course to be checked
     * @return true if the course already exists, false otherwise
     */
    private boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(course.getId())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Description: Get the course by ID
     * @ return The course with the given ID, null if not found
     */
    public void getCourseList(){
        System.out.printf("%-10s%-30s%10s%20s\n", "id", "title", "credit", "department");
        Course []temp= CourseList.this.getCourses();
        for(Course c: temp){
            if(c!=null){
                System.out.println(c);
            }
        }
    }
    /**
     * Description: Remove a course from the list
     * @param id The ID of the course to be removed
     */
    public void removeCourse(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[count - 1] = null;
                count--;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found with ID: " + id);
        }

        System.out.printf("%-10s%-30s%10s%20s\n", "id", "title", "credit", "department");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-10s%-30s%10d%20s\n", courses[i].getId(),
                    courses[i].getTitle(), courses[i].getCredit(), courses[i].getDepartment());
        }
    }

    /**
     * Description: Search course by ID
     * @param id The ID of the course to be searched
     * @return The course with the given ID, null if not found
     */
    public Course[] SearchCourseById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        Course[] course = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                course[j] = courses[i];
                j++;
            }
        }
        return course;
    }
    /**
     * Description: Search course by title
     * @param title The title of the course to be searched
     * @return The course with the given title, null if not found
     */
    public Course[] SearchCourse(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title must not be null or empty");
        }
        Course[] course = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(title)) {
                course[j] = courses[i];
                j++;
            }
        }
        return course;
    }
    /**
     * Description: Search course by department
     * @param department The department of the course to be searched
     * @return The course with the given department, null if not found
     */
    public Course[] SearchCourseByDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("department must not be null or empty");
        }
        Course[] course = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                course[j] = courses[i];
                j++;
            }
        }
        return course;
    }
    /**
     * Description: Sort the course list by title
     * @return The sorted course list
     */
    public Course[]sortCourse(){
        Course []temp= CourseList.this.getCourses();
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                if(temp[i].getTitle().compareTo(temp[j].getTitle())>0){
                    Course t= temp[i];
                    temp[i]=temp[j];
                    temp[j]=t;
                }
            }
        }
        return temp;
    }
    /**
     * Description: Find the course with the maximum credit
     * @return The course with the maximum credit
     */
    public Course[] findMaxCreditCourse(){
        int max=0;
        for(int i=0; i<count; i++){
            if(courses[i].getCredit()>max){
                max=courses[i].getCredit();
            }
        }
        Course []temp= new Course[count];
        int j=0;
        for(int i=0; i<count; i++){
            if(courses[i].getCredit()==max){
                temp[j]=courses[i];
                j++;
            }
        }
        return temp;
    }
    /**
     * Description: Find the department with the most courses
     * @return The department with the most courses
     */
    public String findDepartmentWithMostCourse() {
        String mostPopularDepartment = "";
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            int deptCount = 0;
            String dept = courses[i].getDepartment();

            // Count how many times this department appears
            for (int j = 0; j < count; j++) {
                if (courses[j].getDepartment().equals(dept)) {
                    deptCount++;
                }
            }
            if (deptCount > maxCount) {
                maxCount = deptCount;
                mostPopularDepartment = dept;
            }
        }
        return mostPopularDepartment;
    }
}
