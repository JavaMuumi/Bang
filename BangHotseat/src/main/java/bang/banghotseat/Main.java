package bang.banghotseat;

import bang.banghotseat.userInterface.UserInterface;
import javax.swing.SwingUtilities;

public class Main 
{
    public static void main( String[] args )
    {
        Setup setup = new Setup();
        UserInterface userInterface = new UserInterface(setup);
        SwingUtilities.invokeLater(userInterface);
    }
}