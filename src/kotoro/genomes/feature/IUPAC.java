package kotoro.genomes.feature;

/**
 * Created by mgooc on 10/5/2016.
 */


import java.util.HashMap;

public class IUPAC {
    HashMap<Character, char[]> MatchingCharacters;
    HashMap<Character, String> REstrings;

    private static int getNumBasesRepresented(char sym) {
        switch (sym) {
            case 'A':
            case 'G':
            case 'C':
            case 'T':
//            case 'U':
//                break;
                return 1;
            // ring structure
            case 'Y': // pyrimidine
            case 'R': // purine
                // chemical trait
            case 'K': // keto
            case 'M': // amino
                // strength of bonds
            case 'S': // Strong
            case 'W': // Weak
                return 2;
            // NOT bases
            case 'B': // NOT A
            case 'D': // not C
            case 'H': // not G
            case 'V': // not T
                return 3;
            case 'N':
                return 4;
            default:
                return 0;
        }
    }

    private static char[] getCharsForSymbol(char sym){
        char[] tmpchars = new char[IUPAC.getNumBasesRepresented(sym)];
        switch (sym){
            case 'A':
                tmpchars[0] = 'A';
                break;
            case 'G':
                tmpchars[0] = 'G';
                break;
            case 'C':
                tmpchars[0] = 'C';
                break;
            case 'T':
                tmpchars[0] = 'T';
                break;
//            case 'U':
//                break;
            // ring structure
            case 'Y': // pyrimidine
                tmpchars[0] = 'C';
                tmpchars[1] = 'T';
                break;
            case 'R': // purine
                tmpchars[0] = 'A';
                tmpchars[1] = 'G';
                break;
            // chemical trait
            case 'K': // keto
                tmpchars[0] = 'G';
                tmpchars[1] = 'T';
                break;
            case 'M': // amino
                tmpchars[0] = 'A';
                tmpchars[1] = 'C';
                break;
            // strength of bonds
            case 'S': // Strong
                tmpchars[0] = 'C';
                tmpchars[1] = 'G';
                break;
            case 'W': // Weak
                tmpchars[0] = 'A';
                tmpchars[1] = 'T';
                break;
            //
            case 'B': // NOT A
                tmpchars[0] = 'T';
                tmpchars[1] = 'G';
                tmpchars[2] = 'C';
                break;
            case 'D': // not C
                tmpchars[0] = 'A';
                tmpchars[1] = 'T';
                tmpchars[2] = 'G';
                break;
            case 'H': // not G
                tmpchars[0] = 'A';
                tmpchars[1] = 'T';
                tmpchars[2] = 'C';
                break;
            case 'V': // not T
                tmpchars[0] = 'A';
                tmpchars[1] = 'C';
                tmpchars[2] = 'G';
                break;
            case 'N':
                tmpchars[0] = 'A';
                tmpchars[1] = 'T';
                tmpchars[2] = 'G';
                tmpchars[3] = 'C';
                break;
            default:
                break;
        }
            return tmpchars;
    }
    private static char[] IUPAC_chars = {'A', 'C', 'G', 'T', 'R', 'Y', 'S', 'W', 'K', 'M', 'B', 'D', 'H', 'V', 'N'};
    private static char[] DNA_chars = {'A', 'C', 'G', 'T'};
    private static char[] IUPAC_AA_chars = {};

    public static char[] getIUPAC_AA_chars() {
        return IUPAC.IUPAC_AA_chars;
    }

    public static char[] getIUPACchars(){
        return IUPAC.IUPAC_chars;
    }

    public static char[] getDNAchars(){
        return IUPAC.DNA_chars;
    }

    private IUPAC(){
        MatchingCharacters = new HashMap<Character, char[]>();

        for (char sym : IUPAC_chars) {
            MatchingCharacters.put(sym,IUPAC.getCharsForSymbol(sym));
        }
    }

    private static IUPAC codes = new IUPAC();


}