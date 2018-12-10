package cn.pra_01.clone;

/**
 *  This program demonstrates cloning
 * @version 1.0 2018-07
 * @author wintershii
 */
public class CloneTest {
    public static void main(String[] args) {

        Employee original = new Employee("shi",50000);
        original.setHireDate(2000,1,1);
        try {
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDate(2002,12,31);
            System.out.println("original:" + original);
            System.out.println("copy:" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
