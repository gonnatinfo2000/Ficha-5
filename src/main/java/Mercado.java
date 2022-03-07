import java.util.ArrayList;
import java.util.List;

public class Mercado {
	
	private List<Pessoa> listaPessoas;

	public Mercado(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void totalSaldo(ArrayList<Pessoa> lista) {
		double total = 0.00;
		for(Pessoa pessoa: lista) {
			total += pessoa.getSaldo();
		}
		System.out.println("Total do saldo: " + total);
	}
	

}
