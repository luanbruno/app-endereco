package br.edu.infnet.appendereco.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.appendereco.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "CepClient")
public interface CepClients {

	@GetMapping(value = "/{cep}/json")
	public Endereco obterPorCep(@PathVariable String cep);
}
