import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Scrabble {
		
	public static boolean containsWord(String sameWeightWords, String comparionWord){
		
		boolean result=false;
		
		if(sameWeightWords!=null)
		{
			String [] words = sameWeightWords.split(" ");
			
			for(String word: words) {
				if (comparionWord.trim().equals(word.trim())) {
					return true;
				}
			}
		}
		return result;
		
	}
	
	public static int updatedScore(String word, String rackAlphabets) {
		char [] presentLetters = rackAlphabets.toCharArray();
		int [] alphabetWeights = new WordScore().getAlphabetWeights();
		int score = 0;
		for (int i=0; i< presentLetters.length; i++) {
			if (presentLetters[i]!=' ' && word.contains(Character.toString(presentLetters[i]))) {
				score += alphabetWeights[presentLetters[i]-'a'];
			}
		}
		return score;
	}
	
	public static void writeToFile(String fileName, Map<Integer, String> sortedWords) {

		try {
			BufferedWriter recommendation_writer = new BufferedWriter(new FileWriter(new File(fileName)));
			
			for (Map.Entry<Integer, String> entry : sortedWords.entrySet()) {
				System.out.println(">> "+entry.getKey()+" "+entry.getValue());
				recommendation_writer.write(entry.getKey()+" - "+entry.getValue()+"\n");
			}
			recommendation_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);	
		
		System.out.print("GIVE INPUT  \n");
		String rackWords = input.nextLine();
		
		
		
		//Map<Integer, String> updatedWordScore = new HashMap<Integer, String>();
		WordRecommender wordRecommender = new WordRecommender();
		System.out.println(wordRecommender.maxScoreWords(rackWords));
		
	}
}
