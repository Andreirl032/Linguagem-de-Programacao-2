public class Quadrilatero extends FiguraGeometrica{
    public Quadrilatero(int numLados, String nome, float[] dimensoes) {
        super(numLados, nome, dimensoes);
        boolean flag=true;
        for(float d:dimensoes){
            if(d==0){
                flag=false;
                break;
            }
        }
        if(numLados!=4 || flag==false){
            System.out.println("ERRO: A FIGURA GEOMÉTRICA "+nome+" NÃO É UM QUADRILÁTERO");
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
        return dimensoes[0]*dimensoes[1];
    }
}