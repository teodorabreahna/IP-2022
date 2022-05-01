import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.POS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class ConcepHandler
{

    private final Dictionar dict = new Dictionar();

    public Set<String> compareConceptSets(POS p, Set<String> c1, Set<String> c2) throws JWNLException {

        Set<String> result = new HashSet<String>();
        Set<String> conceptSyn1 = new HashSet<String>();
        Set<String> conceptSyn2 = new HashSet<String>();
        List<String> temp = new ArrayList<String>();

        for (String s1 : c1)
        {

            for (String s2 : c2)
            {

                if(s1.equals(s2))
                {

                    result.addAll(dict.synonyms(p, s1, Integer.MAX_VALUE));
                    temp.add(s1);

                }

            }

        }

        for (int i = 0; i < temp.size(); i++)
        {

            c1.remove(temp.get(i));
            c2.remove(temp.get(i));

        }

        temp.clear();

        for (String s : c1)
        {

            conceptSyn1.addAll(dict.synonyms(p, s, Integer.MAX_VALUE));

        }
        for (String s : c2)
        {

            conceptSyn2.addAll(dict.synonyms(p, s, Integer.MAX_VALUE));

        }

        conceptSyn1.retainAll(conceptSyn2);
        result.addAll(conceptSyn1);

        return result;

    }

    public static void main(String args[]) throws JWNLException {

        System.out.println(new ConcepHandler().compareConceptSets(POS.NOUN,
                new HashSet<String>(Arrays.asList("apple", "berry")),
                new HashSet<String>(Arrays.asList("banana", "Malus pumila"))));

    }

}
