////////////////////////////
// Implementation of Student
//////////////////////////// 


// Naming package
package class_pac;

// Student
public abstract class Student extends Person {

    // Constructor
    Student(String name, int nf, int nc) {
        super(name, nf, nc);

        System.out.println("A New Student has been created!");
    }

    // Attend
    void attend(int N, int L) {}

    // Print for Student is the same as Person's
    // So that method is public
}
