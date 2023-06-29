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
			import javax.swing.JTextField;				// Caixa Texto

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

public class JanelaAdministrador extends JFrame implements ActionListener{
	// Atributos:
		// Define:
			private int LARGURA = 800;
			private int ALTURA  = 600;
			private int max_attractions = 25;

		// Arrays:
			WriteAndRead salvar = new WriteAndRead();
			private ArrayList<Brinquedo> AL_brinquedos;	

		// Painel 1:
			private int LARGURA_p1 = 800;
			private int ALTURA_p1  = 100;

			private JPanel 		 painel_1        = new JPanel();
			private SpringLayout spring_layout_1 = new SpringLayout(); 
			private JLabel  bem_vindo;
			private JButton nov_brinq;
			private JButton nov_restr;
			private JButton nov_usuar;

		// Painel 2:	
			private int LARGURA_p2 = 400;
			private int ALTURA_p2  = 500;

			private JPanel 		 painel_2        = new JPanel();
			private SpringLayout spring_layout_2 = new SpringLayout(); 

			private JLabel     usuar;
			private String[] names_usuar = {"Victor Jose Martinez"};
			private JList      lst_usuar;

		// Painel 3:	
			private int LARGURA_p3 = 400;
			private int ALTURA_p3  = 500;

			private JPanel 		 painel_3        = new JPanel();
			private SpringLayout spring_layout_3 = new SpringLayout(); 

			private JLabel   attrac;
			private String[] names_attrac = new String[this.max_attractions];
			private JList    lst_attrac;	

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

				// Posicionamento:
					painel_1.setBackground(new Color(80,80,80,80));
					painel_1.setBounds(0, 0, LARGURA_p1, ALTURA_p1);
					painel_1.setLayout(spring_layout_1);
					spring_layout_1.putConstraint(SpringLayout.NORTH, bem_vindo,  10, SpringLayout.NORTH, painel_1);
					spring_layout_1.putConstraint(SpringLayout.WEST,  bem_vindo,  10, SpringLayout.WEST,  painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_brinq,  10, SpringLayout.NORTH, painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_brinq, -25, SpringLayout.EAST,  painel_1);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_restr,  10, SpringLayout.NORTH, painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_restr, -15, SpringLayout.WEST,  nov_brinq);

					spring_layout_1.putConstraint(SpringLayout.NORTH, nov_usuar,  10, SpringLayout.NORTH, painel_1);
					spring_layout_1.putConstraint(SpringLayout.EAST,  nov_usuar, -15, SpringLayout.WEST,  nov_restr);

				// Adicionar:
					painel_1.add(bem_vindo);	
					painel_1.add(nov_brinq);
					painel_1.add(nov_restr);		
					painel_1.add(nov_usuar);	

			// Inicializar Painel 02:
				// Atributos:
					this.usuar = new JLabel("Usuarios: ");
					this.lst_usuar = new JList(names_usuar);

				// Posicionamento:
					painel_2.setBackground(new Color(255,0,0,80));
					painel_2.setBounds(0, ALTURA_p1, LARGURA_p2, ALTURA_p2);
					painel_2.setLayout(spring_layout_2);
					spring_layout_2.putConstraint(SpringLayout.NORTH, usuar,  10, SpringLayout.NORTH, painel_2);
					spring_layout_2.putConstraint(SpringLayout.WEST,  usuar,  10, SpringLayout.WEST,  painel_2);

					spring_layout_2.putConstraint(SpringLayout.NORTH, lst_usuar,  10, SpringLayout.SOUTH,   usuar);
					spring_layout_2.putConstraint(SpringLayout.WEST,  lst_usuar,  30, SpringLayout.WEST,  painel_2);

				// Adicionar:
					painel_2.add(usuar);
					painel_2.add(lst_usuar);

			// Inicializar Painel 03 - Attractions:		
				// Atributos:
					this.attrac = new JLabel("Atrações: ");

					this.AL_brinquedos = salvar.lerBrinquedos();
					int i=0;
					for(; i<=AL_brinquedos.size()-1; i++){
						if(i<=this.max_attractions-1){
							names_attrac[i] = AL_brinquedos.get(i).getName();
						}else{
							System.out.printf("Num max de attractions atingido! -> Novas atrações não serão mostradas.\n");
							break;
						}
					}

					// Outro vetor pra lista não ficar com espaços vazios do names_attrac;
					String[] nomes_attrac = new String[i];
					for(int j=0; j<=i-1; j++){nomes_attrac[j]=names_attrac[j];}

					this.lst_attrac = new JList(nomes_attrac);
					this.lst_attrac.setSelectionForeground(Color.RED);
					this.lst_attrac.setSelectionBackground(new Color(255, 100, 100, 80));
					this.lst_attrac.setFixedCellWidth(150);
					this.lst_attrac.setFixedCellHeight(30);
					
					

				// Posicionamento:
					painel_3.setBackground(new Color(0,255,0,80));
					painel_3.setBounds(LARGURA_p2, ALTURA_p1, LARGURA_p3, ALTURA_p3);
					painel_3.setLayout(spring_layout_3);
					spring_layout_3.putConstraint(SpringLayout.NORTH, attrac,  10, SpringLayout.NORTH, painel_3);
					spring_layout_3.putConstraint(SpringLayout.WEST,  attrac,  10, SpringLayout.WEST,  painel_3);

					spring_layout_3.putConstraint(SpringLayout.NORTH, lst_attrac,  10, SpringLayout.SOUTH,   attrac);
					spring_layout_3.putConstraint(SpringLayout.WEST,  lst_attrac,  30, SpringLayout.WEST,  painel_3);

				// Adicionar:
					painel_3.add(attrac);
					painel_3.add(lst_attrac);	

			// Adicionar Paineis:
				this.add(painel_1);	
				this.add(painel_2);	
				this.add(painel_3);	
		}

		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == nov_usuar){
				JOptionPane.showMessageDialog(null, "Cad Usuario");
			}else if(event.getSource() == nov_brinq){
				JanelaAdcBrinquedo JanelaCadBrinquedo = new JanelaAdcBrinquedo();
				this.dispose();
			}else if(event.getSource() == nov_restr){
				JanelaAdcRestaurante JanelaCadRestaurante = new JanelaAdcRestaurante();
				this.dispose();
			}
		}
			
}	