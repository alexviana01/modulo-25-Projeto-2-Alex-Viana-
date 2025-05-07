package test;




import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import alex.viana.dao.IProdutoDAO;
import alex.viana.dao.ProdutoDaoMock;
import alex.viana.domain.Produto;
import alex.viana.exceptions.TipoChaveNaoEncontradaException;
import alex.viana.services.IProdutoService;
import alex.viana.services.ProdutoService;

public class ProdutoServiceTest {

    private IProdutoService produtoService;
    private Produto produto;
    
    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }
    
    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }
    
    @Test
    public void pesquisar() {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }
    
    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }
    
    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }
    
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Rodrigo Pires");
        produtoService.alterar(produto);
        
        Assert.assertEquals("Rodrigo Pires", produto.getNome());
    }
}
