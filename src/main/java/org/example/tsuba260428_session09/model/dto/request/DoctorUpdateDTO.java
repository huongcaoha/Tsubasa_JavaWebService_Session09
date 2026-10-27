package org.example.tsuba260428_session09.model.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorUpdateDTO {
    private String fullName ;
    private String specialization ;
    private int experienceYears ;
}
