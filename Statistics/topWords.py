from collections import Counter
  
data_set = "Coastline Shoreline Lagoon Canoe Cove Sand Boat Landing Whale Reef Gravel Coast Harbour Ocean Peninsula Sea Island Shore Boat Boat Landing Whale Reef Gravel Coast Harbour Shore Cove Sand Boat Shore Shore Ocean Surfing Surf Laguna Palm Sinking Dune Volleyball Surfer Newport Erosion Miami Bathing Resort Ship Florida Vessel Sediment Long Estuary Boat Tourist Ocean Peninsula Sea Island Surfing Surf Laguna Palm Sinking Dune Volleyball Surfer Newport Erosion Miami Bathing Resort Ship Florida Vessel Sediment Long Estuary Boat Tourist Tourist Tourist Tourist" 
  
# split() returns list of all the words in the string
split_it = data_set.split()
  
# Pass the split_it list to instance of Counter class.
Counter = Counter(split_it)
  
# most_common() produces k frequently encountered
# input values and their respective counts.
k = int(input("k = "))
most_occur = Counter.most_common(k)
  
for i in most_occur:
    print ( i, end = " \n")

