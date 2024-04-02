package com.LoveKholiya.Banking_Application.Controller;

import com.LoveKholiya.Banking_Application.Entity.Account;
import com.LoveKholiya.Banking_Application.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController{
    @Autowired
   private AccountService accountService;
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
    }
    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
        return accountService.deposit(id,amount);
    }
    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
        double amount=request.get("amount");
        return accountService.withdraw(id,amount);
    }
    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable Long id){
        return accountService.delete(id);
    }
}
