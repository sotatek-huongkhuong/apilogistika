package logistika.core;
import junit.framework.Assert;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.fogot_password.steps.ForgotPasswordSteps;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
public class Nosubject {

    public static void pause(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getConfirmCodeFromEmail() {
        ForgotPasswordSteps forgotPasswordSteps= new ForgotPasswordSteps();
        forgotPasswordSteps.whenForgotPassword(Account_Constans.USERNAME_LOGISTIKA);
        pause(10000);
        String email="huong.khuong@sotatek.com";
        String password="Huongkc1@";
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        BodyPart bp = null;
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com",email, password);
            Folder[] folderList = store.getFolder("[Gmail]").list();
            for (int i = 0; i < folderList.length; i++) {
            }
            Folder inbox = store.getFolder("[Gmail]/All Mail");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
//            for (Address address : in) {
//                System.out.println("FROM:" + address.toString());
//            }
            Multipart mp = (Multipart) msg.getContent();
            bp = mp.getBodyPart(0);
//            System.out.println("SENT DATE:" + msg.getSentDate());
//            System.out.println("SUBJECT:" + msg.getSubject());
            String code[]=shouldMatchRegex("confirmation_code=(\\d*)",bp.getContent().toString());
            System.out.print(code[1]);
            return code[1];
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return null;
    }
    private static String[] shouldMatchRegex(String pattern,String message) {
        String[] result = new String[10];
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(message);
        if (matcher.find()) {
            for(int i =0; i <matcher.groupCount()+1; i++ ){
                result[i] = matcher.group(i) ;
            }
        }else{
            Assert.fail("String, patten does not match");
        }
        return result;
    }
}