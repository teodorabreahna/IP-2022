package IPStatisticsDemo.DemoStatistics.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import IPStatisticsDemo.DemoStatistics.Services.Concept;
import IPStatisticsDemo.DemoStatistics.Services.DictionaryAccessPoint;


@SpringBootTest
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
class ConceptTest {

	
	
	
	@Test
	public void similaritiesTest(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() {{
            put("cuv1", 1);
            put("cuv2", 2);
            put("cuv3", 3);
            put("cuv5", 3);


        }};
        
        LinkedHashMap<String, Integer> topWords2 =new LinkedHashMap<String, Integer>() {{
            put("cuv1", 1);
            put("cuv2", 2);
            put("cuv4", 4);

        }};
        
        Concept c1 = new Concept("concept1",topWords1);
        Concept c2 = new Concept("concept2",topWords2);
        
        List<String> result = c1.similarities(c2);
        List<String> expected = new ArrayList<>();
        
        expected.add("cuv1");
        expected.add("cuv2");
        //expected.add("cuv3");
        
        assertEquals(result,expected);
      
	}
	
	
	@Test
	public void similaritiesTest2(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() ;
        
        LinkedHashMap<String, Integer> topWords2 =new LinkedHashMap<String, Integer>() ;
        
        Concept c1 = new Concept("concept1",topWords1);
        Concept c2 = new Concept("concept2",topWords2);
        
        List<String> result = c1.similarities(c2);
        List<String> expected = new ArrayList<>();
        
        //expected.add("cuv1");
        //expected.add("cuv2");
        //expected.add("cuv3");
        
        assertEquals(result,expected);
      
    
	}
	
	@Test
	public void similaritiesTest3(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() {{
            put("cuv1", 1);
            put("cuv2", 2);
            put("cuv3", 3);
            put("cuv5", 3);


        }};
        
        LinkedHashMap<String, Integer> topWords2 =new LinkedHashMap<String, Integer>() {{
            put("cuv10", 1);
            put("cuv20", 2);
            put("cuv40", 4);

        }};
        
        Concept c1 = new Concept("concept1",topWords1);
        Concept c2 = new Concept("concept2",topWords2);
        
        List<String> result = c1.similarities(c2);
        List<String> expected = new ArrayList<>();
        
        
        assertEquals(result,expected);
      
	}
	
	
	//
	// eroare cand cauta in dictionar ceva ce nu exista 
	//
	
	
	@Test
	public void commonSynonymsTest(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() ;
        
 
        
        Concept c1 = new Concept("",topWords1);

		Set<String> sin1 =new HashSet<>();
		Set<String> sin2 =new HashSet<>();
		Set<String> test =new HashSet<>();
		Set<String> test2 =new HashSet<>();
        try {
            sin1=new DictionaryAccessPoint().getSynonyms("man");
            sin2=new DictionaryAccessPoint().getSynonyms("man");
            test=new DictionaryAccessPoint().getSynonyms("bad");
            test2=new DictionaryAccessPoint().getSynonyms("decent");
        } catch (IOException e) {
        	
            e.printStackTrace();
        }

        System.out.println("================================================================================================================");
    	System.out.println("good :"+ test);
    	System.out.println("decent :"+ test2);
    	System.out.println("================================================================================================================");

        List<String> result= c1.commonSynonyms("man",sin1,"man",sin2);
        List<String> expected=new ArrayList<>();
        expected.add("person");
        expected.add("omi");
        expected.add("human");
        expected.add("male");


        assertEquals(result,expected);
        
        }
	
	
	@Test
	public void commonSynonymsTest2(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() ;
        Concept c1 = new Concept("",topWords1);

		Set<String> sin1 =new HashSet<>();
		Set<String> sin2 =new HashSet<>();
        try {
            sin1=new DictionaryAccessPoint().getSynonyms("man");
            sin2=new DictionaryAccessPoint().getSynonyms("person");
        } catch (IOException e) {
        	System.out.println("================================================================================================================");
        	System.out.println("exceptie");
        	System.out.println("================================================================================================================");
            e.printStackTrace();
        }


        List<String> result= c1.commonSynonyms("man",sin1,"person",sin2);
        List<String> expected=new ArrayList<>();
        expected.add("person");


        assertEquals(result,expected);
        
        }
	
	
	@Test
	public void diffBetweenSinAndAntTest(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() ;
        Concept c1 = new Concept("",topWords1);
        
		String con1= "decent";
		String con2= "evil";
		Set<String> sin1 =new HashSet<>();
		Set<String> ant2 =new HashSet<>();
		
        try {
        	sin1=new DictionaryAccessPoint().getSynonyms(con1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        	ant2 = new DictionaryAccessPoint().getAntonyms(con2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> result= c1.diffBetweenSinAndAnt("decent",sin1,ant2);

        List<String> expected=new ArrayList<>();
        expected.add("good");

        assertEquals(result,expected);
    }
	
	
	@Test
	public void dictionaryTest(){
		
		LinkedHashMap<String, Integer> topWords1  = new LinkedHashMap<String, Integer>() ;
        
		String con1= "";

		Set<String> sin1 =new HashSet<>();

		
		try {
        	sin1=new DictionaryAccessPoint().getSynonyms(con1);

        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("================================================================================================================");
    	System.out.println(sin1);
    	System.out.println("================================================================================================================");

    }
	
	
	
	
	
	
	
	
    }
	
	
	
	
	
	

