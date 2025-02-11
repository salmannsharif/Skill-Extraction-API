package com.example.springaipoc;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTextExtractor {

    public static String extractTextFromFile(String filePath) throws IOException {
        if (filePath.endsWith(".pdf")) {
            return extractTextFromPdf(filePath);
        } else if (filePath.endsWith(".docx")) {
            return extractTextFromDocx(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file format. Only PDF and DOCX are supported.");
        }
    }

    private static String extractTextFromPdf(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    private static String extractTextFromDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            return extractor.getText();
        }
    }
}
