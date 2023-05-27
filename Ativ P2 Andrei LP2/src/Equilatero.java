public class Equilatero extends Triangulo{
    public Equilatero(int numLados, String nome, float[] dimensoes) {
        super(numLados,nome, dimensoes);
        if(dimensoes[0]!=dimensoes[1] || dimensoes[0]!=dimensoes[2] || dimensoes[1]!=dimensoes[2]){
            System.out.println("O TRIÂNGULO" + nome +"NÃO É EQUILÁTERO");
            System.exit(1);
        }
    }

    public static float[] arrayDimensoes(float lado){
        return new float[]{lado,lado,lado};
    }
}
