package alex.viana.services;

import alex.viana.dao.IProdutoDAO;
import alex.viana.domain.Produto;
import alex.viana.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}