public class main{
	public static void main(String args[]){
		Park VictorPark        = new Park("VictorPark");
		Attraction restaurante = new Attraction("Barriga Cheia",10, "Tudo por 3 Reais", 4);

		Pessoa p1 = new Pessoa("Augusto", 1.55f, 11, 1000);
		Pessoa p2 = new Pessoa("Baankai", 1.66f, 22, 1001);
		Pessoa p3 = new Pessoa("Carrlos", 1.77f, 33, 1002);
		Pessoa p4 = new Pessoa("Danniel", 1.88f, 44, 1003);

		restaurante.addClient(p1);
		restaurante.addClient(p2);
		restaurante.addClient(p3);

		restaurante.addClient(p4); restaurante.extClient(p4);
		restaurante.addClient(p4); restaurante.extClient(p4);
		restaurante.addClient(p4); restaurante.extClient(p4);
		restaurante.addClient(p4); restaurante.extClient(p4);

		VictorPark.addAttraction(restaurante);
		VictorPark.showInfo();
		restaurante.showInfo();
		p4.showInfo();

	}
}