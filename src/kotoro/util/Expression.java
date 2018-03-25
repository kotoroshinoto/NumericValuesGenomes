package kotoro.util;

import kotoro.genomes.features.gene.Gene;
import java.util.LinkedList;
import java.util.HashMap;

class RNApol {
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

class Ribosome {
    public static HashMap<String, AA> CodonTable=new HashMap<String, AA>();
    static {
        //colU
        //rowU
        Ribosome.CodonTable.put("UUU", AA.F);
        Ribosome.CodonTable.put("UUC", AA.F);
        Ribosome.CodonTable.put("UUA", AA.L);
        Ribosome.CodonTable.put("UUG", AA.L);
        //rowC
        Ribosome.CodonTable.put("CUU", AA.L);
        Ribosome.CodonTable.put("CUC", AA.L);
        Ribosome.CodonTable.put("CUA", AA.L);
        Ribosome.CodonTable.put("CUG", AA.L);
        //rowA
        Ribosome.CodonTable.put("AUU", AA.I);
        Ribosome.CodonTable.put("AUC", AA.I);
        Ribosome.CodonTable.put("AUA", AA.I);
        Ribosome.CodonTable.put("AUG", AA.M);
        //rowG
        Ribosome.CodonTable.put("GUU", AA.V);
        Ribosome.CodonTable.put("GUC", AA.V);
        Ribosome.CodonTable.put("GUA", AA.V);
        Ribosome.CodonTable.put("GUG", AA.V);
        //colC
        //rowU
        Ribosome.CodonTable.put("UCU", AA.S);
        Ribosome.CodonTable.put("UCC", AA.S);
        Ribosome.CodonTable.put("UCA", AA.S);
        Ribosome.CodonTable.put("UCG", AA.S);
        //rowC
        Ribosome.CodonTable.put("CCU", AA.P);
        Ribosome.CodonTable.put("CCC", AA.P);
        Ribosome.CodonTable.put("CCA", AA.P);
        Ribosome.CodonTable.put("CCG", AA.P);
        //rowA
        Ribosome.CodonTable.put("ACU", AA.T);
        Ribosome.CodonTable.put("ACC", AA.T);
        Ribosome.CodonTable.put("ACA", AA.T);
        Ribosome.CodonTable.put("ACG", AA.T);
        //rowG
        Ribosome.CodonTable.put("GCU", AA.A);
        Ribosome.CodonTable.put("GCC", AA.A);
        Ribosome.CodonTable.put("GCA", AA.A);
        Ribosome.CodonTable.put("GCG", AA.A);
        //colA
        //rowU
        Ribosome.CodonTable.put("UAU", AA.Y);
        Ribosome.CodonTable.put("UAC", AA.Y);
        Ribosome.CodonTable.put("UAA", AA.STOP);
        Ribosome.CodonTable.put("UAG", AA.STOP);
        //rowC
        Ribosome.CodonTable.put("CAU", AA.H);
        Ribosome.CodonTable.put("CAC", AA.H);
        Ribosome.CodonTable.put("CAA", AA.Q);
        Ribosome.CodonTable.put("CAG", AA.Q);
        //rowA
        Ribosome.CodonTable.put("AAU", AA.N);
        Ribosome.CodonTable.put("AAC", AA.N);
        Ribosome.CodonTable.put("AAA", AA.K);
        Ribosome.CodonTable.put("AAG", AA.K);
        //rowG
        Ribosome.CodonTable.put("GAU", AA.D);
        Ribosome.CodonTable.put("GAC", AA.D);
        Ribosome.CodonTable.put("GAA", AA.E);
        Ribosome.CodonTable.put("GAG", AA.E);
        //colG
        //rowU
        Ribosome.CodonTable.put("UGU", AA.C);
        Ribosome.CodonTable.put("UGC", AA.C);
        Ribosome.CodonTable.put("UGA", AA.STOP);
        Ribosome.CodonTable.put("UGG", AA.W);
        //rowC
        Ribosome.CodonTable.put("CGU", AA.R);
        Ribosome.CodonTable.put("CGC", AA.R);
        Ribosome.CodonTable.put("CGA", AA.R);
        Ribosome.CodonTable.put("CGG", AA.R);
        //rowA
        Ribosome.CodonTable.put("AGU", AA.S);
        Ribosome.CodonTable.put("AGC", AA.S);
        Ribosome.CodonTable.put("AGA", AA.R);
        Ribosome.CodonTable.put("AGG", AA.R);
        //rowG
        Ribosome.CodonTable.put("GGU", AA.G);
        Ribosome.CodonTable.put("GGC", AA.G);
        Ribosome.CodonTable.put("GGA", AA.G);
        Ribosome.CodonTable.put("GGG", AA.G);
    }
    //turn codons into AAs
    public static LinkedList<AA> translate(String t){
        LinkedList<AA> aal = new LinkedList<AA>();
        for(int i=0; i<t.length(); i+=3){
            String sub;
            if(i+3 >= t.length()) {
                sub = t.substring(i);
            } else {
                sub = t.substring(i, i + 3);
            }
            AA aa = Ribosome.CodonTable.get(sub.toUpperCase());
            if(aa == AA.STOP){
                break; // do not include stop codon
            }
            aal.push(aa);
        }
        return aal;
    }
}


/**
 * Created by mgooc on 6/15/2017.
 */
public class Expression {

    public Expression(String filename){

    }
    //either should be loaded with a reference to an existing file, or a place to create a config file.
    //if the file is invalid or does not exist, it will randomly generate settings
    //file should be 2 columns, mapping AA values to numbers
    //stop codons will be accounted for automatically, they won't have int values (will count as 0)
    int AAseqToInt(LinkedList<AA> aal){
        return 0;
    }
    // take a Gene, turn its sequence into amino acids, and translate amino acids into a set of numbers or a number that could represent:
    // a color value, growth rate, adult size, total drop amount etc.
    int SequenceToInt(Gene g){
        return AAseqToInt(Ribosome.translate(RNApol.transcribe(g)));
    }

}
