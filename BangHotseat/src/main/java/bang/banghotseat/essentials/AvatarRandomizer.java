/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.avatars.Avatar;
import bang.banghotseat.avatars.BartCassidy;
import bang.banghotseat.avatars.BlackJack;
import bang.banghotseat.avatars.CalamityJanet;
import bang.banghotseat.avatars.ElGringo;
import bang.banghotseat.avatars.JesseJones;
import bang.banghotseat.avatars.Jourdonnais;
import bang.banghotseat.avatars.KitCarlson;
import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.PedroRamirez;
import bang.banghotseat.avatars.RoseDoolan;
import bang.banghotseat.avatars.SidKetchum;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Antti Korpi
 */
public class AvatarRandomizer {
        
    List<Avatar> avatars = new ArrayList<>();
    
    Random randomizer = new Random();
    int avatarCounter = 14;

    public AvatarRandomizer() {
        
        avatars.add(new BartCassidy());
        avatars.add(new BlackJack());
        avatars.add(new CalamityJanet());
        avatars.add(new ElGringo());
        avatars.add(new JesseJones());
        avatars.add(new Jourdonnais());
        avatars.add(new KitCarlson());
        avatars.add(new LuckyDuke());
        avatars.add(new PaulRegret());
        avatars.add(new PedroRamirez());
        avatars.add(new RoseDoolan());
        avatars.add(new SidKetchum());
        avatars.add(new SlabTheKiller());
        avatars.add(new SuzyLafayette());
        avatars.add(new WillyTheKid());
    }
    
    public Avatar giveAvatar() {  
        int numberOfAvatar = randomizer.nextInt(avatarCounter);
        Avatar toBeGiven = avatars.get(numberOfAvatar);
        avatars.remove(numberOfAvatar);
        avatarCounter--;
        return toBeGiven;
    }
}