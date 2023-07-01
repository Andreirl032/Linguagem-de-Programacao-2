import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class JanelaUsuario extends JFrame implements ActionListener, ListSelectionListener {
    private int LARGURA = 900;
    private int ALTURA  = 600;
    private int max_size = 25;

    private JPanel painel_1        = new JPanel();
    private SpringLayout spring_layout_1 = new SpringLayout();

    private ArrayList<Brinquedo>    AL_brinquedos;
    private ArrayList<Attraction> AL_restaurantes;
    WriteAndRead salvar = new WriteAndRead();
    private String[] names_brinquedos = new String[this.max_size];
    private String[] names_restaurantes = new String[this.max_size];

    private JRadioButton brinquedosButton;
    private JRadioButton restaurantesButton;
    private ButtonGroup group;
    private JComboBox<String> combo;
    private JButton infoButton;
    private JButton comprarButton;

    public JanelaUsuario(){
        super("Janela do Usuário");
        this.setLayout(null);
        this.setSize(LARGURA, ALTURA);
        this.setLocationRelativeTo(null);                           // Centralizar;
        this.setResizable(false);                                   // Não pode redimencionar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.inicializar();
        this.setVisible(true);
    }

    public void inicializar(){

        painel_1.setBackground(new Color(0,0,0,0));
        painel_1.setBounds(0, 0, LARGURA, ALTURA);
        painel_1.setLayout(spring_layout_1);

        // Jlist:
        // Importar Array:
        this.AL_brinquedos = salvar.lerBrinquedos();
        int i=0;
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
        for(int j=0; j<i; j++){nomes_brinqd[j]=names_brinquedos[j];}
        this.names_brinquedos=new String[i];
        for(int j=0; j<i; j++){names_brinquedos[j]=nomes_brinqd[j];}



        this.AL_restaurantes = salvar.lerRestaurantes();
        i=0;
        for(; i<=AL_restaurantes.size()-1; i++){
            if(i<=this.max_size-1){
                names_restaurantes[i] = AL_restaurantes.get(i).getName();
            }else{
                System.out.printf("Num max de attractions atingido! -> Novos restaurantes não serão mostrados.\n");
                break;
            }
        }

        // Criar outro vetor:
        String[] nomes_restaurante = new String[i];
        for(int j=0; j<i; j++){nomes_restaurante[j]=names_restaurantes[j];}
        names_restaurantes=new String[i];
        for(int j=0; j<i; j++){names_restaurantes[j]=nomes_restaurante[j];}


        this.infoButton=new JButton("Visualizar info");
        infoButton.addActionListener(this);
        infoButton.setActionCommand("info");

        this.comprarButton=new JButton("Comprar ingresso");
        comprarButton.addActionListener(this);
        comprarButton.setActionCommand("comprar");

        this.combo = new JComboBox<String>(names_brinquedos);
        combo.addActionListener(this);

        this.brinquedosButton=new JRadioButton("Brinquedos");
        brinquedosButton.setSelected(true);
        brinquedosButton.addActionListener(this);
        brinquedosButton.setActionCommand("brinquedos");

        this.restaurantesButton=new JRadioButton("Restaurantes");
        restaurantesButton.setSelected(false);
        restaurantesButton.addActionListener(this);
        restaurantesButton.setActionCommand("restaurantes");

        this.group = new ButtonGroup();
        group.add(brinquedosButton);
        group.add(restaurantesButton);

        spring_layout_1.putConstraint(SpringLayout.NORTH,      brinquedosButton, 15, SpringLayout.NORTH, painel_1);
        spring_layout_1.putConstraint(SpringLayout.WEST,       brinquedosButton, 30, SpringLayout.WEST,  painel_1);

        spring_layout_1.putConstraint(SpringLayout.NORTH,      restaurantesButton, 10, SpringLayout.SOUTH, brinquedosButton);
        spring_layout_1.putConstraint(SpringLayout.WEST,       restaurantesButton, 30, SpringLayout.WEST,  painel_1);

        spring_layout_1.putConstraint(SpringLayout.NORTH, combo,  30, SpringLayout.NORTH,   painel_1);
        spring_layout_1.putConstraint(SpringLayout.WEST,  combo,  30, SpringLayout.EAST,   brinquedosButton);

        spring_layout_1.putConstraint(SpringLayout.NORTH, infoButton,  15, SpringLayout.NORTH,   painel_1);
        spring_layout_1.putConstraint(SpringLayout.WEST,  infoButton,  30, SpringLayout.EAST,   combo);

        spring_layout_1.putConstraint(SpringLayout.NORTH, comprarButton,  10, SpringLayout.SOUTH,   infoButton);
        spring_layout_1.putConstraint(SpringLayout.WEST,  comprarButton,  30, SpringLayout.EAST,   combo);


        painel_1.add(combo);
        painel_1.add(brinquedosButton);
        painel_1.add(restaurantesButton);
        painel_1.add(infoButton);
        painel_1.add(comprarButton);

        this.add(painel_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==brinquedosButton){
            painel_1.remove(combo);
            combo=new JComboBox<String>(names_brinquedos);
            painel_1.add(combo);
            spring_layout_1.putConstraint(SpringLayout.NORTH, combo,  30, SpringLayout.NORTH,   painel_1);
            spring_layout_1.putConstraint(SpringLayout.WEST,  combo,  30, SpringLayout.EAST,   brinquedosButton);
            spring_layout_1.putConstraint(SpringLayout.NORTH, infoButton,  15, SpringLayout.NORTH,   painel_1);
            spring_layout_1.putConstraint(SpringLayout.WEST,  infoButton,  30, SpringLayout.EAST,   combo);

            spring_layout_1.putConstraint(SpringLayout.NORTH, comprarButton,  10, SpringLayout.SOUTH,   infoButton);
            spring_layout_1.putConstraint(SpringLayout.WEST,  comprarButton,  30, SpringLayout.EAST,   combo);
            this.revalidate();
            this.repaint();
//            painel_1.add(combo);
        } else if (e.getSource()==restaurantesButton) {
            painel_1.remove(combo);
            combo=new JComboBox<String>(names_restaurantes);
            painel_1.add(combo);
            spring_layout_1.putConstraint(SpringLayout.NORTH, combo,  30, SpringLayout.NORTH,   painel_1);
            spring_layout_1.putConstraint(SpringLayout.WEST,  combo,  30, SpringLayout.EAST,   brinquedosButton);
            spring_layout_1.putConstraint(SpringLayout.NORTH, infoButton,  15, SpringLayout.NORTH,   painel_1);
            spring_layout_1.putConstraint(SpringLayout.WEST,  infoButton,  30, SpringLayout.EAST,   combo);

            spring_layout_1.putConstraint(SpringLayout.NORTH, comprarButton,  10, SpringLayout.SOUTH,   infoButton);
            spring_layout_1.putConstraint(SpringLayout.WEST,  comprarButton,  30, SpringLayout.EAST,   combo);
            this.revalidate();
            this.repaint();
        } else if (e.getSource()==infoButton) {
            String selected=(String)combo.getSelectedItem();
            System.out.println(group.getSelection().getActionCommand());
            if(Objects.equals(group.getSelection().getActionCommand(), "brinquedos")){
            for(int i=0; i<=AL_brinquedos.size()-1; i++){
                if(Objects.equals(AL_brinquedos.get(i).getName(), selected)){
                    JanelaShowBrinquedoUsuario showBrinquedo = new JanelaShowBrinquedoUsuario(AL_brinquedos.get(i),this);
                    this.setVisible(false);
                }
            }} else if (Objects.equals(group.getSelection().getActionCommand(), "restaurantes")) {
            for(int i=0; i<=AL_restaurantes.size()-1; i++){
                if(Objects.equals(AL_restaurantes.get(i).getName(), selected)){
                    JanelaShowRestauranteUsuario showRestaurante = new JanelaShowRestauranteUsuario(AL_restaurantes.get(i),this);
                    this.setVisible(false);
                }
            }
        }}

        else if (e.getSource()==comprarButton) {

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
