package net.hassani.accountservicesoaprest.service;

import net.hassani.accountservicesoaprest.entities.Account;
import net.hassani.accountservicesoaprest.utils.VermentRequest;

import java.util.List;

public interface IAccountService {
    List<Account> accounts();
    List<Account> verment(VermentRequest vermentRequest);
}
