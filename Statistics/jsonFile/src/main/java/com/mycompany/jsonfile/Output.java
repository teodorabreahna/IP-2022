
package com.mycompany.jsonfile;

import java.util.ArrayList;
import java.util.List;
public class Output {
    
    private Concept concept1;
    private Concept concept2;
    private List<String> intersect= new ArrayList<>();;
    private List<String> diferentc1= new ArrayList<>();;
    private List<String> diferentc2= new ArrayList<>();;

    public Output(Concept concept1, Concept concept2, List intersect, List diferentc1, List diferentc2) {
        this.concept1 = concept1;
        this.concept2 = concept2;

        this.intersect = intersect;
        this.diferentc1 = diferentc1;
        this.diferentc2 = diferentc2;
    }

    public Concept getConcept1() {
        return concept1;
    }

    public Concept getConcept2() {
        return concept2;
    }

    public List<String> getIntersect() {
        return intersect;
    }

    public List<String> getDiferentc1() {
        return diferentc1;
    }

    public List<String> getDiferentc2() {
        return diferentc2;
    }
    
    
}
