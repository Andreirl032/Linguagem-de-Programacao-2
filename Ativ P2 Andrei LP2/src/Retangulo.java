//import java.util.ArrayList;
public class Retangulo extends Quadrilatero {
    public Retangulo(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        if (
                !((dimensoes[0] == dimensoes[1] && dimensoes[2] == dimensoes[3]) ||
                        (dimensoes[0] == dimensoes[2] && dimensoes[1] == dimensoes[3]) ||
                        (dimensoes[0] == dimensoes[3] && dimensoes[1] == dimensoes[2]))
        ) {
            System.out.println("O QUADRILÁTERO" + nome + "NÃO É UM RETÂNGULO");
            System.exit(1);
        }
    }

    public static float[] arrayDimensoes(float lado, float lado2) {
        return new float[]{lado, lado, lado2, lado2};
    }
}
        /*boolean flag=false;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                if(i!=j) {
                    int count1=0;
                    int count2=0;
                    ArrayList<Float> meuArray= new ArrayList<Float>();
                    for(int k=0;k<5;k++){
                        if(i!=k && j!=k){
                            meuArray.add((Float)dimensoes[k]);
                        }
                    }
                    if ((dimensoes[i] == dimensoes[j]) && ((float)meuArray.get(0) == (float)meuArray.get(1))) {
                        flag=true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        if(!flag){
            System.out.println("O QUADRILÁTERO" + nome +"NÃO É UM RETÂNGULO");
            System.exit(1);
        }*/