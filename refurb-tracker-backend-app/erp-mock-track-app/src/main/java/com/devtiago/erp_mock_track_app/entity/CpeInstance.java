package com.devtiago.erp_mock_track_app.entity;

import com.devtiago.erp_mock_track_app.enums.CpeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CPE_INSTANCE")
public class CpeInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CpeStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cpe_id")
    private Cpe cpe;
}
