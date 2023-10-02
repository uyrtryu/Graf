package curs2.progect.grafic;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Video1 {


    public static void ColorVideo(){
        // Создаём окно для просмотра изображения.
        JFrame window = new JFrame("Window:");
        // Создаём контейнер для изображения.
        JLabel screen = new JLabel();
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);

        VideoCapture cap = new VideoCapture("src\\car.mp4");
        Mat frame = new Mat();
        MatOfByte buf = new MatOfByte();
        ImageIcon ic;
        while (cap.grab()) {

            cap.read(frame);
            String outputFileName = "output.png";
            HighGui.imshow(outputFileName, frame);
            MyImg myImg = new MyImg();
            myImg.outPictureColor(outputFileName,0.4);

            Imgcodecs.imencode(".png",frame,buf);
            ic = new ImageIcon(buf.toArray());
            screen.setIcon(ic);
            window.setContentPane(screen);
            window.pack();

        }
        cap.release();
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));


    }
}
