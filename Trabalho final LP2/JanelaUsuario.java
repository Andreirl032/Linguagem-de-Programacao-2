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
			import javax.swing.event.ListSelectionListener;
			import javax.swing.event.ListSelectionEvent;

			import javax.swing.JLabel;       	   		// Rotulos
			import javax.swing.JButton;                 // Botão 
			import javax.swing.JRadioButton;            // Botão de marcar;
			import javax.swing.ButtonGroup;             // Grupo de Botão; 
			import javax.swing.JComboBox;             // Caixa pesquisa;

			import javax.swing.JTextField;				// Caixa Texto
			import javax.swing.JScrollPane;             // Cria scroll;			

		// Menu:
			import javax.swing.JMenuBar;    		    // Barra de Menu´s
			import javax.swing.JMenu;      			    // Menu
			import javax.swing.JMenuItem;  		    	// Itens do respectivo Menu;

	// Extras:
		import java.util.Vector;	
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.Map;
		import java.awt.Color; 

public class JanelaUsuario extends JFrame implements ActionListener{
	// Atributos:
		private Pessoa pessoa = null;
		private String situation = "";
		// Define:
			private int LARGURA = 800;
			private int ALTURA  = 600;
			private int max_size = 25;

		// Arrays:
			WriteAndRead salvar = new WriteAndRead();
			private ArrayList<Brinquedo>    AL_brinquedos;
		    private ArrayList<Attraction> AL_restaurantes;
		    private String[] names_brinquedos   = new String[this.max_size];
		    private String[] names_restaurantes = new String[this.max_size]; 
		    private String[] nomes_brinquedos   = new String[this.max_size];
		    private String[] nomes_restaurantes = new String[this.max_size]; 

		// Painel 1:
			// Define:
				private int LARGURA_p1 = LARGURA;
				private int ALTURA_p1  = 130;
				
			// Objetos:	
				private JPanel painel_1 = new JPanel();
				private SpringLayout spring_layout_1 = new SpringLayout(); 
				private JLabel      bem_vindo;
				private JLabel      lb_ID;
				private JLabel      lb_idade;
				private JLabel      lb_altura;
				private JLabel      lb_is_doing;
				private JTextField  txt_ID;
				private JTextField  txt_idade;
				private JTextField  txt_altura;
				private JTextField  txt_is_doing;

				private RelogioDigital relogio;

				private JButton sair;

		// Painel 2:
			// Define:
				private int LARGURA_p2 = (int)(LARGURA/2);
				private int ALTURA_p2  = ALTURA - ALTURA_p1;

				private JPanel 		 painel_2        = new JPanel();
				private SpringLayout spring_layout_2 = new SpringLayout(); 

			// Objetos:	
				private JLabel          mensag_cmpra;	
			    private JRadioButton   rdb_brinquedo;
			    private JRadioButton rdb_restaurante;
			    private ButtonGroup       grupo_butt;
			    
			    private JComboBox<String>   comboBox;

			    private JButton           infoButton;
			    private JButton            buyButton; 

		// Painel 3:
			// Define:	     
			    private int LARGURA_p3 = (int)(LARGURA/2);
				private int ALTURA_p3  = ALTURA - ALTURA_p1;

				private JPanel 		 painel_3        = new JPanel();
				private SpringLayout spring_layout_3 = new SpringLayout(); 

			// Objetos:
				private JLabel lb_lista;
				private JList  jl_lista;

	// Construtor:
		public JanelaUsuario(Pessoa p){
			super("Janela Usuario");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);                           // Centralizar;
			this.setResizable(false);                                   // Não pode redimencionar
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.inicializar(p, "");
			this.setVisible(true);
		}

		public JanelaUsuario(Pessoa p, String situa){
			super("Janela Usuario");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);                           // Centralizar;
			this.setResizable(false);                                   // Não pode redimencionar
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.inicializar(p, situa);
			this.setVisible(true);
		}

	// Metodos Adicionais:	
		public void inicializar(Pessoa p, String situa){
			this.pessoa = p;
			this.situation = situa;
			// Inicializar Painel 01:
				// Atributos:
					String mensagem = "Bem Vindo, " + p.getName() + "!\n";
					this.bem_vindo  = new JLabel(mensagem);

					this.lb_ID      = new JLabel("ID: ");
					this.txt_ID     = new JTextField(8);
					this.txt_ID.setText(Integer.toString(p.getID()));
					this.txt_ID.setEditable(false);

					this.lb_idade   = new JLabel("Idade: ");
					this.txt_idade  = new JTextField(8);
					this.txt_idade.setText(Integer.toString(p.getAge()));
					this.txt_idade.setEditable(false);

					this.lb_altura  = new JLabel("Altura: ");
					this.txt_altura = new JTextField(8);
					this.txt_altura.setText(Float.toString(p.getAltura())+"m");
					this.txt_altura.setEditable(false);

					this.lb_is_doing  = new JLabel("Atualmente: ");
					this.txt_is_doing = new JTextField(25);
					String str_is_doing;
					if(p.getIs_doing()!=null){
						str_is_doing = p.getIs_doing().getName();
					}else{
						str_is_doing = "Empty!";
					}
					this.txt_is_doing.setText(str_is_doing);
					this.txt_is_doing.setEditable(false);

					this.relogio = new RelogioDigital();

					this.sair       = new JButton("Sair");
					this.sair.addActionListener(this);

				// Posicionamento:
					painel_1.setBackground(new Color(80,80,80,80));
					painel_1.setBounds(0, 0, LARGURA_p1, ALTURA_p1);
					painel_1.setLayout(spring_layout_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH,  bem_vindo,  10, SpringLayout.NORTH, painel_1);
					spring_layout_1.putConstraint(SpringLayout.WEST,   bem_vindo,  10, SpringLayout.WEST,  painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH,  lb_ID,     10, SpringLayout.SOUTH, bem_vindo);
					spring_layout_1.putConstraint(SpringLayout.WEST,   lb_ID,     20, SpringLayout.WEST,   painel_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH,  txt_ID,    10, SpringLayout.SOUTH, bem_vindo);
					spring_layout_1.putConstraint(SpringLayout.WEST,   txt_ID,    40, SpringLayout.EAST,      lb_ID);

					spring_layout_1.putConstraint(SpringLayout.NORTH,  lb_idade,  10, SpringLayout.SOUTH,     lb_ID);
					spring_layout_1.putConstraint(SpringLayout.WEST,   lb_idade,  20, SpringLayout.WEST,   painel_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH,  txt_idade, 10, SpringLayout.SOUTH,     lb_ID);
					spring_layout_1.putConstraint(SpringLayout.WEST,   txt_idade, 20, SpringLayout.EAST,   lb_idade);

					spring_layout_1.putConstraint(SpringLayout.NORTH, lb_altura,  10, SpringLayout.SOUTH,  lb_idade);
					spring_layout_1.putConstraint(SpringLayout.WEST,  lb_altura,  20, SpringLayout.WEST,   painel_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH, txt_altura, 10, SpringLayout.SOUTH,  lb_idade);
					spring_layout_1.putConstraint(SpringLayout.WEST,  txt_altura, 17, SpringLayout.EAST,  lb_altura);

					spring_layout_1.putConstraint(SpringLayout.NORTH, lb_is_doing,  0, SpringLayout.NORTH,    lb_ID);
					spring_layout_1.putConstraint(SpringLayout.WEST,  lb_is_doing,  250, SpringLayout.EAST,   lb_ID);
					spring_layout_1.putConstraint(SpringLayout.NORTH, txt_is_doing, 10, SpringLayout.SOUTH,   lb_is_doing);
					spring_layout_1.putConstraint(SpringLayout.WEST,  txt_is_doing, -100, SpringLayout.WEST,  lb_is_doing);

					spring_layout_1.putConstraint(SpringLayout.NORTH,    relogio,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,     relogio, -45, SpringLayout.EAST,   painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH,       sair,  80, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,        sair, -45, SpringLayout.EAST,   painel_1);

				// Adicionar:
					painel_1.add(bem_vindo);	
					painel_1.add(lb_ID);
					painel_1.add(txt_ID);		
					painel_1.add(lb_idade);
					painel_1.add(txt_idade);		
					painel_1.add(lb_altura);
					painel_1.add(txt_altura);
					painel_1.add(lb_is_doing);
					painel_1.add(txt_is_doing);

					painel_1.add(relogio);

					painel_1.add(sair);	
			
			// Inicializar Painel 02:
				// Atributos:	
					// Label:
						this.mensag_cmpra = new JLabel("Compra de Ingresso: \n");

					// Radio Buttons:	
						this.rdb_brinquedo=new JRadioButton("Brinquedos");
					    this.rdb_brinquedo.setSelected(true);
					    this.rdb_brinquedo.addActionListener(this);
					    this.rdb_brinquedo.setActionCommand("brinquedos");     // Identificador;

				        this.rdb_restaurante=new JRadioButton("Restaurantes");
				        this.rdb_restaurante.setSelected(false);
				        this.rdb_restaurante.addActionListener(this);
				        this.rdb_restaurante.setActionCommand("restaurantes"); // Identificador;

				        this.grupo_butt = new ButtonGroup();
				        this.grupo_butt.add(rdb_brinquedo);
				        this.grupo_butt.add(rdb_restaurante);

				    // Normal Buttons:
			    	    this.infoButton=new JButton("INFORMATION");
				        this.infoButton.addActionListener(this);
				        this.infoButton.setActionCommand("info");

				        this.buyButton=new JButton("BUY TICKET");
				        this.buyButton.addActionListener(this);
				        this.buyButton.setActionCommand("comprar");    

					// ComboBox:
						// Pre-Carregar Brinquedos:
							// Importar Array: 
					        this.AL_brinquedos = salvar.lerBrinquedos();
					        int i=0;
					        for(; i<=AL_brinquedos.size()-1; i++){
					            if(i<=this.max_size-1){
					                names_brinquedos[i] = AL_brinquedos.get(i).getName();
					            }else{
					                System.out.printf("Janela Usuario: Num max de brinqdtions atingido! -> Novos brinquedos não serão mostradas.\n");
					                break;
					            }
					        }

						    // Outro vetor pra evitar mostrar vazio:
						    	String[] nomes_brinquedos = new String[i];
						        for(int j=0; j<=i-1; j++){nomes_brinquedos[j]=names_brinquedos[j];}


						// Pre-Carregar Restaurantes:
						 	// Importar Array: 
					        this.AL_restaurantes = salvar.lerRestaurantes();
					        i=0;
					        for(; i<=AL_restaurantes.size()-1; i++){
					            if(i<=this.max_size-1){
					                names_restaurantes[i] = AL_restaurantes.get(i).getName();
					            }else{
					                System.out.printf("Janela Usuario: Num max de restaurantes atingido! -> Novos restaurantes não serão mostradas.\n");
					                break;
					            }
					        }

						    // Outro vetor pra evitar mostrar vazio:
						    	String[] nomes_restaurantes = new String[i];
						        for(int j=0; j<=i-1; j++){nomes_restaurantes[j]=names_restaurantes[j];} 

						// Inicializar:        
							this.comboBox = new JComboBox<String>(nomes_brinquedos);
      						this.comboBox.addActionListener(this);               

				// Posicionamento:	
					painel_2.setBackground(new Color(255,255,80,80));
					painel_2.setBounds(0, ALTURA_p1, LARGURA_p2, ALTURA_p2);
					painel_2.setLayout(spring_layout_2);

					spring_layout_2.putConstraint(SpringLayout.NORTH,   mensag_cmpra,   10, SpringLayout.NORTH,     painel_2);
					spring_layout_2.putConstraint(SpringLayout.WEST,    mensag_cmpra,   10, SpringLayout.WEST,      painel_2);
					
				   	spring_layout_2.putConstraint(SpringLayout.NORTH,   rdb_brinquedo,  10, SpringLayout.NORTH,     painel_2);
			        spring_layout_2.putConstraint(SpringLayout.WEST,    rdb_brinquedo,  30, SpringLayout.EAST,  mensag_cmpra);

			        spring_layout_2.putConstraint(SpringLayout.NORTH, rdb_restaurante,  10, SpringLayout.NORTH,     painel_2);
			        spring_layout_2.putConstraint(SpringLayout.WEST,  rdb_restaurante,  30, SpringLayout.EAST, rdb_brinquedo);

			        spring_layout_2.putConstraint(SpringLayout.NORTH,        comboBox,  50, SpringLayout.NORTH, mensag_cmpra);
			        spring_layout_2.putConstraint(SpringLayout.WEST,         comboBox,  90, SpringLayout.WEST,      painel_2);

			        spring_layout_2.putConstraint(SpringLayout.SOUTH,       buyButton, -50, SpringLayout.SOUTH,     painel_2);
			        spring_layout_2.putConstraint(SpringLayout.EAST,        buyButton, -15, SpringLayout.EAST,      painel_2);

			        spring_layout_2.putConstraint(SpringLayout.SOUTH,      infoButton, -50, SpringLayout.SOUTH,     painel_2);
			        spring_layout_2.putConstraint(SpringLayout.EAST,       infoButton, -15, SpringLayout.WEST,     buyButton);

			        
				// Adicionar:
					painel_2.add(mensag_cmpra);
					painel_2.add(rdb_brinquedo);
					painel_2.add(rdb_restaurante);
					painel_2.add(comboBox);
					painel_2.add(buyButton);
					painel_2.add(infoButton);	

			// Inicializar Painel 03:
				// Atributos:
					// Label:
						this.lb_lista = new JLabel("Meus Ingressos: \n");

					// Jlist:
						ArrayList<Attraction> arr_attractions = pessoa.getHave_done();
						String names_attractions[] = new String[arr_attractions.size()];
						for(int k=0; k<=arr_attractions.size()-1; k++){
							names_attractions[k] = arr_attractions.get(k).getName();
						}
						
						this.jl_lista = new JList(names_attractions);
						this.jl_lista.setSelectionForeground(Color.RED);
						this.jl_lista.setSelectionBackground(new Color(255, 100, 100, 80));
						this.jl_lista.setFixedCellWidth(190);
						this.jl_lista.setFixedCellHeight(30);

						// Scroll:
							JScrollPane jl_lista_scroll = new JScrollPane();
							jl_lista_scroll.setViewportView(jl_lista);
							jl_lista.setLayoutOrientation(JList.VERTICAL);
							jl_lista_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


				// Posicionamento:
					painel_3.setBackground(new Color(200,50,50,80));
					painel_3.setBounds(LARGURA_p2, ALTURA_p1, LARGURA_p3, ALTURA_p3);
					painel_3.setLayout(spring_layout_3);
					spring_layout_3.putConstraint(SpringLayout.NORTH,  lb_lista,  10, SpringLayout.NORTH, painel_3);
					spring_layout_3.putConstraint(SpringLayout.WEST,   lb_lista,  10, SpringLayout.WEST,  painel_3);

					spring_layout_3.putConstraint(SpringLayout.NORTH,  jl_lista_scroll,  25, SpringLayout.NORTH, lb_lista);
					spring_layout_3.putConstraint(SpringLayout.WEST,   jl_lista_scroll,  50, SpringLayout.WEST,  painel_3);


				// Adicionar:
					painel_3.add(lb_lista);
					painel_3.add(jl_lista_scroll);

			// Adicionar:				
				this.add(painel_1);	
				this.add(painel_2);	
				this.add(painel_3);		

			// Retorno Ação Janela Anterior:
				if(this.situation!="" && this.situation!=null){JOptionPane.showMessageDialog(null, this.situation);}		

		}

		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == sair){
				salvar.excPessoa(pessoa);
		        salvar.escPessoa(pessoa);
				JanelaPrincipal janela_principal = new JanelaPrincipal();
				this.dispose();
			}
			else if(event.getSource() == rdb_brinquedo){
	            painel_2.remove(comboBox);

	            // Importar Array: 
			        this.AL_brinquedos = salvar.lerBrinquedos();
			        int i=0;
			        for(; i<=AL_brinquedos.size()-1; i++){
			            if(i<=this.max_size-1){
			                names_brinquedos[i] = AL_brinquedos.get(i).getName();
			            }else{
			                System.out.printf("Janela Usuario: Num max de brinqdtions atingido! -> Novos brinquedos não serão mostradas.\n");
			                break;
			            }
			        }
			    	String[] nomes_brinquedos = new String[i];
			        for(int j=0; j<=i-1; j++){nomes_brinquedos[j]=names_brinquedos[j];}

	            this.comboBox = new JComboBox<String>(nomes_brinquedos);
	            painel_2.add(comboBox);
	           	spring_layout_2.putConstraint(SpringLayout.NORTH, comboBox,  50, SpringLayout.NORTH, mensag_cmpra);
		        spring_layout_2.putConstraint(SpringLayout.WEST,  comboBox,  90, SpringLayout.WEST,      painel_2);
	            this.revalidate(); this.repaint();
	        }
	        else if(event.getSource() == rdb_restaurante){
	            painel_2.remove(comboBox);

	            // Importar Array: 
			        this.AL_restaurantes = salvar.lerRestaurantes();
			        int i=0;
			        for(; i<=AL_restaurantes.size()-1; i++){
			            if(i<=this.max_size-1){
			                names_restaurantes[i] = AL_restaurantes.get(i).getName();
			            }else{
			                System.out.printf("Janela Usuario: Num max de restaurantes atingido! -> Novos restaurantes não serão mostradas.\n");
			                break;
			            }
			        }
			    	String[] nomes_restaurantes = new String[i];
			        for(int j=0; j<=i-1; j++){nomes_restaurantes[j]=names_restaurantes[j];} 

	            this.comboBox = new JComboBox<String>(nomes_restaurantes);
	            painel_2.add(comboBox);
	            spring_layout_2.putConstraint(SpringLayout.NORTH, comboBox,  50, SpringLayout.NORTH, mensag_cmpra);
		        spring_layout_2.putConstraint(SpringLayout.WEST,  comboBox,  90, SpringLayout.WEST,      painel_2);
	            this.revalidate(); this.repaint();
	        }
	        else if(event.getSource() == infoButton){
	            String selected=(String)comboBox.getSelectedItem();
	            if(selected!=null){ 
		            if(grupo_butt.getSelection().getActionCommand().equals("brinquedos")){
			            for(int i=0; i<=AL_brinquedos.size()-1; i++){
			                if(AL_brinquedos.get(i).getName().equals(selected)){
			                    JanelaShowBrinquedoUsuario showBrinquedo = new JanelaShowBrinquedoUsuario(AL_brinquedos.get(i),this);
			                    this.setVisible(false);
			                }
			            }
		        	}else if(grupo_butt.getSelection().getActionCommand().equals("restaurantes")) {
			            for(int i=0; i<=AL_restaurantes.size()-1; i++){
			                if(AL_restaurantes.get(i).getName().equals(selected)){
			                    JanelaShowRestauranteUsuario showRestaurante = new JanelaShowRestauranteUsuario(AL_restaurantes.get(i),this);
			                    this.setVisible(false);
			                }
			           	}
		       		}
		       	}	
	    	}
	    	else if(event.getSource() == buyButton) {
	    		String selected=(String)comboBox.getSelectedItem();
	            if(selected!=null){
		            if(grupo_butt.getSelection().getActionCommand().equals("brinquedos")){
			            for(int i=0; i<=AL_brinquedos.size()-1; i++){
			                if(AL_brinquedos.get(i).getName().equals(selected)){
			                    situation = pessoa.compraIngresso(AL_brinquedos.get(i), relogio.getHora());
			                    JanelaUsuario janela_usuario = new JanelaUsuario(pessoa, situation);
			                    this.dispose();
			                }
			            }
		        	}else if(grupo_butt.getSelection().getActionCommand().equals("restaurantes")) {
			            for(int i=0; i<=AL_restaurantes.size()-1; i++){
			                if(AL_restaurantes.get(i).getName().equals(selected)){
			                    situation = pessoa.compraIngresso(AL_restaurantes.get(i), relogio.getHora());
			                    JanelaUsuario janela_usuario = new JanelaUsuario(pessoa, situation);
			                    this.dispose();
			                }
			           	}
		       		}
		       	}
			}	
		}
}		