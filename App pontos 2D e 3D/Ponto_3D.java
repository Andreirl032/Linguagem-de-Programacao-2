public class Ponto_3D extends Ponto{
    float z;

    public Ponto_3D(float x,float y,float z) {
        super(x,y);
        this.z = z;
    }

    void mostrarCoordenadas3D() {
        if(this instanceof Voxel meuVoxel){
            String message = String.format("X = %f\nY = %f\nZ = %f\nCor = RGB(%d, %d, %d)", this.x, this.y, this.z,meuVoxel.cor.getRed(),meuVoxel.cor.getGreen(),meuVoxel.cor.getBlue());
            System.out.println(message);
        }
        else {
            String message = String.format("X = %f\nY = %f\nZ = %f", this.x, this.y, this.z);
            System.out.println(message);
        }
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
