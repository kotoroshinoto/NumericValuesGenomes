package kotoro.util;

import kotoro.genomes.features.gene.Gene;

/**
 * Created by mgooc on 3/25/2018.
 */
public class RNApol {
    public static String transcribe(Gene g){
        String revcomp="";
        //TODO, reverse string, replace T with U
        StringBuilder sb = new StringBuilder(g.get_sequence());
        return sb.reverse().toString().replaceAll("T", "U");
    }
    //turn codons into rev-comp replacing T with U
    //if we ever decide to introduce exons/introns, perform splicing
}

enum AA {
    G, //Glycine
    A, //Alanine
    L, //Leucine
    M, //Methionine
    F, //Phenylalanine
    W, //Tryptophan
    K, //Lysine
    Q, //Glutamine
    E, //Glutamic Acid
    S, //Serine
    P, //Proline
    V, //Valine
    I, //Isoleucine
    C, //Cysteine
    Y, //Tyrosine
    H, //Histidine
    R, //Arginine
    N, //Asparagine
    D, //Aspartic Acid
    T,  //Threonine
    STOP // STOP CODONS
}
