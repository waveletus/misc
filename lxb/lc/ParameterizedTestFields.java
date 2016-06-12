/**
 * Created by lxb on 6/11/16.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class ParameterizedTestFields {

    // fields used together with @Parameter must be public
    public List m1;
    public int m2;
    public boolean m3;

    public ParameterizedTestFields(List m1, int m2, boolean m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }


    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{Arrays.asList(1,2,3), 1, true}, {Arrays.asList(1,2,3), 22, false}};
        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyException() {
        System.out.println("test start");
        MyClass tester = new MyClass();
        //assertEquals("Result", m1 * m2, tester.multiply(m1, m2));
        assertEquals("Result", m3, tester.contains(m1, m2));
    }


    // class to be tested
    class MyClass {
        public int multiply(int i, int j) {
            return i *j;
        }

        public boolean contains(List<Integer> list, int i) {
            return list.contains(i);
        }
    }

}

