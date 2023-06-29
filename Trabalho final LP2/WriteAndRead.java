import java.io.File;           // classe File
import java.io.FileWriter;     //
import java.io.FileReader; 
import java.io.BufferedReader;    
import java.io.PrintWriter;
import java.io.IOException;    // classe IOException

import java.util.ArrayList;    

public class WriteAndRead{
	// Atributos;
		String barra  = System.getProperty("file.separator");
		String curBrq = System.getProperty("user.dir") + barra + "Arquivos" + barra + "Brinquedos";
		String curRst = System.getProperty("user.dir") + barra + "Arquivos" + barra + "Restaurantes";
		private Brinquedo  brinquedo;	private ArrayList<Brinquedo>  AL_brinquedo;
		private Attraction restaurante; private ArrayList<Attraction> AL_restaurante;	
		private Pessoa     pessoa;      private ArrayList<Pessoa>     AL_pessoa;

	// Construtores;
		public WriteAndRead(){
			this.AL_brinquedo   = new ArrayList<Brinquedo>();
			this.AL_restaurante = new ArrayList<Attraction>();
			this.AL_pessoa      = new ArrayList<Pessoa>();
		}

	// Metodos;
		// Brinquedo:
			public boolean escBrinquedo(Brinquedo b){
				String pathTxt = curBrq + barra + b.getName() + ".txt";
				try{ 
					FileWriter   file_arq = new FileWriter(pathTxt);
					PrintWriter print_arq = new PrintWriter(file_arq); 
					print_arq.println(b.getName());
					print_arq.println(b.getID());
					print_arq.println(b.getDesc());
					print_arq.println(b.getCapc());
					print_arq.println(b.getMin_altura());
					print_arq.println(b.getMin_age());
					print_arq.println(b.getOpen());
					print_arq.println(b.getClose());
					print_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever brinquedo em arquivo de txt.\n"); return false;}	
			}

			public ArrayList lerBrinquedos(){
				this.AL_brinquedo = new ArrayList<Brinquedo>();

				String dir;
				String linha;
				int    cont;
				String name=""; int ID=0; String desc=""; int capc=0; float min_altura=0f; int min_age=0; int open=0; int close=0;
				try{
					File pasta = new File(curBrq);
					File[] lista = pasta.listFiles();
					for(File arquivo : lista){ 

						if(arquivo.isFile()){
							dir = curBrq + barra + arquivo.getName(); 
							FileReader     file_arq = new FileReader(dir);
							BufferedReader ler_arq  = new BufferedReader(file_arq);
							linha = ""; cont=0;
							try{

								linha = ler_arq.readLine(); 
								while(linha!=null){
									switch(cont){
										case 0: name       = linha; break;
										case 1: ID         = Integer.parseInt(linha); break;
										case 2: desc       = linha; break;
										case 3: capc       = Integer.parseInt(linha); break;
										case 4: min_altura = Float.parseFloat(linha); break;
										case 5: min_age    = Integer.parseInt(linha); break;
										case 6: open       = Integer.parseInt(linha); break;
										case 7: close      = Integer.parseInt(linha); break;	
									}
									linha = ler_arq.readLine();
									cont++;
								}

								this.AL_brinquedo.add(new Brinquedo(name, ID, desc, capc, min_altura, min_age, open, close));	
							}catch(Exception e){System.out.printf("Erro ao ler_all_brinquedos!\n"); return null;}
						}		
					}
					return this.AL_brinquedo;
				}catch(Exception e){System.out.printf("Erro ao ler_all_brinquedos!\n"); return null;}
			}

		// Restaurante:	
			public boolean escRestaurante(Attraction a){
				String pathTxt = curRst + barra + a.getName() + ".txt";
				try{ 
					FileWriter   file_arq = new FileWriter(pathTxt);
					PrintWriter print_arq = new PrintWriter(file_arq); 
					print_arq.println(a.getName());
					print_arq.println(a.getID());
					print_arq.println(a.getDesc());
					print_arq.println(a.getCapc());
					print_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever Restaurante em arquivo de txt.\n"); return false;}	
			}

			// public void lerRestaurante(Attraction a){
			// 	String curArq = curBrq +barra + "Arquivos" + barra + "Brinquedos";
				
			// }

}