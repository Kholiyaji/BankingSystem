package com.LoveKholiya.Banking_Application.Repository;


import com.LoveKholiya.Banking_Application.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
