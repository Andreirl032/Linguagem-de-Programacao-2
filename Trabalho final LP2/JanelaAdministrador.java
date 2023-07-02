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
			import javax.swing.JButton;  				// Botão
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

public class JanelaAdministrador extends JFrame implements ActionListener, ListSelectionListener{
	// Atributos:
		// Define:
			private int LARGURA = 900;
			private int ALTURA  = 600;
			private int max_size = 25;

		// Arrays:
			WriteAndRead salvar = new WriteAndRead();
			private ArrayList<Brinquedo>    AL_brinquedos;	
			private ArrayList<Attraction> AL_restaurantes;	
			private ArrayList<Pessoa>         AL_usuarios;	

		// Painel 1:
			private int LARGURA_p1 = LARGURA;
			private int ALTURA_p1  = 100;

			private JPanel 		 painel_1        = new JPanel();
			private SpringLayout spring_layout_1 = new SpringLayout(); 
			private JLabel  bem_vindo;
			private JButton nov_brinq;
			private JButton nov_restr;
			private JButton nov_usuar;
			private JButton sair;

		// Painel 2:	
			private int LARGURA_p2 = (int)(LARGURA/3);
			private int ALTURA_p2  = ALTURA - ALTURA_p1;

			private JPanel 		 painel_2        = new JPanel();
			private SpringLayout spring_layout_2 = new SpringLayout(); 

			private JLabel usuar;
			private String[] names_usuarios = new String[this.max_size];
			private JList lst_usuar;

		// Painel 3:	
			private int LARGURA_p3 = (int)(LARGURA/3);
			private int ALTURA_p3  = ALTURA - ALTURA_p1;

			private JPanel 		 painel_3        = new JPanel();
			private SpringLayout spring_layout_3 = new SpringLayout(); 

			private JLabel   brinqd;
			private String[] names_brinquedos = new String[this.max_size];
			private JList    lst_brinqd;

		// Painel 4:	
			private int LARGURA_p4 = (int)(LARGURA/3);
			private int ALTURA_p4  = ALTURA - ALTURA_p1;

			private JPanel 		 painel_4        = new JPanel();
			private SpringLayout spring_layout_4 = new SpringLayout(); 

			private JLabel   restaur;
			private String[] names_restaurantes = new String[this.max_size];
			private JList    lst_restaur;			

	// Construtor:
		public JanelaAdministrador(){
			super("Janela Administrativa");
			this.setLayout(null);
			this.setSize(LARGURA, ALTURA);
			this.setLocationRelativeTo(null);                           // Centralizar;
			this.setResizable(false);                                   // Não pode redimencionar
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.inicializar();
			this.setVisible(true);
		}

	// Metodos Adicionais:
		public void inicializar(){
			// Inicializar Painel 01:
				// Atributos:
					this.bem_vindo = new JLabel("Bem Vindo, Administrador!");
					this.nov_brinq = new JButton("Novo Brinqdo");
					this.nov_brinq.addActionListener(this);
					this.nov_restr = new JButton("Novo Restaur");
					this.nov_restr.addActionListener(this);
					this.nov_usuar = new JButton("Novo Usuario");
					this.nov_usuar.addActionListener(this);
					this.sair      = new JButton("Sair");
					this.sair.addActionListener(this);

				// Posicionamento:
					painel_1.setBackground(new Color(80,80,80,80));
					painel_1.setBounds(0, 0, LARGURA_p1, ALTURA_p1);
					painel_1.setLayout(spring_layout_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH, bem_vindo,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.WEST,  bem_vindo,  10, SpringLayout.WEST,   painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_brinq,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_brinq, -25, SpringLayout.EAST,   painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_restr,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_restr, -15, SpringLayout.WEST,  nov_brinq);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_usuar,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_usuar, -15, SpringLayout.WEST,  nov_restr);

					spring_layout_1.putConstraint(SpringLayout.NORTH,      sair,  10, SpringLayout.NORTH,  painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,       sair, -15, SpringLayout.WEST,  nov_usuar);

				// Adicionar:
					painel_1.add(bem_vindo);	
					painel_1.add(nov_brinq);
					painel_1.add(nov_restr);		
					painel_1.add(nov_usuar);
					painel_1.add(sair);	

			// Inicializar Painel 02:
				// Atributos:
					// Label:
						this.usuar = new JLabel("Usuarios: ");

					// Jlist:
						// Importar Array:
							this.AL_usuarios = salvar.lerPessoas();
							int i=0;
							for(; i<=AL_usuarios.size()-1; i++){
								if(i<=this.max_size-1){
									names_usuarios[i] = AL_usuarios.get(i).getName();
								}else{
									System.out.printf("Num max de Pessoas atingido! -> Novas pessoas não serão mostradas.\n");
									break;
								}
							}

						// Criar outro vetor:
							String[] nomes_usuarios = new String[i];
							for(int j=0; j<=i-1; j++){nomes_usuarios[j]=names_usuarios[j];}

							this.lst_usuar = new JList(nomes_usuarios);
							this.lst_usuar.setSelectionForeground(Color.RED);
							this.lst_usuar.setSelectionBackground(new Color(255, 100, 100, 80));
							this.lst_usuar.setFixedCellWidth(190);
							this.lst_usuar.setFixedCellHeight(30);
							this.lst_usuar.addListSelectionListener(this);

						// Scroll:	
							JScrollPane lst_usuar_scroll = new JScrollPane();
							lst_usuar_scroll.setViewportView(lst_usuar);
							lst_usuar.setLayoutOrientation(JList.VERTICAL);
							lst_usuar_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

				// Posicionamento:
					painel_2.setBackground(new Color(255,0,0,80));
					painel_2.setBounds(0, ALTURA_p1, LARGURA_p2, ALTURA_p2);
					painel_2.setLayout(spring_layout_2);
					spring_layout_2.putConstraint(SpringLayout.NORTH, usuar,  15, SpringLayout.NORTH, painel_2);
					spring_layout_2.putConstraint(SpringLayout.WEST,  usuar,  30, SpringLayout.WEST,  painel_2);

					spring_layout_2.putConstraint(SpringLayout.NORTH, lst_usuar_scroll,  15, SpringLayout.SOUTH,   usuar);
					spring_layout_2.putConstraint(SpringLayout.WEST,  lst_usuar_scroll,  30, SpringLayout.WEST,  painel_2);

				// Adicionar:
					painel_2.add(usuar);
					painel_2.add(lst_usuar_scroll);

			// Inicializar Painel 03 - Brinquedos:
				// Atributos:
					// Label:
						this.brinqd = new JLabel("Brinquedos: ");

					// Jlist:
						// Importar Array:
							this.AL_brinquedos = salvar.lerBrinquedos();
							i=0;
							for(; i<=AL_brinquedos.size()-1; i++){
								if(i<=this.max_size-1){
									names_brinquedos[i] = AL_brinquedos.get(i).getName();
								}else{
									System.out.printf("Num max de brinqdtions atingido! -> Novos brinquedos não serão mostradas.\n");
									break;
								}
							}

						// Criar outro vetor (Pra lista não ficar com espaços vazios do names_brinquedos);
							String[] nomes_brinqd = new String[i];
							for(int j=0; j<=i-1; j++){nomes_brinqd[j]=names_brinquedos[j];}

							this.lst_brinqd = new JList(nomes_brinqd);
							this.lst_brinqd.setSelectionForeground(Color.RED);
							this.lst_brinqd.setSelectionBackground(new Color(255, 100, 100, 80));
							this.lst_brinqd.setFixedCellWidth(190);
							this.lst_brinqd.setFixedCellHeight(30);
							this.lst_brinqd.addListSelectionListener(this);

						// Scroll:
							JScrollPane lst_brinqd_scroll = new JScrollPane();
							lst_brinqd_scroll.setViewportView(lst_brinqd);
							lst_brinqd.setLayoutOrientation(JList.VERTICAL);
							lst_brinqd_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

				// Posicionamento:
					painel_3.setBackground(new Color(0,255,0,80));
					painel_3.setBounds(LARGURA_p2, ALTURA_p1, LARGURA_p3, ALTURA_p3);
					painel_3.setLayout(spring_layout_3);
					spring_layout_3.putConstraint(SpringLayout.NORTH,            brinqd,  15, SpringLayout.NORTH, painel_3);
					spring_layout_3.putConstraint(SpringLayout.WEST,             brinqd,  30, SpringLayout.WEST,  painel_3);

					spring_layout_3.putConstraint(SpringLayout.NORTH, lst_brinqd_scroll,  15, SpringLayout.SOUTH,   brinqd);
					spring_layout_3.putConstraint(SpringLayout.WEST,  lst_brinqd_scroll,  30, SpringLayout.WEST,  painel_3);

				// Adicionar:
					painel_3.add(brinqd);
					painel_3.add(lst_brinqd_scroll);	

			// Inicializar Painel 04 - Restaurantes:
				// Atributos:
					// Label:
						this.restaur = new JLabel("Restaurantes: ");

					// Jlist:	
						// Importar Array:
							this.AL_restaurantes = salvar.lerRestaurantes();
							i=0;
							for(; i<=AL_restaurantes.size()-1; i++){
								if(i<=this.max_size-1){
									names_restaurantes[i] = AL_restaurantes.get(i).getName();
								}else{
									System.out.printf("Num max de attractions atingido! -> Novos restaurantes não serão mostradas.\n");
									break;
								}
							}

						// Criar outro vetor:
							String[] nomes_restaurante = new String[i];
							for(int j=0; j<=i-1; j++){nomes_restaurante[j]=names_restaurantes[j];}

							this.lst_restaur = new JList(nomes_restaurante);
							this.lst_restaur.setSelectionForeground(Color.RED);
							this.lst_restaur.setSelectionBackground(new Color(255, 100, 100, 80));
							this.lst_restaur.setFixedCellWidth(190);
							this.lst_restaur.setFixedCellHeight(30);
							this.lst_restaur.addListSelectionListener(this);		

						// Scroll:
							JScrollPane lst_restaur_scroll = new JScrollPane();
							lst_restaur_scroll.setViewportView(lst_restaur);
							lst_restaur.setLayoutOrientation(JList.VERTICAL);
							lst_restaur_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);	
							

				// Posicionamento:
					painel_4.setBackground(new Color(0,0,255,80));
					painel_4.setBounds(LARGURA_p2 + LARGURA_p3, ALTURA_p1, LARGURA_p4, ALTURA_p4);
					painel_4.setLayout(spring_layout_4);
					spring_layout_4.putConstraint(SpringLayout.NORTH,      restaur, 15, SpringLayout.NORTH, painel_4);
					spring_layout_4.putConstraint(SpringLayout.WEST,       restaur, 30, SpringLayout.WEST,  painel_4);

					spring_layout_4.putConstraint(SpringLayout.NORTH, lst_restaur_scroll,  15, SpringLayout.SOUTH,   restaur);
					spring_layout_4.putConstraint(SpringLayout.WEST,  lst_restaur_scroll,  30, SpringLayout.WEST,   painel_4);

				// Adicionar:
					painel_4.add(restaur);
					painel_4.add(lst_restaur_scroll);		

			// Adicionar Paineis:
				this.add(painel_1);	
				this.add(painel_2);	
				this.add(painel_3);	
				this.add(painel_4);	
		}

		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == nov_usuar){
				JanelaAdcPessoa JanelaCadPessoa = new JanelaAdcPessoa();
				this.dispose();
			}else if(event.getSource() == nov_brinq){
				JanelaAdcBrinquedo JanelaCadBrinquedo = new JanelaAdcBrinquedo();
				this.dispose();
			}else if(event.getSource() == nov_restr){
				JanelaAdcRestaurante JanelaCadRestaurante = new JanelaAdcRestaurante();
				this.dispose();
			}else if(event.getSource() == sair){
				JanelaPrincipal janela_principal = new JanelaPrincipal();
				this.dispose();
			}

		}

		@Override
		public void valueChanged(ListSelectionEvent e){
			if(e.getSource()==lst_usuar){ 
				if (!e.getValueIsAdjusting()) {                                 // Sem double event;
					String novo = (String)lst_usuar.getSelectedValue();
					for(int i=0; i<=AL_usuarios.size()-1; i++){
						if(AL_usuarios.get(i).getName()==novo){
							JanelaShowPessoa showPessoa = new JanelaShowPessoa(AL_usuarios.get(i));
							this.dispose();
						}
					}
				}
			}else if(e.getSource()==lst_brinqd){
				if (!e.getValueIsAdjusting()) {                                 // Sem double event;
					String novo = (String)lst_brinqd.getSelectedValue();
					for(int i=0; i<=AL_brinquedos.size()-1; i++){
						if(AL_brinquedos.get(i).getName()==novo){
							JanelaShowBrinquedo showBrinquedo = new JanelaShowBrinquedo(AL_brinquedos.get(i));
							this.dispose();
						}
					}
				}
			}else if(e.getSource()==lst_restaur){
				if (!e.getValueIsAdjusting()) {                                 // Sem double event;
					String novo = (String)lst_restaur.getSelectedValue();
					for(int i=0; i<=AL_restaurantes.size()-1; i++){
						if(AL_restaurantes.get(i).getName()==novo){
							JanelaShowRestaurante showRestaurante = new JanelaShowRestaurante(AL_restaurantes.get(i));
							this.dispose();
						}
					}
				}
			}	
		}
			
}	