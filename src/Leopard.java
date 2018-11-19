import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import javax.swing.JPanel;

public class Leopard {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1920, 1280);

     /*Читаем картинку в папке и делаем ее копию в ту же папку*/
        File file = new File("src/Leopard.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "jpg", new File("Leopardcopy1.png"));
        System.out.println("Мы скопировали файл по адресу:\n" + file);


        /*Дальше мои эксперементы считывания InOutputStream открытие ее через JPanel и JFrame*/


        InputStream inputStream = new FileInputStream(file);
        BufferedImage image1 = ImageIO.read(inputStream); /*превращаем картинку в массив данных через InputStream*/
        System.out.println("\nНаша картинка, превращенная в массив байтов, выглядит вот так: \n"+image1);       /*распечатываем в консоль массив байтов,
                                            в который InputStream превратил нашу картинку*/
        JPanel panel = new ImageBackgroundPanel(image1); /*Восттанавливаем картинку из нашего массива байтов через
                                                           JPanel и  JFrame*/
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("\nКартинка восстановлена и выведена на экран в открывшемся окне!!! ;-)");
    }

    static class ImageBackgroundPanel extends JPanel {
        BufferedImage image;

        ImageBackgroundPanel(BufferedImage image) {
            this.image = image;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
}
