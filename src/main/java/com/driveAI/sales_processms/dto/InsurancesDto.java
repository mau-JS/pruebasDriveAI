package com.driveAI.sales_processms.dto;

import com.driveAI.sales_processms.model.Insurances;

public class InsurancesDto {
    private int pk_num_id_insurances;
    private String str_insurance_company;
    private float num_amount_insurance;

    public int getPk_num_id_insurances() {
        return pk_num_id_insurances;
    }

    public void setPk_num_id_insurances(int pk_num_id_insurances) {
        this.pk_num_id_insurances = pk_num_id_insurances;
    }

    public String getStr_insurance_company() {
        return str_insurance_company;
    }

    public void setStr_insurance_company(String str_insurance_company) {
        this.str_insurance_company = str_insurance_company;
    }

    public float getNum_amount_insurance() {
        return num_amount_insurance;
    }

    public void setNum_amount_insurance(float num_amount_insurance) {
        this.num_amount_insurance = num_amount_insurance;
    }
    public InsurancesDto(Insurances insurances){
        this.pk_num_id_insurances = insurances.getPk_num_id_insurances();
        this.str_insurance_company = insurances.getStr_insurance_company();
        this.num_amount_insurance = insurances.getNum_amount_insurance();
    }
}
