package br.leonardo.pessoaProject.services;

import java.util.List;

import br.leonardo.pessoaProject.models.Pessoa;

public interface PessoaService {
    
    Pessoa create(final Pessoa pessoa);
    Pessoa findByCodigo(final String pessoaCodigo);
    List<Pessoa> findAll();
    Pessoa update(Pessoa pessoa);
    void delete(final String pessoaCodigo);

}
