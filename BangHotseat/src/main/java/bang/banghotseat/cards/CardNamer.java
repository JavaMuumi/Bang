/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

/**
 *
 * @author Antti Korpi
 */
public class CardNamer {

    public String checkNumber(int number) {

        if (number == 1) {
            return "Ace";
        } else if (number == 11) {
            return "Jack";
        } else if (number == 12) {
            return "Queen";
        } else if (number == 13) {
            return "King";
        }
        return null;
    }
}