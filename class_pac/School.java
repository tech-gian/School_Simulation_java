///////////////////////////
// Implementation of School
///////////////////////////


// Naming package
package class_pac;


// School
public class School {
    
    private Floor[] floors;
    private Yard yard;
    private Stairs stairs;

    private int Lj;
    private int Ls;
    private int Lt;


    // Constructor
    public School(int Lj, int Ls, int Lt, int Cclass) {
        this.Lj = Lj;
        this.Ls = Ls;
        this.Lt = Lt;

        yard = new Yard();
        stairs = new Stairs();
        floors = new Floor[3];
        for (int i=0 ; i<3 ; ++i) floors[i] = new Floor(i, Cclass);

        System.out.println("A New School has been created!");
    }

    // Enter student in school
    public void enter(Student s) {
        System.out.println(s.get_name() + " enters school");

        yard.enter(s);
        s = yard.exit();

        stairs.enter(s);
        s = stairs.exit();

        floors[s.get_flo()].enter(s);
    }

    // Place teacher in school
    public void place(Teacher t) {
        this.floors[t.get_flo()].place(t);
    }

    // Operate school
    public void operate(int N) {
        for (int i=0 ; i<3 ; ++i) floors[i].operate(N, Lj, Ls, Lt);
    }

    // Print
    public void print() {
        System.out.println("School life consists of:");

        for (int i=0 ; i<3 ; ++i) floors[i].print();
    }

    // Empty school
    public void empty() {
        for (int i=0 ; i<3 ; ++i) {
            for (int j=0 ; j<floors[i].get_ccls() ; ++j) {
                Student s = floors[i].exit(j/6);

                stairs.enter(s);
                s = stairs.exit();

                yard.enter(s);
                s = yard.exit();

                // CHECK everything and write for teachers
                // CHECK j/6, it is wrong
            }
        }
    }
}
