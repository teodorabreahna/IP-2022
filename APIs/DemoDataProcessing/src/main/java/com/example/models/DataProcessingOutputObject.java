package com.example.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
public class DataProcessingOutputObject {
    String topic;
    List<String> nouns;
    List<String> adjectives;
    List<String> verbs;
}
