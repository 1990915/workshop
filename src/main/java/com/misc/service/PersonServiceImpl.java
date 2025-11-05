package com.misc.service;

import com.misc.entity.PersonEntity;
import com.misc.repo.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PurchaseService purchaseService;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void savePerson() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Hamed1");
        personEntity.setFamily("Dinari1");
        personEntity.setNationalCode("58955500011");
        personEntity.setAddress("Tehran-Iran1");
        personEntity.setInsertDate(new Date());
        PersonEntity savedEntity = personRepository.save(personEntity);
        System.out.println(savedEntity);
        purchaseService.purchase();
        throw new RuntimeException();
    }
}
