import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lero on 2020/4/25.
 */
@SuppressWarnings("unchecked")
public class StudentManager {
    private List<Student> students;
    //createList
    public void createList(){
        this.students = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
    }

    //check isEmpty
    public boolean checkEmpty(){
        if (this.students.isEmpty())
            return true;
        else
            return false;
    }

    //sort the list
    public void sortList(){
        Collections.sort(students);
    }

    //find a student by ID
    public Student findStudentByID(int studentID){
        //Student resStudent = null;
        if(!checkEmpty()){
            for (Student student : students){
                if (student.getID() == studentID){
                    return student;
                }
            }
        }
        return null;
    }

    //insert a new student
    public void insertStuddent(){
        if(students.size()>=20){
            System.out.println("No more than 20 students can be inserted into the list.");
            return;
        }
        System.out.println("Please input the studentID to insert the student:");
        Scanner in = new Scanner(System.in);
        int studentID = in.nextInt();
        Student student = findStudentByID(studentID);
        if(student != null){
            System.out.println("This student has already been inserted into the list.");
        }
        else{
            student = new Student();
            student.setID(studentID);

            System.out.println("please input the new student's name:");
            String name = in.next();

            System.out.println("please input the new student's birthday:yyyy-MM-dd");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = in.next();
            Date birDate = null;
            try{
                birDate = format.parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }

            System.out.println("Please input the new student's gender:(F/M)");
            String InputGender = in.next();
            boolean gender = true;
            if(InputGender.equals("F")){
                gender = false;
            }
            student.setName(name);
            student.setGender(gender);
            student.setBirDate(birDate);
            students.add(student);
            sortList();
        }
    }

    //delete a student by ID
    public void deleteStudent(){
        System.out.println("Please input the studentID to delete the student:");
        Scanner in = new Scanner(System.in);
        int studentID = in.nextInt();
        Student student = findStudentByID(studentID);
        if(student == null){
            System.out.println("This student doesn't exist.");
        }
        else
            this.students.remove(student);
        sortList();
    }

    //update student info
    public void updateStudent(){
        System.out.println("Please input the studentID to delete the student:");
        Scanner in = new Scanner(System.in);
        int studentID = in.nextInt();
        Student student = findStudentByID(studentID);
        if(student == null){
            System.out.println("This student doesn't exist.");
        }
        else{
            students.remove(student);
            System.out.println("please input the new student's name:");
            String name = in.next();

            System.out.println("please input the new student's birthday:yyyy-MM-dd");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = in.next();
            Date birDate = null;
            try{
                birDate = format.parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }

            System.out.println("Please input the new student's gender:(F/M)");
            String InputGender = in.next();
            boolean gender = true;
            if(InputGender.equals("F")){
                gender = false;
            }
            student.setName(name);
            student.setGender(gender);
            student.setBirDate(birDate);
            students.add(student);
        }
    }

    //check student info by ID
    public void StudentInfo(){
        System.out.println("Please input the studentID to check the student's info:");
        Scanner in = new Scanner(System.in);
        int studentID = in.nextInt();
        Student student = findStudentByID(studentID);
        if(student == null){
            System.out.println("This student doesn't exist.");
        }
        else{
            System.out.println(student.toString());
        }
    }

    //check the whole list
    public void CheckAllStudents(){
        if(checkEmpty()){
            System.out.println("No student found in this list");
        }
        else{
            for(Student student:students){
                System.out.println(student.toString());
            }
        }
    }

    //exit
    public void exit(){
        students.clear();
        System.out.println("Goodbye!");
        System.exit(0);
    }

    //prompt
    public void printPromt(){
        System.out.println("please select the option according to the following numbers:\n" +
                "**************************************\n" +
                "*            1:insert student        *\n" +
                "*            2:search student by ID  *\n" +
                "*            3:delete student by ID  *\n" +
                "*            4:update student by ID  *\n" +
                "*            5:check the list        *\n" +
                "*            6:exit                  *\n" +
                "**************************************");
    }

    //app
    public void appList(){
        createList();
        printPromt();
        Scanner in = new Scanner(System.in);
        int option;
        while (true){
            option = in.nextInt();
            if(option == 1)
                insertStuddent();
            else if(option == 2)
                StudentInfo();
            else if(option == 3)
                deleteStudent();
            else if(option == 4)
                updateStudent();
            else if(option == 5)
                CheckAllStudents();
            else
                exit();
            System.out.println();
            printPromt();
        }

    }

}
