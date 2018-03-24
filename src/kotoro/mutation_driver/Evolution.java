package kotoro.mutation_driver;
import com.sun.javaws.exceptions.InvalidArgumentException;
import kotoro.color.ColorMix;
import kotoro.color.MixableColor;

import java.awt.*;


/**
 * Created by mgooc on 10/5/2016.
 */
public class Evolution {

    public static void main(String[] argv){
        if(MixableColor.cmyk == null){
            throw new RuntimeException("could not load CMYK profile");
        }
        MixableColor color_red = new MixableColor(Color.RED);
        MixableColor color_yellow = new MixableColor(Color.YELLOW);
        MixableColor color_blue = new MixableColor(Color.BLUE);
        MixableColor color_white = new MixableColor(Color.WHITE);
        MixableColor color_black = new MixableColor(Color.BLACK);

        color_red.print_cmyk();
        color_red.print_rgb();
        color_yellow.print_cmyk();
        color_yellow.print_rgb();
        color_blue.print_cmyk();
        color_blue.print_rgb();
        System.out.println("MIXING");
        ColorMix mix = new ColorMix( color_red, color_yellow, color_blue, color_black);
        MixableColor mix_result = mix.get_substractive_color();
        System.out.println("MIXED");
        mix_result.print_cmyk();
        mix_result.print_rgb();
//        System.out.println(Evolution.class.getClassLoader().getResource("icc/CMYK/USWebUncoated.icc"));
    }
}
