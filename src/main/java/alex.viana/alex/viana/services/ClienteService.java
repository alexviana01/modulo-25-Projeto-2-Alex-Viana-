package alex.viana.services;

import alex.viana.dao.IClienteDAO;
import alex.viana.domain.Cliente;
import alex.viana.exceptions.TipoChaveNaoEncontradaException;
import alex.viana.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
}