package Modelo;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerarPdf {
   
    private TableModel content;
    private String nombre;
      
    
    public GenerarPdf(TableModel content, String nombre) {
        
        this.content=content;
        this.nombre = nombre;
        ejecutar();
    }

    public static void drawTable(PDPage page, PDPageContentStream contentStream,
            float y, float margin,
            TableModel content) throws IOException {
        final int rows = content.getRowCount()+1;
        final int cols = content.getColumnCount();
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * (rows);
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 11);
        
        
        
        float textx = margin + cellMargin;
        float texty = y - 15;
        
        
        for (int h = 0; h < cols; h++) {
                String text = content.getColumnName(h);
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
        texty -= rowHeight;
        textx = margin + cellMargin;
            
        for (int i =0; i < rows-1; i++) {
            for (int j = 0; j < cols; j++) {
                String text = content.getValueAt(i, j).toString();
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }

    public void setContent(TableModel content) {
        this.content = content;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutar() {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream contentStream;
        try {
            contentStream = new PDPageContentStream(doc, page);
            drawTable(page, contentStream, 700, 0, content);
            contentStream.close();
            doc.save(getNombre());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de generacion de PDF");
        }

    }

}
