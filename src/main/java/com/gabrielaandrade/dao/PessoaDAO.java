package com.gabrielaandrade.dao;

import com.gabrielaandrade.model.Pessoa;
import com.gabrielaandrade.model.PessoaForm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

@Repository
public class PessoaDAO {
    public static final Map<Long, Pessoa> pessoaMap = new HashMap<Long, Pessoa>();

    static {
        initPessoas();
    }

    private static void initPessoas() {
        Pessoa pessoa1 = new Pessoa(1L,"81500129","Gabriela","6");
        Pessoa pessoa2 = new Pessoa(2L,"81500129","Gabriela","6");
        Pessoa pessoa3 = new Pessoa(3L,"81500129","Gabriela","6");

        pessoaMap.put(pessoa1.getId(), pessoa1);
        pessoaMap.put(pessoa2.getId(), pessoa2);
        pessoaMap.put(pessoa3.getId(), pessoa3);

    }

    public Long getMaxId(){
        Set<Long> keys = pessoaMap.keySet();
        Long max = 0L;
        for(Long key: keys){
            if(key > max){
                max = key;
            }
        }
        return max;
    }
    public Pessoa getPessoa(Long id){
        return pessoaMap.get(id);
    }
    public Pessoa addPessoa(PessoaForm pessoaForm){
        Long id = this.getMaxId()+1;
        pessoaForm.setId(id);
        Pessoa newPessoa = new Pessoa(pessoaForm);

        pessoaMap.put(newPessoa.getId(), newPessoa);
        return newPessoa;
    }

    public Pessoa updatePessoa(PessoaForm pessoaForm){
        Pessoa pessoa = this.getPessoa(pessoaForm.getId());
        if(pessoa!= null)  {
            pessoa.setMatricula(pessoaForm.getMatricula());
            pessoa.setNome(pessoaForm.getNome());
            pessoa.setPeriodo(pessoaForm.getPeriodo());
        }
        return pessoa;
    }

    public void deleteEmployee(Long empId) {
        pessoaMap.remove(empId);
    }

    public List<Pessoa> getAllPessoas() {
        Collection<Pessoa> c = pessoaMap.values();
        List<Pessoa> list = new ArrayList<Pessoa>();
        list.addAll(c);
        return list;
    }

}
