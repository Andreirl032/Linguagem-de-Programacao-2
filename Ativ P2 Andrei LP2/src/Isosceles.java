public class Isosceles extends Triangulo{
    public Isosceles(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if(!(
                   (dimensoes[0]!=dimensoes[1]&&(dimensoes[2]==dimensoes[0] || dimensoes[2]==dimensoes[1]))
                || (dimensoes[0]!=dimensoes[2]&&(dimensoes[1]==dimensoes[0] || dimensoes[1]==dimensoes[2]))
                || (dimensoes[1]!=dimensoes[2]&&(dimensoes[0]==dimensoes[1] || dimensoes[0]==dimensoes[2]))
        )){
            System.out.println("O TRIÂNGULO " + nome +" NÃO É ISÓSCELES");
            System.exit(1);
        }
    }
    public static float[] arrayDimensoes(float ladoIgual,float ladoDiferente){
        return new float[]{ladoIgual,ladoIgual,ladoDiferente};
    }
}
