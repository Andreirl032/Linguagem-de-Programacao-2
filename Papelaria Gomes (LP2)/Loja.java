import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loja {
    private String nome;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

    public void registrarVenda(Integer matricula,String nomeProduto, int quantidade){
        Vendedor vendedor=null;
        Produto produto=null;
        for(Vendedor v:vendedores) {
            if(v.getMatricula()==matricula){
                vendedor=v;
            }
        }
        for(Produto p:produtos){
            if(p.getNome().equals(nomeProduto)){
                produto=p;
            }
        }
        //subtrai do estoque a quantidade de itens vendidos
        int estoque=produto.getEstoque()-quantidade;
        if(estoque<0){
            System.out.println("Sem estoque para "+quantidade+" venda(s) do produto "+produto.getNome()+" pelo vendedor "+vendedor.getNome());
            return;
        }
        produto.setEstoque(estoque);

        Map<Produto,Integer> vendas = vendedor.getVendas();
        if(vendas.containsKey(produto)) {
            quantidade += vendas.get(produto);
        }
        vendas.put(produto,quantidade);
    }

    public void mostrarRelatorioCompleto(){
        Vendedor vendedor = null;
        float totalVendas=0f;
        for(Vendedor v:vendedores){
            System.out.println(v.getMatricula());
            System.out.println(v.getNome());
            v.mostrarRelatorio();

            Map<Produto,Integer> vendas = v.getVendas();
            for (Map.Entry<Produto,Integer> venda : vendas.entrySet()) {
                totalVendas+=venda.getValue()*venda.getKey().getValor();
            }
        }
        System.out.println(totalVendas);


    }
    public void mostrarEstoque(){
        for(Produto p:produtos){
            System.out.println(p.getNome());
            System.out.println(p.getValor());
            System.out.println(p.getEstoque());
            System.out.println();
        }
    }
    public Loja(String nome){
        this.nome=nome;
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }
    public void addVendedor(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

}
