package com.capgemini.MathematicalOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

//If you want to work with this program you should have your file in .txt placed in project folder
// and your file copied to pdf will apere in the same place.
public class CreatePDF {
	public static void create(String pdfName, String textName) throws FileNotFoundException, DocumentException {
		String toPdfText;

		try (BufferedReader file = new BufferedReader(new FileReader(textName + ".txt"))) {

			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(pdfName + ".pdf"));
			document.open();

			do {
				toPdfText = file.readLine();
				document.add(new Paragraph(toPdfText));
			} while (toPdfText != null);

			document.close();
		} catch (IOException exc) {
			System.out.println("File open Error!");
		}
	}

	public static void main(String args[]) {
		ConsolePDF.readConsole();
	}

}
