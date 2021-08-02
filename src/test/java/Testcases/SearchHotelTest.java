package Testcases;

import BO.TestDatasBO;
import PageFlow.SearchConfigureFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchHotelTest extends BaseTest{

    @Test
    public void gotoHoteltab(){
        Assert.assertTrue(SearchConfigureFlow.clickMenuTab());
    }

}
