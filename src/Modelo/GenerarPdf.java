package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerarPdf {

    private TableModel content;
    private String nombre;
    private ArrayList<String> header;
    static private ArrayList<Float> colsWidth;

    public GenerarPdf(JTable tabla, ArrayList<String> header, String nombre) {

        this.content = (TableModel) tabla.getModel();

        this.nombre = nombre;
        this.header = header;
        this.colsWidth = new ArrayList<>();
        for (int i = 0; i < content.getColumnCount(); i++) {
            Float colwidth = (float) tabla.getColumnModel().getColumn(i).getWidth() / 1325 * 605;
            colsWidth.add(colwidth);
        }
        ejecutar();

    }

    public static void drawTable(PDPage page, PDPageContentStream contentStream,
            float y, float margin,
            TableModel content, Integer npage, ArrayList<String> header) throws IOException {
        int rows = content.getRowCount() - npage * 30 +1;
        if (rows > 30) {
            rows = 31;
        }
        final int cols = content.getColumnCount();
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * (rows);
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);

        //header
        try {

            for (String txt : header) {
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(10, y);
                contentStream.drawString(txt);
                contentStream.endText();
                y -= rowHeight;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i < cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colsWidth.get(i);
        }
        contentStream.drawLine(nextx, y, nextx, y - tableHeight);

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
            textx += colsWidth.get(h);
        }
        texty -= rowHeight;
        textx = margin + cellMargin;

        for (int i = npage * 30; i < 30 * npage + rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                String text = content.getValueAt(i, j).toString();
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colsWidth.get(j);
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
        texty = 10;
        textx=tableWidth/2;
        String text =String.valueOf(npage);
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();


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
        PDPageContentStream contentStream;
        try {
            double totalPages = Math.ceil((double) content.getRowCount() / 30);
            for (int i = 0; i < totalPages; i++) {
                PDPage page = new PDPage();
                doc.addPage(page);
                contentStream = new PDPageContentStream(doc, page);
                drawTable(page, contentStream, 750, 0, content, i, this.header);
                contentStream.close();
            }

            doc.save(getNombre());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de generacion de PDF");
        }

    }

}
