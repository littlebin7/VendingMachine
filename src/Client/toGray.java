package Client;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class toGray {
    /*
     * 使用加权法把24位色彩图转化为灰度图
     */
    public static BufferedImage convertToGray(String imagePath)
    {
        BufferedImage bufferedImage = null;
        try
        {
            bufferedImage = ImageIO.read(new File(imagePath));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        assert bufferedImage != null;
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage result = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        for(int j = 0;j < height;j++)
        {
            for(int i = 0;i < width;i++)
            {
                int argb = bufferedImage.getRGB(i, j);
                int a =  argb >> 24 & 0xFF;
                int r = argb >> 16 & 0xFF;
                int g = argb >> 8 & 0xFF;
                int b = argb & 0xFF;

                int gray = (int)(0.3 * r + 0.59 * g + 0.11 * b); //灰度值
                int grayARGB = a << 24 | gray << 16 | gray << 8  | gray;

                result.setRGB(i, j, grayARGB);
            }
        }
        return result;
    }
}
