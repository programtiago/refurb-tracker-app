package com.devtiago.refurb_tracker_app.refurbtracker.entity;

import com.devtiago.refurb_tracker_app.refurb_core.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_INTERNAL_EMPLOYEE")
public class InternalEmployee extends Employee {

    private String workerNo;

    @Override
    public int calculateVacationDays() {
        //se a duração do colaborador na empresa for inferior a 6 meses
        if (getMonthsOfSeniority() < 6){
            return 0; //Ainda não pode tirar férias
        }

        //22 dias de férias base
        int baseVacation = 22;
        if (isBirthdayMonth()){
            //os trabalhadores internos têm direito a mais um dia
            baseVacation += 1;
        }

        return baseVacation;
    }
}
