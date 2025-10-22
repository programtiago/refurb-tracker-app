package com.devtiago.refurbtracker.refurb_core.entity;

import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_EMPLOYEE")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'first_name' is mandatory.")
    @Size(min = 3, max = 10, message = "The field 'first_name' must be between 3 and 10 characters.")
    @Column(name = "first_name", nullable = false, length = 10)
    private String firstName;
    @Size(min = 3, max = 20, message = "The field 'last_name' must be between 3 and 10 characters.")
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @NotNull(message = "The field 'birthday_date' is mandatory.")
    @Column(name = "birthday_date", nullable = false)
    private LocalDate birthdayDate;
    @NotNull(message = "The field 'department' is mandatory.")
    @Size(min = 2, max = 15, message = "The field 'department' must be between 3 and 10 characters.")
    @Column(name = "department", nullable = false, length = 15)
    private String department;
    @NotBlank(message = "The field 'function' is mandatory.")
    @Column(name = "function", nullable = false, length = 50)
    @Size(min = 5, max = 50, message = "The field 'function' must be between 10 and 50 characters")
    private String position;
    @NotNull(message = "The field 'admission_date' is mandatory.")
    @Column(name = "admission_date", nullable = false)
    private LocalDate admissionDate;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "status", nullable = false)
    private StatusEmployee status = StatusEmployee.AVAILABLE;
    @Column(name = "active", nullable = false)
    @Builder.Default
    private boolean active = true;
    @NotBlank(message = "The field 'display_name' is mandatory.")
    @Column(name = "display_name", nullable = false)
    private String displayName;
    @NotBlank(message = "The field 'display_name' is mandatory.")
    @Column(name = "phone_number", nullable = false, length = 15, unique = true)
    private String phoneNumber;

    @PrePersist
    public void onCreation(){
        if (displayName == null || displayName.isBlank()){
            setDisplayName();
        }
    }

    public abstract void setDisplayName();
}
