package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceHeaderRepository extends JpaRepository <InvoiceHeader, Long> {
}
