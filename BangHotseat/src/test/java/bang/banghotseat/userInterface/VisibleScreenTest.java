/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import java.awt.Dimension;
import javax.swing.JFrame;
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
public class VisibleScreenTest {
    
    private JFrame frame;
    private VisibleScreen visibleScreen;
    private Setup setup;
    
    public VisibleScreenTest() {
        
        frame = new JFrame("BANG!");
        frame.setPreferredSize(new Dimension (1365, 765));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.visibleScreen = new VisibleScreen(frame, setup);
        visibleScreen.MainMenu();
        
        frame.pack();
        frame.setVisible(true);
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
    
    @Test
    public void mainMenuContainsCorrectAmountOfComponents() {
    }
}