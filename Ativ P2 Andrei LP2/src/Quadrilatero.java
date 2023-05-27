public class Quadrilatero extends FiguraGeometrica{
    public Quadrilatero(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if(numLados!=4){
            System.out.println("ERRO: A FIGURA GEOMÉTRICA "+nome+" NÃO É UM QUADRILÁTERO");
            System.exit(1);
        }
    }

    @Override
    public float calcularArea() {
        return dimensoes[0]*dimensoes[1];
    }
}