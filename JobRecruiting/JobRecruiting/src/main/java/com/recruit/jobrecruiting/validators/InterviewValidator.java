/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import java.time.LocalDate;

/**
 *
 * @author Doly
 */
public class InterviewValidator extends Validator{

    private LocalDate date;
    private InterviewBean interviewBean;

    public InterviewValidator(LocalDate date, InterviewBean interviewBean) {
        this.date = date;
        this.interviewBean = interviewBean;
    }
    
    
    @Override
    protected void validate() {
        date();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void date() {
        if (!date.isAfter(LocalDate.now())) {
            messageBag.put("date", "Please set a future date!");
        }
    }
    
}
