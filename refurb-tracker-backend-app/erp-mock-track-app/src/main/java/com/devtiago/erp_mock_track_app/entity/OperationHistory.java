package com.devtiago.erp_mock_track_app.entity;

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
@Table(name = "TB_ERP_OPERATION_HISTORY")
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reception_id", nullable = false)
    private Reception reception;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testing_id", nullable = false)
    private Testing testing;

}
