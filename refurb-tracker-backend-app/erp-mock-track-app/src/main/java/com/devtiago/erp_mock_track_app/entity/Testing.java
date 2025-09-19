package com.devtiago.erp_mock_track_app.entity;

import com.devtiago.erp_mock_track_app.enums.TestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "TB_ERP_TESTING")
public class Testing extends Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'mac' is required.")
    @Column(nullable = false)
    private String mac;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpe_instance_id", nullable = false)
    @NotNull
    private CpeInstance cpeInstance;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "start_test", nullable = false)
    @NotNull
    private LocalDateTime startTest;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "end_test", nullable = false)
    @NotNull
    private LocalDateTime endTest;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TestStatus status;
}
