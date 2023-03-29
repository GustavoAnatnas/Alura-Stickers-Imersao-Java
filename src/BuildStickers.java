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
        //escrever uma frase na imagem
        //criar a imagem em um novo arquivo
        //
    }
}
