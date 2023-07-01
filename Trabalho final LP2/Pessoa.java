import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pessoa{
	// Atributos
		private String name;
		private int    ID;
		private float  altura;
		private int    age;

		private Attraction is_doing;
		private HashMap<Attraction, Integer> have_done;

	// Construtores
		public Pessoa(){
			this.is_doing = null;
			this.have_done = new HashMap<Attraction, Integer>();
		}
		public Pessoa(String name, int ID, int age, float altura){
			this.is_doing = null;
			this.have_done = new HashMap<Attraction, Integer>();
			this.name   = name;
			this.ID     = ID;
			this.setAltura(altura);
			this.setAge(age);	
		}

	// Gets && Sets
		// caracteristicas:
			public String getName(){return this.name;}
			public void   setName(String name){
				this.name = name;
			}

			public int  getID(){return this.ID;}
			public void setID(int ID){this.ID = ID;}

			public float getAltura(){return this.altura;}
			public void  setAltura(float altura){
				if(altura>=0){this.altura  = altura;}
			}

			public int  getAge(){return this.age;}
			public void setAge(int age){
				if(age>=0){this.age = age;}
			}

		// actions:
			public Attraction getIs_doing(){return this.is_doing;}
			public void       setIs_doing(Attraction attc){
				this.is_doing = attc;
			}

			public HashMap<Attraction, Integer> getHave_done(){return this.have_done;}
			public void    setHave_done(HashMap<Attraction, Integer> hasm){
				this.have_done = hasm;
			}



	// Metodos
		public void showInfo(){
			System.out.printf("%-10s - %3d Years - %.2fm;\n", this.name, this.age, this.altura);
			System.out.printf("ID: %d;\n", this.ID);
			this.showDoing();
		}	

		public void showDoing(){
			System.out.printf("No momento: %s;\n", (this.is_doing!=null) ? this.is_doing.getName() : "Nada");
			System.out.printf("Já foi em:\n");

			int i=1;
			for(Map.Entry<Attraction, Integer> elem : have_done.entrySet()){
				System.out.printf("\t%d. %s - %d;\n", i, elem.getKey().getName(), elem.getValue());
				i++;
			}
		}
}