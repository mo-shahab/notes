def funclps(pat):
    # lps corresponds to the suffices and prefixes, AAAA , [0, ..., ..., ...] in here, 0 pos is 0 becaues by 1, only A is there and no suffix and prefix for this
    # because prefix cannot be the length of the entire string itself 
    # we are looking at the substring, that is a prefix and also suffix
    lps = [0] * len(pat)
    i = 1
    prevlps = 0
    
    while i < len(pat):
        if pat[i] == pat[prevlps]:
            prevlps += 1
            lps[i] = prevlps
            i += 1
        else:
            if len == 0:
                lps[i] = 0
                i += 1
            else:
                prevlps = lps[prevlps - 1]

    return lps

def kmp(pat, text):
    a = len(pat)
    b = len(text)

    lps = funclps(pat)

    i = 0
    j = 0
    while i < b:
        if text[i] == pat[j]:
            i, j = i+1, j+1
        elif j== a:
            print("the pattern is found at this index", j-1)
            # j -1 is the index
        else:
            if j == 0:
                i += 1
            else:
                j = lps[j-1]


'''
REASONING FOR THE LPS FUNCTION
Initialization:

len = 0: Initialize a variable len to 0. This will keep track of the length of the longest proper prefix which is also a suffix seen so far.
lps[0] = 0: Initialize the first value of the lps array as 0.
Loop through the Pattern:

i = 1: Start a loop from the second character of the pattern (i = 1) because lps[0] is always 0.
while i < M:: Continue the loop until the end of the pattern is reached.
Comparison:

if pat[i] == pat[len]:
If the character at position i in the pattern is equal to the character at position len, it means we've found a new character that extends the current prefix.
Increment len by 1 to indicate an increase in the length of the current common prefix and suffix.
Set lps[i] = len to store the length of the longest proper prefix which is also a suffix for the current position i.
Move to the next character (i += 1).
Mismatch Handling:

else: (When pat[i] != pat[len])
If there is a mismatch and len is not 0, it means there was a common prefix before the mismatch.
Update len using the information stored in the lps array: len = lps[len-1]. This helps in skipping unnecessary comparisons and efficiently handles mismatches.
If len is 0, it means there is no common prefix before the mismatch. In this case, set lps[i] = 0 and move to the next character (i += 1).
Repeat:

Repeat these steps until the entire pattern is processed.
''' 
