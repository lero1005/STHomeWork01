import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
/*
Do not use wildcards after 'import'
import java.util.*;
*/
/**
 * Created by lero on 2020/4/25.
 */
@SuppressWarnings("unchecked")
public class StudentManager {
    /*
    #27:
     */
    private List<Student> students;
    private final int MAXV = 20;
    //createList
    /*
    #14£º
    public void createList(){
     */
    public void createList() {
        this.students = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
    }


    /* #1:
       #18:
       #14:
       #60:
    public boolean checkEmpty(){
        if (this.students.isEmpty())
            return true;
        else
            return false;
    }
    */
    //check isEmpty
    public boolean isEmpty() {
        if (this.students.isEmpty()) {
            return true;
        }
        return false;

    }

    //sort the list
    /*
    #14:
    public void sortList(){
     */
    public void sortList() {
        Collections.sort(students);
    }


    /*
    #14:
    public Student findStudentByID(int studentID){
    #36:
    if(!isEmpty()) {
            for (Student student : students) {
                if (student.getID() == studentID) {
                    return student;
                }
            }
        }
        return null;
     */
    //find a student by ID
    public Student findStudentByID(int studentID) {
        Student resStudent = null;
        if (!isEmpty()) {
            for (Student student : students) {
                if (student.getID() == studentID) {
                    resStudent = student;
                    break;
                }
            }
        }
        return resStudent;
    }

    /*
    #14:
    #18:
    #36:
    #27:
    #34:
    #4:
    #65:
    public void insertStuddent() {
    if(students.size()>=20){
    if(student != null){
    else{
    try{
    if(InputGender.equals("F")){
    #45/#49:
    int studentID = in.nextInt();
    String name = in.next();
    String date = in.next();
    String InputGender = in.next();
     */
    //insert a new student
    public void insertStuddent() {
        //check if the list is full
        if (students.size() >= MAXV) {
            System.out.println("No more than 20 students can be inserted into the list.");
            return;
        }

        //get studentID, and make sure every student's ID is valid and unique
        System.out.println("Please input the studentID to insert the student:");
        Scanner in = new Scanner(System.in);
        int studentID;
        try {
            studentID = in.nextInt();
        }catch (Exception e) {
            studentID = -1;
            System.out.println("Please input a positive integer.");
            return;
        }
        if (studentID <= 0) {
            System.out.println("Please input an positive integer.");
            return;
        }

        Student student = findStudentByID(studentID);
        if (student != null) {
            System.out.println("This student has already been inserted into the list.");
            return;
        }

        //get the new student's name
        System.out.println("please input the new student's name:");
        String name = in.next();

        //get the new student's birthday in correct format
        System.out.println("please input the new student's birthday:yyyy-MM-dd");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = in.next();
        Date birDate = null;
        try {
            birDate = format.parse(date);
        } catch (ParseException e) {
            System.out.println("The format of birthday must be yyyy-MM-dd");
            return;
        }

        //get the new student's gender in correct format
        System.out.println("Please input the new student's gender:(F/M)");
        String InputGender = in.next();
        boolean gender;
        if (InputGender.equals("F")) {
            gender = false;
        } else if (InputGender.equals("M")) {
            gender = true;
        } else {
            System.out.println("The new student's gender must be F or M");
            return;
        }

        //insert the new student's info into the list
        Student newStudent = new Student();
        System.out.println(studentID);
        newStudent.setID(studentID);
        newStudent.setName(name);
        newStudent.setGender(gender);
        newStudent.setBirDate(birDate);
        students.add(newStudent);
        sortList();


    }

    /*
    #4:
    #14:
    public void deleteStudent(){
    if(student == null){
    }
    else{
    #45/#49:
    int studentID = in.nextInt();
     */
    //delete a student by ID
    public void deleteStudent() {
        ////get studentID and check if it is valid
        System.out.println("Please input the studentID to delete the student:");
        Scanner in = new Scanner(System.in);
        int studentID;
        try {
            studentID = in.nextInt();
        }catch (Exception e) {
            System.out.println("Please input a positive integer.");
            return;
        }

        //check if the student is in the list
        Student student = findStudentByID(studentID);
        if (student == null) {
            System.out.println("This student doesn't exist.");
        } else {
            this.students.remove(student);
        }
        sortList();
    }


    /*
    #4:
    #14:
    #34:
    #56:
    public void updateStudent(){
    if(student == null){
    else{
    try{
                birDate = format.parse(date);
            }catch(ParseException e){
                e.printStackTrace();
            }
     #45/#49:
     int studentID = in.nextInt();
     */
    //update student info
    public void updateStudent() {
        //get studentID and check if it is valid
        System.out.println("Please input the studentID to delete the student:");
        Scanner in = new Scanner(System.in);
        int studentID;
        try {
            studentID = in.nextInt();
        }catch (Exception e) {
            System.out.println("Please input a postive integer.");
            return;
        }

        //check if the student is in the list
        Student student = findStudentByID(studentID);
        if (null == student) {
            System.out.println("This student doesn't exist.");
            return;
        }
        //students.remove(student);
        //get the new student's name
        System.out.println("please input the new student's name:");
        String name = in.next();

        //get the new student's birthday in correct format
        System.out.println("please input the new student's birthday:yyyy-MM-dd");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = in.next();
        Date birDate = null;
        try {
            birDate = format.parse(date);
        } catch (ParseException e) {
            System.out.println("The format of birthday must be yyyy-MM-dd");
            return;
        }

        //get the new student's gender in correct format
        System.out.println("Please input the new student's gender:(F/M)");
        String InputGender = in.next();
        boolean gender;
        if (InputGender.equals("F")) {
            gender = false;
        } else if (InputGender.equals("M")) {
            gender = true;
        } else {
            System.out.println("The new student's gender must be F or M");
            return;
        }

        //update the student's info
        student.setID(studentID);
        student.setName(name);
        student.setGender(gender);
        student.setBirDate(birDate);
    }


    /*
    #4:
    #14:
    #34:
    public void StudentInfo(){
    if(student == null){
    else{
    #45/#49:
     int studentID = in.nextInt();
     */
    //check student info by ID
    public void StudentInfo() {
        //get studentID and check if it is valid
        System.out.println("Please input the studentID to check the student's info:");
        Scanner in = new Scanner(System.in);
        int studentID;
        try {
            studentID = in.nextInt();
        }catch (Exception e) {
            System.out.println("Please input a postive integer.");
            return;
        }

        //check if the student is in the list
        Student student = findStudentByID(studentID);
        if (null == student) {
            System.out.println("This student doesn't exist.");
        } else {
            System.out.println(student.toString());
        }
    }

    /*
    #14:
    public void CheckAllStudents(){
    if(isEmpty()){
     } else{
     for(Student student:students){
     */
    //check the whole list
    public void CheckAllStudents() {
        if (isEmpty()) {
            System.out.println("No student found in this list");
        } else {
            for (Student student:students) {
                System.out.println(student.toString());
            }
        }
    }

    /*
    #14:
    public void exit(){
     */
    //exit
    public void exit() {
        students.clear();
        System.out.println("Goodbye!");
        System.exit(0);
    }

    /*
    #14:
    public void printPromt(){
     */
    //prompt
    public void printPromt() {
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

    //getOption
    public int getOption() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        try{
            option = in.nextInt();
        } catch (Exception e) {
            option = -1;
            return option;
        }
        return option;
    }


    /*
    #14:
    appList(){
    while (true){
    if(option == 1){
    else if(option == 2){
    else if(option == 3){
    else if(option == 4){
    else if(option == 5){
    else if(option == 2){
    else{
    #45/#49:
    #56:
    option = in.nextInt();
     */
    //app
    public void appList() {
        createList();
        printPromt();
        Scanner in = new Scanner(System.in);
        int option;

        while (true) {
            option = getOption();

            if (option == 1) {
                insertStuddent();
            } else if (option == 2) {
                StudentInfo();
            } else if (option == 3) {
                deleteStudent();
            } else if (option == 4) {
                updateStudent();
            } else if (option == 5) {
                CheckAllStudents();
            } else if (option == 6) {
                exit();
            } else {
                System.out.println("Please input an integer from 1-6.");
            }

            System.out.println();
            printPromt();
        }

    }

}
