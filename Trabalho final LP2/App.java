import java.io.File;

import java.util.ArrayList;

public class App { 
	public static void main(String args[]) {
		String curDir = System.getProperty("user.dir");
		String curArq = curDir + System.getProperty("file.separator") + "Arquivos";
		String curBrq = curArq + System.getProperty("file.separator") + "Brinquedos";
		String curRst = curArq + System.getProperty("file.separator") + "Restaurantes";
		String curUsr = curArq + System.getProperty("file.separator") + "Usuarios";
		File dirArq = new File(curArq); if(!dirArq.exists()){dirArq.mkdirs();}
		File dirBrq = new File(curBrq); if(!dirBrq.exists()){dirBrq.mkdirs();}
		File dirRst = new File(curRst); if(!dirRst.exists()){dirRst.mkdirs();}
		File dirUsr = new File(curUsr); if(!dirUsr.exists()){dirUsr.mkdirs();}

		JanelaPrincipal janela_principal = new JanelaPrincipal();
		//JanelaAdministrador JanelaADM = new JanelaAdministrador();
			//JanelaAdcBrinquedo JanelaCadBrinquedo = new JanelaAdcBrinquedo();
			//JanelaAdcRestaurante JanelaCadRestaurante = new JanelaAdcRestaurante();
			//JanelaAdcPessoa JanelaCadPessoa = new JanelaAdcPessoa();
		//JanelaUsuario janela_usuario = new JanelaUsuario(new Pessoa("Andrei", 69, 18, 1.8f)); // EVITAR

		// WriteAndRead salvar = new WriteAndRead();
		// ArrayList<Pessoa> pessoas = salvar.lerPessoas();
		// System.out.printf("QTD pessoas: %d\n\n", pessoas.size());
		// for(int i=0; i<=pessoas.size()-1; i++){
		// 	Pessoa p = pessoas.get(i);
		// 	System.out.printf("%s:\n", p.getName());
		// 	ArrayList<Attraction> attc = p.getHave_done();
		// 	System.out.printf("QTD have_done: %d\n", attc.size());
		// 	for(int j=0; j<=attc.size()-1; j++){
		// 		System.out.printf("%s;\n", attc.get(j).getName());
		// 	}
		// 	System.out.println();
		// }



	}
}
