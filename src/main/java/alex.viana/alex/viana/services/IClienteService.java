package alex.viana.services;

import alex.viana.domain.Cliente;
import alex.viana.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {
    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    Cliente buscarPorCPF(Long cpf);
    void excluir(Long cpf);
    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}