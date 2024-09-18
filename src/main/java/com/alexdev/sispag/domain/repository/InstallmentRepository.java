package com.alexdev.sispag.domain.repository;

import com.alexdev.sispag.domain.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends JpaRepository <Installment, Long> {
}
