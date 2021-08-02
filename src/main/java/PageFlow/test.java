package PageFlow;

import BO.TestDatasBO;
import FileReader.JSONReader;

public class test {
    public static void main(String[] args) {
        new JSONReader();
        TestDatasBO bo=new TestDatasBO();
        System.out.println(bo);
        System.out.println(bo.getCheckInDate());
    }
}
