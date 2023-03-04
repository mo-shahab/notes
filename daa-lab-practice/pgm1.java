import java.util.Scanner;

class student {
    String usn, name, phno;
    String branch;
    student(String usn, String name, String phno, String branch) {
        this.usn = usn;
        this.name = name;
        this.phno = phno;
        this.branch = branch;
    }
    void display() {
        System.out.println(usn + "\t" + name + "\t" + phno + "\t" + branch);
    }
}

class pgm1 {
    public static void main(String [] args) {
        String usn, name, phno, branch;
        System.out.println("enter the name of the student: ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("enter the usn of the student: ");
        usn = sc.next();
        System.out.println("enter the phone number of the student: ");
        phno = sc.next();
        System.out.println("enter the branch of the student: ");
        branch = sc.next();

        student obj = new student(usn, name, phno, branch);
        obj.display();
        sc.close();
    }
}