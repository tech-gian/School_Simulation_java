///////////////////////////
// Implementation of Senior
///////////////////////////


// Naming package
package class_pac;


// Senior
public class Senior extends Student {
    
    // Constructor
    public Senior(String name, int nf, int nc) {
        // Initialization of super-class
        super(name, nf, nc);

        System.out.println("A New Senior has been created!");
    }

    // Attend Senior
    @Override
    public void attend(int N, int L) {
        // Add N * Ls
        this.tired += (N * L);
    }

    // Print
    // It just inherits the print from Person
    // (it does the same thing)
}
