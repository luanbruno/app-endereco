package br.edu.infnet.appendereco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appendereco.clients.IbgeClients;
import br.edu.infnet.appendereco.model.domain.Estado;
import br.edu.infnet.appendereco.model.domain.Municipio;

@Service
public class IbgeService {

	@Autowired
	public IbgeClients ibgeClients;

	public List<Estado> obterLista() {
		return ibgeClients.obterEstados();
	}

	public List<Municipio> obterLista(Integer uf) {
		return ibgeClients.obterMunicipios(uf);
	}

}
