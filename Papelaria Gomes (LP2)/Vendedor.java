import java.util.HashMap;
import java.util.Map;
public class Vendedor {
    private int matricula;
    private String nome;
    private Map<Produto,Integer> vendas = new HashMap<Produto,Integer>();
    public Vendedor(String nome, int matricula){
        this.matricula=matricula;
        this.nome=nome;
    }
    public void mostrarRelatorio(){
        for (Map.Entry<Produto,Integer> venda : vendas.entrySet()) {
            String nomeProduto=venda.getKey().getNome();
            String descricao=venda.getKey().getDescricao();
            int quantidade=venda.getValue();
            float valorTotal = venda.getKey().getValor()*quantidade;
//            System.out.println("Nome: %s,Descrição: %s,Valor: %d".format(nomeProduto,descricao,valor));
           /* System.out.println(nomeProduto);
            System.out.println(descricao);
            System.out.println(quantidade);
            System.out.println(valorTotal);*/
            String relatorio = String.format("Nome: %s,Descrição: %s,Quantidade: %d, Valor Total: R$%.2f",nomeProduto,descricao,quantidade,valorTotal);
            System.out.println(relatorio);
            System.out.println();
        }
    }
    public Map<Produto,Integer> getVendas(){
        return this.vendas;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
}
