package com.jdbc.view;

import com.jdbc.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class GetInfoFromUser {

    public void greeting() {
        System.out.println("Hello! I am your employees database\n" +
                "What you want to do ?");
    }

    public int getMenuVariant() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printMenu();
        int menuVariant = 0;
        for(;;) {
            System.out.println("Enter the number of menu:");
            try {
                menuVariant = Integer.parseInt(br.readLine());
                if (menuVariant > 5 || menuVariant < 1) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException | IllegalArgumentException e) {
                System.out.println("Incorrect value");
            }
        }
        return menuVariant;
    }

    private void printMenu() {
        System.out.println("1. Get info about distinct employee. ");
        System.out.println("2. Show full employee list. ");
        System.out.println("3. Remove employee by ID. ");
        System.out.println("4. Add new employee. ");
        System.out.println("5. Save and exit. ");
    }

    public Employee createEmployee() {
        Employee employee = new Employee();
        employee.setId(getEmpNoFromUser());
        employee.setSurName(getENameFromUser());
        employee.setJob(getJobFromUser());
        employee.setHireDate(getHireDateFromUser());
        employee.setSalary(getSalFromUser());
        employee.setCommission(getCommFromUser());
        employee.setManagerId(getMgrFromUser());
        employee.setDepartmentId(getDeptNoFromUser());
        //employee.setGrade(getGradeFromUser(employee.getSal()));
        //employee.setDepLocation(getDeptLocFromUser());
        //employee.setDepName(getDeptNameFromUser());
        return employee;
    }

    public int getEmpNoFromUser() {
        int num;
        for(;;) {
            System.out.println("Enter employee number(empNo)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                num = Integer.parseInt(br.readLine());
                if (num <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee number");
            }
        }
        return num;
    }
    private String getENameFromUser() {
        String name;
        for(;;) {
            System.out.println("Enter employee name(eName)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                name = br.readLine().toUpperCase();
                if (name.equals("")) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee name");
            }
        }
        return name;
    }
    private String getJobFromUser() {
        String job;
        for(;;) {
            System.out.println("Enter employee position (job)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                job = br.readLine().toUpperCase();
                if (job.equals("")) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee job");
            }
        }
        return job;
    }
    private Date getHireDateFromUser() {
        Date date;
        for(;;) {
            System.out.println("Enter employee hire data (hireDate) in such format yyyy-mm-dd");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                date = Date.valueOf(br.readLine());
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee hire date");
            }
        }
        return date;
    }
    private float getSalFromUser() {
        float sal;
        for(;;) {
            System.out.println("Enter employee salary(sal)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                sal = Float.parseFloat(br.readLine());
                if (sal < 700 || sal > 9999) {
                    System.out.println("Salary does not comply with company policy");
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee salary");
            }
        }
        return sal;
    }
    private float getCommFromUser() {
        float comm;
        for(;;) {
            System.out.println("Enter employee commission (comm)" +
                    "If employee does't have commission — enter 0 ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                comm = Float.parseFloat(br.readLine());
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee salary");
            }
        }
        return comm;
    }
    private int getMgrFromUser() {
        int manager;
        for(;;) {
            System.out.println("Enter employee manager number(mgr)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                manager = Integer.parseInt(br.readLine());
                if (manager <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee manager number");
            }
        }
        return manager;
    }
    private int getDeptNoFromUser() {
        int deptNumber;
        for(;;) {
            System.out.println("Enter employee  department number (deptNo)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                deptNumber = Integer.parseInt(br.readLine());
                if (deptNumber <= 0 || deptNumber % 10 != 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IOException  | IllegalArgumentException e) {
                System.out.println("Incorrect employee department number");
            }
        }
        return deptNumber;
    }

}
