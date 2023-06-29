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
			import javax.swing.JList;                   // Lista; 
			import javax.swing.JLabel;       	   		// Rotulos
			import javax.swing.JButton;  				// Botão
			import javax.swing.JTextField;				// Linha de Texto
			import javax.swing.JTextArea;				// Caixa Texto
			import javax.swing.JScrollPane;             // Cria scroll do textArea;

		// Menu:
			import javax.swing.JMenuBar;    		    // Barra de Menu´s
			import javax.swing.JMenu;      			    // Menu
			import javax.swing.JMenuItem;  		    	// Itens do respectivo Menu;

	// Extras:
		import java.util.HashMap;
		import java.util.Map;
		import java.awt.Color; 	

public class JanelaAdcRestaurante extends JFrame implements ActionListener{
	// Atributos:
		// Define:
			private int LARGURA = 410;
			private int ALTURA  = 275;	

		// Return:
			public Attraction restaurante = null;	

		// Painel:
			private JPanel 		 painel        = new JPanel();
			private SpringLayout spring_layout = new SpringLayout(); 

			private JLabel     lbl_nome;
			private JTextField txt_nome;
			private JLabel     lbl_ID;
			private JTextField txt_ID;
			private JLabel     lbl_desc;
			private JTextArea  txt_desc; private JScrollPane scroll;
			private JLabel     lbl_capc;
			private JTextField txt_capc;
			
			private JButton cadastrar;
			private JButton limpar;
			private JButton sair;

	// Construtor:
		public JanelaAdcRestaurante(){
			super("Adicionar Restaurante");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.inicializar();
			this.setVisible(true);
		}	

	// Gets && Sets:
		public Attraction getRestaurante(){return this.restaurante;}	
	
	// Metodos Adicionais:
		public void inicializar(){
			// Atributos:
				this.lbl_nome       = new JLabel("Nome:               ");
				this.txt_nome       = new JTextField(25);
				this.lbl_ID         = new JLabel("ID: ");
				this.txt_ID         = new JTextField(25);

				this.lbl_desc       = new JLabel("Description:     ");
				this.txt_desc       = new JTextArea(5,25);
				this.txt_desc.setLineWrap(true); 
				this.txt_desc.setWrapStyleWord(true);
				this.scroll = new JScrollPane(txt_desc);
				this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				this.lbl_capc       = new JLabel("Capacidade:    ");
				this.txt_capc       = new JTextField(25);

				this.cadastrar = new JButton("CADASTRAR");
				this.cadastrar.addActionListener(this);
				this.limpar    = new JButton("LIMPAR");
				this.limpar.addActionListener(this);
				this.sair      = new JButton("CANCELAR");
				this.sair.addActionListener(this);

			// Posicionamento:
				painel.setBackground(new Color(120,120,120,80));
				painel.setBounds(0, 0, LARGURA, ALTURA);
				painel.setLayout(spring_layout);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_nome,  10, SpringLayout.NORTH,  painel);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_nome,  10, SpringLayout.WEST,   painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_nome,  10, SpringLayout.NORTH,  painel);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_nome,  10, SpringLayout.EAST, lbl_nome);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_ID,  15, SpringLayout.SOUTH,  lbl_nome);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_ID,  10, SpringLayout.WEST,     painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_ID,  10, SpringLayout.SOUTH,  txt_nome);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_ID,  74, SpringLayout.EAST,     lbl_ID);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_desc,  40, SpringLayout.SOUTH,   lbl_ID);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_desc,  10, SpringLayout.WEST,    painel);
				spring_layout.putConstraint(SpringLayout.NORTH,   scroll,  10, SpringLayout.SOUTH,   txt_ID);
				spring_layout.putConstraint(SpringLayout.WEST,    scroll,  10, SpringLayout.EAST,  lbl_desc);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_capc,  10, SpringLayout.SOUTH,   scroll);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_capc,  10, SpringLayout.WEST,    painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_capc,  10, SpringLayout.SOUTH,   scroll);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_capc,   9, SpringLayout.EAST,  lbl_capc);

				spring_layout.putConstraint(SpringLayout.NORTH, cadastrar,  10, SpringLayout.SOUTH,  txt_capc);
				spring_layout.putConstraint(SpringLayout.EAST,  cadastrar,   0, SpringLayout.EAST,   txt_capc);
				spring_layout.putConstraint(SpringLayout.NORTH,    limpar,  10, SpringLayout.SOUTH,  txt_capc);
				spring_layout.putConstraint(SpringLayout.EAST,     limpar, -40, SpringLayout.WEST,  cadastrar);
				spring_layout.putConstraint(SpringLayout.NORTH,      sair,  10, SpringLayout.SOUTH,  txt_capc);
				spring_layout.putConstraint(SpringLayout.EAST,       sair, -40, SpringLayout.WEST,     limpar);

			// Adicionar:
				painel.add(lbl_nome);	
				painel.add(txt_nome);
				painel.add(lbl_ID);	
				painel.add(txt_ID);	
				painel.add(lbl_desc);	
				//painel.add(txt_desc);
				painel.add(scroll);
				painel.add(lbl_capc);	
				painel.add(txt_capc);

				painel.add(cadastrar);
				painel.add(limpar);	
				painel.add(sair);	
				this.add(painel);	
		}

		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == cadastrar){
		        try{
		        	// Salvar e testa:
						String nome = this.txt_nome.getText();
						if(nome.length()<=0){int quebra = Integer.parseInt("a");}
						String desc = this.txt_desc.getText();

						String s_ID = this.txt_ID.getText();
						int    n_ID = Integer.parseInt(s_ID);

						String s_capc = this.txt_capc.getText();
						int    n_capc = Integer.parseInt(s_capc);

					// Criar:	
						this.restaurante = new Attraction(nome, n_ID, desc, n_capc);
						WriteAndRead salvar = new WriteAndRead(); 
						if(salvar.escRestaurante(restaurante)){System.out.printf("Restaurante %s Cadastrado!\n", restaurante.getName());}
						String mensagem = "Restaurante  " + restaurante.getName() + "  Cadastrado!"; 
						JOptionPane.showMessageDialog(null, mensagem);
						JanelaAdministrador JanelaADM = new JanelaAdministrador();
						this.dispose();
		        }
		        catch(Exception ex){
	        		JOptionPane.showMessageDialog(null, "Não Foi Possivel Criar O Restaurante!");
		        }
			}else if(event.getSource() == limpar){
				this.txt_nome.setText("");
				this.txt_ID.setText("");
				this.txt_desc.setText("");
				this.txt_capc.setText("");
			}else if(event.getSource() == sair){
				this.txt_nome.setText("");
				this.txt_ID.setText("");
				this.txt_desc.setText("");
				this.txt_capc.setText("");
				this.restaurante = null;
				JanelaAdministrador JanelaADM = new JanelaAdministrador();
				this.dispose();
			}
		}
			
}	