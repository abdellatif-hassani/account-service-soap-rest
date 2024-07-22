package net.hassani.accountservicesoaprest.service;

import jakarta.transaction.Transactional;
import net.hassani.accountservicesoaprest.entities.Account;
import net.hassani.accountservicesoaprest.repository.AccountRepository;
import net.hassani.accountservicesoaprest.utils.VermentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AccountService implements IAccountService{
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> accounts() {
        return accountRepository.findAll();
    }

    public List<Account> verment(VermentRequest vermentRequest) {
        Long idC1 = vermentRequest.getIdC1();
        Long idC2 = vermentRequest.getIdC2();
        double amount = vermentRequest.getAmount();
        Account c1 = accountRepository.findById(idC1).get();
        Account c2 = accountRepository.findById(idC2).get();
        retirer(idC1, amount);
        verser(idC2, amount);
        List<Account> accounts = new ArrayList<>();
        accounts.add(c1);
        accounts.add(c2);
        return accounts;
    }

    public Account verser(Long id,double amount) {
        Account c = accountRepository.findById(id).get();
        c.setBalance(c.getBalance() + amount);
        accountRepository.save(c);
        return c;
    }
    public Account retirer(Long id,double amount) {
        Account c = accountRepository.findById(id).get();
        if (c.getBalance() < amount) throw new RuntimeException("Solde insuffisant");
        else c.setBalance(c.getBalance() - amount);
        accountRepository.save(c);
        return c;
    }

}
