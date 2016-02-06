package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.GarlandLengthIdentifier;

public class GarlandLengthIdentifierImplTest {
    private final GarlandLengthIdentifier garlandLengthIdentifier = new GarlandLengthIdentifierImpl();

    @Test
    public void testExpected() {
        Assert.assertEquals(garlandLengthIdentifier.identifyGarlandLength("undergrounder"), 5);
    }

}