package org.example.tsuba260428_session09.model.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private int status ;
    private String message;
    private T data ;
}
