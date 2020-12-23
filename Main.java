///////////////////////////////////////
// Main function to run iImplementations
///////////////////////////////////////



// Import Random for random selection
// of students-teachers
import java.util.Random;


// Import local package
import class_pac.*;


public class Main {
    
    // Main Function
    public static void main(String[] args) {
        
        // Get parameters
        int Cclass = Integer.parseInt(args[0]);
        int Lj = Integer.parseInt(args[1]);
        int Ls = Integer.parseInt(args[2]);
        int Lt = Integer.parseInt(args[3]);
        int N = Integer.parseInt(args[4]);


        // Create school
        School school = new School(Lj, Ls, Lt, Cclass);


        // Create Students and Teachers
        int size_stud = Cclass * 3 * 6;
        Student[] students = new Student[size_stud];
        int nf = 0;

        for (int i=0 ; i<size_stud ; ++i) {
            if (i % 6 == 0 && i != 0) nf++;

            if (i%6 < 3) students[i] = new Junior("Junior_name" + i, nf%3, i%6);
            else students[i] = new Senior("Senior_name" + i, nf%3, i%6);            
        }

        int size_teacher = 3 * 6;
        Teacher[] teachers = new Teacher[size_teacher];
        nf = 0;

        for (int i=0 ; i<size_teacher ; ++i) {
            if (i % 6 == 0 && i != 0) nf++;

            teachers[i] = new Teacher("Teacher_name" + i, nf, i%6);
        }

        // Creating rand
        Random rand = new Random();
        int i = 0;
        int j = 0;
        boolean stud;

        // Loop to get students and teachers
        // random in their classes
        while (true) {
            if (rand.nextInt(2) % 2 == 0) {
                if (i >= size_stud) {
                    stud = false;
                    break;
                }

                school.enter(students[i]);
                ++i;
            }
            else {
                if (j >= size_teacher) {
                    stud = true;
                    break;
                }

                school.place(teachers[j]);
                ++j;
            }
        }

        // If there are students to enter school
        if (stud) {
            for (int k=i ; k<size_stud ; ++k) {
                school.enter(students[k]);
            }
        }
        // If there are teachers to enter school
        else {
            for (int k=j ; k<size_teacher ; ++k) {
                school.place(teachers[k]);
            }
        }

        
        // School should operate for N hours
        school.operate(N);


        // Print out School
        school.print();
        

        // Empty School
        school.empty();
    }
}
