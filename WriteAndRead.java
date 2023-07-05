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
					print_arq.println(b.getCurr());
					print_arq.println(b.getCapc());
					print_arq.println(b.getMin_altura());
					print_arq.println(b.getMin_age());
					print_arq.println(b.getOpen());
					print_arq.println(b.getClose());
					print_arq.close(); file_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever brinquedo em arquivo de txt.\n"); return false;}	
			}

			public ArrayList lerBrinquedos(){
				this.AL_brinquedo = new ArrayList<Brinquedo>();

				String dir;
				String linha;
				int    cont;
				String name=""; int ID=0; String desc=""; int curr=0; int capc=0; float min_altura=0f; int min_age=0; int open=0; int close=0;
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
										case 3: curr       = Integer.parseInt(linha); break;
										case 4: capc       = Integer.parseInt(linha); break;
										case 5: min_altura = Float.parseFloat(linha); break;
										case 6: min_age    = Integer.parseInt(linha); break;
										case 7: open       = Integer.parseInt(linha); break;
										case 8: close      = Integer.parseInt(linha); break;	
									}
									linha = ler_arq.readLine();
									cont++;
								}
								file_arq.close(); ler_arq.close();
								this.AL_brinquedo.add(new Brinquedo(name, ID, desc, capc, min_altura, min_age, open, close, curr));	
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
					print_arq.println(a.getCurr());
					print_arq.println(a.getCapc());
					print_arq.close(); file_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever Restaurante em arquivo de txt.\n"); return false;}	
			}

			public ArrayList lerRestaurantes(){
				this.AL_restaurante = new ArrayList<Attraction>();

				String dir;
				String linha;
				int    cont;
				String name=""; int ID=0; String desc=""; int capc=0; int curr=0;
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
										case 3: curr       = Integer.parseInt(linha); break;
										case 4: capc       = Integer.parseInt(linha); break;
									}	
									linha = ler_arq.readLine();
									cont++;
								}
								file_arq.close(); ler_arq.close();
								this.AL_restaurante.add(new Attraction(name, ID, desc, capc, curr));	
							}catch(Exception e){System.out.printf("bErro ao ler_all_brinquedos!\n"); return null;}
						}		
					}
					return this.AL_restaurante;
				}catch(Exception e){System.out.printf("aErro ao ler_all_brinquedos!\n"); return null;}
			}

			public boolean excRestaurante(Attraction a){
				String pathTxt = curRst + barra + a.getName() + ".txt";
				try{
					File file = new File(pathTxt);
					if(file.delete()){return true;}else{return false;}
				}catch(Exception e){
					return false;
				}
			}			

		// Pessoa:	
			public boolean escPessoa(Pessoa p){
				String pathTxt = curUsr + barra + p.getName() + ".txt";
				try{ 
					FileWriter   file_arq = new FileWriter(pathTxt);
					PrintWriter print_arq = new PrintWriter(file_arq); 
					print_arq.println(p.getName());
					print_arq.println(p.getID());
					print_arq.println(p.getAge());
					print_arq.println(p.getAltura());
					print_arq.println(p.getIs_doing()!=null ? p.getIs_doing().getName() : "Empty!");

					for(int i=0; i<=p.getHave_done().size()-1; i++){
						print_arq.print(p.getHave_done().get(i).getID());
						if(i!=p.getHave_done().size()-1){print_arq.print("_");}	
					}

					print_arq.close(); file_arq.close();
					return true;
				}catch(IOException e){System.out.printf("Erro ao escrever Usuario em arquivo de txt.\n"); return false;}	
			}

			public ArrayList lerPessoas(){
				this.AL_pessoa = new ArrayList<Pessoa>();
				ArrayList<Attraction> all_brinquedos   = lerBrinquedos();
				ArrayList<Attraction> all_restaurantes = lerRestaurantes();

				String dir;
				String linha;
				int    cont;
				String txt_separado[] = new String[100];
				String name=""; int ID=0; int idade=0; float altura=0f; 
				Attraction is_doing = null; String str_is_doing="";
				ArrayList<Attraction> arry_retorno = new ArrayList<Attraction>();

				try{
					File pasta = new File(curUsr);
					File[] lista = pasta.listFiles();
					for(File arquivo : lista){ 
						if(arquivo.isFile()){
							dir = curUsr + barra + arquivo.getName();
							FileReader     file_arq = new FileReader(dir);
							BufferedReader ler_arq  = new BufferedReader(file_arq);
							linha = ""; cont=0; arry_retorno = new ArrayList<Attraction>();

							try{
								linha = ler_arq.readLine(); 
								while(linha!=null){
									switch(cont){
										case 0: name   = linha; break;
										case 1: ID     = Integer.parseInt(linha); break;
										case 2: idade  = Integer.parseInt(linha); break;
										case 3: altura = Float.parseFloat(linha); break;
										case 4:
											str_is_doing = linha;
											if(str_is_doing.equals("Empty!")){
												is_doing = null;
											}else{ 
												for(int i=0; i<=all_brinquedos.size()-1; i++){
													if(str_is_doing.equals(all_brinquedos.get(i).getName())){
														is_doing = all_brinquedos.get(i);
													}
												}
												for(int i=0; i<=all_restaurantes.size()-1; i++){
													if(str_is_doing.equals(all_restaurantes.get(i).getName())){
														is_doing = all_restaurantes.get(i);
													}
												}
											}
											break;
										case 5:
											txt_separado = linha.split("_");
											if(txt_separado.length>=1){ 
												for(int i=0; i<=txt_separado.length-1; i++){
													for(int j=0; j<=all_brinquedos.size()-1; j++){
														if(txt_separado[i].equals(Integer.toString(all_brinquedos.get(j).getID()))){
															arry_retorno.add(all_brinquedos.get(j));
															break;
														}	
													}
													for(int j=0; j<=all_restaurantes.size()-1; j++){
														if(txt_separado[i].equals(Integer.toString(all_restaurantes.get(j).getID()))){
															arry_retorno.add(all_restaurantes.get(j));
															break;
														}
													}
												}
												break;
											}	
									}	
									linha = ler_arq.readLine();
									cont++;
								}
								file_arq.close(); ler_arq.close();

								Pessoa p = new Pessoa(name, ID, idade, altura, is_doing); p.setHave_done(arry_retorno);
								this.AL_pessoa.add(p);	
							}catch(Exception e){System.out.printf("1_Erro ao ler_all_pessoas!\n"); return null;}
						}		
					}
					return this.AL_pessoa;
				}catch(Exception e){System.out.printf("2_Erro ao ler_all_pessoas!\n"); return null;}
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