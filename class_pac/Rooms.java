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


