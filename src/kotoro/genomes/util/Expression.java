package kotoro.genomes.util;

import kotoro.genomes.gene.Gene;

class RNApol {
    public static String transcribe(Gene g){
        return "";
    }
    //turn codons into rev-comp replacing T with U
    //if we ever decide to introduce exons/introns, perform splicing
}

class Ribosome {
    //turn codons into AAs
    public static String translate(String aas){
        return "";
    }
}

/**
 * Created by mgooc on 6/15/2017.
 */
public class Expression {
    //either should be loaded with a reference to an existing file, or a place to create a config file.
    //if the file is invalid or does not exist, it will randomly generate settings
    //file should be 2 columns, mapping AA values to numbers
    //stop codons will be accounted for automatically, they won't have int values (will count as 0)
    int AAseqToInt(String aas){
        return 0;
    }
    // take a Gene, turn its sequence into amino acids, and translate amino acids into a set of numbers or a number that could represent:
    // a color value, growth rate, adult size, total drop amount etc.
    int SequenceToInt(Gene g){
        return AAseqToInt(Ribosome.translate(RNApol.transcribe(g)));
    }

}
