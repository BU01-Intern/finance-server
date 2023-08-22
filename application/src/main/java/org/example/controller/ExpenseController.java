package org.example.controller;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.Expense;
import org.example.request.ExpenseRequest;
import org.example.request.ExpenseSearchRequest;
import org.example.service.ExpenseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/search")
    PageResponse<Expense> searchExpense(@RequestBody ExpenseSearchRequest request) {
        return expenseService.searchExpense(request);
    }

    @PostMapping("/insert")
    Response<Expense> insertExpense(@RequestBody ExpenseRequest request) {
        return expenseService.insertExpense(request);
    }

    @PutMapping("/update")
    Response<Expense> updateExpense(@RequestBody ExpenseRequest request) {
        return expenseService.updateExpense(request);
    }
}
