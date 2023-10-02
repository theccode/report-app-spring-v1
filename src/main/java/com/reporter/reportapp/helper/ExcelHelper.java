package com.reporter.reportapp.helper;

import com.reporter.reportapp.Type.TransactionType;
import com.reporter.reportapp.Type.TransactionTypeAccount;
import com.reporter.reportapp.Type.TransactionTypeCustomFieldId;
import com.reporter.reportapp.account.financial.FinancialAccount;
import com.reporter.reportapp.transaction.Transaction;
import com.reporter.reportapp.transaction.details.TransactionDetails;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {
            "id",
            "type",
            "date",
            "value date",
            "description",
            "project",
            "currency",
            "account",
            "credit",
            "amount",
            "detail description",
            "employee"
    };
    static String SHEET = "Transactions";

    public static boolean hasExcelFormat(MultipartFile file){
        return TYPE.equals(file.getContentType());
    }

    public static List<Transaction> excelTransaction(InputStream is)  {
        try {
//            Workbook workbook = new XSSFWorkbook(is);
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<Transaction> transactions = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                Transaction transaction = new Transaction();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();                            System.out.println(new Date(currentCell.getStringCellValue()));
                    System.out.println("DATE: " +new Date(currentCell.getStringCellValue()));

                    switch (cellIdx) {
                        case 2 -> transaction.setDate(new Date(currentCell.getStringCellValue()));
                        case 4-> transaction.setDescription(currentCell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIdx++;
                }
                transactions.add(transaction);
            }
            workbook.close();
            return transactions;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }

    public static List<FinancialAccount> excelFinancialAccount(InputStream is){
        try {
//            Workbook workbook = new XSSFWorkbook(is);
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<FinancialAccount> financialAccounts = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                FinancialAccount financialAccount = new FinancialAccount();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 5 -> financialAccount.setName(currentCell.getStringCellValue());
                        case 7 -> financialAccount.setCode(currentCell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIdx++;
                }
                financialAccounts.add(financialAccount);
            }
            workbook.close();
            return financialAccounts;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }
    public static List<TransactionTypeCustomFieldId> excelTransactionTypeCustomField(InputStream is){
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<TransactionTypeCustomFieldId> transactionTypeCustomFieldIds = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                TransactionTypeCustomFieldId transactionTypeCustomFieldId = new TransactionTypeCustomFieldId();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    if (cellIdx == 0) {
                        transactionTypeCustomFieldId.setValue(currentCell.getStringCellValue());
                    }
                    cellIdx++;
                }
                transactionTypeCustomFieldIds.add(transactionTypeCustomFieldId);
            }
            workbook.close();
            return transactionTypeCustomFieldIds;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }
    public static List<TransactionType> excelTransactionType(InputStream is){
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<TransactionType> transactionTypes = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                TransactionType transactionType = new TransactionType();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0 -> transactionType.setPrefix(currentCell.getStringCellValue());
                        case 4 -> transactionType.setName(currentCell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIdx++;
                }
                transactionTypes.add(transactionType);
            }
            workbook.close();
            return transactionTypes;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }
    public static List<TransactionTypeAccount> excelTransactionTypeAccount(InputStream is){
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<TransactionTypeAccount> transactionTypeAccounts = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                TransactionTypeAccount transactionTypeAccount = new TransactionTypeAccount();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    if (cellIdx == 8) {
                        transactionTypeAccount.setCredit(currentCell.getBooleanCellValue());
                    }
                    cellIdx++;
                }
                transactionTypeAccounts.add(transactionTypeAccount);
            }
            workbook.close();
            return transactionTypeAccounts;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }
    public static List<TransactionDetails> excelTransactionDetails(InputStream is){
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("SHEET: " + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<TransactionDetails> transactionDetails = new ArrayList<>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow = rows.next();
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                TransactionDetails transactionDetail = new TransactionDetails();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 8 -> transactionDetail.setCredit(currentCell.getBooleanCellValue());
                        case 9 -> transactionDetail.setAmount(currentCell.getNumericCellValue());
                        default -> {
                        }
                    }
                    cellIdx++;
                }
                transactionDetails.add(transactionDetail);
            }
            workbook.close();
            return transactionDetails;
        } catch (IOException e){
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }
    private static Iterator<Cell> iterate(){

        return null;
    }
}
