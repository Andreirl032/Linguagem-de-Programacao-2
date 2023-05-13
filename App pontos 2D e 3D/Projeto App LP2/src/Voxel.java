import java.awt.Color;
public class Voxel extends Ponto_3D{
    Color cor;

    public Voxel(float x,float y, float z,Color cor) {
        super(x,y,z);
        this.cor = cor;
    }

    public Color getCor() {
        return this.cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}
