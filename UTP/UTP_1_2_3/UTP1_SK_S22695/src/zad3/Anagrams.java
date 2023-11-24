/**
 *
 *  @author Stachnik Krystian S22695
 *
 */

package zad3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    private Map<String, ArrayList<Anagram>> sortedAnagrams = new HashMap<>();

    public Anagrams(String filePath) {
        readFile(filePath);
    }

    public void readFile(String file_name) {
        ArrayList<Anagram> allWords = new ArrayList<>();

        List<Anagram> allWords2 ;


        try (Stream<String> stream = Files.lines(Paths.get(file_name))) {
            allWords2 = stream
                    .map(line -> line.split(" "))
                    .flatMap(Stream::of)
                    .map(word -> new Anagram(word))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        allWords.forEach(anagram -> {
            String key = anagram.getSortedText();

            sortedAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(anagram);
        });



        sortedAnagrams = sortedAnagrams.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().size(), Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public List<List<String>> getSortedByAnQty() {
        List<List<String>> temp = new ArrayList<>();

        sortedAnagrams.forEach((klucz, wartosc) -> {
            temp.add(wartosc.stream()
                    .map(Anagram::getText)
                    .collect(Collectors.toList()));
        });

        return temp;
    }

    public String getAnagramsFor(String word) {
        Anagram tempAnagram = new Anagram(word);
        ArrayList<Anagram> listaAnagramow = new ArrayList<>(sortedAnagrams.get(tempAnagram.getSortedText()));


        Optional<Anagram> znalezionyAnagram = sortedAnagrams.values().stream()
                .flatMap(List::stream)
                .filter(a -> word.equals(a.getText()))
                .findFirst();

        if (znalezionyAnagram.isPresent()) {
            listaAnagramow.remove(znalezionyAnagram.get());
        }

        return word + ": " + listaAnagramow;
    }

}  
