// Importações:
	// File:
		import java.io.File;

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

public class JanelaShowPessoa extends JFrame implements ActionListener{
	// Atributos:
		// Define:
			private int LARGURA = 410;
			private int ALTURA  = 220;	

		// Return:	
			Pessoa pessoa = null;
			WriteAndRead salvar = new WriteAndRead();

		// Painel:
			private JPanel 		 painel        = new JPanel();
			private SpringLayout spring_layout = new SpringLayout(); 

			private JLabel     lbl_nome;
			private JTextField txt_nome;      
			
			private JLabel     lbl_ID;
			private JTextField txt_ID;  	    
			
			private JLabel     lbl_idade;
			private JTextField txt_idade;	
			
			private JLabel     lbl_altura;
			private JTextField txt_altura;	
			

			private JButton excluir;
			private JButton sair;

	// Construtor:
		public JanelaShowPessoa(Pessoa p){
			super("Information of: \"" + p.getName() +"\"");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.inicializar(p);
			this.setVisible(true);
		}	
	
	// Metodos Adicionais:
		public void inicializar(Pessoa p){
			this.pessoa = p;
			// Atributos:
				this.lbl_nome   = new JLabel("Nome:               ");
				this.txt_nome   = new JTextField(25);
				this.txt_nome.setText(p.getName());
				this.txt_nome.setEditable(false);

				this.lbl_ID     = new JLabel("ID: ");
				this.txt_ID     = new JTextField(25);
				this.txt_ID.setText(Integer.toString(pessoa.getID()));
				this.txt_ID.setEditable(false);

				this.lbl_idade  = new JLabel("Idade: ");
				this.txt_idade  = new JTextField(25);
				this.txt_idade.setText(Integer.toString(pessoa.getAge()));
				this.txt_idade.setEditable(false);

				this.lbl_altura = new JLabel("Altura:     ");
				this.txt_altura = new JTextField(25);
				this.txt_altura.setText(Float.toString(pessoa.getAltura()));
				this.txt_altura.setEditable(false);
				
				this.excluir = new JButton("EXCLUIR");
				this.excluir.addActionListener(this);
				this.sair      = new JButton("CANCELAR");
				this.sair.addActionListener(this);

			// posicionamento:
				painel.setBackground(new Color(120,120,120,80));
				painel.setBounds(0, 0, LARGURA, ALTURA);
				painel.setLayout(spring_layout);

				spring_layout.putConstraint(SpringLayout.NORTH,   lbl_nome,  10, SpringLayout.NORTH,     painel);
				spring_layout.putConstraint(SpringLayout.WEST,    lbl_nome,  10, SpringLayout.WEST,      painel);
				spring_layout.putConstraint(SpringLayout.NORTH,   txt_nome,  10, SpringLayout.NORTH,     painel);
				spring_layout.putConstraint(SpringLayout.WEST,    txt_nome,  10, SpringLayout.EAST,    lbl_nome);

				spring_layout.putConstraint(SpringLayout.NORTH,     lbl_ID,  15, SpringLayout.SOUTH,   lbl_nome);
				spring_layout.putConstraint(SpringLayout.WEST,      lbl_ID,  10, SpringLayout.WEST,      painel);
				spring_layout.putConstraint(SpringLayout.NORTH,     txt_ID,  10, SpringLayout.SOUTH,   txt_nome);
				spring_layout.putConstraint(SpringLayout.WEST,      txt_ID,  74, SpringLayout.EAST,      lbl_ID);

				spring_layout.putConstraint(SpringLayout.NORTH,  lbl_idade,  14, SpringLayout.SOUTH,     lbl_ID);
				spring_layout.putConstraint(SpringLayout.WEST,   lbl_idade,  10, SpringLayout.WEST,      painel);
				spring_layout.putConstraint(SpringLayout.NORTH,  txt_idade,  10, SpringLayout.SOUTH,     txt_ID);
				spring_layout.putConstraint(SpringLayout.WEST,   txt_idade,  54, SpringLayout.EAST,   lbl_idade);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_altura,  14, SpringLayout.SOUTH,  lbl_idade);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_altura,  10, SpringLayout.WEST,      painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_altura,  10, SpringLayout.SOUTH,  txt_idade);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_altura,  39, SpringLayout.EAST,  lbl_altura);

				spring_layout.putConstraint(SpringLayout.NORTH,    excluir,  10, SpringLayout.SOUTH, txt_altura);
				spring_layout.putConstraint(SpringLayout.EAST,     excluir,   0, SpringLayout.EAST,  txt_altura);
				spring_layout.putConstraint(SpringLayout.NORTH,       sair,  10, SpringLayout.SOUTH, txt_altura);
				spring_layout.putConstraint(SpringLayout.EAST,        sair, -40, SpringLayout.WEST,     excluir);

			// Adicionar:
				painel.add(lbl_nome);	
				painel.add(txt_nome);
				painel.add(lbl_ID);	
				painel.add(txt_ID);	
				painel.add(lbl_idade);	
				painel.add(txt_idade);
				painel.add(lbl_altura);	
				painel.add(txt_altura);

				painel.add(excluir);
				painel.add(sair);	
				this.add(painel);	
		}

		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == excluir){
		       	if(salvar.excPessoa(pessoa)){
		       		System.out.printf("Pessoa %s excluida!\n", pessoa.getName());
		       	}else{
		       		System.out.printf("ERR -> Não foi Possivel excluir a pessoa %s!\n", pessoa.getName());
		       	}
		        JanelaAdministrador JanelaADM = new JanelaAdministrador();
		        this.dispose();
			}else if(event.getSource() == sair){
				JanelaAdministrador JanelaADM = new JanelaAdministrador();
				this.dispose();
			}	
		}
			
}	