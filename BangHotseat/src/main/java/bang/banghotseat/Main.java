package bang.banghotseat;

import bang.banghotseat.userInterface.TextInterface;

public class Main 
{
    public static void main( String[] args )
    {
        
        TextInterface text = new TextInterface();
        Setup setup = new Setup(text);
        text.go(setup);
    }
}