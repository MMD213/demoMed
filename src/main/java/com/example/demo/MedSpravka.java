package com.example.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedSpravka {

    public static void med(String patientName, String doctorName, String complaints, String diagnosis, String recommendations) {
        // Замените эти значения соответствующими данными
        String organizationName = "Медицинская клиника";
        String clinicAddress = "Улица Клиническая, 123";
        String clinicPhone = "+7 (123) 456-7890";
        String clinicEmail = "info@clinic.com";

        Date currentDate = new Date(); // Текущая дата

        String fileName = "MedicalDocument.pdf";

        try {
            generateMedicalDocument(organizationName, clinicAddress, clinicPhone, clinicEmail,
                    patientName, doctorName, complaints, diagnosis, recommendations, currentDate, fileName);
            System.out.println("Медицинский документ успешно создан в файле: " + fileName);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void generateMedicalDocument(String organizationName, String clinicAddress, String clinicPhone, String clinicEmail,
                                                String patientName, String doctorName, String complaints,
                                                String diagnosis, String recommendations, Date currentDate, String fileName)
            throws IOException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(fileName));

        document.open();

        // Используем шрифт Times New Roman
        BaseFont baseFont = BaseFont.createFont("TimesNewRomanRegular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 12, Font.NORMAL);

        // Добавляем информацию о клинике
        addTextToDocument(document, organizationName, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Font.BOLD));
        addTextToDocument(document, "Адрес: " + clinicAddress, font);
        addTextToDocument(document, "Телефон: " + clinicPhone, font);
        addTextToDocument(document, "Email: " + clinicEmail, font);
        addTextToDocument(document, "\n", font);  // Пустая строка перед заголовком

        // Добавляем заголовок
        addTextToDocument(document, "Заключение и Рекомендации", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Font.BOLD));
        addTextToDocument(document, "\n", font);  // Пустая строка перед информацией о пациенте

        // Добавляем информацию о пациенте
        addTextToDocument(document, "Пациент: " + patientName, font);
        addTextToDocument(document, "Врач: " + doctorName + ", ", font);
        addTextToDocument(document, "Жалобы пациента: " + complaints, font);
        addTextToDocument(document, "Диагноз: " + diagnosis, font);
        addTextToDocument(document, "Рекомендации: " + recommendations, font);

        // Форматируем дату
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateStr = dateFormat.format(currentDate);

        addTextToDocument(document, "Дата: " + currentDateStr, font);
        addTextToDocument(document, "\n\n\n\n\n\n", font); // Пустые строки для подписи и печати

        addTextToDocument(document, "___________________________", font); // Линия подписи
        addTextToDocument(document, "Подпись врача", font);

        document.close();
    }

    public static void openPdf(String fileName) {
        try {

            if ((new File("MedicalDocument.pdf")).exists()) {

                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler MedicalDocument.pdf");
                p.waitFor();

            } else {

                System.out.println("File is not exists");

            }

            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void addTextToDocument(Document document, String text, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, font);
        document.add(paragraph);
        document.add(new Paragraph("\n"));  // Добавляем пустую строку после каждого параграфа
    }
}
