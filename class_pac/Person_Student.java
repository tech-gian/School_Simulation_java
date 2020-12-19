///////////////////////////////////////
// Implementation of Person and Student
// ////////////////////////////////////


// Naming package
package class_pac;


// Person
abstract class Person {
    // Private variables
    private String name;
    private int no_flo;
    private int no_cls;

    // Package's variables
    boolean in_cls;
    int tired;


    // Constructor
    Person(String name, int nf, int nc) {
        this.name = name;
        this.no_flo = nf;
        this.no_cls = nc;

        in_cls = false;
        tired = 0;

        System.out.println("A New Person has been created!");
    }


    // Print
    void print() {
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
    void set_cls() { this.in_cls = true; }
}



// Student
abstract class Student extends Person {

    // Constructor
    Student(String name, int nf, int nc) {
        super(name, nf, nc);

        System.out.println("A New Student has been created!");
    }

    // Attend
    void attend(int N, int L) {}

    // CHECK it doesnt need
    // Print
    // @Override
    // void print()
    //     super.print()
}
