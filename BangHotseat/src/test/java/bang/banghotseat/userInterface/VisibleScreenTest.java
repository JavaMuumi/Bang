/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
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
        
        setup = new Setup();
        
        this.visibleScreen = new VisibleScreen(frame, setup);
        visibleScreen.getSetup().runSetup();
        visibleScreen.MainMenu();
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
    public void mainMenuHas11Components() {
        assertEquals(11, frame.getContentPane().getComponentCount());
    }
    
    @Test
    public void rulesHas2Componenets() {
        
        frame.getContentPane().removeAll();
        visibleScreen.rules();
        
        assertEquals(2, frame.getContentPane().getComponentCount());
    }
    
    @Test
    public void exitScreenHas3Components() {
        
        frame.getContentPane().removeAll();
        visibleScreen.exit();
        
        assertEquals(3, frame.getContentPane().getComponentCount());
    }
    
    @Test
    public void newGameInfoHas5Components() {
        
        frame.getContentPane().removeAll();
        visibleScreen.newGameInfo();
        
        assertEquals(5, frame.getContentPane().getComponentCount());
    }
    
    @Test
    public void playerXLookAwayToPlayerYTurnHas2Components() {
        
        frame.getContentPane().removeAll();
        visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
        
        assertEquals(2, frame.getContentPane().getComponentCount());
    }
}