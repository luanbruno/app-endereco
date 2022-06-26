package br.edu.infnet.appendereco.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appendereco.model.domain.Estado;
import br.edu.infnet.appendereco.model.domain.Municipio;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibgeClient")
public interface IbgeClients {

	@GetMapping(value = "/estados")
	public List<Estado> obterEstados();

	@GetMapping(value = "/estados/{uf}/municipios")
	public List<Municipio> obterMunicipios(@PathVariable Integer uf);

}
