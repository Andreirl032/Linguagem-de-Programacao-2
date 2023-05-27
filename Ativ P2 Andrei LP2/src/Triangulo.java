import java.lang.Math;
public class Triangulo extends FiguraGeometrica{
    public Triangulo(int numLados,String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if(!(numLados!=3 || dimensoes[0]+dimensoes[1]>dimensoes[2] ||
                dimensoes[0]+dimensoes[2]>dimensoes[1] || dimensoes[1]+dimensoes[2]>dimensoes[0])){
            System.out.println("ERRO: A FIGURA GEOMÉTRICA "+nome+" NÃO É UM TRIÂNGULO.");
            System.exit(1);
        }
    }

    @Override
    public float calcularArea() {
        float s = calcularPerimetro() / 2;
        return (float)Math.sqrt(s*(s- this.getDimensoes()[0])*(s- this.getDimensoes()[1])*(s- this.getDimensoes()[2]));
    }

}
