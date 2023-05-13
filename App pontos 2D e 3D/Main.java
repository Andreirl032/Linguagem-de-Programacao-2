//FEITO POR ANDREI :)
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ponto ponto1=new Ponto(1,4);
        Ponto ponto2=new Ponto(6,2);
        System.out.println("Ponto 1:");
        ponto1.mostrarCoordenadas2D();
        System.out.println("Ponto 2:");
        ponto2.mostrarCoordenadas2D();
        System.out.println("Distância ponto 1 e ponto 2: "+App.distancia2d(ponto1,ponto2));
        System.out.println();
        Pixel pixel1=new Pixel(7,8,new Color(20,140,50));
        System.out.println("Pixel 1:");
        pixel1.mostrarCoordenadas2D();
        System.out.println("Distância ponto 1 e pixel 1: "+App.distancia2d(ponto1,pixel1));
        System.out.println("\n");

        Ponto_3D ponto3d_1=new Ponto_3D(1,4,8);
        Ponto_3D ponto3d_2=new Ponto_3D(6,2,5);
        System.out.println("Ponto 3D 1:");
        ponto3d_1.mostrarCoordenadas3D();
        System.out.println("Ponto 3D 2:");
        ponto3d_2.mostrarCoordenadas3D();
        System.out.println("Distância ponto 3D 1 e ponto 3D 2: "+App.distancia3d(ponto3d_1,ponto3d_2));
        System.out.println("\n");


        Voxel voxel1 = new Voxel(5,15,6,new Color(95,32,77));
        voxel1.mostrarCoordenadas3D();
        System.out.println("Distância voxel 1 e ponto 3D 2: "+App.distancia3d(voxel1,ponto3d_2));
        System.out.println("\n");
    }

}