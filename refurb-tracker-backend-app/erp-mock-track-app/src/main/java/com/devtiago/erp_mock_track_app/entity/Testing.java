package com.devtiago.erp_mock_track_app.entity;

import com.devtiago.erp_mock_track_app.enums.TestStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "TB_TESTING")
public class Testing extends Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'mac' is required.")
    private String mac;
    @NotBlank(message = "The field 'tested_by' is required.")
    private String testedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpe_instance_id", nullable = false)
    private CpeInstance cpeInstance;

    private LocalDateTime startTest;
    private LocalDateTime endTest;

    @Enumerated(EnumType.STRING)
    private TestStatus status;
}
