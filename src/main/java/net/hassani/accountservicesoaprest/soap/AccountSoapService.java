package net.hassani.accountservicesoaprest.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import net.hassani.accountservicesoaprest.entities.Account;
import net.hassani.accountservicesoaprest.service.AccountService;
import net.hassani.accountservicesoaprest.utils.VermentRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "AccountService")
public class AccountSoapService {
    private final AccountService accountService;

    public AccountSoapService(AccountService accountService) {
        this.accountService = accountService;
    }

    @WebMethod
    public List<Account> accounts() {
        return accountService.accounts();
    }

    @WebMethod
    public List<Account> verment(@WebParam(name = "vermentRequest") VermentRequest vermentRequest) {
        return accountService.verment(vermentRequest);
    }
}
