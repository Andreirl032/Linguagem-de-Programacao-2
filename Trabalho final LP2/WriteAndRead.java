import org.w3c.dom.Attr;

import java.io.File;           // classe File
import java.io.FileWriter;     //
import java.io.FileReader; 
import java.io.BufferedReader;    
import java.io.PrintWriter;
import java.io.IOException;    // classe IOException

import java.util.ArrayList;
import java.util.HashMap;

public class WriteAndRead{
	// Atributos;
		String barra  = System.getProperty("file.separator");
		String curBrq = System.getProperty("user.dir") + barra + "Arquivos" + barra + "Brinquedos";
		String curRst = System.getProperty("user.dir") + barra + "Arquivos" + barra + "Restaurantes";
		String curUsr = System.getProperty("user.dir") + barra + "Arquivos" + barra + "Usuarios";
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
								file_arq.close(); ler_arq.close();
								this.AL_brinquedo.add(new Brinquedo(name, ID, desc, capc, min_altura, min_age, open, close));
							}catch(Exception e){System.out.printf("Erro ao ler_all_brinquedos!\n"); return null;}
						}		
					}
					return this.AL_brinquedo;
				}catch(Exception e){System.out.printf("Erro ao ler_all_brinquedos!\n"); return null;}
			}

			public boolean excBrinquedo(Brinquedo b){
				String pathTxt = curBrq + barra + b.getName() + ".txt";
				try{
					File file = new File(pathTxt);
					if(file.delete()){return true;}else{return false;}
				}catch(Exception e){
					return false;
				}
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

			public ArrayList lerRestaurantes(){
				this.AL_restaurante = new ArrayList<Attraction>();

				String dir;
				String linha;
				int    cont;
				String name=""; int ID=0; String desc=""; int capc=0;
				try{
					File pasta = new File(curRst);
					File[] lista = pasta.listFiles();
					for(File arquivo : lista){ 

						if(arquivo.isFile()){
							dir = curRst + barra + arquivo.getName(); 
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
									}	
									linha = ler_arq.readLine();
									cont++;
								}
								file_arq.close(); ler_arq.close();
								this.AL_restaurante.add(new Attraction(name, ID, desc, capc));	
							}catch(Exception e){System.out.printf("bErro ao ler_all_brinquedos!\n"); return null;}
						}		
					}
					return this.AL_restaurante;
				}catch(Exception e){System.out.printf("aErro ao ler_all_brinquedos!\n"); return null;}
			}

			public boolean excRestaurante(Attraction a){
				String pathTxt = curBrq + barra + a.getName() + ".txt";
				try{
					File file = new File(pathTxt);
					if(file.delete()){return true;}else{return false;}
				}catch(Exception e){
					return false;
				}
			}			

		// Restaurante:	
			public boolean escPessoa(Pessoa p){
				String pathTxt = curUsr + barra + p.getName() + ".txt";
				String str = "";
				ArrayList<Attraction> have_done_list = p.getHave_done();
				for(int i=0;i<have_done_list.size();i++){
					str+=have_done_list.get(i).getID();
					if(i!=have_done_list.size()-1){
					str+=",";
					}
				}


				try{ 
					FileWriter   file_arq = new FileWriter(pathTxt);
					PrintWriter print_arq = new PrintWriter(file_arq); 
					print_arq.println(p.getName());
					print_arq.println(p.getID());
					print_arq.println(p.getAge());
					print_arq.println(p.getAltura());
					print_arq.println(str);
					print_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever Usuario em arquivo de txt.\n"); return false;}	
			}

			public ArrayList<Attraction> turnStringIntoHaveDone(String s){
				String[] str = s.split(",");
				int[] ids = new int[str.length];
				for(int i=0;i<str.length;i++){
					ids[i]=Integer.parseInt(str[i]);
				}

				ArrayList<Attraction> attracs = new ArrayList<Attraction>();
				ArrayList<Attraction> AL_brinquedos = this.lerBrinquedos();
				ArrayList<Attraction> AL_restaurantes = this.lerRestaurantes();
				for(int i:ids){
					for(Attraction brinqs:AL_brinquedos){
						if(brinqs.getID()==i){
							attracs.add(brinqs);
						}
					}
					for(Attraction rests:AL_restaurantes){
						if(rests.getID()==i){
							attracs.add(rests);
						}
					}
				}
				return attracs;
			}

			public ArrayList<Pessoa> lerPessoas(){
				this.AL_pessoa = new ArrayList<Pessoa>();

				String dir;
				String linha;
				int    cont;
				String name=""; int ID=0; int idade=0; float altura=0f; ArrayList<Attraction> have_done = new ArrayList<Attraction>();
				try{
					File pasta = new File(curUsr);
					File[] lista = pasta.listFiles();
					for(File arquivo : lista){ 
						if(arquivo.isFile()){
							dir = curUsr + barra + arquivo.getName(); 
							FileReader     file_arq = new FileReader(dir);
							BufferedReader ler_arq  = new BufferedReader(file_arq);
							linha = ""; cont=0;
							try{
								linha = ler_arq.readLine(); 
								while(linha!=null){
									switch(cont){
										case 0: name   = linha; break;
										case 1: ID     = Integer.parseInt(linha); break;
										case 2: idade  = Integer.parseInt(linha); break;
										case 3: altura = Float.parseFloat(linha); break;
										case 4: have_done = turnStringIntoHaveDone(linha); break;
									}	
									linha = ler_arq.readLine();
									cont++;
								}
								file_arq.close(); ler_arq.close();
								this.AL_pessoa.add(new Pessoa(name, ID, idade, altura, have_done));
							}catch(Exception e){System.out.printf("Erro ao ler_all_pessoas!\n"); return null;}
						}		
					}
					return this.AL_pessoa;
				}catch(Exception e){System.out.printf("Erro ao ler_all_pessoas!\n"); return null;}
			}	

			public boolean excPessoa(Pessoa p){
				String pathTxt = curUsr + barra + p.getName() + ".txt";
				try{
					File file = new File(pathTxt);
					if(file.delete()){return true;}else{return false;}
				}catch(Exception e){
					return false;
				}
			}
}