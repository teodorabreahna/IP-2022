from wordhoard import Synonyms
from wordhoard import Antonyms
import numpy as np
from collections import OrderedDict

inputConceptList1 = ['small', 'little', 'happy', 'boring' ]
inputConceptList2 = ['big', 'depressed' , 'colossal', 'interesting']

nonDupicateConceptList = []

nonDupicateConceptList1=list(OrderedDict.fromkeys(inputConceptList1));
outDupicateConceptList1 = []

aux = []

for i in nonDupicateConceptList1:
        temp = Antonyms(search_string=i).find_antonyms()
        outDupicateConceptList1.append(temp)
        for t in outDupicateConceptList1:
            for j in inputConceptList2:
                temp = np.intersect1d(t, j)
                if len(temp):
                    nonDupicateConceptList.append(i)
                    nonDupicateConceptList.append(j)
                    nonDupicateConceptList.append("|")
                    inputConceptList2.remove(j)

print(*nonDupicateConceptList)