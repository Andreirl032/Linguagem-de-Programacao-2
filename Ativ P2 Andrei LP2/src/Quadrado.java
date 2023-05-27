public class Quadrado extends Quadrilatero{
    public Quadrado(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if(nome!="null" && numLados!=0 && dimensoes[0]!=0 && dimensoes[1]!=0&& dimensoes[2]!=0) {
            for (float d : dimensoes) {
                if (d != dimensoes[0]) {
                    System.out.println("O QUADRILÁTERO" + nome + "NÃO É UM QUADRADO");
//                    System.exit(1);
                }
            }
        }
    }
    public static float[] arrayDimensoes(float lado){
        return new float[]{lado,lado,lado,lado};
    }
}
