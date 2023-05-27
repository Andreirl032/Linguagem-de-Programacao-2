public abstract class FiguraGeometrica implements FiguraPlanar {
    protected int numLados;
    protected String nome;
    protected float[] dimensoes;

    public FiguraGeometrica(int numLados, String nome, float[] dimensoes) {
        this.numLados = numLados;
        this.nome = nome;
        this.dimensoes = dimensoes;
        if(dimensoes.length<3){
            System.out.println("ERRO: UMA FIGURA GEOMÉTRICA DEVE TER NO MÍNIMO 3 " +
                    "LADOS, A FIGURA"+nome+" POSSUI APENAS"+numLados+"LADOS");
            System.exit(1);
        }
    }

    void mostrarDimensoes(){
        System.out.println("TAMANHO DOS LADOS DA FIGURA "+nome+":");
        for(float d:dimensoes){
            System.out.println(d);
        }
    }

    void mostrarPerimetro(){
        System.out.println("PERÍMETRO DA FIGURA "+nome+":");
        float perimetro = 0;
        for (float d:dimensoes){
            perimetro+=d;
        }
    }

    public float calcularPerimetro(){
        float perimetro=0;
        for(float d:this.dimensoes){
            perimetro+=d;
        }
        return perimetro;
    }

    public abstract float calcularArea();


    public int getNumLados() {
        return this.numLados;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float[] getDimensoes() {
        return this.dimensoes;
    }

    public void setDimensoes(float[] dimensoes) {
        this.dimensoes = dimensoes;
    }
}

