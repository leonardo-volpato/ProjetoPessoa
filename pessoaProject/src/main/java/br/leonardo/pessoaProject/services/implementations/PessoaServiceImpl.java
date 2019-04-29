package br.leonardo.pessoaProject.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.leonardo.pessoaProject.models.Pessoa;
import br.leonardo.pessoaProject.services.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
    
    // Contador responsável por gerar um código fake já que não estou acessando nenhum banco de dados
    private final AtomicLong counter = new AtomicLong();

    // Metodo responsável por criar uma nova pessoa. Se tivéssemos um banco de dados esse seria o
    // momento de persistir os dados
    @Override
    public Pessoa create(Pessoa pessoa) {
        pessoa.setCodigo(counter.longValue());
        return pessoa;
    }

    // Método responsável por retornar uma pessoa. Como não há nenhuma base de dados, retorna um mock
    @Override
    public Pessoa findByCodigo(String pessoaCodigo) {
        try {
            long codigo = Long.parseLong(pessoaCodigo);
            Pessoa pessoa = new Pessoa();
            pessoa.setCodigo(codigo);
            pessoa.setNome("Leandro");
            pessoa.setCpf("123456789");
            return pessoa;
        } catch (Exception e) {
            return null;
        }
    }

    // Método responsável por retornar todas as pessoas
    @Override
    public List<Pessoa> findAll() {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Pessoa pessoa = mockPessoa(i);
            listaPessoas.add(pessoa);
        }
        return listaPessoas;
    }

    private Pessoa mockPessoa(int i) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCodigo(counter.incrementAndGet());
        pessoa.setNome("Nome: " + (i + 1));
        pessoa.setCpf("CPF: " + (i + 1));
        return pessoa;
    }
    
    // Método responsável por atualizar uma pessoa. Por ser mock retorna a mesma informação passada
    @Override
    public Pessoa update(Pessoa pessoa) {
    	return pessoa;
    }

    // Método responsável por deletar uma pessoa a partir de um codigo
    @Override
    public void delete(String pessoaCodigo) {
        Pessoa pessoa = findByCodigo(pessoaCodigo);
        pessoa = null;
    }
}
