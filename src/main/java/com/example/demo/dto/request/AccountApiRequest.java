package com.example.demo.dto.request;

import com.example.demo.entity.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountApiRequest {

    private String userId;
    private String password;
    private GenderEnum gender; //MALE. FEMALE
    private String nickName;
    private boolean adAgree;
}
