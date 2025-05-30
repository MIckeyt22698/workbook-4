package com.pluralsight;

    public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double startTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = null;
    }
        public void punchTimeCard(double time) {
            if (startTime == null) {
                startTime = time;
                System.out.println(name + " punched in at " + time);
            } else {
                double worked = time - startTime;
                if (worked > 0) {
                    hoursWorked += worked;
                    System.out.println(name + " punched out at " + time + " (worked " + worked + " hours)");
                } else {
                    System.out.println("Invalid time: Punch out must be after punch in.");
                }
                startTime = null;
            }
        }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getPayRate() {
        return payRate;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }
    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }
}

