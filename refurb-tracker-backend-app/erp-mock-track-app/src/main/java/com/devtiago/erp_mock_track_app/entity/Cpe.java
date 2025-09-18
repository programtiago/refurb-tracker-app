package com.devtiago.erp_mock_track_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CPE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "sap")
})
public class Cpe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 6, max = 6)
    @NotBlank(message = "The field 'sap' is required.")
    private String sap; //model identifier unique
    @NotBlank(message = "The field 'design' is required.")
    private String design; //description
    @Column(name = "part_no", nullable = false)
    private String partNo; //part number of the equipment
    @Length(min = 13, max = 13)
    private String ean;
    private boolean active;
}
