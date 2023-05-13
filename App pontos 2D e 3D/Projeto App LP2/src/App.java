import java.lang.Math;
public class App {
    Ponto A;
    Ponto_3D B;
    Pixel C;
    Voxel D;

    public App(Ponto a, Ponto_3D b, Pixel c, Voxel d) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    static float distancia2d(Ponto p1, Ponto p2){
        double xsquare=Math.pow((p1.x-p2.x),2);
        double ysquare=Math.pow((p1.y-p2.y),2);
        double xy=xsquare+ysquare;
        return (float)(Math.pow(xy,(1.0/2.0)));
    }


    static float distancia3d(Ponto p1, Ponto p2) {
        double xsquare = Math.pow((p1.x - p2.x), 2);
        double ysquare = Math.pow((p1.y - p2.y), 2);

        if (p1 instanceof Ponto_3D && p2 instanceof Ponto_3D) {
            Ponto_3D p1_3D = (Ponto_3D) p1;
            Ponto_3D p2_3D = (Ponto_3D) p2;
            double zsquare = Math.pow((p1_3D.z - p2_3D.z), 2);
            double xyz = xsquare + ysquare + zsquare;
            return (float) (Math.pow(xyz, (1.0 / 2.0)));
        }
        else if (p1 instanceof Ponto_3D != p2 instanceof Ponto_3D) {
            return -1;
        }
        else {
            return distancia2d(p1, p2);
        }
    }


    public Ponto getA() {
        return this.A;
    }

    public Ponto_3D getB() {
        return this.B;
    }

    public Pixel getC() {
        return this.C;
    }

    public Voxel getD() {
        return this.D;
    }

    public void setA(Ponto a) {
        this.A = a;
    }

    public void setB(Ponto_3D b) {
        this.B = b;
    }

    public void setC(Pixel c) {
        this.C = c;
    }

    public void setD(Voxel d) {
        this.D = d;
    }
}
