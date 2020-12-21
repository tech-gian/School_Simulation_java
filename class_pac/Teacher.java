////////////////////////////
// Implementation of Teacher
////////////////////////////


// Naming package
package class_pac;

// Teacher
public class Teacher extends Person {

    // Constructor
    public Teacher(String name, int nf, int nc) {
        // Initialization of super-class
        super(name, nf, nc);
        
        System.out.println("A New Teacher has been created!");
    }


    // Teach
    void teach(int N, int Lt) {
        // Add N * Lt
        this.tired += (N * Lt);
    }

    // Print
    @Override
    public void print() {
        System.out.print("The Teacher is: ");
        super.print();
    }
}
