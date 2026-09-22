package com.datajpa.demo.jpa.mappings;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/useraccounts")
public class UserAccountController {


    private final UserAccountRepository userAccountRepository;
    private final AddressRepository addressRepository;
    private final PostRepository postRepository;
    @Autowired

    public UserAccountController(UserAccountRepository userAccountRepository, AddressRepository addressRepository, PostRepository postRepository) {
        this.userAccountRepository = userAccountRepository;
        this.addressRepository = addressRepository;
        this.postRepository = postRepository;
    }



    @PostMapping("/register")
    public UserAccount registerNewUserAccount(@RequestBody UserAccount newUserAccount)
    {
        return this.userAccountRepository.save(newUserAccount);
    }

    @PostMapping("/{id}/addaddress")
    @Transactional
    public UserAccount registernewAddress(@PathVariable Integer id, @RequestBody Address newAddress)
    {
        UserAccount userAccount = this.userAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User id not available"));
        if(userAccount != null) {
            Address address = this.addressRepository.save(newAddress);
            userAccount.setAddress(address);
            return this.userAccountRepository.save(userAccount);

        }
        else {
            throw new RuntimeException("UserAccount not available");
    }

    }
    @PostMapping("{id}/posts")
    public  UserAccount addUserPost(@PathVariable Integer id, @RequestBody Post newPost)
    {
        UserAccount userAccount = this.userAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User id not available"));
        if(userAccount != null) {
            Post savedPost = this.postRepository.save(newPost);
            userAccount.getPosts().add(savedPost);
            return this.userAccountRepository.save(userAccount);
        }
        else {
            throw new RuntimeException("UserAccount not available");
        }

    }
    @GetMapping("/{id}")
    public UserAccount getUserAccountById(@PathVariable Integer id)
    {
        return this.userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User id not available"));
    }




}
