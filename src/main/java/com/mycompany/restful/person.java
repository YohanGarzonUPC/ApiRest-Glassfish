/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="persona")
@XmlType(propOrder={"id","fullName","age"})
public class person {
    
    private int id;
    private String fullName;
    private int age;
    private int salario;
    private static int salariomin = 1300000 ;
    
    public person(){
        
    }
    
    @XmlElement
    public int calcularSalario() {
        this.salario=getAge()*salariomin/3;
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
