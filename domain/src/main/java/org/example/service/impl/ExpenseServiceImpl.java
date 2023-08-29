package org.example.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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
        Page<Expense> page = expenseRepository.searchExpense(request, request.getPageable());
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

    @Override
    public byte[] export() throws IOException {
        List<Expense> results = expenseRepository.findAll();

        try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            SXSSFSheet sheet = workbook.createSheet("ExpenseList");

            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("id");
            row.createCell(1).setCellValue("name");
            row.createCell(2).setCellValue("account_number");
            row.createCell(3).setCellValue("type");
            row.createCell(4).setCellValue("is_distributed");
            row.createCell(5).setCellValue("status");
            row.createCell(6).setCellValue("created_time");
            row.createCell(7).setCellValue("is_deleted");

            for (int i = 0; i < results.size(); i++) {
                row = sheet.createRow(i + 1);
                Expense expense = results.get(i);
                row.createCell(0).setCellValue(expense.getId());
                row.createCell(1).setCellValue(expense.getName());
                row.createCell(2).setCellValue(expense.getAccountNumber());
                row.createCell(3).setCellValue(expense.getType());
                row.createCell(4).setCellValue(expense.getIsDistributed());
                row.createCell(5).setCellValue(expense.getStatus());
                row.createCell(6).setCellValue(expense.getCreatedTime());
                row.createCell(7).setCellValue(expense.getIsDeleted());
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                workbook.write(bos);
            } finally {
                bos.close();
            }
            return bos.toByteArray();
        }
    }
}
