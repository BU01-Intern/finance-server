package org.example.service;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.Expense;
import org.example.request.ExpenseRequest;
import org.example.request.ExpenseSearchRequest;

public interface ExpenseService {

    PageResponse<Expense> searchExpense(ExpenseSearchRequest request);

    Response<Expense> insertExpense(ExpenseRequest request);

    Response<Expense> updateExpense(ExpenseRequest request);

    Response<Expense> deleteExpense(ExpenseRequest request);
}
