package com.softdight.instantorder.backend.helper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.softdight.instantorder.backend.model.Menu;
import com.softdight.instantorder.backend.model.MenuSubMenu;
import com.softdight.instantorder.backend.model.SubCategory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class MenuTemplates {

    public static String buildTemplateOne(Menu menu){

        String head = "<html>\n" +
                "<head>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"text-align: center;\">\n" +
                "    <h1>{Menu_title}</h1>\n".replace("{Menu_title}",menu.getName());

        String body = "<table style=\"width:100%; text-align: center;\">\n";

        // TODO add category later
//        Set<SubCategory> subCategories = menu.getSubCategories();
//        for (SubCategory subCategory:
//             subCategories) {
//            body += "    <tr>\n" +
//                    "        <th>{Category1}</th>\n" +
//                    "    </tr>\n" +
//                    "    <tr>\n" +
//                    "        <th></th>\n" +
//                    "    </tr>";
            int MAX_LENGTH = 80;
            for(MenuSubMenu menuSubMenu : menu.getSubMenus()){
                String line = "{Sub_menu_name}...........................{price}".replace("{Sub_menu_name}",menuSubMenu.getSubmenu().getName())
                        .replace("{price}",menuSubMenu.getPrice().toString());
                StringBuffer newLine = new StringBuffer(line);
                if (line.length() < MAX_LENGTH) {
                    for(int i =line.length(); i < MAX_LENGTH; i++) {
                        newLine.insert(line.length()-8, '.');
                    }
                }
                body += ("<tr>\n" +
                        "        <td><p>"+newLine+"</p></td>\n" +
                        "    </tr>");
            }

//        }


        return head + body + "    </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }

    public static void generatePDFFromHTML(String filename) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(filename + ".pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(filename));
        document.close();
    }
}
