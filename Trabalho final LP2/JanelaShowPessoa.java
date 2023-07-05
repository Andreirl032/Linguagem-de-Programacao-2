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
			private int ALTURA  = 450;	

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

			private JLabel     lbl_is_doing;
			private JTextField txt_is_doing;	

			private JLabel    lbl_ingresso;
			private JList<String> jl_lista;

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

				this.lbl_is_doing = new JLabel("Atualmente:     ");
				this.txt_is_doing = new JTextField(25);
				String str_is_doing;
				if(pessoa.getIs_doing()!=null){
					str_is_doing = pessoa.getIs_doing().getName();
				}else{
					str_is_doing = "Empty!";
				}
				this.txt_is_doing.setText(str_is_doing);
				this.txt_is_doing.setEditable(false);


				this.lbl_ingresso = new JLabel("Ingressos: ");
		        // Jlist:
			        int tam = pessoa.getHave_done().size() <= 0 ? 1 : pessoa.getHave_done().size();
					String ingressos[] = new String[tam];
					for(int i=0; i<=pessoa.getHave_done().size()-1; i++){
			            ingressos[i]=pessoa.getHave_done().get(i).getName();
			        }
			        if(ingressos[0]==null){ingressos[0]="Sem Ingressos!\n";}
			        
					this.jl_lista = new JList<String>(ingressos);
					this.jl_lista.setSelectionForeground(Color.RED);
					this.jl_lista.setSelectionBackground(new Color(255, 100, 100, 80));
					this.jl_lista.setFixedCellWidth(260);
					this.jl_lista.setFixedCellHeight(21);

				// Scroll:
					JScrollPane jl_lista_scroll = new JScrollPane();
			        jl_lista.setLayoutOrientation(JList.VERTICAL);
			        jl_lista_scroll.setViewportView(jl_lista);
			        jl_lista_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	

				
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

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_is_doing,  10, SpringLayout.SOUTH,   lbl_altura);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_is_doing,  10, SpringLayout.WEST,        painel);
				spring_layout.putConstraint(SpringLayout.NORTH, txt_is_doing,  10, SpringLayout.SOUTH,   txt_altura);
				spring_layout.putConstraint(SpringLayout.WEST,  txt_is_doing,  10, SpringLayout.EAST,  lbl_is_doing);

				spring_layout.putConstraint(SpringLayout.NORTH, lbl_ingresso,  14, SpringLayout.SOUTH,    lbl_is_doing);
				spring_layout.putConstraint(SpringLayout.WEST,  lbl_ingresso,  10, SpringLayout.WEST,           painel);
				spring_layout.putConstraint(SpringLayout.NORTH, jl_lista_scroll,  14, SpringLayout.SOUTH, lbl_is_doing);
				spring_layout.putConstraint(SpringLayout.WEST,  jl_lista_scroll,  28, SpringLayout.EAST,  lbl_ingresso);

				spring_layout.putConstraint(SpringLayout.SOUTH,    excluir,  -55, SpringLayout.SOUTH,   painel);
				spring_layout.putConstraint(SpringLayout.EAST,     excluir,  -40, SpringLayout.EAST,    painel);
				spring_layout.putConstraint(SpringLayout.SOUTH,       sair,  -55, SpringLayout.SOUTH,   painel);
				spring_layout.putConstraint(SpringLayout.EAST,        sair,  -40, SpringLayout.WEST,   excluir);

			// Adicionar:
				painel.add(lbl_nome);	
				painel.add(txt_nome);
				painel.add(lbl_ID);	
				painel.add(txt_ID);	
				painel.add(lbl_idade);	
				painel.add(txt_idade);
				painel.add(lbl_altura);	
				painel.add(txt_altura);
				painel.add(lbl_is_doing);	
				painel.add(txt_is_doing);
				painel.add(lbl_ingresso);
				painel.add(jl_lista_scroll);

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