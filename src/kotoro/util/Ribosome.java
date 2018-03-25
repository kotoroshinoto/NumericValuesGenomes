package kotoro.util;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by mgooc on 3/25/2018.
 */
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
