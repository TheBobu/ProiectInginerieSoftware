/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.admin.ejb;

import com.recruit.jobrecruiting.user.ejb.UserBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andrei
 */
@Stateless
public class AdministrationBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject UserBean userBean;
    
}
