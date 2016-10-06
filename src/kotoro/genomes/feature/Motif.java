package kotoro.genomes.feature;

/**
 * Created by mgooc on 10/5/2016.
 */
public class Motif {
    public enum MotifType {
        BRE, TATA, INR, CENTROMERE, TELOMERE
    }
}
//NOTE: I am ignoring DPEs for now as their role in vertebrates isn't well established.

//Default Motifs
// BRE: SSRCGCC
// TATA: TATAWAAR
// INR: YYANWYY
// telomere: TTAGGG

//geometry
//BRE (-37 to -32 )
//TATA (-31 to -26)
//INR (-2 to 4)
