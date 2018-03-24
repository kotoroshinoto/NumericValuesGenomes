package kotoro.color;

import java.util.Collection;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Created by mgooc on 3/23/2018.
 */
public class ColorMix {

    public ArrayList<MixableColor> colors;

    public ColorMix(){
        this.colors = new ArrayList<MixableColor>();
    }
    public ColorMix(MixableColor... colors){
        this.colors = new ArrayList<MixableColor>();
        for(MixableColor c: colors) {
            this.add_color(c);
        }
    }
    public ColorMix(Collection<MixableColor> colors){
        this.colors = new ArrayList<MixableColor>(colors);
    }

    public void add_color(MixableColor c){
        colors.add(c);
    }

    public float[] get_centroid(boolean... additive){
        boolean use_cmyk = true;
        if(additive.length == 1){
            use_cmyk = !(additive[0]);
        }
        if(additive.length > 1){
            throw new IllegalArgumentException("too many arguments given");
        }
        if(colors.size() < 2){
            throw new RuntimeException("Must provide at least two colors");
        }

        float[] mix = new float[MixableColor.cmyk.getNumComponents()];
        for(MixableColor mc:colors){
            float[] c;
            if(use_cmyk){
                c = mc.to_cmyk();
            } else {
                c = mc.to_xyz();
            }

            for(int i=0;i<c.length;i++){
                mix[i] += c[i] / ((float)colors.size());
            }
        }
        return mix;
    }

    public MixableColor get_substractive_color(){
        return new MixableColor(new Color(MixableColor.cmyk, this.get_centroid(false), 1.0f));
    }

    public MixableColor get_additive_color(){
        return new MixableColor(new Color(MixableColor.ciexyz, this.get_centroid(true), 1.0f));
    }

}
