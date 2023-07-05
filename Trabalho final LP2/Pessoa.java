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
		public Pessoa(String name, int ID, int age, float altura){
			this.is_doing = null;
			this.have_done = new ArrayList<Attraction>();
			this.name   = name;
			this.ID     = ID;
			this.setAltura(altura);
			this.setAge(age);	
		}
		public Pessoa(String name, int ID, int age, float altura, Attraction is_doing){
			this.is_doing = is_doing;
			this.have_done = new ArrayList<Attraction>();
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
			public void       setIs_doing(Attraction attc){this.is_doing = attc;}

			public ArrayList<Attraction> getHave_done(){return this.have_done;}
			public void setHave_done(ArrayList arry){this.have_done = arry;}

	// Metodos	
		public void sairAtual(){
			WriteAndRead salvar = new WriteAndRead(); 
			if(this.is_doing!=null){
				this.is_doing.setCurr(this.is_doing.getCurr()-1);
				if(this.is_doing instanceof Brinquedo){
					Brinquedo b = (Brinquedo)is_doing;
					salvar.excBrinquedo(b);
					salvar.escBrinquedo(b);
				}else{
					salvar.excRestaurante(is_doing);
					salvar.escRestaurante(is_doing);
				}
				this.is_doing = null;	
			} 
		}


		public boolean verificarHorario(Brinquedo b,int hora){
			if(b!=null) {
				int open = b.getOpen();
				int close = b.getClose();
				if (close > open) {
					if (open <= hora && hora < close) {
						return true;
					}
				} else if (open > close) {
					if (hora >= open || hora < close) {
						return true;
					}
				}
			}
			return false;
		}

		public String compraIngresso(Attraction a, int hora){
			// Compra o ingresso?
				WriteAndRead salvar = new WriteAndRead(); 
				ArrayList<Attraction> arr_rest = salvar.lerRestaurantes();
				boolean flag = true;
				if(this.is_doing!=null){ 
					for(int i=0; i<=arr_rest.size()-1; i++){
						if(this.is_doing.getName().equals(arr_rest.get(i).getName())){
							flag=false;
						}
					}
				}

				this.sairAtual();

				// Atualizando dados do brinquedo (caso eu queira ir novamente no brinquedo que já está)
					String ret = "";
					ArrayList<Attraction> arr_att = salvar.lerRestaurantes();
					ArrayList<Brinquedo>  arr_brq = salvar.lerBrinquedos();
					for(int i=0; i<=arr_att.size()-1; i++){
						if(arr_att.get(i).getName().equals(a.getName())){a=arr_att.get(i); break;}
					}
					for(int i=0; i<=arr_brq.size()-1; i++){
						if(arr_brq.get(i).getName().equals(a.getName())){a=arr_brq.get(i); break;}
					}
 
 				// Testes pra ver se pode comprar o ingresso:
					if(a.getCurr()<a.getCapc()){

						if(a instanceof Brinquedo){
							Brinquedo b = (Brinquedo)a;
							if(verificarHorario(b,hora)){
								if(this.getAge()>=b.getMin_age()){ 
									if(this.getAltura()>=b.getMin_altura()){
										if(flag){
											this.is_doing = a;
											this.have_done.add(a);
											a.setCurr(a.getCurr()+1);
											ret="Ingresso Comprado!\n";
											salvar.excBrinquedo(b);
											salvar.escBrinquedo(b);
										}else{ret="Precisa repousar a comida!\n";}
									}else{ret="Não tem altura suficiente!\n";}	
								}else{ret="Não tem idade suficiente!\n";}
							}else{ret="Fora do Horario!\n";}

						}else{
							this.is_doing = a;
							this.have_done.add(a);
							a.setCurr(a.getCurr()+1);
							salvar.excRestaurante(a);
							salvar.escRestaurante(a);
							ret="Ingresso Comprado!\n";
						}
					}else{
						ret = "Lotado!\n";
					}

			// Salvar Alteraçoes em pessoa;
				salvar.excPessoa(this);
				salvar.escPessoa(this);
			return ret;
		}
}