package org.example.tsuba260428_session09.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.tsuba260428_session09.validator.CheckDoctorCodeExisted;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorCreateDTO {
    @NotBlank(message = "mã bác sĩ không được đc trống")
//    @Size(min = 4 ,max = 6 ,message = "mã bác sĩ trong khoảng 4 đến 6 ký tự")
//    @Pattern(regexp = "^D[0-9]{3}$", message = "Mã bác sĩ phải đúng định dạng Dxxx")
    @CheckDoctorCodeExisted
    private String doctorCode ;
    @NotBlank(message = "Tên bác sĩ không được để trống")
//    @Email (message = "")
    private String fullName ;
    @NotBlank
    private String specialization ;
    @NotNull

    private int experienceYears ;
}
