/*
 * @ (#) TestCourse.java   1.0   8/24/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.se1;

import java.util.Scanner;
/*
 * @description: This class represents a list of courses
 * @author: Le Minh Duc
 * @version: 1.0
 * @created: 8/24/2024 9:31 PM
 */


public class TestCourse {
    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);
        initDate(courseList);
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---------------------------");
            System.out.println("1. Add Course");
            System.out.println("2. List of Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Course by Title");
            System.out.println("5. Search Course by ID");
            System.out.println("6. Search Course by Department");
            System.out.println("7. Sort by CourseTitle");
            System.out.println("8. Course with max credit");
            System.out.println("9. Department with the most courses");
            System.out.println("0. Exit");
            System.out.println("---------------------------");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                case 2:
                    System.out.println("List of Courses");
                    System.out.println("---------------------------");
                    courseList.getCourseList();
                    break;
                case 3:
                    System.out.println("Enter the course id to delete: ");
                    id = sc.nextLine();
                    System.out.println("List of Courses after removing");
                    courseList.removeCourse(id);
                    break;
                case 4:
                    System.out.println("Enter the course title to search: ");
                    title = sc.nextLine();
                    Course[] r = courseList.SearchCourse(title);
                    System.out.println("Search result for CourseTitle: " + title);
                    System.out.println("-----------");
                    System.out.printf("%-10s%-30s%10s%20s\n", "ID", "Title", "Credit", "Department");
                    for (Course c : r) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter the course id to search: ");
                    id = sc.nextLine();
                    Course[] a = courseList.SearchCourseById(id);
                    System.out.println("Search result for CourseID: " + id);
                    System.out.println("-----------");
                    System.out.printf("%-10s%-30s%10s%20s\n", "ID", "Title", "Credit", "Department");
                    for (Course c : a) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter the department to search: ");
                    department = sc.nextLine();
                    Course[] b = courseList.SearchCourseByDepartment(department);
                    System.out.println("Search result for Department: " + department);
                    System.out.println("-----------");
                    System.out.printf("%-10s%-30s%10s%20s\n", "ID", "Title", "Credit", "Department");
                    for (Course c : b) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 7:
                    Course[] d = courseList.sortCourse();
                    System.out.println("Sort by CourseTitle");
                    System.out.println("-----------");
                    System.out.printf("%-10s%-30s%10s%20s\n", "ID", "Title", "Credit", "Department");
                    for (Course c : d) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 8:
                    Course[] e = courseList.findMaxCreditCourse();
                    System.out.println("Course with max credit");
                    System.out.printf("%-10s%-30s%10s%20s\n", "ID", "Title", "Credit", "Department");
                    for (Course c : e) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 9:
                    System.out.println("Department with the most courses: "+ courseList.findDepartmentWithMostCourse());
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("----");
                    break;
            }
        }
        while (choice != 0);
    }
    private static void initDate(CourseList courseList) {
        Course c1 = new Course("CS01","Java oop",2,"SE");
        Course c2 = new Course("CS02","Database",4,"IS");
        Course c3 = new Course("CS03","Computer Vision",3,"CS");
        Course c4 = new Course("CS04", "Mobile Programming", 3, "SE");
        Course c5 = new Course("CS05", "Software Engineering", 3, "SE");
        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
        courseList.addCourse(c5);
    }
}
