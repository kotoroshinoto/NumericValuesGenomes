package kotoro.util;
import kotoro.color.MixableColor;
import kotoro.genomes.features.gene.Gene;
import java.util.Collection;
import java.util.LinkedList;
import java.util.HashMap;


/**
 * Created by mgooc on 6/15/2017.
 */
public class Expression {
    //get value for expression of gene
    //Single Gene Traits
    public static int ExpressionInt(Gene g){return 0;}
    public static MixableColor ExpressionColor(Gene g){return null;}
    //Multi Gene Traits
    public static int ExpressionInt(Collection<Gene> gcol){return 0;}
    public static MixableColor ExpressionColor(Collection<Gene> gcol){return null;}

    //Get an int value for sequences that are not expressed, such as for weights from UTR, etc.
    public static int SequenceInt(Gene g){
        return 0;
    }
}
