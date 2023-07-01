import java.util.ArrayList;

public class Brinquedo extends Attraction{
	//Atributos
		private float min_altura;
		private int   min_age;
		private int   open;
		private int   close;

	//Construtores
		public Brinquedo(){super();}
		public Brinquedo(String name, int ID, String desc, int capacidade, float min_altura, int min_age, int open, int close){
			super(name, ID, desc, capacidade);
			this.min_altura = min_altura;
			this.min_age    = min_age;
			this.open       = open;
			this.close      = close;
		}

	//Gets && Sets
		public float getMin_altura(){return this.min_altura;}
		public void  setMin_altura(float min_altura){
			this.min_altura = min_altura;
		}

		public int  getMin_age(){return this.min_age;}
		public void setMin_age(int min_age){
			this.min_age = min_age;
		}

		public int  getOpen(){return this.open;}
		public void setOpen(int open){
			this.open = open;
		}

		public int  getClose(){return this.close;}
		public void setClose(int close){
			this.close = close;
		}

	//Metodos
		@Override
		public void showInfo(){
			System.out.printf("Imprimindo Information:\n");
			System.out.printf("\t%15s: %s;\n", super.getName(), super.getDesc());
			System.out.printf("\tID:            %d;\n",            this.getID());
			System.out.printf("\tCapacidade:    %d;\n",            super.getCapc());
			System.out.printf("\tMinima Altura: %.1f;\n",          this.min_altura);
			System.out.printf("\tMinima Idade:  %d;\n",            this.min_age);
			System.out.printf("\tFuncionamento: %2d:00-%2d:00;\n", this.open, this.close);
			System.out.println();
			super.showCUClients();
			super.showEXClients();
		}

		@Override
		public boolean addClient(Pessoa p){
			ArrayList cur = super.getCUclients();
			if(!cur.contains(p)){
				if(super.getCUclients().size() < super.getCapc()){
					if(p.getAltura() >= this.min_altura){
						if(p.getAge() >= this.min_age){
							if( Park.getTime() >=this.open && Park.getTime()<=this.close){
								// Restrições especificas a brinquedos
								if(super.getID()==100){

								}else if(super.getID()==110){

								}
							}
						}
					}
				}
			}
			return false;
		}
}