import curs2.progect.grafic.MyImg;
import curs2.progect.grafic.Video1;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.IOException;

import static org.opencv.imgcodecs.Imgcodecs.imread;

public class Main {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);
    }
    public static void main(String[] args) throws IOException {
        MyImg myImg = new MyImg();
        Video1 video = new Video1();

//        Mat img = Imgcodecs.imread("src/AT.png");



          Video1.ColorVideo();
//        myImg.outPictureGray("src\\AT.png",0.3,"src\\A.txt");
//        myImg.outPictureColor("src\\AT.png", 0.2);
    }
}