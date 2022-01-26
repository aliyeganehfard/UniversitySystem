package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//      default value
        TrainingEmployeeList trainingEmployeeList = new TrainingEmployeeList();
        trainingEmployeeList.add("mohammad", "mohammadi", "5865468445", "2000-02-02", "admin", "admin");

        StudentList studentList = new StudentList();
        studentList.add("ali", "yegane", "2500555555", "2002-02-02", "COMPUTER");
        studentList.add("majid", "majidi", "2500562078", "2008-03-02", "COMPUTER");

        ProfessorList professorList = new ProfessorList();
        professorList.add("hossai", "yegane", "2500000000", "2000-11-11", "SCIENCE_COMMITTEE");
        professorList.add("omid", "jafari", "2500000001", "2000-11-11", "SCIENCE_COMMITTEE");

        CourseList courseList = new CourseList();
        courseList.add("1", "COMPUTER", "java", "4", "2500000000");
        courseList.add("2", "COMPUTER", "c#", "4", "2500000000");
        courseList.add("3", "COMPUTER", "scala", "24", "2500000001");
        courseList.add("4", "COMPUTER", "c++", "4", "2500000001");


        ScoreList scoreList = new ScoreList();
        System.out.println("------------ trainingEmployeeList Information ------------");
        trainingEmployeeList.showList();
        System.out.println();
        System.out.println("------------ student Information ------------");
        studentList.showList();
        System.out.println();
        System.out.println("------------ professor Information ------------");
        professorList.showList();
        System.out.println();
        Scanner scn = new Scanner(System.in);
        boolean flag = false;
        boolean state = true;
        int permission = -1;
        String tempTerm = "";
        String id = "";
        String commendLine;
        String[] commend;
        while (state) {
            printLoginForm();
            commendLine = scn.nextLine().trim();
            commend = commendLine.split(" ");
            if (commend[0].equals("login")) {
                if (trainingEmployeeList.login(commend[1], commend[2])) {
                    id = commend[2];
                    permission = 1;
                    flag = true;
                    printTrainingEmployeeCommend();
                } else if (studentList.login(commend[1], commend[2])) {
                    id = commend[1];
                    permission = 2;
                    flag = true;
                    printStudentCommend();
                } else if (professorList.login(commend[1], commend[2])) {
                    id = commend[1];
                    permission = 3;
                    flag = true;
                    printProfessorCommend();
                } else {
                    System.out.println("wrong userName or password!");
                }
            }

            while (flag) {
                switch (permission) {
                    case 1:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "registerStudent":
                                studentList.add(commend[1], commend[2], commend[3], commend[4], commend[5]);
                                break;
                            case "deleteStudent":
                                studentList.delete(commend[1]);
                                break;
                            case "editStudent":
                                studentList.edit(commend[1], commend[2], commend[3], commend[4]);
                                break;
                            case "registerProfessor":
                                professorList.add(commend[1], commend[2], commend[3], commend[4], commend[5]);
                                break;
                            case "deleteProfessor":
                                professorList.delete(commend[1]);
                                break;
                            case "editProfessor":
                                professorList.edit(commend[1], commend[2], commend[3], commend[4]);
                                break;
                            case "registerTrainingEmployee":
                                trainingEmployeeList.add(commend[1], commend[2], commend[3], commend[4], commend[5], commend[6]);
                                break;
                            case "deleteTrainingEmployee":
                                trainingEmployeeList.delete(commend[1]);
                                break;
                            case "editTrainingEmployee":
                                trainingEmployeeList.edit(commend[1], commend[2], commend[3], commend[4]);
                                break;
                            case "addCourse":
                                courseList.add(commend[1], commend[2], commend[3], commend[4], commend[5]);
                                break;
                            case "deleteCourse":
                                courseList.delete(commend[1]);
                                break;
                            case "editCourse":
                                courseList.edit(commend[1], commend[2], commend[3], commend[4]);
                                break;
                            case "salary":
                                System.out.println(trainingEmployeeList.showSalary());
                                break;
                            case "showStudentList":
                                studentList.showList();
                                break;
                            case "showProfessorList":
                                professorList.showList();
                                break;
                            case "showTrainingEmployeeList":
                                trainingEmployeeList.showList();
                                break;
                            case "showCourseList":
                                courseList.showList();
                                break;
                            case "help":
                                printTrainingEmployeeCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                    case 2:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "showProfile":
                                studentList.showStudentProfile(id);
                                break;
                            case "showCoursesList":
                                courseList.showDepartmentCourse(studentList.getDepartment(id));
                                break;
                            case "selectUnit":
                                String[] courses = new String[commend.length - 2];
                                for (int i = 2; i < commend.length; i++) {
                                    courses[i - 2] = commend[i];
                                }
                                tempTerm = commend[1];
                                Integer unit = courseList.getUnit(courses);
                                studentList.addTerm(id, commend[1], courses , unit);
                                break;
                            case "showSelectedCourses":
                                courseList.showStudentCourses(studentList.getStudentCoursesID(id,tempTerm) );
                                String n = studentList.getNationalCode(id);
                                scoreList.showStudentScores(n);
                                studentList.setGrade(id,scoreList.getGradPointAverage(n));

                                studentList.getGrade(id);
                                break;
                            case "help":
                                printStudentCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "showProfile":
                                professorList.showProfessorProfile(id);
                                break;
                            case "showCourses":
                                courseList.showProfessorCourses(professorList.getNationalCode(id));
                                break;
                            case "showStudent":
                                studentList.showList();
                                break;
                            case "setScore":
                                scoreList.add(commend[1], commend[2], id, commend[3]);
                                break;
                            case "showSalary":
                                String nationalCode = professorList.getNationalCode(id);
                                System.out.println(professorList.getProfessorSalary(id, courseList.getProfessorUnit(nationalCode, studentList.getTerm(commend[1]))));
                                break;
                            case "help":
                                printProfessorCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                }

            }
        }
    }

    public static void printLoginForm() {
        System.out.println("login userName password \t {user name => studentCode || professorCode && password => nationalCode}");
        System.out.print("commend : ");
    }

    public static void printTrainingEmployeeCommend() {
        System.out.println("registerStudent firstName LastName nationalCode birthDate department");
        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteStudent studentCode");
        System.out.println("editStudent studentCode newFirstName newLastName newNationalCode");
        System.out.println("registerProfessor firstName LastName nationalCode birthDate status");
        System.out.println("{ status => SCIENCE_COMMITTEE , TUITION_FEE}");
        System.out.println("deleteProfessor professorCode");
        System.out.println("editProfessor professorCode newFirstName newLastName newNationalCode");
        System.out.println("registerTrainingEmployee firstName LastName nationalCode birthDate userName password");
        System.out.println("deleteTrainingEmployee TrainingEmployeeCode ");
        System.out.println("editTrainingEmployee TrainingEmployeeCode newFirstName newLastName newNationalCode");
        System.out.println("addCourse courseCode department courseName unit professorNationalCode");
        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteCourse courseCode");
        System.out.println("editCourse courseCode newCourseName newUnit newProfessorNationalCode");
        System.out.println("salary");
        System.out.println("showStudentList");
        System.out.println("showProfessorList");
        System.out.println("showTrainingEmployeeList");
        System.out.println("showCourseList");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");

    }

    public static void printStudentCommend() {
        System.out.println("showProfile");
        System.out.println("showCoursesList");
        System.out.println("selectUnit term courseCode... \t{ selectUnit 1-95 1 2 \" you can write multi course id \" }");
        System.out.println("showSelectedCourses  \t {show selected course & score & grad point average }");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

    public static void printProfessorCommend() {
        System.out.println("showProfile");
        System.out.println("showCourses");
        System.out.println("showStudent");
        System.out.println("setScore courseCode studentNationalCode score");
        System.out.println("showSalary term");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

}
