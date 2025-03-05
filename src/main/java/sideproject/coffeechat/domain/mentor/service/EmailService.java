package sideproject.coffeechat.domain.mentor.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmailWithAttachment(String toEmail, MultipartFile file) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject("멘토 인증 파일 첨부");
        helper.setText("멘토 신청자가 재직 인증 신청했습니다. 첨부파일을 확인하세요.");

        String filename = file.getOriginalFilename();
        if (filename == null) {
            filename = "재직증명서";
        }
        helper.addAttachment(filename, new ByteArrayResource(file.getBytes()));

        mailSender.send(message);
    }

}
