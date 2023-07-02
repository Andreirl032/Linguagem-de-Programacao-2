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
		private ArrayList<Attraction> have_done;

	// Construtores
		public Pessoa(){
			this.is_doing = null;
			this.have_done = new ArrayList<Attraction>();
		}
		public Pessoa(String name, int ID, int age, float altura,ArrayList<Attraction> have_done){
			this.is_doing = null;
			this.have_done = have_done;
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

			public ArrayList<Attraction> getHave_done(){return this.have_done;}
			public void    setHave_done(ArrayList<Attraction> hasm){
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
			for(Attraction elem : this.have_done){
				System.out.printf("\tid:%d nome:%s;\n", i, elem.getID(),elem.getName());
				i++;
			}
		}
}