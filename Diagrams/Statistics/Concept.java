package ip;
import java.util.List;
import java.util.Map;

public class Concept {

  private String conceptName;

  private Map<Word, Integer> associatedWords;

  public void Concept(String name) 
  {
  }

  public String getConcept() {
  return null;
  }

  public Map<Word, Integer> getConceptWords() {
  return null;
  }

  public int getWordFrequency(Word word) {
  return 0;
  }

  public void setConcept(String name) {
  }

  public void setWord(Word word, int frequency) {
  }

  public List<Word> compareConceptWith(Concept concept) {
  return null;
  }

  public float calculateWordRelevance(Word word) {
  return 0;
  }

  public List<Word> getTheNMostUsedWords(int n) {
  return null;
  }

  public List<Word> getTheNMostRelevantWords(int n) {
  return null;
  }

  public Word getWordByString(String wordName) {
  return null;
  }

}