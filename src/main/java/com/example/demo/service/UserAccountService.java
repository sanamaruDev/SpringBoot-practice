package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;

@Service
@Transactional
public class UserAccountService {

		@Autowired
		UserAccountRepository userAccountRepository;
		
		public List<UserAccount> findAll() {
			return userAccountRepository.findAll();
		}
}
