package com.misc.service;

import com.misc.entity.PurchaseEntity;
import com.misc.repo.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public void purchase() {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setPersonNationalCode("99990");
        purchaseEntity.setInsertDate(new Date());
        PurchaseEntity savedEntity = purchaseRepository.save(purchaseEntity);
        System.out.println(savedEntity);
    }
}
