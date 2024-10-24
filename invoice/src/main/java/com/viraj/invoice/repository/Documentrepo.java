package com.viraj.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viraj.invoice.model.SellerBuyer;

@Repository
public interface Documentrepo extends JpaRepository<SellerBuyer, Long> {

}
