package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import alex.viana.dao.ClienteDAO;
import alex.viana.dao.IClienteDAO;
import alex.viana.dao.IProdutoDAO;
import alex.viana.dao.IVendaDAO;
import alex.viana.dao.ProdutoDAO;
import alex.viana.dao.VendaDAO;
import alex.viana.domain.Cliente;
import alex.viana.domain.Produto;
import alex.viana.domain.Venda;
import alex.viana.domain.Venda.Status;
import alex.viana.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAOTest {
    
    private IVendaDAO vendaDao;
    private IClienteDAO clienteDao;
    private IProdutoDAO produtoDao;
    private Cliente cliente;
    private Produto produto;
    
    public VendaDAOTest() {
        vendaDao = new VendaDAO();
        clienteDao = new ClienteDAO();
        produtoDao = new ProdutoDAO();
    }
    
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("A1", BigDecimal.TEN);
    }

    
    @Test
    public void pesquisar() throws TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A1");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }
    
    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A2");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertTrue
