package example.pdf;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;

public class LabelWriter {

	public void writeLabelToAllPages(PDDocument doc, Label label) throws IOException {
		int pageCount = doc.getNumberOfPages();
		@SuppressWarnings("unchecked")
		List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
		for (int i = 0; i < pageCount; ++i) {
			PDPage page = pages.get(i);
			this.writeLabelToPage(doc, page, label);
		}
	}
	
	public void writeLabelToPage(PDDocument doc, PDPage page, Label label) throws IOException {
		PDRectangle mediaBox = page.getMediaBox();
		PDPageContentStream stream = new PDPageContentStream(doc, page, true, true);
		stream.beginText();
		stream.setFont(label.getFont(), 16);
		stream.moveTextPositionByAmount(mediaBox.getWidth()/2, mediaBox.getHeight()/2);
		stream.drawString(label.getText());
		stream.endText();
		stream.close();
	}
}
