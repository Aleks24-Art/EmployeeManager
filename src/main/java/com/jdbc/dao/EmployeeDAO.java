package com.jdbc.dao;

import com.jdbc.connection.DBConnection;
import com.jdbc.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements DAO<Employee> {

    @Override
    public Employee get(int id) {
        Employee employee = new Employee();
        try(Connection connection = new DBConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT e.*, d.loc, d.dname, s.grade " +
                    "FROM emp e, dept d, salgrade s " +
                    "WHERE e.empno = "+ id +" AND (e.sal BETWEEN s.minsal AND s.hisal) AND (e.deptno = d.deptno); ")) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                employee.setId(resultSet.getInt("empno"));
                employee.setSurName(resultSet.getNString("ename"));
                employee.setJob(resultSet.getNString("job"));
                employee.setManagerId(resultSet.getInt("mgr"));
                employee.setHireDate(resultSet.getDate("hiredate"));
                employee.setSalary(resultSet.getFloat("sal"));
                employee.setCommission(resultSet.getFloat("comm"));
                employee.setDepartmentId(resultSet.getInt("deptno"));
                employee.getDepartment().setLoc(resultSet.getNString("loc"));
                employee.getDepartment().setdName(resultSet.getNString("dname"));
                employee.getSalGrade().setGrade(resultSet.getInt("grade"));
            }

        } catch (SQLException e1) {
            System.out.println("Exception while getting employee from db by empno" + e1);
        }

        return employee;
    }

    @Override
    public void add(Employee employee) {
        try(Connection connection = new DBConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO emp VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getSurName());
            ps.setString(3, employee.getJob());
            ps.setInt(4, employee.getManagerId());
            ps.setDate(5, employee.getHireDate());
            ps.setFloat(6, employee.getSalary());
            ps.setFloat(7, employee.getCommission());
            ps.setInt(8, employee.getDepartmentId());

            ps.execute();

            System.out.println("Employee " + employee + " was successful added");

        } catch (SQLException e1) {
            System.out.println("Exception while getting employee from db by empno" + e1);
        }
    }

    @Override
    public void remove(int id) {
        try(Connection connection = new DBConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM emp WHERE empno = " + id)) {

            ps.execute();

            System.out.println("Employee with id " + id + " was successful removed");
        } catch (SQLException e1) {
            System.out.println("Exception while getting employee from db by empno" + e1);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = new DBConnection().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT e.*, d.loc, d.dname, s.grade FROM emp e, dept d, salgrade s WHERE (e.sal BETWEEN s.minsal AND s.hisal) AND (e.deptno = d.deptno)")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("empno"));
                employee.setSurName(resultSet.getNString("ename"));
                employee.setManagerId(resultSet.getInt("mgr"));
                employee.setHireDate(resultSet.getDate("hiredate"));
                employee.setSalary(resultSet.getFloat("sal"));
                employee.setJob(resultSet.getNString("job"));
                employee.setCommission(resultSet.getFloat("comm"));
                employee.setDepartmentId(resultSet.getInt("deptno"));
                employee.getDepartment().setLoc(resultSet.getNString("loc"));
                employee.getDepartment().setdName(resultSet.getNString("dname"));
                employee.getSalGrade().setGrade(resultSet.getInt("grade"));
                employees.add(employee);
            }

            System.out.println("All employees was successful got");
        } catch (SQLException e1) {
            System.out.println("Exception while getting employee from db by empno" + e1);
        }
        return employees;
    }
}
