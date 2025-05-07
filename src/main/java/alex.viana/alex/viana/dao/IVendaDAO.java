package alex.viana.dao;

import alex.viana.dao.generic.IGenericDAO;
import alex.viana.domain.Venda;
import alex.viana.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}