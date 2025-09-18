package com.devtiago.erp_mock_track_app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_RECEPTION")
public class Reception extends Operation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String receptionIdentifier; //RECXXXXXX
    private String purchaseOrder; //POXXXXXX
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime receptionDate;
    @Pattern(regexp = "P-\\d{11}", message = "The pallet_id must start with 'P-' followed by 11 digits")
    @NotBlank(message = "The field 'pallet_id' is required.")
    private String palletId;
    private String receptionedBy;
}
