public class Produto {
    private String nome;
    private String descricao;
    private float valor;
    private int estoque;

    public Produto(String nome,String descricao,float valor,int estoque){
        this.nome=nome;
        this.descricao=descricao;
        this.valor=valor;
        this.estoque=estoque;
    }
    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }

    public float getValor() {
        return this.valor;
    }

    public int getEstoque() {
        return this.estoque;
    }
    public void setEstoque(int estoque){
        this.estoque=estoque;
    }
}
