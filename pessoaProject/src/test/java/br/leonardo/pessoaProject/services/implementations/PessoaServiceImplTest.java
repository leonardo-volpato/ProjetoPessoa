package br.leonardo.pessoaProject.services.implementations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.leonardo.pessoaProject.models.Pessoa;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.volpato
 */
public class PessoaServiceImplTest {
    
    ArrayList<Pessoa> todasPessoas = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    
    public PessoaServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
        Pessoa pessoaUm = new Pessoa();
        pessoaUm.setCodigo(counter.getAndIncrement());
        pessoaUm.setNome("Leandro");
        pessoaUm.setCpf("123456789");
        
        todasPessoas.add(pessoaUm);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PessoaServiceImpl.
     */
    /*
    @Test
    public void testCreate() {
        System.out.println("create");
        Pessoa pessoa = null;
        PessoaServiceImpl instance = new PessoaServiceImpl();
        Pessoa expResult = null;
        Pessoa result = instance.create(pessoa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of findByCodigo method, of class PessoaServiceImpl.
     */
    @Test
    public void testFindByCodigoQueEncontra() {
        System.out.println("findByCodigoQueEncontra");
        String pessoaCodigo = Long.toString(todasPessoas.get(0).getCodigo());
        
        PessoaServiceImpl instance = new PessoaServiceImpl();
        
        Pessoa expResult = todasPessoas.get(0);
        Pessoa result = instance.findByCodigo(pessoaCodigo);
        assertEquals(expResult.getCodigo(), result.getCodigo());
    }
    
    @Test
    public void testFindByCodigoQueNaoEncontra() {
        System.out.println("findByCodigoQueNaoEncontra");
        String pessoaCodigo = "abc";
        
        PessoaServiceImpl instance = new PessoaServiceImpl();
        
        Pessoa expResult = null;
        Pessoa result = instance.findByCodigo(pessoaCodigo);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class PessoaServiceImpl.
     */
    /*
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        PessoaServiceImpl instance = new PessoaServiceImpl();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    @Test
    public void testUpdate() {
        System.out.println("updateQueFunciona");
        
        Pessoa pessoaAtualizar = todasPessoas.get(0);
        pessoaAtualizar.setNome("Tiago");
        pessoaAtualizar.setCpf("123456780");
        
        Pessoa pessoaAtualizada = todasPessoas.get(0);
        assertNotNull(pessoaAtualizada);
    	assertEquals("Tiago", pessoaAtualizada.getNome());
    	assertEquals("123456780", pessoaAtualizada.getCpf());
    }

    @Test
    public void testDelete() {
        System.out.println("deleteQueFunciona");
           
        PessoaServiceImpl instance = new PessoaServiceImpl();
        
        String pessoaCodigo = "1";
        
        instance.delete(pessoaCodigo);
        assertNull(null);
    }
}
