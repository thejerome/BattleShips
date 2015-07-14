package com.efimchick.battleships.model;

import org.testng.annotations.Test;

import static com.efimchick.battleships.model.Direction.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by efimchick on 14.07.15.
 */
public class DirectionTest {

    @Test
    public void testCountDifference() throws Exception {
        assertEquals(N.countDifference(N), 0);
        assertEquals(E.countDifference(E), 0);
        assertEquals(S.countDifference(S), 0);
        assertEquals(W.countDifference(W), 0);
        assertEquals(NE.countDifference(NE), 0);
        assertEquals(NW.countDifference(NW), 0);
        assertEquals(SE.countDifference(SE), 0);
        assertEquals(SW.countDifference(SW), 0);

        assertEquals(N.countDifference(NW), 1);
        assertEquals(N.countDifference(NE), 1);
        assertEquals(E.countDifference(NE), 1);
        assertEquals(E.countDifference(SE), 1);
        assertEquals(S.countDifference(SE), 1);
        assertEquals(S.countDifference(SW), 1);
        assertEquals(W.countDifference(NW), 1);
        assertEquals(W.countDifference(SW), 1);
        assertEquals(NW.countDifference(N), 1);
        assertEquals(SE.countDifference(E), 1);

        assertEquals(N.countDifference(E), 2);
        assertEquals(N.countDifference(W), 2);
        assertEquals(E.countDifference(N), 2);
        assertEquals(E.countDifference(S), 2);
        assertEquals(S.countDifference(W), 2);
        assertEquals(S.countDifference(E), 2);
        assertEquals(W.countDifference(S), 2);
        assertEquals(W.countDifference(N), 2);
        assertEquals(NW.countDifference(NE), 2);
        assertEquals(SE.countDifference(NE), 2);

        assertEquals(N.countDifference(SE), 3);
        assertEquals(N.countDifference(SW), 3);
        assertEquals(E.countDifference(NW), 3);
        assertEquals(E.countDifference(SW), 3);
        assertEquals(S.countDifference(NW), 3);
        assertEquals(S.countDifference(NE), 3);
        assertEquals(W.countDifference(SE), 3);
        assertEquals(W.countDifference(NE), 3);
        assertEquals(NW.countDifference(E), 3);
        assertEquals(SE.countDifference(N), 3);

        assertEquals(N.countDifference(S), 4);
        assertEquals(E.countDifference(W), 4);
        assertEquals(S.countDifference(N), 4);
        assertEquals(W.countDifference(E), 4);
        assertEquals(NW.countDifference(SE), 4);
        assertEquals(NE.countDifference(SW), 4);
    }
}