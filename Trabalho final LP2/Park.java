import java.util.ArrayList;
import java.util.HashMap;

public class Park{
	// Atributos
		private String name;
		public  static int time;
		private ArrayList<Attraction>  Attractions; 
		private HashMap<Integer, Pessoa>   Clients; 

	// Constutores
		public Park(){
			this.Attractions = new ArrayList<Attraction>();
			this.Clients     = new HashMap<Integer, Pessoa>();
		}
		public Park(String name){
			this.name = name;
			this.Attractions = new ArrayList<Attraction>();
			this.Clients     = new HashMap<Integer, Pessoa>();
		}

	// Gets && Sets
		public String getName(){return this.name;}
		public void   setName(String name){
			this.name = name;
		}		

		public static int   getTime(){return Park.time;}
		public static void  setTime(int time){
			Park.time = time;
		}

		public ArrayList getAttractions(){return this.Attractions;}
		public void      setAttractions(ArrayList Attractions){
			this.Attractions = Attractions;
		}		

	// Metodos
		public void addPessoa(Pessoa p){
			if(!Clients.containsKey(p.getID())){
				Clients.put(p.getID(), p);	
			}
		}

		public void addAttraction(Attraction a){
 			if(!Attractions.contains(a)){
 				Attractions.add(a);
 			}
		}

		public void showAttractions(){
			for(int i=0; i<=Attractions.size()-1; i++){
				if(Attractions.get(i) instanceof  Brinquedo){
					Brinquedo b = (Brinquedo)Attractions.get(i);
					b.showInfo();
				}else{
					Attractions.get(i).showInfo();
				}
			}
		}

		public void showInfo(){
			System.out.printf("-------------------------------------------\n");
			System.out.printf("%-15s:\n", this.name);
			this.showAttractions();
			System.out.printf("-------------------------------------------\n");
		}
	
}