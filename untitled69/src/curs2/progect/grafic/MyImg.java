package curs2.progect.grafic;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.opencv.imgproc.Imgproc.FONT_HERSHEY_PLAIN;

public class MyImg {


    public void outPictureGray(String imgWay, double scaleFactor, String saveTxt) throws IOException {

        File file = new File(saveTxt);
        Mat img = Imgcodecs.imread(imgWay);
        FileWriter writer = new FileWriter(file);
        double w, h;
        w = img.size(1);
        h = img.size(0);

        double oneCharWidth = 8;
        double oneCharHeight = 18;

        String che = " .,-=+:;^_!?0123456789NW@#";
        char[] pix = che.toCharArray();

        Imgproc.resize(img, img, new Size((w * scaleFactor), h * scaleFactor * (oneCharWidth / oneCharHeight)));

        w = img.size(1);
        h = img.size(0);

        double lChar = pix.length;

        double interval = lChar / 256;


        for (int i = 0; i < h; i++) {

            for (int j = 0; j < w; j++) {
                int r = (int) img.get(i, j)[2];
                int g = (int) img.get(i, j)[1];
                int b = (int) img.get(i, j)[0];
                int n = (r / 3 + g / 3 + b / 3);
                img.get(i, j)[0] = n;
                img.get(i, j)[1] = n;
                img.get(i, j)[2] = n;
                int l = (int) Math.floor(n * interval);

                String q = String.valueOf(pix[l]);
                writer.write(q);

            }


            writer.write('\n');
        }
        writer.close();

    }

    public void outPictureColor(String imgWay, double scaleFactor) {

        Mat img = Imgcodecs.imread(imgWay);
        double w, h;
        w = img.size(1);
        h = img.size(0);

        double oneCharWidth = 8;
        double oneCharHeight = 18;

        String che = " .,-=+:;^_!?0123456789NW@#";
        char[] pix = che.toCharArray();

        Imgproc.resize(img, img, new Size((w * scaleFactor), h * scaleFactor * (oneCharWidth / oneCharHeight)));

        w = img.size(1);
        h = img.size(0);

        Mat outputImage = new Mat((int) (oneCharHeight * h), (int) (oneCharWidth * w), CvType.CV_8UC3, new Scalar(0, 0, 0));


        double lChar = pix.length;

        double interval = lChar / 256;


        for (int i = 0; i < h; i++) {

            for (int j = 0; j < w; j++) {
                int r = (int) img.get(i, j)[2];
                int g = (int) img.get(i, j)[1];
                int b = (int) img.get(i, j)[0];

                int n = (r / 3 + g / 3 + b / 3);

                img.get(i, j)[0] = n;
                img.get(i, j)[1] = n;
                img.get(i, j)[2] = n;


                int l = (int) Math.floor(n * interval);
                Point org = new Point((oneCharWidth * j), (oneCharHeight * i));
                String q = String.valueOf(pix[l]);
                Scalar scalar = new Scalar(b, g, r);

                Imgproc.putText(outputImage, q, org, FONT_HERSHEY_PLAIN, 1.0, scalar, 2);

            }
        }
        Imgcodecs.imwrite("output_image.png", outputImage);
    }


}
