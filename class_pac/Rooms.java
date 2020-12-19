////////////////////////////////////////
// Implementation of Room, Yard, Stairs,
// Corridor, Classroom, Floor
//////////////////////////////////////// 


// Naming package
package class_pac;


// Room
abstract class Room {
    
    Student student;

    // Constructor
    Room() {
        System.out.println("A New Room has been created!");
    }

    // Enter student in room
    void enter(Student s) {}

    // Exit student from room
    Student exit() {
        // CHECK temporary
        return null;
    }
}



// Yard
class Yard extends Room {

    // Constructor
    Yard() {
        super();

        System.out.println("A New Yard has been created!");
    }

    // Enter student in yard
    @Override
    void enter(Student s) {
        this.student = s;
        System.out.println(s.get_name() + " enters schoolyard");
    }

    // Exit student 
    @Override
    Student exit() {
        System.out.println(this.student.get_name() + " exits schoolyard");
        return this.student;
    }
}



// Stairs
class Stairs extends Room {

    // Constructor
    Stairs() {
        super();

        System.out.println("A New Stairs has been created!");
    }

    // Enter student in stairs
    @Override
    void enter(Student s) {
        this.student = s;
        System.out.println(s.get_name() + " enters stairs");
    }

    // Exit student from stairs
    @Override
    Student exit() {
        System.out.println(this.student.get_name() + " exits stairs");
        return this.student;
    }
}



// Corridor
class Corridor extends Room {

    // Constructor
    Corridor() {
        super();

        System.out.println("A New Corridor has been created!");
    }

    // Enter student in corridor
    @Override
    void enter(Student s) {
        this.student = s;
        System.out.println(s.get_name() + " enters corridor");
    }

    // Exit student from corridor
    @Override
    Student exit() {
        System.out.println(this.student.get_name() + " exits corridor");
        return this.student;
    }
}



// Classroom
class Classroom {

    private int no;

    private Teacher teacher;
    private Student[] students;
    private int size;

    private int Cclass;


    // Constructor
    Classroom(int no, int Cclass) {
        this.no = no;
        this.size = 0;
        this.Cclass = Cclass;

        students = new Student[Cclass];
        teacher = null;

        System.out.println("A New Classroom has been created!");
    }

    // Enter student in classroom
    void enter(Student s) {
        if (size < Cclass) {
            s.set_cls();
            this.students[size] = s;
            this.size++;
        }

        System.out.println(s.get_name() + " enters classroom");
    }

    // Place teacher in classroom
    void place(Teacher t) {
        this.teacher = t;
        t.get_in();

        System.out.println(t.get_name() + " places in classroom");
    }

    // Operate classroom
    void operate(int N, int Lj, int Ls, int Lt) {
        if (teacher != null) this.teacher.teach(N, Lt);

        for (int i=0 ; i<size ; ++i) {
            if (students[i].get_cls() < 3) students[i].attend(N, Lj);
            else students[i].attend(N, Ls);
        }
    }

    // Get Cclass
    int get_ccls() { return this.Cclass; }

    // Print
    void print() {
        System.out.println("People in class " + no + " are: ");
        
        for (int i=0 ; i<size ; ++i) students[i].print();

        if (teacher != null) teacher.print();
    }

}



// Floor
class Floor {
    
    private int no;

    private Classroom[] classes;
    private Corridor corridor;


    // Constructor
    Floor(int no, int Cclass) {
        this.no = no;
        this.classes = new Classroom[6];
        this.corridor = new Corridor();

        for (int i=0 ; i<6 ; ++i) classes[i] = new Classroom(i, Cclass);
        
        System.out.println("A New Floor has been created!");
    }

    // Enter student in Floor
    void enter(Student s) {
        System.out.println(s.get_name() + " enters floor");

        corridor.enter(s);
        s = corridor.exit();

        classes[s.get_cls()].enter(s);
    }

    // Place teacher in floor
    void place(Teacher t) {
        this.classes[t.get_cls()].place(t);
    }

    // Operate floor
    void operate(int N, int Lj, int Ls, int Lt) {
        for (int i=0 ; i<6 ; ++i) {
            classes[i].operate(N, Lj, Ls, Lt);
        }
    }

    // Get Cclass
    int get_ccls() { return this.classes[0].get_ccls(); }

    // Print
    void print() {
        System.out.println("Floor number " + no + " contains:");

        for (int i=0 ; i<6 ; ++i) classes[i].print();
    }
}


