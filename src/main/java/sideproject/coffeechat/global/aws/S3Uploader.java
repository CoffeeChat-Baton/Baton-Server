package sideproject.coffeechat.global.aws;

import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.CustomException;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Slf4j
@Service
public class S3Uploader {

    private final S3Client s3Client;
    private final String bucket;

    public S3Uploader(
            @Value("${cloud.aws.s3.bucket}") String bucket,
            @Value("${cloud.aws.credentials.accessKey}") String accessKey,
            @Value("${cloud.aws.credentials.secretKey}") String secretKey,
            @Value("${cloud.aws.region}") String region) {
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)
                )).build();
        this.bucket = bucket;
    }

    public String upload(String prefix, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String fileName = prefix + UUID.randomUUID() + "_" + file.getOriginalFilename();

        try {
            uploadToS3(file, fileName);
            return getFileUrl(fileName);
        } catch (Exception e) {
            log.error("Error while uploading file", e);
            throw new CustomException(ErrorCode.S3_ERROR, "Error while uploading file");
        }
    }

    private void uploadToS3(MultipartFile file, String fileName) throws IOException {
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(fileName)
                        .build(),
                RequestBody.fromBytes(file.getBytes())
        );
    }

    private String getFileUrl(String fileName) {
        return String.format("https://%s.s3.amazonaws.com/%s", bucket, fileName);
    }

}
