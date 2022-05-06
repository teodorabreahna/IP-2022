
package com.mycompany.jsonfile;

public class Concept {
    private String cuvant;
    private String descriere;
    private String chart;

    public Concept(String cuvant, String descriere, String relevant) {
        this.cuvant = cuvant;
        this.descriere = descriere;
        this.chart = relevant;
    }

    public String getCuvant() {
        return cuvant;
    }
    public String getDescriere() {
        return descriere;
    }
    public String getChart() { return chart; }
    
    
}
