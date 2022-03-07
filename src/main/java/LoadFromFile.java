import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class LoadFromFile {

	// Métodos
	public ArrayList<Pessoa> obterInformacaoFicheiro(String nomeFicheiro) {	
		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		
		try {
			InputStream ios = getFileAsIOStream(nomeFicheiro);
			
			String conteudo = getFileContent(ios);
			
			listaPessoa =  converterStringParaListaPessoa(conteudo);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return listaPessoa; 
	}

	private InputStream getFileAsIOStream(String nomeFicheiro) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(nomeFicheiro);
		
		if (is == null) {
            throw new IllegalArgumentException(nomeFicheiro + "não foi encontrado");
        }	
		
		return is;
	}
	
	private String getFileContent(InputStream is) {
		String conteudo = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String linha;
			while((linha = br.readLine()) != null) {
				conteudo = conteudo + linha;
			}
			
			is.close();
		}catch(Exception e){
			System.out.println(e);
		}

        return conteudo;
	}
	
	private static ArrayList<Pessoa> converterStringParaListaPessoa(String texto) throws JSONException {

        ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
        JSONArray jsonArray = new JSONArray(texto);
        
        for(int i = 0; i < jsonArray.length(); i++) {
        	 JSONObject jsonObject = jsonArray.getJSONObject(i);
        	 
        	 Pessoa pessoa = new Pessoa(
        		 jsonObject.getString("Primeiro_nome"),
        		 jsonObject.getString("Ultimo_nome"),
        		 jsonObject.getInt("Idade"),
        		 jsonObject.getDouble("Saldo")
        	 );
        	 
        	 listaPessoa.add(pessoa);
        	 
        } 
        return listaPessoa;
	}
}
