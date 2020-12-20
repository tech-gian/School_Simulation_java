///////////////////////////
// Implementation of Senior
///////////////////////////


// Naming package
package class_pac;


// Senior
public class Senior extends Student {
    
    // Constructor
    public Senior(String name, int nf, int nc) {
        super(name, nf, nc);

        System.out.println("A New Senior has been created!");
    }

    // Attend Senior
    @Override
    public void attend(int N, int L) {
        this.tired += (N * L);
    }

    // Print
    // CHECK maybe you should just inherit
    @Override
    public void print() {
        super.print();
    }
}
