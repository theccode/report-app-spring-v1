package com.reporter.reportapp.transaction;

import com.reporter.reportapp.account.Account;
import com.reporter.reportapp.helper.ExcelHelper;
import com.reporter.reportapp.response.ResponseMessage;
import com.reporter.reportapp.service.ExcelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/report")
@AllArgsConstructor
@CrossOrigin
public class TransactionController {
    private final TransactionService transactionService;
    private final ExcelService fileService;


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadTransaction(@RequestParam("file") MultipartFile file){
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)){
            try {
                fileService.save(file);
                message = "Upload the file successfully: " + file.getOriginalFilename();
                System.out.println(message);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e){
                message = "Could not upload the file: " + file.getOriginalFilename();
                System.out.println(message + " ERROR: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file";
        System.out.println(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long id){
        List<Transaction> transactions = transactionService.getTransactions(id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
