package org.example.service.impl;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.Expense;
import org.example.exception.CommonException;
import org.example.repository.ExpenseRepository;
import org.example.request.ExpenseRequest;
import org.example.request.ExpenseSearchRequest;
import org.example.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public PageResponse<Expense> searchExpense(ExpenseSearchRequest request) {
        Page<Expense> page =
                expenseRepository.searchExpense(request, request.getPageable());
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public Response<Expense> insertExpense(ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setName(request.getName());
        expense.setAccountNumber(request.getAccountNumber());
        expense.setType(request.getType());
        expense.setIsDistributed(request.getIsDistributed());
        expense.setStatus(request.getStatus());

        Expense save = expenseRepository.save(expense);
        return new Response<>(save);
    }

    @Override
    public Response<Expense> updateExpense(ExpenseRequest request) {
        if (request.getId() == null) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Bắt buột nhập id");
        }

        Expense expense = expenseRepository.findById(request.getId())
                .orElseThrow(() -> new CommonException(HttpStatus.BAD_REQUEST, "Không tìm thấy"));

        expense.setName(request.getName());
        expense.setAccountNumber(request.getAccountNumber());
        expense.setType(request.getType());
        expense.setIsDistributed(request.getIsDistributed());
        expense.setStatus(request.getStatus());

        Expense save = expenseRepository.save(expense);
        return new Response<>(save);
    }

    @Override
    public Response<Expense> deleteExpense(ExpenseRequest request) {
        if (request.getId() == null) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Bắt buột nhập id");
        }

        Expense expense = expenseRepository.findById(request.getId())
                .orElseThrow(() -> new CommonException(HttpStatus.BAD_REQUEST, "Không tìm thấy"));

        expense.setIsDeleted(true);

        Expense save = expenseRepository.save(expense);
        return new Response<>(save);
    }
}
