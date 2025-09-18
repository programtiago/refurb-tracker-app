package com.devtiago.erp_mock_track_app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_RECEPTION", uniqueConstraints = {
        @UniqueConstraint(columnNames = "reception_identifier")
})
public class Reception extends Operation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "REC\\d{6}", message = "The receptionIdentifier must start with 'REC' followed by 6 digits")
    @Length(min = 9, max = 9)
    @NotBlank
    @Column(name = "reception_identifier", nullable = false)
    private String receptionIdentifier; //RECXXXXXX
    @Pattern(regexp = "PO\\d{6}", message = "The receptionIdentifier must start with 'REC' followed by 6 digits")
    @Length(min = 9, max = 9)
    @NotBlank
    @Column(name = "purchase_order", nullable = false)
    private String purchaseOrder; //POXXXXXXX
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull
    @Column(name = "reception_date", nullable = false)
    private LocalDateTime receptionDate;
    @Pattern(regexp = "P-\\d{11}", message = "The pallet_id must start with 'P-' followed by 11 digits")
    @NotBlank(message = "The field 'pallet_id' is required.")
    @Column(name = "pallet_id", nullable = false)
    private String palletId;
    @NotBlank(message = "The field 'receptionedBy' is required.")
    @Column(name = "receptioned_by", nullable = false)
    private String receptionedBy;
}
