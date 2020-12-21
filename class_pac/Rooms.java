////////////////////////////////////////
// Implementation of Room, Yard, Stairs,
// Corridor, Classroom, Floor
//////////////////////////////////////// 


// Naming package
package class_pac;



// Room
abstract class Room {
    Student student;    // Temporary save of Student in Room

    // Constructor
    Room() {
        this.student = null;
        System.out.println("A New Room has been created!");
    }

    // Enter student in room
    // It will be written in children
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
        // Initialization of super-class
        super();

        System.out.println("A New Yard has been created!");
    }

    // Enter student in yard
    @Override
    void enter(Student s) {
        // Temp save of Student
        this.student = s;
        System.out.println(s.get_name() + " enters schoolyard");
    }

    // Exit student 
    @Override
    Student exit() {
        // Return Student
        System.out.println(this.student.get_name() + " exits schoolyard");
        return this.student;
    }
}



// Stairs
class Stairs extends Room {
    // Constructor
    Stairs() {
        // Initialization of super-class
        super();

        System.out.println("A New Stairs has been created!");
    }

    // Enter student in stairs
    @Override
    void enter(Student s) {
        // Temp save of Student
        this.student = s;
        System.out.println(s.get_name() + " enters stairs");
    }

    // Exit student from stairs
    @Override
    Student exit() {
        // Return Student
        System.out.println(this.student.get_name() + " exits stairs");
        return this.student;
    }
}



// Corridor
class Corridor extends Room {
    // Constructor
    Corridor() {
        // Initialization of super-class
        super();

        System.out.println("A New Corridor has been created!");
    }

    // Enter student in corridor
    @Override
    void enter(Student s) {
        // Temp save of Student
        this.student = s;
        System.out.println(s.get_name() + " enters corridor");
    }

    // Exit student from corridor
    @Override
    Student exit() {
        // Return Student
        System.out.println(this.student.get_name() + " exits corridor");
        return this.student;
    }
}



// Classroom
class Classroom {
    private int no;             // Number of classroom

    private Teacher teacher;    // Teacher of classroom
    private Student[] students; // Array of Students in classroom
    private int size;           // Size of the array

    private int Cclass;         // Capacity of Array

    // Constructor
    Classroom(int no, int Cclass) {
        // Initialization
        this.no = no;
        this.size = 0;
        this.Cclass = Cclass;

        students = new Student[Cclass];
        teacher = null;

        System.out.println("A New Classroom has been created!");
    }

    // Enter student in classroom
    void enter(Student s) {
        // If classroom is full
        if (size < Cclass) return;
            
        s.set_in();
        this.students[size] = s;
        this.size++;

        System.out.println(s.get_name() + " enters classroom");
    }

    // Exit student from classroom
    Student exit() {
        // If class is empty
        if (size <= 0) return null;

        Student s = students[--size];
        s.set_out();

        System.out.println(s.get_name() + " starts exiting");
        System.out.println(s.get_name() + " exits classroom");
        return s;
    }

    // Place teacher in classroom
    void place(Teacher t) {
        // Teacher instant placement
        this.teacher = t;
        t.get_in();

        System.out.println(t.get_name() + " places in classroom");
    }

    // Teacher_out
    Teacher teacher_out() {
        // If there is no teacher in classroom
        if (teacher == null) return null;

        System.out.println(teacher.get_name() + " teacher is out");

        // Return teacher
        teacher.set_out();
        return teacher;
    }

    // Operate classroom
    void operate(int N, int Lj, int Ls, int Lt) {
        // If there is a teacher
        if (teacher != null) this.teacher.teach(N, Lt);

        // For students in classroom
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
    private int no;                 // Number of Floor

    private Classroom[] classes;    // Classrooms of Floor
    private Corridor corridor;      // Corridod of Floor

    // Constructor
    Floor(int no, int Cclass) {
        // Initialization
        this.no = no;
        this.classes = new Classroom[6];
        this.corridor = new Corridor();

        for (int i=0 ; i<6 ; ++i) classes[i] = new Classroom(i, Cclass);
        
        System.out.println("A New Floor has been created!");
    }

    // Enter student in floor
    void enter(Student s) {
        System.out.println(s.get_name() + " enters floor");

        // Get Student in Corridor and then out
        corridor.enter(s);
        s = corridor.exit();

        classes[s.get_cls()].enter(s);
    }

    // Exit student from floor
    Student exit(int cls_no) {
        Student s = classes[cls_no].exit();

        // Get Student in Corridor and then out
        corridor.enter(s);
        s = corridor.exit();

        return s;
    }

    // Place teacher in floor
    void place(Teacher t) {
        this.classes[t.get_cls()].place(t);
    }

    // Teacher_out
    Teacher teacher_out(int cls_no) {
        return this.classes[cls_no].teacher_out();
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
