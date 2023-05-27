public class Quadrado extends Quadrilatero{
    public Quadrado(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        for(float d:dimensoes) {
            if (d != dimensoes[0]) {
                System.out.println("O QUADRILÁTERO" + nome +"NÃO É UM QUADRADO");
                System.exit(1);
            }
        }
    }
    public static float[] arrayDimensoes(float lado){
        return new float[]{lado,lado,lado,lado};
    }
}
