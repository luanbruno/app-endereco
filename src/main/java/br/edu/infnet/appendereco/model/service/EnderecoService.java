package br.edu.infnet.appendereco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appendereco.clients.CepClients;
import br.edu.infnet.appendereco.clients.EnderecoCliente;
import br.edu.infnet.appendereco.model.domain.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoCliente enderecoCliente;
	
	@Autowired
	private CepClients cepClients;

//	private static Map<Integer, Endereco> mapaEndereco = new HashMap<Integer, Endereco>();
//	private static Integer pk = 0;

	public List<Endereco> obterLista() {
//		return new ArrayList<Endereco>(mapaEndereco.values());
		return enderecoCliente.obterLista();
	}

	public Endereco obterPorCep(String cep) {

//		for(Endereco end : mapaEndereco.values()) {
//			if(end.getCep().equals(cep)) {
//				return end;
//			}
//		}
//		Endereco endereco = new Endereco();
//		endereco.setCep(cep);
//		return endereco;

		//Endereco endereco = enderecoCliente.obterPorCep(cep);
		Endereco endereco = cepClients.obterPorCep(cep);
		if(endereco == null) {
			return new Endereco(cep);
		}else {
			return endereco;
		}
				
	}

	public void incluir(Endereco endereco) {
//		endereco.setId(++pk);
//		mapaEndereco.put(endereco.getId(), endereco);
		enderecoCliente.incluir(endereco);
	}

	public void excluir(Integer id) {
//		mapaEndereco.remove(id);
		enderecoCliente.excluir(id);
	}

}
