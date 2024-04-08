/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 
@author yohan*/

@XmlRootElement(name = "Salario")
@XmlType(propOrder = {"sumaSalario"})
public class SalarioPromedio {
    private int sumaSalario;

    
    public SalarioPromedio() {
    }

    public SalarioPromedio(int sumaSalario) {
        this.sumaSalario = sumaSalario;
    }

    @XmlElement
    public double getSumaSalario() {
        return sumaSalario;
    }

    public void setSumaSalario(int sumaSalario) {
        this.sumaSalario = sumaSalario;
    }
}