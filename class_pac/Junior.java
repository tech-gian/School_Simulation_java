///////////////////////////
// Implementation of Junior
///////////////////////////


// Naming package
package class_pac;


// Junior
public class Junior extends Student {
    
    // Constructor
    public Junior(String name, int nf, int nc) {
        // Initialization of super-class
        super(name, nf, nc);

        System.out.println("A New Junior has been created!");
    }

    // Attend Junior
    @Override
    public void attend(int N, int L) {
        // Add N * Lj
        this.tired += (N * L);
    }

    // Print
    // It just inherits the print from Person
    // (it does the same thing)
}
