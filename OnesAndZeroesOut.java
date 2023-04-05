package inputTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class OnesAndZeroesOut {
	public static void binaryConversion()
			throws IOException
		{
			BufferedImage img = null;
			File f = null;
			
			//read image
			Scanner in = new Scanner(System.in);
			System.out.println("Input the directory of a image file.\nImages larger than 200x200 tend to be truncated,\nso try inputting something smaller."
					+ "images with high contrast tend to work best");
			String directory = in.nextLine();
			try {
				f = new File(directory);
				img = ImageIO.read(f);
			} catch (IOException e) {
				System.out.println(e);
			}
			int width = img.getWidth();
			System.out.println(width);
			int height = img.getHeight();
			System.out.println(height);
			int[] xSeq = new int[width];
			
			for(int y = 0; y<height; y++) {
				for(int x = 0; x<width; x++){
					int pixColor = img.getRGB(x,y);
					int blue = pixColor & 0xff;
					int green = (pixColor & 0xff00) >> 8;
					int red = (pixColor & 0xff0000) >> 16;
					//reads decimal color and outputs black or white.
					int colorAdd = blue+green+red;
					int colorMag = 765-colorAdd;
					int digit;
					if (colorMag<colorAdd) {
						pixColor = -16777216;
						/*blue = 255;
						green = 255;
						red = 255;*/
						digit = 0;
						xSeq[x] = digit;
					} else { 
						pixColor = -1;
						/*blue = 0;
						green = 0;
						red = 0;*/
						digit = 1;
						xSeq[x] = digit;
						}
					}
				for(int i = 0; i<width; i++) {
					System.out.print(xSeq[i]+" ");
				}
				System.out.print("\n");
				}
			in.close();
		}
		public static void main(String args[]) {
				try {
					binaryConversion();
				} catch (IOException e) {
					System.out.println("you fucked up idiot");
				}
		}
}
