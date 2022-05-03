
package com.mycompany.jsonfile;

import java.util.ArrayList;
import java.util.List;
public class Concept {
    private String cuvant;
    private String descriere;

    public Concept(String cuvant, String descriere) {
        this.cuvant = cuvant;

        this.descriere = descriere;
    }

    public String getCuvant() {
        return cuvant;
    }

    public String getDescriere() {
        return descriere;
    }
    
    
}
