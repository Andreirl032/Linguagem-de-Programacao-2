import java.awt.Color;
public class Pixel extends Ponto{
    Color cor;

    public Pixel(float x,float y,Color cor) {
        super(x,y);
        this.cor = cor;
    }

    public Color getCor() {
        return this.cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}
