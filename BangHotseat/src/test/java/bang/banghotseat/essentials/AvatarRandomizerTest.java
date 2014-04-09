/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Antti Korpi
 */
public class AvatarRandomizerTest {
    
    private AvatarRandomizer randomizer = new AvatarRandomizer();
    
    public AvatarRandomizerTest() {
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
    public void all15AvatarsAreAvailable() {
        assertEquals(15, randomizer.getAvatarlist().size());
    }
    
    @Test
    public void givenAvatarsAreDeletedFromAvatarlist() {
        randomizer.giveAvatar();
        assertEquals(14, randomizer.getAvatarlist().size());
    }
    
    @Test
    public void avatarlistIsEmptyWhen15AvatarsHaveBeenTaken() {
        int counter = 1;
        while (counter <= 15) {
            randomizer.giveAvatar();
            counter++;
        }
        assertEquals(0, randomizer.getAvatarlist().size());
    }
}