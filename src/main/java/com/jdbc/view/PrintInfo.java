package com.jdbc.view;

import com.jdbc.model.Employee;

import java.util.List;

public class PrintInfo {




    public void printEmployees(List<Employee> list) {
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
        System.out.printf( "|  ID  |    Name    |     Job    | Hire_Date | Salary | Comm |  Mgr | Grade | Dept_Num | Dept_Loc | Dept_Name|\n");
        for (Employee e : list) {
            System.out.printf("| %4d | %10s | %10s | %10s|  %4.0f  | %4.0f | %4d | %3d   |    %2d    |%10s|%10s|\n",
                    e.getId(), e.getSurName(), e.getJob(), e.getHireDate(), e.getSalary(), e.getCommission(), e.getManagerId(),  e.getSalGrade().getGrade(),e.getDepartmentId(), e.getDepartment().getLoc(), e.getDepartment().getdName());
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
    }
}
