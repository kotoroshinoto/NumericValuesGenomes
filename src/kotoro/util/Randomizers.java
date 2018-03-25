package kotoro.util;

import java.security.SecureRandom;
/**
 * Created by mgooc on 10/6/2016.
 */

public class Randomizers {
    private static SecureRandom random = new SecureRandom();
    public char getRandomIUPAC(){
        char[] IUPAC_chars = IUPAC.getIUPACchars();
        return IUPAC_chars[Randomizers.random.nextInt(IUPAC_chars.length)];
    }
    public char getRandomNucleotide(){
        char[] DNA_chars = IUPAC.getDNAchars();
        return DNA_chars[Randomizers.random.nextInt(DNA_chars.length)];
    }
    public String getRandomDNAseq(int length){
        char[] DNA_chars = IUPAC.getDNAchars();
        String seq = "";
        for (int i = 0; i < length; i++){
            seq += DNA_chars[Randomizers.random.nextInt(DNA_chars.length)];
        }
        return seq;
    }
    public String getRandomIUPACseq(int length){
        char[] IUPAC_chars = IUPAC.getIUPACchars();
        String seq = "";
        for (int i = 0; i < length; i++){
            seq += IUPAC_chars[Randomizers.random.nextInt(IUPAC_chars.length)];
        }
        return seq;
    }

    public String getRandomIUPAC_AA_seq(int length){
        //todo method stub
        return "";
    }

    public String getRandomIUPAC_AA_seq_no_stop(int length){
        //todo method stub
        return "";
    }

    public String getRandomHexID(int length){
        byte[] bytes = new byte[length];
        Randomizers.random.nextBytes(bytes);
        final char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public String getRandomChromosomeSeq(int length){
        //todo method stub
        //generate telomeres
        //generate centromere
        return "";
    }

    public String getRandomGeneSeq(int length){
        //todo method stub
        //choose + or - strand direction
        //construct promoter region
        //add start codon
        //generate random AA sequence (with no stops)
        //convert AA seq to random codons and add this sequence
        //add random stop codon
        return "";
    }

    public String getRandomGeneSeq(int length, int target_value){
        //todo method stub
        //choose + or - strand direction
        //construct promoter region
        //add start codon
        //generate somewhat random AA sequence that meets needed value:
        //  toss required AA into a temporary container,
        //  balance excess once value is reached  by selecting + and - AA with same values and 0 value AAs
        //  randomize retrieval to build final AA seq
        //convert AA seq to random codons and add this sequence
        //add random stop codon
        return "";
    }
}
