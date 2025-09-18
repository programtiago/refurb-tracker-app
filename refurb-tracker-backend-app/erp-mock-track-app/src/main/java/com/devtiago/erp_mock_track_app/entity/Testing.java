package com.devtiago.erp_mock_track_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_TESTING")
public class Testing extends Operation {

    @NotBlank(message = "The field 'mac' is required.")
    private String mac;
    @NotBlank(message = "The field 'tested_by' is required.")
    private String testedBy;
}
