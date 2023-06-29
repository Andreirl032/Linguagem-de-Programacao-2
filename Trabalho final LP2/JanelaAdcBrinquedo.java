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

public class JanelaAdcBrinquedo extends JFrame implements ActionListener{
	// Atributos:
		// Define:
			private int LARGURA = 410;
			private int ALTURA  = 400;	

		// Return:
			public Brinquedo brinquedo = null;	
			WriteAndRead salvar = new WriteAndRead();

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
			private JLabel     lbl_min_age;
			private JTextField txt_min_age;
			private JLabel     lbl_min_altura;
			private JTextField txt_min_altura;
			private JLabel     lbl_open;
			private JTextField txt_open;
			private JLabel     lbl_close;
			private JTextField txt_close;
			
			private JButton cadastrar;
			private JButton limpar;
			private JButton sair;

	// Construtor:
		public JanelaAdcBrinquedo(){
			super("Adicionar Brinquedo");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.inicializar();
			this.setVisible(true);
		}	
	
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
				this.lbl_min_age    = new JLabel("Idade Minima: ");
				this.txt_min_age    = new JTextField(25);
				this.lbl_min_altura = new JLabel("Altura Minima:");
				this.txt_min_altura = new JTextField(25);
				this.lbl_open       = new JLabel("Hor. Abertura: ");
				this.txt_open       = new JTextField(25);
				this.lbl_close      = new JLabel("Hor. Fecham.: ");
				this.txt_close      = new JTextField(25);

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

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_min_age,  16, SpringLayout.SOUTH,    lbl_capc);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_min_age,  10, SpringLayout.WEST,       painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_min_age,  10, SpringLayout.SOUTH,    txt_capc);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_min_age,  10, SpringLayout.EAST,  lbl_min_age);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_min_altura,  14, SpringLayout.SOUTH,    lbl_min_age);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_min_altura,  10, SpringLayout.WEST,          painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_min_altura,  10, SpringLayout.SOUTH,    txt_min_age);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_min_altura,  10, SpringLayout.EAST,  lbl_min_altura);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_open,  14, SpringLayout.SOUTH, lbl_min_altura);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_open,  10, SpringLayout.WEST,          painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_open,  10, SpringLayout.SOUTH, txt_min_altura);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_open,   9, SpringLayout.EAST,        lbl_open);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_close,  14, SpringLayout.SOUTH,  lbl_open);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_close,  10, SpringLayout.WEST,     painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_close,  10, SpringLayout.SOUTH,  txt_open);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_close,  11, SpringLayout.EAST,  lbl_close);

				spring_layout.putConstraint(SpringLayout.NORTH, cadastrar,  10, SpringLayout.SOUTH,  txt_close);
				spring_layout.putConstraint(SpringLayout.EAST,  cadastrar,   0, SpringLayout.EAST,   txt_close);
				spring_layout.putConstraint(SpringLayout.NORTH,    limpar,  10, SpringLayout.SOUTH,  txt_close);
				spring_layout.putConstraint(SpringLayout.EAST,     limpar, -40, SpringLayout.WEST,   cadastrar);
				spring_layout.putConstraint(SpringLayout.NORTH,      sair,  10, SpringLayout.SOUTH,  txt_close);
				spring_layout.putConstraint(SpringLayout.EAST,       sair, -40, SpringLayout.WEST,      limpar);

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
				painel.add(lbl_min_age);	
				painel.add(txt_min_age);
				painel.add(lbl_min_altura);	
				painel.add(txt_min_altura);
				painel.add(lbl_open);	
				painel.add(txt_open);
				painel.add(lbl_close);	
				painel.add(txt_close);
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

						String s_min_age  = this.txt_min_age.getText();
						int    n_min_age  = Integer.parseInt(s_min_age);

						String s_min_altura = this.txt_min_altura.getText();
						float  n_min_altura = Float.parseFloat(s_min_altura);

						String s_open = this.txt_open.getText();
						int    n_open = Integer.parseInt(s_open);

						String s_close = this.txt_close.getText();
						int    n_close = Integer.parseInt(s_close);

					// Criar:	
						this.brinquedo = new Brinquedo(nome, n_ID, desc, n_capc, n_min_altura, n_min_age , n_open, n_close); 
						if(salvar.escBrinquedo(brinquedo)){System.out.printf("Brinquedo %s Cadastrado!\n", brinquedo.getName());}
						salvar.lerBrinquedos();
						String mensagem = "Brinquedo  " + brinquedo.getName() + "  Cadastrado!"; 
						JOptionPane.showMessageDialog(null, mensagem);
						JanelaAdministrador JanelaADM = new JanelaAdministrador();
						this.dispose();
		        }
		        catch(Exception ex){
	        		JOptionPane.showMessageDialog(null, "Não Foi Possivel Criar O Brinquedo!");
		        }
			}else if(event.getSource() == limpar){
				this.txt_nome.setText("");
				this.txt_ID.setText("");
				this.txt_desc.setText("");
				this.txt_capc.setText("");
				this.txt_min_age.setText("");
				this.txt_min_altura.setText("");
				this.txt_open.setText("");
				this.txt_close.setText("");
			}else if(event.getSource() == sair){
				this.txt_nome.setText("");
				this.txt_ID.setText("");
				this.txt_desc.setText("");
				this.txt_capc.setText("");
				this.txt_min_age.setText("");
				this.txt_min_altura.setText("");
				this.txt_open.setText("");
				this.txt_close.setText("");
				this.brinquedo = null;
				JanelaAdministrador JanelaADM = new JanelaAdministrador();
				this.dispose();
			}	
		}
			
}	