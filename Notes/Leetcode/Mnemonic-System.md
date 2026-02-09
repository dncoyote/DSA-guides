# Arrays & Hashing 🧱 + 🗃️
## Contains Duplicate 👯‍♀️  
#### 🐢 Brute Force
- 🛠️ Approach: Nested loops
- ⏱️ Time: ♟️ O(n²)
- 📦 Space: 🧤O(1)

#### 🚀 Optimal
- 🛠️ Approach: HashSet 
- ⏱️ Time: 🪖O(n)
- 📦 Space: 🎒O(n)


## Valid Anagram 🐘   
#### 🐢 Brute Force
- 🛠️ Approach: convert to char array, sort char array, compare char array 
- ⏱️ Time: 🪖🌲 O(n log n) 
- 📦 Space: 🎒 O(n) 
#### 🚀 Optimal
- 🛠️ Approach: counter char array increment and decrement 
- ⏱️ Time: 🪖O(n)
- 📦 Space: 🧤  O(1)


## Two Sum 🤼‍♂️ 
#### 🐢 Brute Force
- 🛠️ Approach: Check every pair using nested loops
- ⏱️ Time: ♟️ O(n²)
- 📦 Space: 🧤O(1)
#### 🚀 Optimal
- 🛠️ Approach: Store complement (target − x) in HashMap and check lookup
- ⏱️ Time: 🪖 O(n)
- 📦 Space: 🧤  O(1)


## Group Anagrams 🐘🐘🐘 
#### 🐢 Brute Force
- 🛠️ Approach: Create a HashMap that store sorted string as key and List<String> of that sorted string as value→Return the values 
- ⏱️ Time: 🪖🌲  O(n m log n) (Where `m` is number of strings and `n` is the length of the longest String.)
- 📦 Space: 🎒 O(nm)
#### 🚀 Optimal
- 🛠️ Approach: Create a HashMap that store char[26] count String as key and List<String> of that count as value→Return the values 
- ⏱️ Time: 🪖O(nm) (Where `m` is number of strings and `n` is the length of the longest String.)
- 📦 Space: 🎒 O(nm)


## Encode Decode String 🔒🔓
#### 🐢 Brute Force
- 🛠️ Approach:  Join with delimiter "#", decode by split("#")
- ⏱️ Time: 🪖  O(L) (Where `L` is Length of string.)
- 📦 Space: 🎒 O(L)
#### 🚀 Optimal
- 🛠️ Approach: Length-prefix each string: "<len>#<string>"  
- ⏱️ Time: 🪖  O(L) (Where `L` is Length of string.)
- 📦 Space: 🎒 O(L)


## Product of Array Except Self ✖️⁉ 
#### 🐢 Brute Force
- 🛠️ Approach: using nested loops
- ⏱️ Time: ♟️ O(n²)
- 📦 Space: 🧤O(1)
#### 🚀 Optimal
- 🛠️ Approach: Compute prefix product = product of elements to the left, Compute suffix product = product of elements to the right, multiply both together 
- ⏱️ Time: 🪖 O(n)
- 📦 Space: 🧤  O(1)


### Legend
#### Complexities 
- 🪖 = O(n) Linear time - Soldiers march in a straight line
- ♟️ = O(n²) Quadratic time - 
- 🌲 = O(log n) Logarithmic time
- 🪖🌲 = O(n log n) Linear work with Logarithmic steps
- 🧤 = O(1) space Constant space - empty hand
- 🎒 = O(n) space Linear space 
- 📚 = O(n²) space Quadratic space
#### Variables
- 🪖 = n (soldiers)
- 👥 = m (crowd)
- 🎭 = k (masked group)
#### Time
- 🎇 = O(2^n) (exponential)
- 🌀 = O(n!) (factorial)
- 🧊 = O(n³)
