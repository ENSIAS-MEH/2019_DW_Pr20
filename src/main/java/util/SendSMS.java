package util;

import DAO.DAOFactory;
import DAO.Implementation.BanqueSangDaoImpl;
import DAO.Implementation.DonnateurDaoImpl;
import Model.Donnateur;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.util.List;

public class SendSMS implements Runnable {
    private List<Donnateur> donnateurList;
    private String message;

    /*public static  void main(String [] args){
        System.out.println("Helop");
        DonnateurDaoImpl dd =new DonnateurDaoImpl(DAOFactory.getInstance());
        List<Donnateur> donnateurs = dd.getAllDonnateurs();
        Thread sendSMS = new SendSMS(donnateurs,"Hello");

        sendSMS.start();
    }*/
    public SendSMS(List<Donnateur> donnateurList, String message) {
        this.donnateurList = donnateurList;
        this.message = message;
    }

    private void sendSMS() throws Exception {
        String API_KEY = "4373f51f";
        String API_SECRET = "OGZ2MA2VCb7TCPvY";

        NexmoClient client = new NexmoClient.Builder().apiKey(API_KEY).apiSecret(API_SECRET).build();

        for (Donnateur donnateur : donnateurList) {

            SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                    "DON DU SANG",
                    donnateur.getTeleD(),message));
            for (SmsSubmissionResponseMessage response : responses.getMessages()) {
                System.out.println(response);
            }
        }

    }

    @Override
    public void run() {
        try {
            sendSMS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}