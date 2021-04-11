package app2you.probateapp.datos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    private Database db = null;

    @Before
    public void init() {
        db = Database.getInstance();
    }

    @Test
    public void creacionExitosa() {
        Assert.assertTrue(db.getInstitutos().size() > 0);
    }



}
