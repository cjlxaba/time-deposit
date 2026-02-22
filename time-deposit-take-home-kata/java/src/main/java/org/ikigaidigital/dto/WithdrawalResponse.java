package org.ikigaidigital.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class WithdrawalResponse {
    private Integer id;
    private Double amount;
    private Date date;
}
