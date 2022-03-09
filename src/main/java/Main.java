import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String IDADE = null;

	public static void main(String[] args) {
		
		LoadFromFile load = new LoadFromFile();
		
		Pessoa pessoa = new Pessoa("Gonçalo", "Natividade", 20, 0.00);
		System.out.println(pessoa);
		
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		Pessoa pessoa1 = new Pessoa("Gonçalo", "Natividade", 20, 10.00);
		Pessoa pessoa2 = new Pessoa("Margarida", "Diniz", 37, 20.00);
		Pessoa pessoa3 = new Pessoa("Fábio", "Freitas", 27, 15.00);
		Pessoa pessoa4 = new Pessoa("Luís", "Filipe", 30, 30.00);
		
		listaPessoas.add(pessoa1);
		listaPessoas.add(pessoa2);
		listaPessoas.add(pessoa3);
		listaPessoas.add(pessoa4);
		
		Mercado mercado = new Mercado(listaPessoas);
		mercado.totalSaldo(listaPessoas); 
		
		System.out.println(load.obterInformacaoFicheiro("./pessoas.json"));
		System.out.println(load.getFileContent(load.getFileAsIOStream("./pessoas.json")));
		System.out.println(load.converterStringParaListaPessoa(load.getFileContent(load.getFileAsIOStream("./pessoas.json"))));
	}
	
}
