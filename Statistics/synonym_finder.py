from wordhoard import Synonyms
import numpy as np
from collections import OrderedDict

inputConceptList1 = ['apple', 'phone', 'honeycrisp', 'red']
inputConceptList2 = ['banana', 'plantain', 'berry', 'yellow']
nonDupicateConceptList1=list(OrderedDict.fromkeys(inputConceptList1));
nonDupicateConceptList2=list(OrderedDict.fromkeys(inputConceptList2));
outDupicateConceptList1 = []
outDupicateConceptList2 = []
nonDupicateConceptList = []
for i in nonDupicateConceptList1:
    temp = Synonyms(search_string=i).find_synonyms()
    outDupicateConceptList1.append(temp)

for i in nonDupicateConceptList2:
    temp = Synonyms(search_string=i).find_synonyms()
    outDupicateConceptList2.append(temp)

for i in outDupicateConceptList1:
    for j in outDupicateConceptList2:
        temp = np.intersect1d(i, j)
        if len(temp):
            nonDupicateConceptList.append(temp)

print(*nonDupicateConceptList)
