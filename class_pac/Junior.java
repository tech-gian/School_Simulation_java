///////////////////////////
// Implementation of Junior
///////////////////////////


// Naming package
package class_pac;


// Junior
public class Junior extends Student {
    
    // Constructor
    public Junior(String name, int nf, int nc) {
        super(name, nf, nc);

        System.out.println("A New Junior has been created!");
    }

    // Attend Junior
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
