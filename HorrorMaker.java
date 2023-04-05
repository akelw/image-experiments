package inputTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class HorrorMaker {
	
	public static void makeHorror() {
	
	BufferedImage img = null;
	File f = null;
	Scanner get = new Scanner(System.in);
	System.out.println("Input file directory of desired image: ");
	String fileDirct = /* wantedFile; */get.nextLine();
	//read image
	try {
		f = new File(fileDirct);
		img = ImageIO.read(f);
	} catch (IOException e) {
		System.out.println(e);
	}
	int height = img.getHeight();
	int width = img.getWidth();
	int pixColor;
	int blue;
	int green;
	int red;
	int alpha;
	Scanner z = new Scanner(System.in);
	System.out.println("Input AAAAAAAA AAAAAAAAA multiplier: ");
	int mult = z.nextInt();
	for(int y = 0; y<height; y++) {
		for(int x = 0; x<width; x++){
			pixColor = img.getRGB(x,y);
			blue = (pixColor & 0xff)*mult;
			green = ((pixColor & 0xff00) >> 8)*mult;
			red = ((pixColor & 0xff0000) >> 16)*mult;
			alpha = pixColor >> 24 & 0xff;
			pixColor = (alpha << 24) | (red << 16) | (green << 8) | blue;
			img.setRGB(x, y, pixColor);
			}
	}
	Scanner in = new Scanner(System.in);
	Scanner ip = new Scanner(System.in);
	System.out.println("input file directory:");
	String directory = ip.nextLine();
	System.out.println("name the new file:");
	String newFileName = in.nextLine();
	try {
        f = new File(
            directory+"\\"+newFileName+".png");
        ImageIO.write(img, "png", f);
        System.out.println("It Worked");
    }
    catch (IOException e) {
        System.out.println(e);
    }
	in.close();
	get.close();
	z.close();
	ip.close();
}
	public static void main(String args[]) {
		makeHorror();
	}
}
