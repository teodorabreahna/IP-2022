import json
import sys
from wordhoard import Synonyms
from wordhoard import Antonyms
from wordhoard import Hypernyms

word = sys.argv[1]

synonyms = Synonyms(search_string=word).find_synonyms() 
antonyms = Antonyms(search_string=word).find_antonyms()
hypernyms = Hypernyms(search_string=word).find_hypernyms()

data = {
    word : {
        'synonyms' : {
            'size' : len(synonyms),
            'list' : synonyms
            },
        'antonyms' : {
            'size' : len(antonyms),
            'list' : antonyms
            },
        'hypernyms' : {
            'size' : len(hypernyms),
            'list' : hypernyms
            },
    }
}

with open('word.json', 'w') as jfile:
    json.dump(data ,jfile, indent = 4)
