import java.util.Scanner;

class program2a {
    public static void main(String[] args) {
        int i, choice;
        String staffId, name;
        float salary;
        String phoneNumber, domain, publication, skills, period;
        int teachingCount = 0, technicalCount = 0, contractCount = 0;
        System.out.println("Enter no. of staff to be created for each category ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Teaching[] teachingstaff = new Teaching[n];
        Technical[] technicalstaff = new Technical[n];
        Contract[] contractstaff = new Contract[n];
        for (;;) {
            System.out.println("Enter your Choice: ");
            System.out.println("1.Teaching Staff Entry");
            System.out.println("2.Technical Staff Entry");
            System.out.println("3.Contract Staff Entry");
            System.out.println("4.Teaching Staff Details");
            System.out.println("5.Technical Staff Details");
            System.out.println("6.Contract Staff Details");
            System.out.println("7.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println(
                                "Enter Teaching staff Details(StaffId,Name,Salary,PhoneNumber,Domain,Publication)");
                        staffId = scanner.next();
                        name = scanner.next();
                        salary = scanner.nextFloat();
                        phoneNumber = scanner.next();
                        domain = scanner.next();
                        publication = scanner.next();
                        teachingstaff[teachingCount] = new Teaching(staffId, name, salary, phoneNumber, domain,
                                publication);
                        teachingCount++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Teaching staff entries cannot be done");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter Technical staff details(StaffId,Name,Salary,PhoneNumber,Skills)");
                        staffId = scanner.next();
                        name = scanner.next();
                        salary = scanner.nextFloat();
                        phoneNumber = scanner.next();
                        skills = scanner.next();
                        technicalstaff[technicalCount] = new Technical(staffId, name, salary, phoneNumber, skills);
                        technicalCount++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Technical staff entries cannot be done");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter Contract staff details(StaffId,Name,Salary,PhoneNumber,Period)");
                        staffId = scanner.next();
                        name = scanner.next();
                        salary = scanner.nextFloat();
                        phoneNumber = scanner.next();
                        period = scanner.next();
                        contractstaff[contractCount] = new Contract(staffId, name, salary, phoneNumber, period);
                        contractCount++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Contract staff entries cannot be done");
                    }
                    break;
                case 4:
                    if (teachingCount == 0)
                        System.out.println("No teaching Staff Details Found");
                    else {
                        System.out.println("Teaching Staff Details are as follows: ");

                        for (i = 1; i <= teachingCount; i++) {
                            System.out.println(teachingstaff[i - 1]);
                        }
                    }
                    break;
                case 5:
                    if (technicalCount == 0)
                        System.out.println("No technical Staff Details Found");
                    else {
                        System.out.println("Technical Staff Details are as follows: ");
                        for (i = 1; i <= technicalCount; i++) {
                            System.out.println(technicalstaff[i - 1]);
                        }
                    }
                    break;
                case 6:
                    if (contractCount == 0)
                        System.out.println("No contract Staff Details Found");
                    else {
                        System.out.println("Contract Staff Details are as follows: ");
                        for (i = 1; i <= contractCount; i++) {
                            System.out.println(contractstaff[i - 1]);
                        }
                    }
                    break;
                case 7:
                    if ((teachingCount + technicalCount + contractCount) < 3)
                        break;
                    else
                        System.exit(0);
            }
        }
    }
}

class Staff {
    private String staffId;
    private String name;
    private float salary;
    private String phoneNumber;

    public Staff(String staffId, String staffName, float staffSalary, String staffPhoneNumber) {
        this.staffId = staffId;
        this.name = staffName;
        this.salary = staffSalary;
        this.phoneNumber = staffPhoneNumber;
    }

    public String toString() {
        return ("STAFF ID:" + staffId + "\n" + "STAFF NAME:" + name + "\n" + "SALARY:" + salary + "\n" + "PHONENUMBER:"+ phoneNumber);
    }
}

class Teaching extends Staff {
    private String domain;
    private String publication;

    public Teaching(String staffId, String name, float salary, String phoneNumber, String domain, String publication) {
        super(staffId, name, salary, phoneNumber);
        this.domain = domain;
        this.publication = publication;
    }

    public String toString() {
        return super.toString() + "\n" + "DOMAIN:" + domain + "\n" + "Publications:" + publication;
    }
}

class Technical extends Staff {
    private String skills;

    public Technical(String staffId, String name, float salary, String phoneNumber, String skills) {
        super(staffId, name, salary, phoneNumber);
        this.skills = skills;
    }

    public String toString() {
        return super.toString() + "\n" + "SKILLS:" + skills;
    }
}

class Contract extends Staff {
    private String period;

    public Contract(String staffId, String staffName, float staffSalary, String staffPhoneNumber, String period) {
        super(staffId, staffName, staffSalary, staffPhoneNumber);
        this.period = period;
    }

    public String toString() {
        return super.toString() + "\n" + "PERIOD:" + period;
    }
}