import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BuildStickers {
    public void build() throws IOException {
        //leitura da imagem
        BufferedImage originalImage = ImageIO.read(new File("imagem.jpg"));
        //cria nova imagem em memória com transparencia e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copia a imagem original para nova imagem(em memoria)
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        //escrever uma frase na imagem
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setFont(font);
        graphics.setColor(Color.CYAN);
        graphics.drawString("Alura Cursos Online de Tecnologia", 10, height + 50);

        //criar a imagem em um novo arquivo
        ImageIO.write(newImage, "png", new File("saida/imagem.png"));
        
    }
    public static void main(String[] args) throws IOException {
        var builder = new BuildStickers();
        builder.build();
    }
}
