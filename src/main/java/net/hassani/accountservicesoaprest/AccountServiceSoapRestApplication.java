package net.hassani.accountservicesoaprest;

import net.hassani.accountservicesoaprest.entities.Account;
import net.hassani.accountservicesoaprest.enums.AccountStatus;
import net.hassani.accountservicesoaprest.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AccountServiceSoapRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceSoapRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
            accountRepository.save(new Account(null, new Date(), 9000, AccountStatus.ACTIVE));
            accountRepository.save(new Account(null, new Date(), 8044, AccountStatus.SUSPENDED));
            accountRepository.save(new Account(null, new Date(), 200, AccountStatus.ACTIVE));
            accountRepository.save(new Account(null, new Date(), 35698, AccountStatus.BLOCKED));
            accountRepository.findAll().forEach(System.out::println);
        };
    }
}
