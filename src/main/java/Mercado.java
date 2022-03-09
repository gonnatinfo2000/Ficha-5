import java.util.ArrayList;
import java.util.List;

public class Mercado {
	
	private ArrayList<Pessoa> listaPessoas;

	public Mercado(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public static void totalSaldo(ArrayList<Pessoa> lista) {
		double total = 0.00;
		for(Pessoa pessoa: lista) {
			total += pessoa.getSaldo();
		}
		System.out.println("Total do saldo: " + total);
	}
	
	public static void main(String[] args) {	
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		Pessoa pessoa1 = new Pessoa("Gonçalo", "Natividade", 20, 10.00);
		Pessoa pessoa2 = new Pessoa("Margarida", "Diniz", 37, 20.00);
		Pessoa pessoa3 = new Pessoa("Fábio", "Freitas", 27, 15.00);
		Pessoa pessoa4 = new Pessoa("Luís", "Filipe", 30, 30.00);
		
		listaPessoas.add(pessoa1);
		listaPessoas.add(pessoa2);
		listaPessoas.add(pessoa3);
		listaPessoas.add(pessoa4);
		
		totalSaldo(listaPessoas);
	}
	

}
