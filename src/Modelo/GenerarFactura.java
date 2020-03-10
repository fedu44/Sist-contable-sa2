package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerarFactura {

    private TableModel content;
    private String nombre;
    private ArrayList<String> header;
    static private ArrayList<Float> colsWidth;
    private ArrayList<String> rightHeader;
    private double total;

    public GenerarFactura(JTable tabla, ArrayList<String> header, ArrayList<String> rightHeader, String nombre, double total) {

        this.content = (TableModel) tabla.getModel();
        this.total = total;
        this.nombre = nombre;
        this.header = header;
        this.rightHeader = rightHeader;
        this.colsWidth = new ArrayList<>(Arrays.asList(100f, 310f, 100f, 100f));

        ejecutar();

    }

    public static void drawTable(PDPage page, PDPageContentStream contentStream,
            float y, float margin,
            TableModel content, Integer npage, ArrayList<String> header, ArrayList<String> rightHeader, double total, boolean end) throws IOException {
        int rows = content.getRowCount() - npage * 30 + 1;
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
            float yaux = y;
            for (String txt : header) {
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(10, yaux);
                contentStream.drawString(txt);
                contentStream.endText();
                yaux -= rowHeight;
            }
            contentStream.drawLine(tableWidth / 2 - 20, y, tableWidth / 2 + 20, y);
            contentStream.drawLine(tableWidth / 2 - 20, y, tableWidth / 2 - 20, y - 40);
            contentStream.drawLine(tableWidth / 2 - 20, y - 40, tableWidth / 2 + 20, y - 40);
            contentStream.drawLine(tableWidth / 2 + 20, y, tableWidth / 2 + 20, y - 40);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(tableWidth / 2 -5, y - 24);
            contentStream.drawString("B");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            for (String txt : rightHeader) {
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(400, y);
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
        textx = tableWidth / 2;
        String text = String.valueOf(npage);
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();

        if (end) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            texty = 50;
            textx = tableWidth - 200;
            text = "Importe total: " + String.valueOf(total);
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx, texty);
            contentStream.drawString(text);
            contentStream.endText();
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
        PDPageContentStream contentStream;
        try {
            double totalPages = Math.ceil((double) content.getRowCount() / 30);
            boolean end = false;
            for (int i = 0; i < totalPages; i++) {
                PDPage page = new PDPage();
                doc.addPage(page);
                contentStream = new PDPageContentStream(doc, page);
                if (i == totalPages - 1) {
                    end = true;
                }
                drawTable(page, contentStream, 750, 0, content, i, this.header, this.rightHeader, this.total, end);
                contentStream.close();
            }

            doc.save(getNombre());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de generacion de PDF");
        }

    }

}
