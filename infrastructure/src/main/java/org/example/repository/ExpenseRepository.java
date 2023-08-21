package org.example.repository;

import org.example.entity.Expense;
import org.example.request.ExpenseSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query("SELECT expense FROM Expense expense WHERE expense.name LIKE %:#{#request.name}% AND expense.accountNumber LIKE %:#{#request.accountNumber}%")
    Page<Expense> searchExpense(@Param("request") ExpenseSearchRequest request, Pageable pageable);
}
