package net.hassani.accountservicesoaprest.repository;

import net.hassani.accountservicesoaprest.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface AccountRepository extends JpaRepository<Account, Long>{

}
