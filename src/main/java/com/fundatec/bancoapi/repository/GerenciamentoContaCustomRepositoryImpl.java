package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.contas.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
@AllArgsConstructor
public class GerenciamentoContaCustomRepositoryImpl implements GerenciamentoContaCustomRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Conta findByCpfTitular(String cpfTitular) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery();
        Root<Conta> conta = cq.from(Conta.class);
        Predicate cpfPredicate = cb.equal(conta.get("cpfTitular"), cpfTitular);
        cq.where(cpfPredicate);
        TypedQuery<Conta> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }
}
