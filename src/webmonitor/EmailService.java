package webmonitor;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

	public boolean email(String senderAddress, String senderDisplayAddress, String recipientEmail, String recipientName, String bccEmail, String bccName, String subject, String txtBody) {
		boolean success = false;
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName(Constant.monitorMailHost);
			email.setSmtpPort(Constant.monitorSmtpPort);
			email.setAuthentication(senderAddress, Constant.monitorMailAuthenticationPassword);
			email.setSSLOnConnect(true);
			email.setFrom(senderAddress, senderDisplayAddress);
			email.addTo(recipientEmail, recipientName);
			if (bccEmail != null && bccName != null) {
				email.addBcc(bccEmail, bccName);
			}
			email.setSubject(subject);
			email.setMsg(txtBody);
			email.send();
			success = true;
		} catch (EmailException ee) {
			ee.printStackTrace();
		}
		return success;
	}

}
