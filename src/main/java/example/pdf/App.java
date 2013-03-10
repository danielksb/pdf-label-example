package example.pdf;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class App {

	
	public static void main(String[] args) throws IOException, COSVisitorException {
		Long start = System.currentTimeMillis();
		
		LabelWriter labelWriter = new LabelWriter();
		
		PDDocument doc = PDDocument.load("test.pdf");
		
		Label label = new Label("This is a test", PDType1Font.HELVETICA_BOLD);
		
		labelWriter.writeLabelToAllPages(doc, label);
		
		doc.save("labeled_test.pdf");
		doc.close();
		
		Long end = System.currentTimeMillis();
		System.out.println(end - start + " ms elapsed");
	}
}
