package com.jdbc.controller;

import com.jdbc.dao.EmployeeDAO;
import com.jdbc.model.Employee;
import com.jdbc.view.GetInfoFromUser;
import com.jdbc.view.PrintInfo;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private final EmployeeDAO dao = new EmployeeDAO();
    private final PrintInfo printer = new PrintInfo();
    private final GetInfoFromUser infoFromUser = new GetInfoFromUser();

    public void startEmployeeApplication() {
        infoFromUser.greeting();
        for (; ;) {
            int menuVariant = infoFromUser.getMenuVariant();
            switch (menuVariant) {
                case 1: {
                    List<Employee> employees = new ArrayList<>();
                    Employee emp = dao.get(infoFromUser.getEmpNoFromUser());
                    if (isExist(emp)) {
                        employees.add(emp);
                        printer.printEmployees(employees);
                    } else {
                        System.out.println("\nSuch an employee does not exist\n  ");
                    }
                    break;
                }
                case 2: {
                    printer.printEmployees(dao.getAll());
                    break;
                }
                case 3: {
                    dao.remove(infoFromUser.getEmpNoFromUser());
                    break;
                }
                case 4: {
                    dao.add(infoFromUser.createEmployee());
                    break;
                }
                case 5: {
                    System.exit(0);
                }
            }
        }
    }

    private boolean isExist(Employee employee) {
        return !(employee.getSurName() == null);
    }
}

