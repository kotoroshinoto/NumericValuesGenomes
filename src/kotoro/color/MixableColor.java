package kotoro.color;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;

class ColorSpaceLoader{
    static ICC_ColorSpace get_cmyk_color_space(){
        try{
            ICC_Profile cmyk_prof = ICC_Profile.getInstance("C:\\Users\\mgooc\\IdeaProjects\\NumericValueGenomes\\icc\\CMYK\\USWebUncoated.icc");
            return new ICC_ColorSpace(cmyk_prof);
        } catch (java.io.IOException e){
            return null;
        }
    }
}

/**
 * Created by mgooc on 3/23/2018.
 */
public class MixableColor {
    public static ICC_ColorSpace cmyk = ColorSpaceLoader.get_cmyk_color_space();
    public static ColorSpace ciexyz = ColorSpace.getInstance(ColorSpace.CS_CIEXYZ);
    private int red;
    private int green;
    private int blue;

    public MixableColor(int r, int g, int b){
        this.red=r;
        this.green=g;
        this.blue=b;
    }

    public MixableColor(Color c){
        this.red=c.getRed();
        this.green=c.getGreen();
        this.blue=c.getBlue();
    }

    public void print_xyz(){
        float[] c=this.to_xyz();
        System.out.format("X:%f, Y:%f, Z:%f\n", c[0], c[1], c[2]);
    }
    public void print_cmyk(){
        float[] c=this.to_cmyk();
        System.out.format("C:%f, M:%f, Y:%f, K:%f\n", c[0], c[1], c[2], c[3]);
    }
    public void print_rgb(){
        System.out.format("R:%03d, G:%03d, B:%03d\n", this.red, this.green, this.blue);
    }

    float[] to_cmyk(){
        Color c = new Color(this.red, this.green, this.blue);
        return MixableColor.cmyk.fromRGB(c.getColorComponents(null));
    }
    float[] to_xyz(){
        Color c = new Color(this.red, this.green, this.blue);
        return MixableColor.ciexyz.fromRGB(c.getColorComponents(null));
    }

}
