package bang.banghotseat;

import bang.banghotseat.userInterface.UserInterface;
import javax.swing.SwingUtilities;

public class Bang 
{
    public static void main( String[] args )
    {
        UserInterface userInterface = new UserInterface();
        SwingUtilities.invokeLater(userInterface);
    }
}