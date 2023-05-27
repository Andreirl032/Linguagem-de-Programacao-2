import java.lang.Math;
public class Triangulo extends FiguraGeometrica{
    public Triangulo(int numLados,String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        boolean flag=true;
        for(float d:dimensoes){
            if(d==0){
                flag=false;
                break;
            }
        }
        if(!(numLados==3 && dimensoes[0]+dimensoes[1]>dimensoes[2] &&
                dimensoes[0]+dimensoes[2]>dimensoes[1] && dimensoes[1]+dimensoes[2]>dimensoes[0] && flag==true)){
            System.out.println("ERRO: A FIGURA GEOMÉTRICA "+nome+" NÃO É UM TRIÂNGULO.");
//            System.exit(1);
            this.setNome("null");
            this.setNumLados(0);
            for(int i=0;i<dimensoes.length;i++){
                this.dimensoes[i]=0;
            }
        }
    }

    @Override
    public float calcularArea() {
        float s = calcularPerimetro() / 2;
        return (float)Math.sqrt(s*(s- this.getDimensoes()[0])*(s- this.getDimensoes()[1])*(s- this.getDimensoes()[2]));
    }

}
