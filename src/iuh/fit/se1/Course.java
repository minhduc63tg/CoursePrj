/*
 * @ (#) Course.java   1.0   8/24/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.se1;

/*
 * @description: This class represents the information of a course
 * @author: Le Minh Duc
 * @version: 1.0
 * @created: 8/24/2024 9:21 PM
 */

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    /**
     * Description: Constructor with parameters
     *
     * @param id The ID of the course
     * @param title The title of the course
     * @param credit The credit of the course
     * @param department The department of the course
     */
    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    /**
     * Description: Default constructor
     */
    public Course() {
        this("0","", 0,"");
        this.id= "0";
        this.title="";
        this.credit=0;
        this.department="";
    }
    public String getId() {
        return id;
    }
    /**
     * Description: Set the ID of the course
     * @param id The ID of the course
     * @throws IllegalArgumentException if id is null, id length is less than 3, or id contains characters other than letters or digits
     */
    public void setId(String id) {
        if (id == null || id.length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }
    /**
     * Description: Get the title of the course
     * @return The title of the course
     */
    public String getTitle() {
        return title;
    }
    /**
     * Description: Set the title of the course
     * @param title The title of the course
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }
    /**
     * Description: Set the credit of the course
     * @param credit The credit of the course
     * @throws IllegalArgumentException if credit is less than 0
     */
    public void setCredit(int credit) {
        if(credit<0){
            throw new IllegalArgumentException("credit must be greater than 0");
        }
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%10d%20s", id, title, credit,department);
    }
}
