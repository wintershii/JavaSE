package cn.pra_01;

import java.util.Arrays;

/**
 * This program demostrates the use of the Comparable interface.
 * @version 1.0 2018-7
 * @author wintershii
 */

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("shi",35000);
        staff[1] = new Employee("zhang",75000);
        staff[2] = new Employee("zeng",39000);

        Arrays.sort(staff);

        //print out information about all Employee objects
        for (Employee e : staff){
            System.out.println("name=" + e.getName() + "   " + "salary=" + e.getSalary());
        }
    }
}
