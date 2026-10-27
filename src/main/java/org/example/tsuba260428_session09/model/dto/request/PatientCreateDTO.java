package org.example.tsuba260428_session09.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.example.tsuba260428_session09.validator.CheckFileImage;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PatientCreateDTO {
    @NotBlank
    private String patientName ;
    @NotBlank
    @Pattern(regexp = "^0[35789][0-9]{8}$")
    private String phoneNumber ;
    @CheckFileImage
    private MultipartFile avatarFile ;
}
