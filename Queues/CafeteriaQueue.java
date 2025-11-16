/**
 * CafeteriaQueue stores Students in a queue
 * @author Rishik Sehgal
 * @version Nov 1, 2025
 */
public class CafeteriaQueue
{
    ArrayQueue<Student> a;
    /**
     * Creates a CafeteriaQueue with 5 spaces
     */
    public CafeteriaQueue()
    {
        a = new ArrayQueue<>(5);
    }
    /**
     * Adds a student
     * @param name of the student 
     * @param studentID of the student 
     * @param gradeLevel of the student
     */
    public void addStudent(String name, int studentID, String gradeLevel)
    {
        a.add(new Student(name, studentID, gradeLevel));
    }

    /**
     * Serves the Student
     * @return the Student served
     */
    public Student serveStudent()
    {
        return a.remove();
    }

    /**
     * Peeks next Student
     * @return the element of the next Student
     */
    public Student peekNextStudent()
    {
        return a.element();
    }

    /**
     * Returns the size of the Queue
     * @return the size of the Queue
     */
    public int getQueueSize()
    {
        return a.size();
    }
}
