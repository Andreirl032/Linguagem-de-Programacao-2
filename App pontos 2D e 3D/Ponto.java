public class Ponto {
    float x;
    float y;

    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void mostrarCoordenadas2D(){
        if(this instanceof Pixel meuPixel){
            String message = String.format("X = %f\nY = %f\nCor = RGB(%d, %d, %d)",this.x,this.y,meuPixel.cor.getRed(),meuPixel.cor.getGreen(), meuPixel.cor.getBlue());
            System.out.println(message);
        }
        else{
        String message = String.format("X = %f\nY = %f",this.x,this.y);
        System.out.println(message);
        }
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
