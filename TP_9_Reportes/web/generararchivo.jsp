<%-- 
    Document   : generararchivo
    Created on : 15 nov. 2021, 23:55:28
    Author     : pablo
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFCell"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFRow"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFSheet"%>
<%@page import="org.apache.poi.ss.usermodel.FillPatternType"%>
<%@page import="org.apache.poi.ss.usermodel.IndexedColors"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFCellStyle"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFFont"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFWorkbook"%>
<%@page import="com.lowagie.text.pdf.PdfPCell"%>
<%@page import="com.lowagie.text.Rectangle"%>
<%@page import="com.lowagie.text.Phrase"%>
<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="com.lowagie.text.PageSize"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="com.lowagie.text.Font"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="modelo.Reporte"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.ControladorReportes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
String pais = request.getParameter("pais");
String region = request.getParameter("region");
String tipoArchivo = "";

if (request.getParameter("pdf") != null) {
    tipoArchivo = "pdf";
} else if (request.getParameter("excel") != null) {
    tipoArchivo = "excel";
} 


ControladorReportes contr = new ControladorReportes();
List<Reporte> reportes = new ArrayList();
reportes = contr.getReporte(region, pais);


if(tipoArchivo=="pdf"){
    
    response.setContentType("application/pdf");
    
    Font titulo = new Font(Font.COURIER, 14, Font.BOLD);
    Font textoBold = new Font(Font.COURIER, 11, Font.BOLD);
    Font texto = new Font(Font.COURIER, 11, Font.NORMAL);
    

    Document document = new Document(PageSize.A4, 30, 30, 50, 30);
    

    document.addTitle("PROG 3");
    document.addSubject("UTN");
    document.addKeywords("PracticoReportesValentini");
    document.addAuthor("Valentini");
    document.addCreator("Valentini");

    PdfWriter.getInstance(document, response.getOutputStream());
    
 
    document.open();
    
   
    Paragraph paragraph = new Paragraph("Reporte", titulo);
    Paragraph paragraph2 = new Paragraph(" ", titulo);
  
    document.add(paragraph);
    document.add(paragraph2);


    PdfPTable table = new PdfPTable(4);

    table.setWidthPercentage(100);

    PdfPCell celda1 = new PdfPCell(new Phrase("Ciudad", textoBold));


    PdfPCell celda2 = new PdfPCell(new Phrase("Poblacion", textoBold));

    PdfPCell celda3 = new PdfPCell(new Phrase("Pais", textoBold));

    PdfPCell celda4 = new PdfPCell(new Phrase("Region", textoBold));

    table.addCell(celda1);
    table.addCell(celda2);
    table.addCell(celda3);
    table.addCell(celda4);

    
    for (Reporte reporte : reportes) {
            celda1 = new PdfPCell(new Phrase(reporte.getCiudad(), texto));
            celda1.setBorder(Rectangle.RECTANGLE);
            celda2 = new PdfPCell(new Phrase(reporte.getPoblacion(), texto));
            celda2.setBorder(Rectangle.RECTANGLE);
            celda3 = new PdfPCell(new Phrase(reporte.getPais(), texto));
            celda3.setBorder(Rectangle.RECTANGLE);
            celda4 = new PdfPCell(new Phrase(reporte.getRegion(), texto));
            celda4.setBorder(Rectangle.RECTANGLE);
            table.addCell(celda1);
            table.addCell(celda2);
            table.addCell(celda3);
            table.addCell(celda4);
        }
    

    document.add(table);

    document.close();
}

if(tipoArchivo=="excel"){

    SXSSFWorkbook libro = new SXSSFWorkbook(50);

    XSSFFont font = (XSSFFont) libro.createFont();

    
    XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
    style.setFont(font);
    
    XSSFFont font2 = (XSSFFont) libro.createFont();
    font2.setBold(true);
    XSSFCellStyle styleBold = (XSSFCellStyle) libro.createCellStyle();
    styleBold.setFont(font2);
    
    
    
    XSSFCellStyle styleGris = (XSSFCellStyle) libro.createCellStyle();
    styleGris.setFont(font);
    styleGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
    styleGris.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleGreen = (XSSFCellStyle) libro.createCellStyle();
    styleGreen.setFont(font);
    styleGreen.setFillForegroundColor(IndexedColors.SEA_GREEN.index);
    styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleRed = (XSSFCellStyle) libro.createCellStyle();
    styleRed.setFont(font);
    styleRed.setFillForegroundColor(IndexedColors.RED.index);
    styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleNaranja = (XSSFCellStyle) libro.createCellStyle();
    styleNaranja.setFont(font);
    styleNaranja.setFillForegroundColor(IndexedColors.TAN.index);
    styleNaranja.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleTurquesa = (XSSFCellStyle) libro.createCellStyle();
    styleTurquesa.setFont(font);
    styleTurquesa.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
    styleTurquesa.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleRosa = (XSSFCellStyle) libro.createCellStyle();
    styleRosa.setFont(font);
    styleRosa.setFillForegroundColor(IndexedColors.ROSE.index);
    styleRosa.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleAmarillo = (XSSFCellStyle) libro.createCellStyle();
    styleAmarillo.setFont(font);
    styleAmarillo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
    styleAmarillo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    XSSFCellStyle styleOro = (XSSFCellStyle) libro.createCellStyle();
    
    styleOro.setFont(font);
    styleOro.setFillForegroundColor(IndexedColors.GOLD.index);
    styleOro.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleOroObservado = (XSSFCellStyle) libro.createCellStyle();
    styleOroObservado.setFont(font);
    styleOroObservado.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    styleOroObservado.setBottomBorderColor(IndexedColors.RED.index);
    styleOroObservado.setFillForegroundColor(IndexedColors.YELLOW.index);
    
    XSSFCellStyle styleVerdeClaro = (XSSFCellStyle) libro.createCellStyle();
    styleVerdeClaro.setFont(font);
    styleVerdeClaro.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
    styleVerdeClaro.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    XSSFCellStyle styleVerdeObservacion = (XSSFCellStyle) libro.createCellStyle();
    styleVerdeObservacion.setFont(font);
    styleVerdeObservacion.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
    styleVerdeObservacion.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    styleVerdeObservacion.setBottomBorderColor(IndexedColors.RED.index);
    
    XSSFCellStyle styleAzul = (XSSFCellStyle) libro.createCellStyle();
    styleAzul.setFont(font);
    styleAzul.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
    styleAzul.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    

    SXSSFSheet hoja = libro.createSheet();
    
    int nroColumna = 0;

    SXSSFRow row = hoja.createRow(0);
    SXSSFCell cell = row.createCell(nroColumna);

    cell.setCellValue("Ciudad");

    cell.setCellStyle(sty    cell.setCellValue("Ciudad");

    cell = row.createCell(++nroColumna);
    cell.setCellValue("Poblacion");
    cell.setCellStyle(styleBold);
    cell = row.createCell(++nroColumna);
    cell.setCellValue("Pais");
    cell.setCellStyle(styleBold);
    cell = row.createCell(++nroColumna);
    cell.setCellValue("Region");
    cell.setCellStyle(styleBold);
    

    int nroFila = 1;

    nroColumna = 0;
    
    for (Reporte reporte : reportes) {
        nroColumna = 0;
        row = hoja.createRow(nroFila);
        ++nroFila;
        cell = row.createCell(nroColumna);
        cell.setCellValue(reporte.getCiudad());
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue(reporte.getPoblacion());
        if(Integer.parseInt(reporte.getPoblacion())>5000000) cell.setCellStyle(styleAmarillo);
        else if(Integer.parseInt(reporte.getPoblacion())<100000) cell.setCellStyle(styleVerdeClaro);
        else cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue(reporte.getPais());
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue(reporte.getRegion());
        cell.setCellStyle(style);
    }
    
    
    

    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    libro.write(outByteStream);
    byte [] outArray = outByteStream.toByteArray();
    

    response.setContentType("application/ms-excel");
    response.setContentLength(outArray.length);
    response.setHeader("Expires:", "0"); 

    response.setHeader("Content-Disposition", "attachment; filename=testxls.xls");
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    outStream.flush();
}


%>