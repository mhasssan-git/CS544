package cs544.bank.dao;

import cs544.bank.EntityManagerHelper;
import cs544.bank.domain.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;

public class JPAAccountDAO implements IAccountDAO {
    private static EntityManager em;

    @Override
    public void saveAccount(Account account) {
        em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    @Override
    public void updateAccount(Account account) {
        em.merge(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        return em.find(Account.class,accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        TypedQuery<Account> query= em.createQuery("from Account a order by a.customer.name desc", Account.class);
        Collection<Account> accounts=query.getResultList();
        return accounts;
    }
}
