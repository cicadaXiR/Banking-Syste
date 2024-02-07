package com.myproject.mybankingsystem.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfService {
	
	public byte[] generatePdf(String apidata) {
		try{
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			
			document.open();
			document.add(new Paragraph("data"));
			document.add(new Paragraph(apidata));
			return byteArrayOutputStream.toByteArray();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
