package kotoro.genomes.features;

import kotoro.util.Motif;
import java.util.ArrayList;

/**
 * Created by mgooc on 10/3/2016.
 */
public abstract class GenomicFeature {
    private int chrom;
    private int start;
    private int end;
    private Motif type;
    ArrayList<GenomicFeature> subfeatures;
    GenomicFeature parentFeature;
}
