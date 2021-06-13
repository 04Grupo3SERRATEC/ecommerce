package com.residencia.ecommerce.services;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.exceptions.EmailException;
import com.residencia.ecommerce.vo.PedidoVO;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.username}")
	private String emailServerUserName;
	
	@Value("${spring.mail.password}")
	private String emailServerPassword;
	
	@Value("${spring.mail.protocol}")
	private String emailServerProtocol;
	
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setUsername(emailServerUserName);
		mailSender.setPassword(emailServerPassword);
		mailSender.setProtocol("smtp");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", false);
		mailSender.setJavaMailProperties(prop);

		return mailSender;

	}
	
		public void emailPedidoFinalizado(PedidoVO emailVO) throws MessagingException, EmailException {

			this.emailSender = javaMailSender();

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			try {
				helper.setFrom(emailRemetente);
				helper.setTo("email@gmail.com");
				helper.setSubject("Pedido Nº " + emailVO.getPedidoId());

				SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat dfMoeda = new DecimalFormat("R$ ,##0.00");
				
				Calendar dataChegada =  emailVO.getDataPedido();
				dataChegada.add(Calendar.DAY_OF_YEAR, 5);
				
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("<html>\r\n");
				sBuilder.append("	<body>\r\n");
				sBuilder.append("		<div align=\"center\">\r\n");
				sBuilder.append("					PEDIDO\r\n");
				sBuilder.append("		</div>\r\n");
				sBuilder.append("		<br/>\r\n");
				sBuilder.append("		<center>\r\n");
				sBuilder.append("		<table border='1' cellpadding='5'  >\r\n");
				sBuilder.append("<tr><th>Nº Pedido</th><th>Data de Chegada</th><th>Total do pedido</th></tr>\r\n");

				sBuilder.append("		<tr>\r\n");
				sBuilder.append("			<td>\r\n");
				sBuilder.append(emailVO.getPedidoId());
				sBuilder.append("			</td>\r\n");
				sBuilder.append("			<td>\r\n");
				sBuilder.append(sdfData.format(dataChegada.getTime()));
				sBuilder.append("			</td>\r\n");
				sBuilder.append("			<td>\r\n");
				sBuilder.append(dfMoeda.format(emailVO.getValorTotalPedido()));
				sBuilder.append("			</td>\r\n");
				sBuilder.append("		</tr>\r\n");
				
				sBuilder.append("		</table>\r\n");
				sBuilder.append("		</center>\r\n");
				sBuilder.append("	</body>\r\n");
				sBuilder.append("</html>");
				
				ProdutoPedido pp = new ProdutoPedido();
				Produto p = new Produto();
				
				sBuilder.append("<html>\r\n");
				sBuilder.append("	<body>\r\n");
				sBuilder.append("		<div align=\"center\">\r\n");
				sBuilder.append("					LISTA DE PRODUT\r\n");
				
				sBuilder.append("		<table border='1' cellpadding='5'  >\r\n");
				sBuilder.append("<tr><th>produto</th><th>Quantidade</th></tr>\r\n");
				
				sBuilder.append("		<tr>\r\n");
				sBuilder.append("			<td>\r\n");
				sBuilder.append(p.getNomeProduto());
				sBuilder.append("			</td>\r\n");
				sBuilder.append("		</tr>\r\n");
				sBuilder.append(pp.getQuantidade());
				sBuilder.append("			</td>\r\n");
				sBuilder.append("		</tr>\r\n");
				
				sBuilder.append("		</table>\r\n");
				sBuilder.append("		</center>\r\n");
				sBuilder.append("	</body>\r\n");
				sBuilder.append("</html>");
				

				helper.setText(sBuilder.toString(), true);

				emailSender.send(message);

			} catch (Exception e) {
				throw new EmailException("Houve erro ao enviar o email do pedido: " + e.getMessage());
			}
	}


}