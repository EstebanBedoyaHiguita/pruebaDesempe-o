package com.Prueba.prueba.infrastructure.helpers;



import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.criteria.CollectionJoin;
import lombok.AllArgsConstructor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.http.MediaType;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;

@Component
@AllArgsConstructor
public class EmailHelper  {

    //  private final JavaMailSender mailSender;


    //  public void sendMail(String destinity, String nameClient, String nameEmployee, LocalDateConverter date){
    //      MimeMessage message = mailSender.createMimeMessage();

    //      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //      String dateAppointment = date.format(formatter);
    //      String htmlContent = this.readHTMLTemplate(nameClient, nameEmployee, dateAppointment);

    //      try {
    //          message.setFrom(new InternetAddress("Estebanbedoyahiguita@gmail.com"));
    //          message.setSubject("Confirmación de cita en Beauty Salon");

    //          message.setRecipients(MimeMessage.RecipientType.TO,destinity);
    //          message.setContent(htmlContent,MediaType.TEXT_HTML_VALUE);

    //          mailSender.send(message);
    //          System.out.println("Email enviado");

    //      } catch (Exception e) {
    //          System.out.println("ERROR no se pudo enviar el email " + e.getMessage());

    //      }
    //  }


    //  private String readHTMLTemplate(String nameClient, String nameEmployee, String date){
    //      //Indicar en donde se encuentra el template
    //      final Path path = Paths.get("src/main/resources/emails/email_template.html");

    //      try (var lines = Files.lines(path)){
    //          var html = lines.collect(CollectionJoin.joining());

    //          return html.replace("{name}", nameClient).replace("{employee}", nameEmployee).replace("{date}", date);
    //      } catch (IOException e) {
    //          System.out.println("No se pudo leer el html");
    //          throw new RuntimeException();
    //      }
    //  }

    //  private final EmailHelper emailHelper;

    //  if(Objects.notNull(user.getEmail()))
    //     emailHelper.sendMail(user.getEmail,"asignado a un proyect:" + project.getName,
    //      "utd ha sido asignado a un pro", LocalDateTime.now())
}
