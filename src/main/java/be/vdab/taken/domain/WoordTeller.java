package be.vdab.taken.domain;

import java.util.StringTokenizer;

public class WoordTeller {

    public int aantalWoordenInEenZin(String eenZin) {
        /*var aantalWoorden = 0;
        var index = 0;
        while (index != eenZin.length()) {
            while (index != eenZin.length() &&
                    (eenZin.charAt(index) == ' ' || eenZin.charAt(index) == ',')) {
                index++;
            }
            if (index != eenZin.length()) {
                aantalWoorden++;
                while (index != eenZin.length() &&
                        (eenZin.charAt(index) != ' ' && eenZin.charAt(index) != ',')) {
                    index++;
                }
            }
        }
        return aantalWoorden;*/
        return new StringTokenizer(eenZin, " ,").countTokens();
    }
}
