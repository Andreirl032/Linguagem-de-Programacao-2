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

public class JanelaShowRestauranteUsuario extends JFrame implements ActionListener{
    // Atributos:
    // Define:
    private int LARGURA = 410;
    private int ALTURA  = 275;

    // Return:
    public Attraction restaurante = null;
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

//    private JButton excluir;
    private JButton sair;

    private JanelaUsuario janelaUser;

    // Construtor:
    public JanelaShowRestauranteUsuario(Attraction a,JanelaUsuario janelaUser){
        super("Information of: \"" + a.getName() +"\"");
        this.setLayout(null);
        this.setSize(LARGURA, ALTURA);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.inicializar(a);
        this.setVisible(true);
        this.janelaUser=janelaUser;
    }

    // Metodos Adicionais:
    public void inicializar(Attraction a){
        this.restaurante = a;
        // Atributos:
        this.lbl_nome = new JLabel("Nome:               ");
        this.txt_nome = new JTextField(25);
        this.txt_nome.setText(restaurante.getName());
        this.txt_nome.setEditable(false);


        this.lbl_ID  = new JLabel("ID: ");
        this.txt_ID  = new JTextField(25);
        this.txt_ID.setText(Integer.toString(restaurante.getID()));
        this.txt_ID.setEditable(false);

        this.lbl_desc = new JLabel("Description:     ");
        this.txt_desc = new JTextArea(5,25);
        this.txt_desc.setLineWrap(true);
        this.txt_desc.setWrapStyleWord(true);
        this.txt_desc.setText(restaurante.getDesc());
        this.txt_desc.setEditable(false);
        this.scroll = new JScrollPane(txt_desc);
        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.lbl_capc = new JLabel("Capacidade:    ");
        this.txt_capc = new JTextField(25);
        this.txt_capc.setText(Integer.toString(restaurante.getCapc()));
        this.txt_capc.setEditable(false);

//        this.excluir = new JButton("EXCLUIR");
//        this.excluir.addActionListener(this);
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

//        spring_layout.putConstraint(SpringLayout.NORTH, excluir,  10, SpringLayout.SOUTH,  txt_capc);
//        spring_layout.putConstraint(SpringLayout.EAST,  excluir,   0, SpringLayout.EAST,   txt_capc);
        spring_layout.putConstraint(SpringLayout.NORTH,      sair,  10, SpringLayout.SOUTH,  txt_capc);
        spring_layout.putConstraint(SpringLayout.EAST,       sair, 0, SpringLayout.EAST,  txt_capc);

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

//        painel.add(excluir);
        painel.add(sair);
        this.add(painel);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == sair){
//            JanelaUsuario JanelaUser = new JanelaUsuario();
            janelaUser.setVisible(true);
            this.dispose();
        }
    }

}	