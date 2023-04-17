package LAB_6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class Tests {
    private Sum main;

    @Before
    public void setUp(){
        main = new Sum();
    }
    @After
    public void tearDown(){
        main = null;
    }
    @Test
    public void sumTest(){
        Assert.assertEquals(5, main.sum(new double[]{2.0, 3.0}),0.1);
    }
}
