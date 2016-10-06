package kotoro.genomes.feature;

import kotoro.genomes.feature.Motif;
import java.util.ArrayList;

/**
 * Created by mgooc on 10/3/2016.
 */
public class GenomicFeature {
    private int chrom;
    private int start;
    private int end;
    private Motif type;
    ArrayList<GenomicFeature> subfeatures;
    GenomicFeature parentFeature;
}
