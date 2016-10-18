package kotoro.genomes;

/**
 * Created by mgooc on 10/3/2016.
 */
public class Chromosome {
    class Chiasma {
        // in real life average number per chromosome is 1.56 per chromosome pair
        // typically one per arm. Would imagine this is more due to sequence length, but perhaps they don't form close to each other either.
    }
    class ChromArm {

    }
    class Centromere {
        //should be a fairly long motif with a somewhat repetetive sequence.
        //could alternatively just blackbox it and split chromosome into arms around it
    }
    class Telomere  {
        // repeating sequence. (TTAGGG)
    }
    class MeioticHomology {
        //abstraction to assist in determining sexual compatibility, meiotic events, etc.
        //real biology would be more complicated
        //should act like GenomicFeatures, mapped to paired sequences on opposite chromosome

    }
}

