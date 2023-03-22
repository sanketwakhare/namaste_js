/* Typehead Search Decay */

/* Problem Description

You need to implement search typeahead on a single machine with daily frequency decay. Basically, you need to implement 3 kinds of functions. :-

incrementSearchTermFrequency(string search_term, int increment) - Increase the frequency of search_term by increment .
findTopXSuggestion(string queryPrefix, int X) - Find the top X (X <= 5) search terms i.e. 5 terms that have queryPrefix as a strict prefix and have the highest frequency in the eligible set.
dayPasses(decayFactor) - This is an indicator of transition to another day with decayFactor. The frequency of all existing search terms gets divided by decayFactor.
Note:- For two strings with the same frequency, we give more preference to the lexicographically larger one. For the second function, if there are fewer than X strings with the given prefix then add empty strings. Also, the strings must be returned after sorting them lexicographically. The division by decayFactor is a float division.


Constraints

Sum of increment over all test cases <= 109

Product of decayFactor over all test cases <= 109

1 <= X <= 5

2 <= decayFactor <= 5

'a' <= queryPrefix <= 'z'


Sample Input

incrementSearchTermFrequency(“michelleobama”, 100)

incrementSearchTermFrequency(“michaeljackson”, 90)

incrementSearchTermFrequency(“michaeljordan”, 120)

dayPasses(2)

incrementSearchTermFrequency(“mickeymouse”, 51)

findTopXSuggestion(“mic”, 2) - This should return (“michaeljordan”, “mickeymouse”). */
package typeahead;

import java.util.*;

public class TypeheadSearchDecay {

    // Map to keep track of word frequency
    private Map<String, Double> wordFrequency = new HashMap<>();

    // Map to keep track of words starting with a given prefix
    private Map<String, Set<String>> startsWith = new HashMap<>();

    // Method to increment the frequency of a search term
    public void incrementSearchTermFrequency(String searchTerm, int increment) {
        // Increment the frequency of the search term
        wordFrequency.put(searchTerm, wordFrequency.getOrDefault(searchTerm, 0d) + (double)increment);

        // Update the prefix map
        for (int i = 1; i <= searchTerm.length(); i++) {
            String prefix = searchTerm.substring(0, i);
            startsWith.computeIfAbsent(prefix, k -> new HashSet<>()).add(searchTerm);
        }
    }

    // Method to find the top X search terms that start with a given prefix and have the highest frequency
    public String[] findTopXSuggestion(String queryPrefix, int X) {
        // Get the set of words that start with the given prefix
        Set<String> prefixWords = startsWith.getOrDefault(queryPrefix, new HashSet<>());

        // Convert the set to a list and sort it based on frequency and lexicographical order
        List<String> sortedWords = new ArrayList<>(prefixWords);
        sortedWords.sort((w1, w2) -> {
            double freq1 = wordFrequency.getOrDefault(w1, 0d);
            double freq2 = wordFrequency.getOrDefault(w2, 0d);
            return freq2 != freq1 ? Double.compare(freq2, freq1) : w2.compareTo(w1);
        });

        // Create an array to hold the top X words and fill it with empty strings
        String[] topWords = new String[X];
        Arrays.fill(topWords, "");

        // Copy the top X words to the array
        for (int i = 0; i < Math.min(X, sortedWords.size()); i++) {
            topWords[i] = sortedWords.get(i);
        }

        // Sort the array alphabetically and return it
        Arrays.sort(topWords);
        return topWords;
    }

    public void dayPasses(int decayFactor) {

        if(decayFactor == 0) return;

        // iterate over frequency map
        for(Map.Entry<String, Double> entry : wordFrequency.entrySet()) {
            String searchTerm = entry.getKey();
            double currentFrequency = entry.getValue();
            double updatedFrequency = (double)currentFrequency / (double)decayFactor;

            // update frequency
            wordFrequency.put(searchTerm, updatedFrequency);
        }
    }

    public Map<String, Double> getWordFrequency() {
        return wordFrequency;
    }

    public static void main(String[] args) {
        TypeheadSearchDecay t1 = new TypeheadSearchDecay();
        t1.incrementSearchTermFrequency("michelleobama", 100);
        t1.incrementSearchTermFrequency("michaeljackson", 90);
        t1.incrementSearchTermFrequency("michaeljordan", 120);
        t1.dayPasses(2);
        t1.incrementSearchTermFrequency("mickeymouse", 51);
        String[] result = t1.findTopXSuggestion("mic", 2);
        System.out.println(Arrays.toString(result));
        // [michaeljordan, mickeymouse]
        Map<String, Double> wordFreq = t1.getWordFrequency();
        System.out.println(wordFreq);
    }
}
