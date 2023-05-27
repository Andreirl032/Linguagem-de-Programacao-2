public class Escaleno extends Triangulo{
    public Escaleno(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if((dimensoes[0]==dimensoes[1] || dimensoes[0]==dimensoes[2] || dimensoes[1]==dimensoes[2])
                &&(nome!="null" && numLados!=0 && dimensoes[0]!=0 && dimensoes[1]!=0&& dimensoes[2]!=0)){
            System.out.println("O TRIÂNGULO " + nome +" NÃO É ESCALENO");
//            System.exit(1);
        }
    }

    public static float[] arrayDimensoes(float lado1,float lado2,float lado3){
        return new float[]{lado1,lado2,lado3};
    }
}
