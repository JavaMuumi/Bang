/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.Round;
import bang.banghotseat.Setup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti Korpi
 */
public class RoundTest {
    
    private Setup setup = new Setup();
    private Round round;
    
    public RoundTest() {
        setup.runSetup();
        round = new Round(setup.getPlayer1(), setup.getPlayer2(), setup.getDrawpile(), setup.getDiscardpile(), setup.getAsker());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
}