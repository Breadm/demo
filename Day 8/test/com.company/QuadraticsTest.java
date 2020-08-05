package com.company;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class QuadraticsTest {
    @Test
    public void solution1Test(){
        Quadratics q = new Quadratics();

        Double value = q.solution1(2,-9,4);
        assertEquals(4d, value);

        value = q.solution1(5,-7,2);
        assertEquals(1d, value);

        value = q.solution1(5,1,2);
        assertEquals(null, value);
    }

    @Test
    public void solution2Test(){
        Quadratics q = new Quadratics();

        Double value = q.solution2(2,-9,4);
        assertEquals(0.5, value);

        value = q.solution2(5,-7,2);
        assertEquals(0.4, value);

        value = q.solution2(5,1,2);
        assertEquals(null, value);
    }
}
