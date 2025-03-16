import java.util.*;

public class ipa_p1java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter company name:");
        String lp = sc.nextLine();
        System.out.print("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] f1 = new Employee[n];
        Company c1 = new Company();
        System.out.print("Enter employee details:");
       
        for (int i = 0; i < f1.length; i++) {
            System.out.println("Employee "+(i+1)+":");
            System.out.print("Enter ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name:");
            String name = sc.nextLine();
            System.out.print("Enter designation:");
            String designation = sc.nextLine();
            System.out.print("Enter salary:");
            double salary = sc.nextDouble();
            sc.nextLine();

            f1[i] = new Employee(id, name, designation, salary);
        }
        c1.setCompanyName(lp);
        c1.setEmployees(f1);  
        c1.setNumEmployees(n);

        double avgSalary = calculateAverageSalary(f1);
        System.out.println("Average salary:" + avgSalary);
        double highSalaries = findEmployeesWithHighestSalary(f1);
        System.out.print("Max salary:" + highSalaries);
        System.out.print("Employees with designation: ");
        String kop=sc.nextLine();
        Employee[] ans = findEmployeesByDesignation(f1,kop);
        for(int p=0;p<ans.length;p++)
        {
            System.out.println("ID: "+ans[p].getId()+", "+"Name: "+ans[p].getName()+", "+"Designation: "+ans[p].getDesignation()+", "+"Salary: "+ans[p].getSalary());
        }

    }
    public static double calculateAverageSalary(Employee[] f1)
    {
        double sum = 0;
        for (Employee e : f1) {
            sum += e.getSalary();
        }
        return sum / f1.length;
    }
    public static double findEmployeesWithHighestSalary(Employee[] f1)
    {
     for(int i=0;i<f1.length;i++)
     {
        for(int j=i;j<f1.length;j++)
        {
            if(f1[i].getSalary()<f1[j].getSalary())
            {
                Employee temp=f1[i];
                f1[i]=f1[j];
                f1[j]=temp;
            }
        }
     }
     return f1[0].getSalary();
    }
    public static Employee[] findEmployeesByDesignation(Employee[] f1, String designation)
    {
        Employee[] f2=new Employee[0];
        for(int i=0;i<f1.length;i++)
        {
            if(f1[i].getDesignation().equalsIgnoreCase(designation))
            {
                f2=Arrays.copyOf(f2, f2.length+1);
                f2[f2.length-1]=f1[i];
            }
        }
        for(int i=0;i<f2.length;i++)
        {
            for(int j=i;j<f2.length;j++)
            {
                if(f2[i].getId()>f2[j].getId())
                {
                    Employee temp=f2[i];
                    f2[i]=f2[j];
                    f2[j]=temp;
                }
            }
        }
        return f2;
    }
}

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

class Company {
    private Employee[] employees;
    private String companyName;
    private int numEmployees;

    

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

}
