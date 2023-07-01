import java.io.File;

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

		//JanelaPrincipal janela_principal = new JanelaPrincipal();
//		JanelaAdministrador JanelaADM = new JanelaAdministrador();
		//JanelaAdcBrinquedo JanelaCadBrinquedo = new JanelaAdcBrinquedo();
		//JanelaAdcRestaurante JanelaCadRestaurante = new JanelaAdcRestaurante();
//		JanelaAdcPessoa JanelaCadPessoa = new JanelaAdcPessoa();
		JanelaUsuario janela_usuario = new JanelaUsuario();
	}
}
