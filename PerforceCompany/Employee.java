package PerforceCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Stream program to generate set of employees depending on JobTitle
public class Employee {
    private Integer empId;
    private String empName;
    private String jobTitle;
    private Double salary;

    public Employee(Integer empId, String empName, String jobTitle, Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return '{'+ "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void  groupByJobTitle(List<Employee> employees){
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getJobTitle)));
    }

    public static void main(String []args){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Sanjivani", "Dev", 60000.0));
        list.add(new Employee(102, "ABC", "QA", 40000.0));
        list.add(new Employee(103, "PQR", "Dev", 50000.0));
        list.add(new Employee(104, "XYZ", "QA", 40000.0));
        groupByJobTitle(list);

    }
}
