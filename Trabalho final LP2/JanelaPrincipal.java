// Importações:
	// Layout:
		import javax.swing.SpringLayout;

	// Eventos:
		import java.awt.event.ActionListener;       // Classe escuta Evento
		import java.awt.event.ActionEvent;          // Classe Evento

	// Interface:	
		// Janelas:
			import javax.swing.JFrame; 					// Classe Janela Principal;	
			import javax.swing.JDialog; 				// Nova Janela subordinada a um Jframe;
			import javax.swing.JOptionPane;             // Janela de Mensagem;
			import javax.swing.JPanel; 					// Painel	

		// Objetos	
			import javax.swing.JLabel;       	   		// Rotulos
			import javax.swing.JButton;  				// Botão
			import javax.swing.JTextField;				// Caixa Texto

		// Menu:
			import javax.swing.JMenuBar;    		    // Barra de Menu´s
			import javax.swing.JMenu;      			    // Menu
			import javax.swing.JMenuItem;  		    	// Itens do respectivo Menu;

	// Extras:
		import java.util.HashMap;
		import java.util.Map;
		import java.awt.Color; 	
		

public class JanelaPrincipal extends JFrame implements ActionListener{
	// Atributos:
		// Define:
			private int LARGURA = 800;
			private int ALTURA  = 600;

			private int LARGURA_p = 350;
			private int ALTURA_p  = 100;

			private String adm_name = "admin";
			private String adm_pass = "12345";

		// Dados Login:
			private String login;
			private String senha;
			private HashMap<String, String> HM_clientes;

		// Menu
			private JMenuBar  barra_menu = new JMenuBar();
			private JMenu     menu1      = new JMenu("Alunos");
			private JMenu     menu2      = new JMenu("Sair");	
			private JMenuItem item1_1    = new JMenuItem("Victor");

		// Painel_login
			private JPanel painel_login       = new JPanel();
			private SpringLayout layout_login = new SpringLayout(); 

			private JLabel 	 label_login;
			private JLabel   label_senha;
			private JTextField txt_login;
			private JTextField txt_senha;
			private JButton  butt_enviar;
			private JButton  butt_limpar;
	
	// Construtor:
		public JanelaPrincipal(){
			super("Programa do Victor");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);                           // Centralizar;
			this.setResizable(false);                                   // Não pode redimencionar
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.inicializar();
			this.setVisible(true);
		}

	// Metodos Adicionais:
		private void inicializar(){

			// Inicializar barra de menu:
				this.setJMenuBar(barra_menu);
				this.barra_menu.add(menu1);
				this.barra_menu.add(menu2);
				this.menu1.add(item1_1);
				item1_1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});

			// Inicializar Painel_login:
				// Atributos:
					label_login = new JLabel("Login: ");
					txt_login   = new JTextField(25);
					label_senha = new JLabel("Senha: ");
					txt_senha   = new JTextField(25);

					butt_enviar  = new JButton("Enviar"); 
					butt_enviar.addActionListener(this);
					butt_enviar.setToolTipText("Clique aqui para Submeter.");

					butt_limpar  = new JButton("Limpar");
					butt_limpar.addActionListener(this);
					butt_limpar.setToolTipText("Clique aqui para Limpar.");

				// Posicionamento:
					painel_login.setBackground(new Color(255,0,0,80));
					painel_login.setBounds((LARGURA-LARGURA_p)/2, (ALTURA-2*ALTURA_p)/2, LARGURA_p, ALTURA_p);
					painel_login.setLayout(layout_login);
					layout_login.putConstraint(SpringLayout.NORTH, label_login, 12, SpringLayout.NORTH,        this);
					layout_login.putConstraint(SpringLayout.WEST,  label_login, 15, SpringLayout.WEST,         this);
					layout_login.putConstraint(SpringLayout.NORTH, txt_login,   10, SpringLayout.NORTH,        this);
					layout_login.putConstraint(SpringLayout.WEST,  txt_login,   10, SpringLayout.EAST,  label_login);

					layout_login.putConstraint(SpringLayout.NORTH, label_senha, 14, SpringLayout.SOUTH, label_login);
					layout_login.putConstraint(SpringLayout.WEST,  label_senha, 10, SpringLayout.WEST,         this);
					layout_login.putConstraint(SpringLayout.NORTH, txt_senha,   10, SpringLayout.SOUTH,   txt_login);
					layout_login.putConstraint(SpringLayout.WEST,  txt_senha,   10, SpringLayout.EAST,  label_senha);

					layout_login.putConstraint(SpringLayout.NORTH, butt_enviar, 10, SpringLayout.SOUTH,   txt_senha);
					layout_login.putConstraint(SpringLayout.EAST,  butt_enviar,  0, SpringLayout.EAST,    txt_senha);
					layout_login.putConstraint(SpringLayout.NORTH, butt_limpar, 10, SpringLayout.SOUTH,   txt_senha);
					layout_login.putConstraint(SpringLayout.EAST,  butt_limpar, -10, SpringLayout.WEST, butt_enviar);

			// Inicializar Armazenamento:
				HM_clientes = new HashMap<String, String>(); // senha = hashmap[login]
				HM_clientes.put("victor", "1811");


			// Adicionar:
				painel_login.add(label_login);
				painel_login.add(txt_login);
				painel_login.add(label_senha);
				painel_login.add(txt_senha);
				painel_login.add(butt_enviar);
				painel_login.add(butt_limpar);	
				this.add(painel_login);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == butt_enviar) {
				login = this.txt_login.getText();
				senha = this.txt_senha.getText(); 
				if(login.equals(adm_name) && senha.equals(adm_pass)){
					JanelaAdministrador JanelaADM = new JanelaAdministrador();
					this.dispose();
				}else{
					boolean flag = false;
					for(Map.Entry<String, String> elem : HM_clientes.entrySet()){
						if(login.equals(elem.getKey()) && senha.equals(elem.getValue())){
							flag=true;
							break;
						}
					}

					if(flag){
						JOptionPane.showMessageDialog(null, "Usuario Aceito!");
					}else{
						JOptionPane.showMessageDialog(null, "Sem Correspondente!");
					}
				}
				this.txt_login.setText("");
				this.txt_senha.setText("");
			}
			else if(event.getSource() == butt_limpar) {
				this.txt_login.setText("");
				this.txt_senha.setText("");
			}
		}	


}		