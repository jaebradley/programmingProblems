package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.GarlandDegreeIdentifier;

public class GarlandDegreeIdentifierImplTest {
    private final GarlandDegreeIdentifier garlandDegreeIdentifier = new GarlandDegreeIdentifierImpl();

    @Test
    public void testExpected() {
        Assert.assertEquals(garlandDegreeIdentifier.identifyGarlandDegree("undergrounder"), 5);
    }

}