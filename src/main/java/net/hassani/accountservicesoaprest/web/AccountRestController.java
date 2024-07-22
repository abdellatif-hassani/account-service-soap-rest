package net.hassani.accountservicesoaprest.web;

import net.hassani.accountservicesoaprest.entities.Account;
import net.hassani.accountservicesoaprest.service.AccountService;
import net.hassani.accountservicesoaprest.utils.VermentRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping({"/", ""})
    public List<Account> accounts() {
        return accountService.accounts();
    }

    @PostMapping("/verment")
    public List<Account> verment(@RequestBody VermentRequest vermentRequest) {
        return accountService.verment(vermentRequest);
    }

}
