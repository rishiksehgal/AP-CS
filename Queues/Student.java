/**
 * Student stores name studentID and gradeLevel
 * @author Rishik Sehgal
 * @version Oct 31, 2025
 */
public class Student 
{
    private String name;
    private int studentID;
    private String gradeLevel;

    /**
     * Creates a Student object
     * @param n is the name
     * @param s is the ID
     * @param g is the grade
     */
    public Student(String n, int s, String g)
    {
        name = n;
        studentID = s;
        gradeLevel = g;
    }

    /**
     * Prints the details
     * @return the details of the student
     */
    public String printDetails()
    {
        return this.name + " ID: " + this.studentID + " Grade: " + this.gradeLevel;
    }
}
