package example.pdf;

import org.apache.pdfbox.pdmodel.font.PDFont;

public class Label {

	private String text;
	private PDFont font;
	
	public Label(String text, PDFont font) {
		this.setFont(font);
		this.setText(text);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public PDFont getFont() {
		return font;
	}
	public void setFont(PDFont font) {
		this.font = font;
	}
}
