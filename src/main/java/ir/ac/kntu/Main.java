package ir.ac.kntu;

import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Filename:  Main.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */
public class Main {
    /**
     * edit student method
     */
    public void editStudent() {
        System.out.println("Enter student id:");
        Scanner scanner = new Scanner(System.in);
        Student student = Data.getInstance().searchForStudent(scanner.nextLine());
        ArrayList<Student> students = Data.getInstance().getConfigStudent();
        students.remove(student);
        System.out.println("what do you want to edit:");
        System.out.println("*name[1]");
        System.out.println("*family name[2]");
        System.out.println("*id[3]");
        System.out.println("*pass[4]");
        System.out.println("*obtained course[5]");
        System.out.println("Marks[6]");
        int menu = Integer.parseInt(scanner.nextLine());
        if (menu == 1) {
            System.out.println("enter the name:");
            student.setName(scanner.nextLine());
        } else if (menu == 2) {
            System.out.println("enter the family name:");
            student.setFamilyName(scanner.nextLine());
        } else if (menu == 3) {
            System.out.println("enter the id:");
            student.setId(scanner.nextLine());
        } else if (menu == 4) {
            System.out.println("enter the pass:");
            student.setPassword(scanner.nextLine());
        } else if (menu == 5) {
            student.printCourses();
            System.out.println("*add[1]");
            System.out.println("*remove[2]");
            int enter = Integer.parseInt(scanner.nextLine());
            if (enter == 1) {
                System.out.println("enter course ID:");
                student.addingCourse(Data.getInstance().searchForCourse(Integer.parseInt(scanner.nextLine())));
            } else if (enter == 2) {
                System.out.println("enter course ID:");
                student.removeCourse(Integer.parseInt(scanner.nextLine()));
            }
        } else if (menu == 6) {
            System.out.println("Enter course ID");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter grade");
            student.getObtainedCoursesMarks().put(Data.getInstance().searchForCourse(id),
                    Integer.parseInt(scanner.nextLine()));
        }
        student.update();
        students.add(student);
        Data.getInstance().setConfigStudent(students);

    }

    /**
     * edit professor method
     */
    public void editProfessor() {
        System.out.println("Enter professor id:");
        Scanner scanner = new Scanner(System.in);
        Professor professor = Data.getInstance().searchForProfessor(scanner.nextLine());
        ArrayList<Professor> professors = Data.getInstance().getConfigProfessor();
        professors.remove(professor);
        System.out.println("what do you want to edit:");
        System.out.println("*name[1]");
        System.out.println("*family name[2]");
        System.out.println("*id[3]");
        System.out.println("*pass[4]");
        int menu = Integer.parseInt(scanner.nextLine());
        if (menu == 1) {
            System.out.println("enter the name:");
            professor.setName(scanner.nextLine());
        } else if (menu == 2) {
            System.out.println("enter the family name:");
            professor.setFamilyName(scanner.nextLine());
        } else if (menu == 3) {
            System.out.println("enter the id:");
            professor.setId(scanner.nextLine());
        } else if (menu == 4) {
            System.out.println("enter the pass:");
            professor.setPassword(scanner.nextLine());
        }

        professors.add(professor);
        Data.getInstance().setConfigProfessor(professors);
    }

    /**
     * edit course method
     */
    public void editCourse() {
        System.out.println("Enter course id:");
        Scanner scanner = new Scanner(System.in);
        CourseGroup courseGroup = Data.getInstance().searchForCourse(Integer.parseInt(scanner.nextLine()));
        ArrayList<CourseGroup> courseGroups = Data.getInstance().getConfigCourses();
        courseGroups.remove(courseGroup);
        System.out.println("what do you want to edit:");
        System.out.println("*Course Group Number[1]");
        System.out.println("*Semester Number[2]");
        System.out.println("*id[3]");
        System.out.println("*title[4]");
        System.out.println("*sits[5]");
        int menu = Integer.parseInt(scanner.nextLine());
        if (menu == 1) {
            System.out.println("Enter Course Group Number:");
            courseGroup.setCourseGroupNumber(Integer.parseInt(scanner.nextLine()));
        } else if (menu == 2) {
            System.out.println("Enter semester Number:");
            courseGroup.setSemesterNumber(Integer.parseInt(scanner.nextLine()));
        } else if (menu == 3) {
            System.out.println("id:");
            courseGroup.setId(Integer.parseInt(scanner.nextLine()));
        } else if (menu == 4) {
            System.out.println("title:");
            courseGroup.setTitle(scanner.nextLine());
        } else if (menu == 5) {
            System.out.println("sits:");
            courseGroup.setSits(Integer.parseInt(scanner.nextLine()));
        }
        courseGroups.add(courseGroup);
        Data.getInstance().setConfigCourses(courseGroups);

    }

    public static void main(String[] args) {
        Main main = new Main();
        //  data initial config
        Admin admin = new Admin();
        OnlineClass configCourse1 = new OnlineClass(10001, "mathematics1");
        configCourse1.setSits(2);
        HashMap<String, String> schedule = new HashMap<>();
        schedule.put("saturday", "13");
        configCourse1.setSchedule(schedule);
        ClassicClass configCourse2 = new ClassicClass(10002, "electronics1");
        configCourse2.setPlace(Places.roof);
        configCourse2.setSits(1);
        schedule.put("saturday", "14");
        configCourse2.setSchedule(schedule);
        ClassicClass configCourse3 = new ClassicClass(10003, "electronics2");
        configCourse3.setPlace(Places.class101);
        HashMap<String, String> schedule2 = new HashMap<>();
        schedule2.put("monday", "14");
        configCourse3.setSchedule(schedule2);
        configCourse3.setSits(1);
        ArrayList<CourseGroup> configCourse = new ArrayList<>();
        configCourse.add(configCourse1);
        configCourse.add(configCourse2);
        configCourse.add(configCourse3);
        //config courses
        Data.getInstance().setConfigCourses(configCourse);
        ArrayList<CourseGroup> student1Courses = new ArrayList<>();
        student1Courses.add(configCourse1);
        student1Courses.add(configCourse2);
        Student student1 = new Student();
        student1.setId("9625183222");
        student1.setPassword("asdfg");
        student1.setName("Atoosa");
        student1.setFamilyName("Ayazbakhsh");
        student1.setObtainedCourses(student1Courses);
        ArrayList<Student> configStudents = new ArrayList<>();
        student1.update();
        configStudents.add(student1);
        //config student
        Data.getInstance().setConfigStudent(configStudents);
        Professor professor1 = new Professor();
        professor1.setFamilyName("Aghaii");
        professor1.setId("2");
        professor1.setPassword("a");
        professor1.setName("Ahmad");
        ArrayList<CourseGroup> professor1courses = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        professor1courses.add(configCourse1);
        professor1courses.add(configCourse2);
        professor1courses.add(configCourse3);
        professor1.setObtainedCourses(professor1courses);
        professors.add(professor1);
        //config professors
        Data.getInstance().setConfigProfessor(professors);
        admin.syncCourses();
        admin.changeSits(configCourse1);
        admin.changeSits(configCourse2);
        String path = "request.txt";
        //food reservation
        Lunch hotdog = new Lunch();
        hotdog.setName("HotDog");
        hotdog.setType(Type.MainCourse);
        hotdog.setPlace(PlacesFood.Faculty);
        hotdog.setPrice(100);

        Lunch burger = new Lunch();
        burger.setName("Burger");
        burger.setType(Type.MainCourse);
        burger.setPlace(PlacesFood.Dorm);
        burger.setPrice(90);

        Lunch soda = new Lunch();
        soda.setName("soda");
        soda.setType(Type.Drink);
        soda.setPlace(PlacesFood.Dorm);
        soda.setPrice(20);

        Lunch dugh = new Lunch();
        dugh.setName("dugh");
        dugh.setType(Type.Drink);
        dugh.setPlace(PlacesFood.Dorm);
        dugh.setPrice(15);

        Lunch lettuce = new Lunch();
        lettuce.setName("lettuce");
        lettuce.setType(Type.Salad);
        lettuce.setPlace(PlacesFood.Faculty);
        lettuce.setPrice(30);

        Breakfast traditional = new Breakfast();
        traditional.setName("sonnati irani");
        traditional.setPlace(PlacesFood.Dorm);
        traditional.setPrice(40);

        Breakfast british = new Breakfast();
        british.setName("british");
        british.setPlace(PlacesFood.Dorm);
        british.setPrice(50);

        ArrayList<Lunch> lunches = new ArrayList<>();
        ArrayList<Breakfast> breakfasts = new ArrayList<>();
        lunches.add(lettuce);
        lunches.add(burger);
        lunches.add(hotdog);
        lunches.add(dugh);
        lunches.add(soda);
        breakfasts.add(traditional);
        breakfasts.add(british);
        Data.getInstance().setBreakfasts(breakfasts);
        Data.getInstance().setLunches(lunches);

        //
        while (true) {
            System.out.println("Enter username and password:");
            Scanner scanner = new Scanner(System.in);
            String user = scanner.nextLine();
            String pass = scanner.nextLine();
            boolean adminSection = true;
            boolean studentSection = true;
            boolean professorSection = true;
            while (admin.login(user, pass).equals("login was successful!: login as admin") && adminSection) {
                System.out.println("Hello dear Admin!");
                System.out.println("select an option:");
                System.out.println("*add student[1]");
                System.out.println("*add professor[2]");
                System.out.println("*add course[3]");
                System.out.println("*students requests[4]");
                System.out.println("*remove student[5]");
                System.out.println("*remove professor[6]");
                System.out.println("*remove course[7]");
                System.out.println("*edit student[8]");
                System.out.println("*edit professor[9]");
                System.out.println("*edit course[10]");
                System.out.println("*nothing[11]");
                int inputSection = Integer.parseInt(scanner.nextLine());
                if (inputSection == 1) {//student
                    System.out.println("enter name:");
                    String name = scanner.nextLine();
                    System.out.println("enter familyname:");
                    String familyname = scanner.nextLine();
                    System.out.println("enter id:");
                    String id = scanner.nextLine();
                    System.out.println("enter password:");
                    pass = scanner.nextLine();
                    System.out.println("enter number of courses:");
                    CourseGroup courseToAdd;
                    int numberOfCourses = Integer.parseInt(scanner.nextLine());
                    ArrayList<CourseGroup> studentnCourses = new ArrayList<>();
                    for (int i = 0; i < numberOfCourses; i++) {
                        System.out.println("enter course id:");
                        int idInt = Integer.parseInt(scanner.nextLine());
                        for (int j = 0; j < Data.getInstance().getConfigCourses().size(); j++) {
                            if (idInt == (Data.getInstance().getConfigCourses().get(j).getId())) {
                                if (Data.getInstance().getConfigCourses().get(j).getSits() > 0) {
                                    if (!(admin.checkTimeConflict(new Student(name, familyname, id, pass, studentnCourses),
                                            Data.getInstance().getConfigCourses().get(j))) &&
                                            !admin.checkDuplication(new Student(name, familyname, id, pass, studentnCourses),
                                                    Data.getInstance().getConfigCourses().get(j))) {
                                        courseToAdd = Data.getInstance().getConfigCourses().get(j);
                                        studentnCourses.add(courseToAdd);
                                        admin.changeSits(Data.getInstance().getConfigCourses().get(j));
                                    }
                                } else {
                                    System.out.println("Class is full");
                                }
                            }
                        }
                    }
                    configStudents.add(new Student(name, familyname, id, pass, studentnCourses));
                    Data.getInstance().setConfigStudent(configStudents);
                    admin.syncCourses();


                } else if (inputSection == 2) {//professor
                    System.out.println("enter name:");
                    String name = scanner.nextLine();
                    System.out.println("enter familyname:");
                    String familyname = scanner.nextLine();
                    System.out.println("enter id:");
                    String id = scanner.nextLine();
                    System.out.println("enter password:");
                    pass = scanner.nextLine();
                    System.out.println("enter number of courses:");
                    ArrayList<CourseGroup> professornCourses = new ArrayList<>();
                    CourseGroup courseToAdd = new CourseGroup(null);
                    int numberOfCourses = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numberOfCourses; i++) {
                        System.out.println("enter course id:");
                        id = scanner.nextLine();
                        for (int j = 0; j < Data.getInstance().getConfigCourses().size(); j++) {
                            if (Integer.parseInt(id) == Data.getInstance().getConfigCourses().get(j).getId()) {
                                if (!(admin.checkTimeConflict(new Student(name, familyname, id, pass, professornCourses),
                                        Data.getInstance().getConfigCourses().get(j)))) {
                                    courseToAdd = Data.getInstance().getConfigCourses().get(j);
                                }
                                professornCourses.add(courseToAdd);

                            }
                        }
                    }
                    configStudents.add(new Student(name, familyname, id, pass, professornCourses));
                    Data.getInstance().setConfigStudent(configStudents);
                    admin.syncCourses();

                } else if (inputSection == 3) {//Course
                    System.out.println("enter course id or title : ");
                    System.out.println("*id[1]");
                    System.out.println("*title[2]");
                    System.out.println("*id and title[3]");
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input == 1) {
                        System.out.println("enter course id : ");
                        String id = scanner.nextLine();
                        configCourse.add(new CourseGroup(id));
                        Data.getInstance().setConfigCourses(configCourse);
                    } else if (input == 2) {
                        System.out.println("enter course title : ");
                        String title = scanner.nextLine();
                        configCourse.add(new CourseGroup(title));
                        Data.getInstance().setConfigCourses(configCourse);
                    } else if (input == 3) {
                        System.out.println("enter course id : ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("enter course title : ");
                        String title = scanner.nextLine();
                        configCourse.add(new CourseGroup(id, title));
                        Data.getInstance().setConfigCourses(configCourse);
                    }

                } else if (inputSection == 4) {

                    try {
                        BufferedReader br = new BufferedReader(new FileReader(path));
                        String s;
                        int counter = 0;
                        String number = "";
                        while ((s = br.readLine()) != null) {
                            counter++;
                            System.out.println(s);
                            if (counter == 2) {
                                number = s;
                            }
                            if (counter == 3) {
                                System.out.println("Do you agree?[yes/no]");
                                String answer = scanner.nextLine();
                                if (answer.equals("yes")) {
                                    Data.getInstance().searchForStudent(number).removeCourse(Integer.parseInt(s));

                                    counter = 0;
                                } else {
                                    System.out.println("you have denied the request");

                                }

                            }

                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (inputSection == 5) {
                    System.out.println("Enter Student's id");
                    String id = scanner.nextLine();
                    admin.removeStudent(id);
                    admin.syncCourses();
                } else if (inputSection == 6) {
                    System.out.println("Enter Professor's id");
                    String id = scanner.nextLine();
                    admin.removeProfessor(id);
                    admin.syncCourses();
                } else if (inputSection == 7) {
                    System.out.println("Enter Course's id");
                    String id = scanner.nextLine();
                    admin.removeClass(id);
                } else if (inputSection == 8) {
                    main.editStudent();
                    admin.syncCourses();
                } else if (inputSection == 9) {
                    main.editProfessor();
                    admin.syncCourses();
                } else if (inputSection == 10) {
                    main.editCourse();
                    admin.syncCourses();
                } else if (inputSection == 11) {
                    System.out.println("Admin menu skipped");
                }

                admin.checkCoursesStudent();
                admin.checkMaxSits();
                admin.syncCourses();
                System.out.println("do you want to conrinue as admin?[yes/no]");
                String checkAdmin = scanner.nextLine();
                if (!checkAdmin.equals("yes")) {
                    adminSection = false;
                }

            }
            for (int i = 0; i < Data.getInstance().getConfigStudent().size(); i++) {
                if (user.equals(Data.getInstance().getConfigStudent().get(i).getId())) {
                    if (!Data.getInstance().getConfigStudent().get(i).login(user, pass).
                            equals("login was successful!: login as a Student")) {
                        System.out.println(Data.getInstance().getConfigStudent().get(i).login(user, pass));
                    } else {

                        while (studentSection) {
                            //login as student
                            System.out.println("Hello Dear " + Data.getInstance().getConfigStudent().get(i).getName());
                            System.out.println("Menu:");
                            System.out.println("*weekly schedule[1]");
                            System.out.println("*adding a course[2]");
                            System.out.println("*transcript[3]");
                            System.out.println("*cancel a course request[4]");
                            System.out.println("*food reservation service[5]");
                            int inputMenu = Integer.parseInt(scanner.nextLine());
                            Student currentStu = Data.getInstance().getConfigStudent().get(i);
                            if (inputMenu == 1) {
                                currentStu.printWeeklySchedule();
                            } else if (inputMenu == 2) {
                                System.out.println("Enter the Course ID:");
                                int classId = Integer.parseInt(scanner.nextLine());
                                for (CourseGroup courseGroup : Data.getInstance().getConfigCourses()) {
                                    if (courseGroup.getId() == classId) {
                                        if (courseGroup.getSits() > 0) {
                                            if (!(admin.checkTimeConflict(currentStu, courseGroup)) &&
                                                    !(admin.checkDuplication(currentStu, courseGroup))) {
                                                admin.changeSits(courseGroup);
                                                Data.getInstance().getConfigStudent().get(i).addingCourse(courseGroup);
                                                Data.getInstance().getConfigStudent().get(i).update();
                                                admin.syncCourses();
                                            }
                                        } else {
                                            System.out.println("Class is full");
                                        }
                                    }
                                }
                            } else if (inputMenu == 3) {
                                currentStu.printTranscript();
                            } else if (inputMenu == 4) {
                                System.out.println("Enter the Course ID:");
                                String classId = scanner.nextLine();
                                try {
                                    BufferedWriter bw = new BufferedWriter(new FileWriter(path));
                                    bw.write(Data.getInstance().getConfigStudent().get(i).getFamilyName() + "\n");
                                    bw.write(Data.getInstance().getConfigStudent().get(i).getId());
                                    bw.newLine();
                                    bw.write(classId);
                                    bw.newLine();
                                    bw.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (inputMenu == 5) {
                                System.out.println("Breakfast[1] or lunch[2]?");
                                String food = scanner.nextLine();
                                if (food.equals("1")) {
                                    for (Breakfast breakfast : Data.getInstance().getBreakfasts()) {
                                        System.out.println(breakfast.toString());
                                    }
                                    System.out.println("enter the name of the food you want to add:");
                                    String food1 = scanner.nextLine();
                                    for(Breakfast breakfast: Data.getInstance().getBreakfasts()){
                                        if(breakfast.getName().equals(food1)){
                                            Data.getInstance().getConfigStudent().get(i).getFoods().add(breakfast);

                                        }
                                    }
                                } else if (food.equals("2")) {
                                    for (Lunch lunch : Data.getInstance().getLunches()) {
                                        System.out.println(lunch.toString());
                                    }
                                    System.out.println("enter the name of the food you want to add:");
                                    String food1 = scanner.nextLine();
                                    for(Lunch lunch: Data.getInstance().getLunches()){
                                        if(lunch.getName().equals(food1)){
                                            Data.getInstance().getConfigStudent().get(i).getFoods().add(lunch);

                                        }
                                    }
                                }

                            }

                            admin.syncCourses();
                            Data.getInstance().getConfigStudent().get(i).update();
                            System.out.println("do you want to continue as student?[yes/no]");
                            String checkAdmin = scanner.nextLine();
                            if (!checkAdmin.equals("yes")) {
                                studentSection = false;
                            }

                        }
                    }
                }
            }
            for (int i = 0; i < Data.getInstance().getConfigProfessor().size(); i++) {
                if (user.equals(Data.getInstance().getConfigProfessor().get(i).getId())) {
                    if (!Data.getInstance().getConfigProfessor().get(i).login(user, pass).
                            equals("login was successful!:  Professor")) {
                        System.out.println(Data.getInstance().getConfigProfessor().get(i).login(user, pass));
                    } else {

                        while (professorSection) {
                            Professor professor = Data.getInstance().getConfigProfessor().get(i);
                            Data.getInstance().getConfigProfessor().remove(professor);
                            //login as Professor
                            System.out.println("Hello Dear " + Data.getInstance().getConfigProfessor().get(i).getName());
                            System.out.println("Menu:");
                            System.out.println("*weekly schedule[1]");
                            System.out.println("*Student list[2]");
                            System.out.println("*grading[3]");
                            System.out.println("*Courses[4]");
                            int input = Integer.parseInt(scanner.nextLine());
                            if (input == 1) {
                                professor.printWeeklySchedule();
                            } else if (input == 2) {
                                professor.printStudents();
                            } else if (input == 3) {
                                System.out.println("*Print all grades[1]");
                                System.out.println("*grade a student[2]");
                                int input2 = Integer.parseInt(scanner.nextLine());
                                if (input2 == 1) {
                                    professor.printGrades();
                                } else if (input2 == 2) {
                                    System.out.println("enter student id:");
                                    Student student = Data.getInstance().searchForStudent(scanner.nextLine());
                                    System.out.println("enter course id:");
                                    int courseId = Integer.parseInt(scanner.nextLine());
                                    System.out.println("enter grade:");
                                    int grade = Integer.parseInt(scanner.nextLine());
                                    professor.grading(student, courseId, grade);
                                }
                                admin.syncCourses();

                            } else if (input == 4) {
                                professor.printCourses();
                            }
                            Data.getInstance().getConfigProfessor().add(professor);
                            admin.syncCourses();
                            System.out.println("do you want to continue as professor?[yes/no]");
                            String checkAdmin = scanner.nextLine();
                            if (!checkAdmin.equals("yes")) {
                                professorSection = false;
                            }

                        }
                    }
                }
            }
            System.out.println("do you want to exit?[yes/no]");
            String exit = scanner.nextLine();
            if (exit.equals("yes")) {
                break;
            }
        }

    }
}