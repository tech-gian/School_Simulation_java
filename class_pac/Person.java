///////////////////////////////////////
// Implementation of Person and Student
// ////////////////////////////////////


// Naming package
package class_pac;


// Person
abstract class Person {
    // Private variables
    private String name;    // Person's name
    private int no_flo;     // Person's floor_number
    private int no_cls;     // Person's classroom_number

    // Package's variables
    boolean in_cls;
    int tired;


    // Constructor
    Person(String name, int nf, int nc) {
        // Initialization
        this.name = name;
        this.no_flo = nf;
        this.no_cls = nc;

        in_cls = false;
        tired = 0;

        System.out.println("A New Person has been created!");
    }


    // Print
    public void print() {
        System.out.println(this.name + " " + this.tired);
    }


    // Get name
    String get_name() { return this.name; }
    // Get no_flo
    int get_flo() { return this.no_flo; }
    // Get no_cls
    int get_cls() { return this.no_cls; }
    // Get in_cls
    boolean get_in() { return this.in_cls; }
    // Get tired
    int get_tired() { return this.tired; }

    // Set in_cls
    void set_in() { this.in_cls = true; }
    // Set out_cls
    void set_out() { this.in_cls = false; }
}
