/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import tn.esprit.entities.Job;
import tn.esprit.entities.Reclamation;

/**
 *
 * @author mghozzi
 */
public class ServicePdfGenerator {

    public static void createAndSendRepport(List<Reclamation> reclamations, Job job) throws Exception {

        Font greenFonts = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 12, BaseColor.CYAN) ;
        Font greenFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12 , BaseColor.MAGENTA) ;
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Font redFont = FontFactory.getFont(FontFactory.COURIER, 8, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
        Font whFont = FontFactory.getFont(FontFactory.defaultEncoding, 10, BaseColor.WHITE) ;
  
Font Style2 =  FontFactory.getFont(FontFactory.COURIER, Font.DEFAULTSIZE, Font.BOLD | Font.ITALIC);
        try {
  Rectangle pageSize = new Rectangle(350, 720);
    pageSize.setBackgroundColor(BaseColor.DARK_GRAY);
    Document document = new Document(pageSize);
          //  Document document = new Document();
            PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home") + "/Desktop/REPORT_NUM_" + job.getId() + ".pdf"));

            document.open();
            Image image1 = Image.getInstance("src/resources/images/azer.png");
            double percent = 0.5;
            image1.scaleAbsolute(150, 130);
 
            Paragraph chapterTitle = new Paragraph("Horde Social Pro ADMINISTRATION ",  greenFont);
            chapterTitle.setFont(blueFont);
            Paragraph paragraphOne = new Paragraph("Objet : Reclamation a propos de votre publication " ,greenFonts );
            paragraphOne.setFont(redFont);
            Paragraph paragraphtwo = new Paragraph("Madame / Monsieur,\n"
                    + "Suite au taux de reclmation depassé , Nous sommes désolé de vous annocer que votre publication "
                    + "a éte désactiver par notre Equipe Support HordeTeamSocialPro .  \n"
                    + "On vous annonce aussi que la PROCHAINE fois si on recoit un taux de reclamation qui dépasse   \n"
                    + "le maximuim des reclamation , votre compte sera DESACTIVE d'une facon DEFINITIVE \n"
                    + "On vous rappel de nos regle de réglement d'utilisation de nos Application (HORDE )\n"
                    + "1/ PAS de RASICM , HARCELEMENT ou n'importe quelle type de violance              \n "
                    + "2/ PAS de FAKE publication                                                        \n"
                    + "3/ PAS de FAKE user                                                                \n"
                    + "4/Considérez votre enivronnement avec respect                                      \n"
                    + "5/ PAS de photo de profil indésirable                                               \n"
                    + " ****AU dessous vous trouvez les reclamation récu de votre publication indésirable ! *** \n" , whFont );
            Paragraph paragraphsignature = new Paragraph("ADMINISTRATION", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            document.add(chapter1);
            document.add(paragraphOne);
            document.add(paragraphtwo);

            for (Reclamation reclamation : reclamations) {
                document.add(new Paragraph("Reclamation identifier: " + reclamation.getId() + " , Type de reclamation =  " + reclamation.getType() + " , details = " + reclamation.getDetails() + " , Status de reclmation = " + reclamation.getStatus(), redFont));

            }
            document.add(image1);
            document.add(paragraphsignature);
            
            document.close();
            System.out.println(job.getCompany().getRecruiter().getEmail());
            System.out.println(System.getProperty("user.home") + "/Desktop/" + job.getId() + ".pdf");
            ServiceMail.sendMailWithFile(job.getCompany().getRecruiter().getEmail(), "SocialPro support Team", new File(System.getProperty("user.home") + "/Desktop/REPORT_NUM_" + job.getId() + ".pdf"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        System.out.println("generated success");

    }

}
