package logicalLayers;


import javax.mail.*;
import javax.mail.internet.*;


import java.util.*;

public class SendEmail {

   final String senderEmailID = "sosadoptionn@gmail.com";
final String senderPassword = "sos12345678";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";
String receiverEmailID = "tomerca94@gmail.com";
static String emailSubject = "Test Mail";
static String emailBody = ":)";
  public SendEmail(String receiverEmailID,String Subject,
  String Body){
   
  // Receiver Email Address
  this.receiverEmailID=receiverEmailID; 
  // Subject
  this.emailSubject=Subject;
  // Body
  this.emailBody=Body;
  Properties props = new Properties();
  props.put("mail.smtp.user",senderEmailID);
  props.put("mail.smtp.host", emailSMTPserver);
  props.put("mail.smtp.port", emailServerPort);
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.socketFactory.port", emailServerPort);
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");
  
 
  SecurityManager security = System.getSecurityManager();
  try{  
  Authenticator auth = new SMTPAuthenticator();
  Session session = Session.getInstance(props, auth);
  MimeMessage msg = new MimeMessage(session);
    msg.setText(emailBody);
  msg.setSubject(emailSubject);
  msg.setFrom(new InternetAddress(senderEmailID));
  msg.addRecipient(Message.RecipientType.TO,
  new InternetAddress(receiverEmailID));
  Transport.send(msg);
  System.out.println("Message send Successfully:)"); }
  
  catch (Exception mex){
  mex.printStackTrace();}
  
  
  }
  public class SMTPAuthenticator extends javax.mail.Authenticator
  {
  public PasswordAuthentication getPasswordAuthentication()
  {
  return new PasswordAuthentication(senderEmailID, senderPassword);
  }
  }
     }
