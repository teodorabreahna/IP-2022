from wordhoard import Hypernyms
from wordhoard import Definitions
from wordhoard import Hyponyms
from wordhoard import Synonyms
import numpy as np

print("The similarities between the two concepts are:")
print(np.intersect1d(Hypernyms(search_string='man').find_hypernyms(), Hypernyms(search_string='woman').find_hypernyms()))


definition = Definitions('travelling')
definition_results = definition.find_definitions()

print()
print("The definition of travelling is:")
print(definition_results)


hypernym = Hypernyms('travelling')
hypernym_results = hypernym.find_hypernyms()
print()
print("Some of the words related to travelling are:")
print(hypernym_results)

print()
print(Hyponyms(search_string='beach').find_hyponyms())
print(Hyponyms(search_string='mountain').find_hyponyms())