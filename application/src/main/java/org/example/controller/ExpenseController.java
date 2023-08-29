package org.example.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.Expense;
import org.example.request.ExpenseRequest;
import org.example.request.ExpenseSearchRequest;
import org.example.service.ExpenseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    Response<Expense> insertExpense(@Valid @RequestBody ExpenseRequest request) {
        return expenseService.insertExpense(request);
    }

    @PutMapping("/update")
    Response<Expense> updateExpense(@Valid @RequestBody ExpenseRequest request) {
        return expenseService.updateExpense(request);
    }

    @PutMapping("/delete")
    Response<Expense> deleteExpense(@RequestBody ExpenseRequest request) {
        return expenseService.deleteExpense(request);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        byte[] fileContent = expenseService.export();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ExpenseList.xlsx");
        headers.add(HttpHeaders.CONTENT_TYPE,
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }
}
