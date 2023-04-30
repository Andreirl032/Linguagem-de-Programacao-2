//FEITO POR ANDREI RAMOS LOPES
public class Main {
    public static void main(String [] args){
        Loja papelariaGomes = new Loja("Papelaria Gomes");
        Produto caneta = new Produto("Caneta","Azul",3.00f,25);
        Produto caderno = new Produto("Caderno","96 folhas",25.00f,20);
        Produto lapis = new Produto("Lápis","HB",1.00f,5);
        Vendedor manoel = new Vendedor("Manoel Gomes",1);
        Vendedor joao = new Vendedor("João Gomes",2);
        Vendedor ciro = new Vendedor("Ciro Gomes",3);
        papelariaGomes.addProduto(caneta);
        papelariaGomes.addProduto(caderno);
        papelariaGomes.addProduto(lapis);
        papelariaGomes.addVendedor(manoel);
        papelariaGomes.addVendedor(joao);
        papelariaGomes.addVendedor(ciro);
        papelariaGomes.registrarVenda(1,"Caneta",5);
        papelariaGomes.registrarVenda(1,"Caderno",2);
        papelariaGomes.registrarVenda(2,"Lápis",3);
        papelariaGomes.registrarVenda(3,"Lápis",2);
        papelariaGomes.registrarVenda(1,"Caneta",10);
        papelariaGomes.registrarVenda(2,"Caderno",9);
        papelariaGomes.registrarVenda(1,"Lápis",1);
        papelariaGomes.registrarVenda(3,"Caderno",3);
        papelariaGomes.registrarVenda(3,"Caneta",2);
//        manoel.mostrarRelatorio();
//        papelariaGomes.mostrarRelatorioCompleto();
        papelariaGomes.mostrarEstoque();
    }
}
