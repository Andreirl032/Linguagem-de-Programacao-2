//Feito por Andrei
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<FiguraGeometrica> figuras= new ArrayList<>();
        figuras.add(new Equilatero(3,"equilátero bacana",Equilatero.arrayDimensoes(5)));
        figuras.add(new Isosceles(3,"isósceles maneiro",Isosceles.arrayDimensoes(5,3)));
        figuras.add(new Escaleno(3,"escaleno dahora",Escaleno.arrayDimensoes(5,3,6)));
        figuras.add(new Quadrado(4,"quadrado do balacobaco",Quadrado.arrayDimensoes(7)));
        figuras.add(new Retangulo(4,"retângulo show de bola",Retangulo.arrayDimensoes(4,9)));
        compararPerimetro(figuras.get(0),figuras.get(4));
    }

    static void compararPerimetro(FiguraGeometrica obj1,FiguraGeometrica obj2){
        float p1=obj1.calcularPerimetro();
        float p2=obj2.calcularPerimetro();
        if(p1>p2){
            System.out.println("A figura com maior perímetro é a figura "+
                    obj1.getNome()+", com "+p1+" de perímetro");
        }
        else if(p2>p1){
            System.out.println("A figura com maior perímetro é a figura "+
                    obj2.getNome()+", com "+p2+" de perímetro");
        }
        else{
            System.out.println("As figuras"+obj1.getNome()+" e "+
                    obj2.getNome()+" possuem o mesmo perímetro, que é de "+p1);
        }
    }

    static void compararArea(FiguraGeometrica obj1,FiguraGeometrica obj2){
        float a1=obj1.calcularArea();
        float a2=obj2.calcularArea();
        if(a1>a2){
            System.out.println("A figura com maior área é a figura "+
                    obj1.getNome()+", com "+a1+" de área");
        }
        else if(a2>a1){
            System.out.println("A figura com maior área é a figura "+
                    obj2.getNome()+", com "+a2+" de área");
        }
        else{
            System.out.println("As figuras"+obj1.getNome()+" e "+
                    obj2.getNome()+" possuem a mesma área, que é de "+a1);
        }
    }
}