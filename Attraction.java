import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Attraction{
	// Atributos
		private String    name;
		private int         ID;			
		private String    desc;
		private int       capc;
		private int       curr;

	// Construtores
		public Attraction(){}
		public Attraction(String name, int ID, String desc, int capc){
			this.name = name;
			this.ID   =   ID;
			this.desc = desc;
			this.capc = capc;
			this.curr = 0;
		}
		public Attraction(String name, int ID, String desc, int capc, int curr){
			this.name = name;
			this.ID   =   ID;
			this.desc = desc;
			this.capc = capc;
			this.curr = curr;
		}

	// Gets && Sets
		public String getName(){return this.name;}
		public void   setName(String name){
			this.name = name;
		}

		public int  getID(){return this.ID;}
		public void setID(int ID){
			this.ID = ID;
		}

		public String getDesc(){return this.desc;}
		public void   setDesc(String desc){
			this.desc = desc;
		}

		public int  getCapc(){return this.capc;}
		public void setCapc(int capc){this.capc = capc;}

		public int  getCurr(){return this.curr;}
		public void setCurr(int curr){this.curr = curr;}
		

	// Metodos	
		//Show:
			// public void showCUClients(){
			// 	System.out.printf("Imprimindo Atuais Clientes:\n");
			// 	for(int i=0; i<=this.CUclients.size()-1; i++){
			// 		System.out.printf("\t%d. %s;\n", i, CUclients.get(i).getName());
			// 	}
			// 	System.out.println();
			// }	

			// public void showEXClients(){
			// 	System.out.printf("Imprimindo EX-Clientes:\n");
			// 	int i=1;
			// 	for(Map.Entry<Pessoa, Integer> elem : EXclients.entrySet()){
			// 		System.out.printf("\t%d. %s - %d;\n", i, elem.getKey().getName(), elem.getValue());
			// 		i++;
			// 	}
			// 	System.out.println();
			// }	

			// public void showInfo(){
			// 	System.out.printf("%s, %s:\n", this.name, this.desc);
			// 	System.out.printf("ID: %d:\n", this.ID);
			// 	System.out.printf("Capacidade: %d/%d;\n", this.CUclients.size(), this.capc);
			// 	this.showCUClients();
			// 	this.showEXClients();
			// }

		//Action:	
			// public boolean addClient(Pessoa p){
			// 	if(this.CUclients.size() < this.capc){          // Se cabe mais 1;				
			// 			CUclients.add(p);
			// 			return true;
			// 	}
			// 	return false;
			// }

			// public boolean remClient(Pessoa p){			
			// 	if(CUclients.contains(p)){
			// 		CUclients.remove(p);
			// 	}
			// 	return false;
			// }

			// public boolean extAllClient(){
			// 	while(CUclients.size()>0){
			// 		this.remClient(CUclients.get(0));
			// 	}
			// 	return false;
			// }


}