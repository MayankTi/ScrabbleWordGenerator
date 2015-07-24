import java.util.HashMap;
import java.util.Map;


public class WordRecommender {
		
		public Map<Integer, String> Recommendation(String wordInput)
		{
			AnagramDictionary anagramDictionary = new AnagramDictionary();
			anagramDictionary.createMapFromFile();
			String [] allWords = AllCombinations.possibleCombinations(wordInput);
			Map<Integer,String> mapWords = new HashMap<Integer,String>();
			WordScorePair anagramsCollection;
			String keyString = "";
			
			for (String word: allWords) {
				
				anagramsCollection = anagramDictionary.getAnagrams(word);
				if (!keyString.contains(anagramDictionary.sortString(word)) && anagramsCollection.listofAnagram!=null)
				{
					if (mapWords.containsKey(anagramsCollection.score))
					{
						mapWords.put(anagramsCollection.score, anagramsCollection.listofAnagram+ " " +mapWords.get(anagramsCollection.score));
					}
					else
					{
						mapWords.put(anagramsCollection.score, anagramsCollection.listofAnagram);
					}
						
				}
				
			}
			
			return mapWords;
			
		}
		
		public String maxScoreWords(String wordInput)
		{
			AnagramDictionary anagramDictionary = new AnagramDictionary();
			anagramDictionary.createMapFromFile();
			String [] allWords = AllCombinations.possibleCombinations(wordInput);
			WordScorePair anagramsCollection;
			String resultString = "";
			int maxScore=0;
			
		
			for (String word: allWords) {
				
				
				
				anagramsCollection = anagramDictionary.getAnagrams(word);
				
				//System.out.println(word+" "+anagramsCollection.score+" "+maxScore +" "+anagramsCollection.listofAnagram);
			
					if ( maxScore < anagramsCollection.score )
					{
						resultString = anagramsCollection.listofAnagram;
						maxScore = anagramsCollection.score ;
						
					}
					else if (maxScore == anagramsCollection.score )
					{
						resultString = " "+anagramsCollection.listofAnagram;
					}
				
			}
			
			resultString+=" "+maxScore;
			
			return resultString;
			
		}
	
}
