package com.example.demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;



public class Database implements ClassScheduleInterface {
    private Connection con;

    public Database() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "noelhannah");
            System.out.println("Connected to database!");
            Schedule schedule = new Schedule();
            Courses course= new Courses();
            Students stud= new Students();
            Classes cl=new Classes();
            aggregateGrades ag= new aggregateGrades();
            List<AggGrade> l1=ag.groupBy();
            int sum=0;
            Map<Character,Integer> m1=new HashMap<>();
            for (AggGrade p:l1) {
                m1.put(p.getGrade(),p.getCount());
                sum+=p.getCount();
            }
            int n=l1.size();


            HistogramAlphaBet hist=new HistogramAlphaBet();
           hist.histoLaunch(n,m1,sum);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class Courses {
        public Courses() {
            ClassScheduleInterface.dropTable(con, "Courses");
            String sqlSchedule = "create table Courses(courseid varchar(100) not NULL,title varchar(100) not NULL, depprogram varchar(100) not NULL,primary key (courseid))";
            ClassScheduleInterface.createTable(con, sqlSchedule);
            populateTbl();
        }

        public void populateTbl() {

            File sched = new File("/Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt");

            try {
                Scanner scanner = new Scanner(sched);
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                while (scanner.hasNext()) {
                    String[] tokens = scanner.nextLine().split("\t");
                    insertRowCourse(tokens[0], tokens[2], tokens[6]);
                    //db.insertCourse(tokens[0])
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        public void insertRowCourse(String courseid, String title, String depprogram) { //schedule path /Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt
            String s = "insert into Courses(courseid,title,depprogram) values (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, courseid);
                ps.setString(2, title);
                ps.setString(3, depprogram);
                if (ps.executeUpdate() == -1) {
                    System.out.println("Insert into courses failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //after splitting data pass into this method and do the insert


        }

    }

    class Schedule {
        public Schedule() {
            ClassScheduleInterface.dropTable(con, "Schedule");
            String sqlSchedule = "create table Schedule(courseid varchar(100) not NULL,section_no integer not NULL,title varchar(100) not NULL, year integer not NULL, semester varchar(100) not NULL, instructor varchar(100) not NULL, depprogram varchar(100) not NULL,primary key (courseid))";
            ClassScheduleInterface.createTable(con, sqlSchedule);
            populateTbl();

        }

        public void populateTbl() {
            //String s="insert into Schedule(courseid,section_no,title,year,semester,instructor,depprogram) values (?,?,?,?,?,?,?)"; //sql insert statement add rest of columbs
            // String st="insert into Student(courseid,section_no,title,year,semester,instructor,depprogram) values (?,?,?,?,?,?,?)";
            //create dynamic sql statement to insert rows into database
            File sched = new File("/Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt");

            try {
                Scanner scanner = new Scanner(sched);
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                while (scanner.hasNext()) {
                    String[] tokens = scanner.nextLine().split("\t");
                    insertRow(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6]);
                    //db.insertCourse(tokens[0])

                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }


        public void insertRow(String courseid, int section_no, String title, int year, String semester, String instructor, String depprogram) { //schedule path /Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt
            String s = "insert into Schedule(courseid,section_no,title,year,semester,instructor,depprogram) values (?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, courseid);
                ps.setInt(2, section_no);
                ps.setString(3, title);
                ps.setInt(4, year);
                ps.setString(5, semester);
                ps.setString(6, instructor);
                ps.setString(7, depprogram);
                if (ps.executeUpdate() == -1) {
                    System.out.println("Insert into schedule failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    class Students {
        public Students() {
            ClassScheduleInterface.dropTable(con, "Students");
            String sqlSchedule = "create table Students(empid integer not NULL, first varchar(100) not NULL, last varchar(100) not NULL,email varchar(100) not NULL,gender varchar(3) not NULL,primary key (empid))";
            ClassScheduleInterface.createTable(con, sqlSchedule);
            populateTbl();
        }

        public void populateTbl() {

            File sched = new File("/Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/students.txt");

            try {
                Scanner scanner = new Scanner(sched);
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                while (scanner.hasNext()) {
                    String[] tokens = scanner.nextLine().split("\t");
                    insertRowStudent(Integer.parseInt(tokens[0]), tokens[1], tokens[2],tokens[3],tokens[4]);
                    //db.insertCourse(tokens[0])
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        public void insertRowStudent(int empid, String first, String last, String email, String gender) { //schedule path /Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt
            String s = "insert into Students(empid,first,last,email,gender) values (?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(s);
                ps.setInt(1, empid);
                ps.setString(2, first);
                ps.setString(3, last);
                ps.setString(4, email);
                ps.setString(5, gender);
                if (ps.executeUpdate() == -1) {
                    System.out.println("Insert into student failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //after splitting data pass into this method and do the insert


        }

    }

    class Classes {
        public Classes() {
            ClassScheduleInterface.dropTable(con, "Classes");
            String sqlSchedule = "create table Classes(courseid varchar(100) not NULL,section_no integer not NULL, year integer not NULL, semester varchar(100) not NULL, studentid integer not NULL, grade varchar(100) not NULL,primary key (courseid,studentid,section_no))";
            ClassScheduleInterface.createTable(con, sqlSchedule);
            populateTbl();
        }

        public void populateTbl() {

            File sched = new File("/Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/class.txt");

            try {
                Scanner scanner = new Scanner(sched);
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                while (scanner.hasNext()) {
                    String[] tokens = scanner.nextLine().split("\t");
                    insertRowClasses(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),tokens[3],Integer.parseInt(tokens[4]),tokens[5]);
                    //db.insertCourse(tokens[0])
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        public void insertRowClasses(String courseid, int section_no, int year, String semester, int studentid,String grade) { //schedule path /Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt
            String s = "insert into Classes(courseid,section_no,year,semester,studentid,grade) values (?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, courseid);
                ps.setInt(2, section_no);
                ps.setInt(3, year);
                ps.setString(4, semester);
                ps.setInt(5, studentid);
                ps.setString(6, grade);
                if (ps.executeUpdate() == -1) {
                    System.out.println("Insert into classes failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //after splitting data pass into this method and do the insert


        }

    }
class AggGrade{
        private String courseid;
        private char grade;
        private int count;

    public AggGrade(String courseid, char grade, int count) {
        this.courseid=courseid;
        this.grade=grade;
        this.count=count;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
    class aggregateGrades{
        public aggregateGrades() {
            ClassScheduleInterface.dropTable(con, "aggregateGrades");
            String sqlSchedule = "create table aggregateGrades(courseid varchar(100) not NULL,grade varchar(100) not NULL,count integer not NULL)";
            ClassScheduleInterface.createTable(con, sqlSchedule);
            populateTbl(groupBy());


        }
        public List<AggGrade> groupBy()
        {
            String AG="SELECT courseid,grade,COUNT(grade) as count FROM Classes GROUP BY courseid,grade HAVING courseid= 33600 ORDER BY grade";
            List<AggGrade>list=null;
            try {
                list=new ArrayList<>();
                PreparedStatement ps = con.prepareStatement(AG);

                ResultSet rs= ps.executeQuery() ;
                while(rs.next())
                {
                    AggGrade agg=new AggGrade(rs.getString("courseid"),rs.getString("grade").charAt(0),rs.getInt("count"));
                    list.add(agg);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return list;
        }

        public void populateTbl(List<AggGrade> list) {
            if(list!=null) {
                for (AggGrade c : list) {
                    insertRowAggregateGrades(c);
                }
            }
        }

        public void insertRowAggregateGrades(AggGrade c) { //schedule path /Users/noelmathew/IdeaProjects/demo1/src/main/java/com/example/demo1/schedule.txt
            String s = "insert into aggregateGrades(courseid,grade,count) values (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, c.getCourseid());
                ps.setString(2, c.getGrade()+"");
                ps.setInt(3, c.getCount());
                if (ps.executeUpdate() == -1) {
                    System.out.println("Insert into aggregateGrades failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //after splitting data pass into this method and do the insert


        }


    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Database db = new Database();
        db.close();
    }
}

