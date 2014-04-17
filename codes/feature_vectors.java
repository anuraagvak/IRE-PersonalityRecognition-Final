import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class feature_vectors {
	public static int flagbegin=1;
	public static ArrayList<String> ext= new ArrayList<String>();
	public static HashMap<String , String> synonyms_list= new HashMap<String , String>();
	public static ArrayList<String> positive_words= new ArrayList<String>();
	public static ArrayList<String> smileys= new ArrayList<String>();
	public static ArrayList<String> emotions= new ArrayList<String>();
	public static ArrayList<String> swear_words= new ArrayList<String>();
	public static ArrayList<String> anger_words= new ArrayList<String>();
	public static ArrayList<String> negative_words= new ArrayList<String>();
	public static ArrayList<String> top_10000= new ArrayList<String>();
	public static ArrayList<String> top_20000= new ArrayList<String>();
	public static ArrayList<String> firstperson_singular= new ArrayList<String>();
	public static ArrayList<String> firstperson_plural= new ArrayList<String>();
	public static ArrayList<String> secondperson= new ArrayList<String>();
	public static ArrayList<String> thirdperson_singular= new ArrayList<String>();
	public static ArrayList<String> thirdperson_plural= new ArrayList<String>();
	public static ArrayList<String> indefinite_pronouns= new ArrayList<String>();
	public static ArrayList<String> articles= new ArrayList<String>();
	public static ArrayList<String> future_words= new ArrayList<String>();
	public static ArrayList<String> adverbs= new ArrayList<String>();
	public static ArrayList<String> prepositions= new ArrayList<String>();
	public static ArrayList<String> conjunctions= new ArrayList<String>();
	
	
	public static ArrayList<String> auxillary_verbs= new ArrayList<String>();
	public static ArrayList<String> negations= new ArrayList<String>();
	public static ArrayList<String> quantifiers= new ArrayList<String>();
	public static ArrayList<String> anxiety= new ArrayList<String>();
	public static ArrayList<String> family_words= new ArrayList<String>();
	public static ArrayList<String> sadness_words= new ArrayList<String>();
	public static ArrayList<String> happy_words= new ArrayList<String>();
	public static ArrayList<String> body_words= new ArrayList<String>();
	public static ArrayList<String> health_words= new ArrayList<String>();
	public static ArrayList<String> job_words= new ArrayList<String>();
	public static ArrayList<String> achievement= new ArrayList<String>();
	public static ArrayList<String> money_words= new ArrayList<String>();
	public static ArrayList<String> death= new ArrayList<String>();
	
	
	


	// public static  MaxentTagger tagger = new MaxentTagger("/home/navya/Downloads/stanford-postagger-2014-01-04/models/english-bidirectional-distsim.tagger");

	public static void  getfeature_vectors(String filename ) throws IOException
	{
		ext= new ArrayList<String>();
		synonyms_list= new HashMap<String , String>();

		FileReader fr= new FileReader(filename+"_synonym");

		BufferedReader br= new BufferedReader(fr);
		String currentline="";
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();

			String[] toks = currentline.split(":");
			synonyms_list.put(toks[0], toks[1]);

		}
		br.close();
		fr.close();
		fr= new FileReader(filename);

		br= new BufferedReader(fr);
		currentline="";
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			if(!ext.contains(currentline))
				ext.add(currentline);

		}
		br.close();
		fr.close();
		if(flagbegin==1)
		{
			flagbegin=0;
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/positive-words.txt");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			if(!positive_words.contains(currentline))
				positive_words.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/negative-words.txt");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			//currentline= currentline.toLowerCase();
			if(!negative_words.contains(currentline))
				negative_words.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/smileys");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			String[] toks= currentline.split(" ");
			for(int it=0;it< toks.length ; it++)
			{
				if(!smileys.contains(toks[it]))
					smileys.add(toks[it]);
			}
		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/emotions");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			if(currentline.length()!=1)
			{
				if(!emotions.contains(currentline))
					emotions.add(currentline);
			}
		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/swear_words");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			if(currentline.length()!=1)
			{
				if(!swear_words.contains(currentline))
					swear_words.add(currentline);
			}
		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/anger_words");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			if(currentline.length()!=1)
			{
				if(!swear_words.contains(currentline))
					swear_words.add(currentline);
			}
		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/top-10000.txt");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			if(!top_10000.contains(currentline))
				top_10000.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/top-20000.txt");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			currentline= currentline.toLowerCase();
			if(!top_20000.contains(currentline))
				top_20000.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/firstperson_singular");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			currentline= currentline.toLowerCase();
			if(!firstperson_singular.contains(currentline))
				firstperson_singular.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/firstperson_plural");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			//currentline= currentline.toLowerCase();
			if(!firstperson_plural.contains(currentline))
				firstperson_plural.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/secondperson");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			//currentline= currentline.toLowerCase();
			if(!secondperson.contains(currentline))
				secondperson.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/thirdperson_singular");

		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
			//currentline= currentline.toLowerCase();
			if(!thirdperson_singular.contains(currentline))
				thirdperson_singular.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/thirdperson_plural");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(!thirdperson_plural.contains(currentline))
				thirdperson_plural.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/indefinite_pronouns");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(!indefinite_pronouns.contains(currentline))
				indefinite_pronouns.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/future_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(!future_words.contains(currentline))
				future_words.add(currentline);

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/adverbs");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!adverbs.contains(currentline))
				adverbs.add(currentline);
			}
		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/prepositions");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!prepositions.contains(currentline))
				prepositions.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/conjunctions");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!conjunctions.contains(currentline))
				conjunctions.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/auxillaryverbs_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			
			if(!auxillary_verbs.contains(currentline))
				auxillary_verbs.add(currentline);
			
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/negations");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!negations.contains(currentline))
				negations.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/negations");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!quantifiers.contains(currentline))
				quantifiers.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/anxiety");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			
			if(!anxiety.contains(currentline))
				anxiety.add(currentline);
			
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/family_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!family_words.contains(currentline))
				family_words.add(currentline);
			
			}

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/happy");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!happy_words.contains(currentline))
				happy_words.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/body_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!body_words.contains(currentline))
				body_words.add(currentline);
			}
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/health_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			if(currentline.length()!=1)
			{
			if(!health_words.contains(currentline))
				health_words.add(currentline);
			}
			

		}
		br.close();
		fr.close();	
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/sadness_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			currentline= currentline.split(" ")[0];
			if(!sadness_words.contains(currentline))
				sadness_words.add(currentline);
			
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/job_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			currentline= currentline.split(" ")[0];
			if(!job_words.contains(currentline))
				job_words.add(currentline);
			
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/money_words");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			currentline= currentline.split(" ")[0];
			if(!money_words.contains(currentline))
				money_words.add(currentline);
					

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/achievement");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			
			if(!achievement.contains(currentline))
				achievement.add(currentline);
			
			

		}
		br.close();
		fr.close();
		fr= new FileReader("/home/navya/Downloads/mypersonality_final/death");
		br= new BufferedReader(fr);
		while ((currentline=br.readLine())!=null)
		{
			currentline= currentline.toLowerCase();
			currentline= currentline.replaceAll("\\s+" , "\\s");
			currentline= currentline.replaceAll("\\n+" , "\\n");
		//	currentline= currentline.toLowerCase();
			
			if(!death.contains(currentline))
				death.add(currentline);
			
			

		}
		br.close();
		fr.close();
		articles.add("the");
		articles.add("a");
		articles.add("an");
		}
	}
	//this will return the day given a date 
	public static int getDay(int year, int month ,int dd)
	{
		Date date= (new GregorianCalendar(year, month, dd)).getTime();
		SimpleDateFormat f = new SimpleDateFormat("EEEE");
		String day=f.format(date);
		// System.out.println(day);
		if(day.equals("Saturday") || day.equals("Sunday"))
		{
			return 1;
		}
		else return 0;

		//	     return day ;
	}
	public static HashMap<String , Integer[]> LIWC(ArrayList<String> text)
	{
		Integer[] language= new Integer[18];
		Integer[] affective= new Integer[6] ; 
		Integer[] social= new Integer[1] ; 
		Integer[] biology= {0,0} ; 
		Integer[] personal= {0,0,0,0} ; 
		Integer[] complexity = {0,0,0,0,0};
		Integer[] smiley = {0};
		social[0]=0;
		for(int i=0;i<18;i++) language[i]=0;
		for(int i=0;i<6;i++) affective[i]=0;
		HashMap<String , Integer[]> liwc = new HashMap<String , Integer[]>();
		for(int i=0; i< text.size();i++)
		{
			String temp= text.get(i).toLowerCase();
			temp= temp.replaceAll("\\.", "") ;
/*	if(firstperson_singular.contains(temp))
			{
			language[0]++;
			}
			if(firstperson_plural.contains(temp))
			{
			language[1]++;
			}
			if(secondperson.contains(temp))
			{
			language[2]++;
			}
			if(thirdperson_singular.contains(temp))
			{
			language[3]++;
			}
			if(thirdperson_plural.contains(temp))
			{
			language[4]++;
			}
			if(indefinite_pronouns.contains(temp))
			{
			language[5]++;
			}
			if(articles.contains(temp))
			{
			language[6]++;
			}
			if(future_words.contains(temp))
			{
			language[7]++;
			}
			if(auxillary_verbs.contains(temp))
			{
			language[8]++;
			}
			if(adverbs.contains(temp))
			{
			language[9]++;
			}
			if(prepositions.contains(temp))
			{
			language[10]++;
			}
			if(conjunctions.contains(temp))
			{
			language[11]++;
			}
			if(negations.contains(temp))
			{
			language[12]++;
			}
			if(quantifiers.contains(temp))
			{
			language[13]++;
			}
			if(swear_words.contains(temp))
			{
			language[14]++;
			}  
			*/
		if(positive_words.contains(temp))
				affective[0]++;
			if(negative_words.contains(temp))
				affective[1]++;
			if(sadness_words.contains(temp))
				affective[2]++;
			if(anger_words.contains(temp))
				affective[3]++;
			if(anxiety.contains(temp))
				affective[4]++;
			if(happy_words.contains(temp))
				affective[5]++;  
		if(family_words.contains(temp))
				social[0]++;  
			if(body_words.contains(temp))
				biology[0]++;
			if(health_words.contains(temp))
				biology[1]++;
			if(job_words.contains(temp))
				personal[0]++;
			if(money_words.contains(temp))
				personal[1]++;
			if(achievement.contains(temp))
				personal[2]++;
			if(death.contains(temp))
				personal[3]++;
		int rank =top_10000.indexOf(text.get(i));
			if(!(rank ==-1))
			{
				if(rank<=5000) complexity[0]++;
				else complexity[1]++;

			}
			else
			{

				rank =top_20000.indexOf(text.get(i));
				if(!(rank ==-1))
				{
					if(rank<=15000) complexity[2]++;
					else complexity[3]++;

				}
			}
			
			if(smileys.contains(text.get(i)))
				smiley[0]++;
		
			
		}
		liwc.put("language" , language);
		liwc.put("affective", affective);
		liwc.put("personal", personal);
		liwc.put("social", social);
		liwc.put("biology", biology);
		liwc.put("complexity", complexity);
		liwc.put("smileys", smiley);
		return liwc; 
		
		
	}
	//meta_features include number of punctutaions  ,  number of words in uppercase , number of words , average number of letters per word  . 
	public static int[] meta_features(String text)

	{

		char[] punct={'.',',','!' ,'?','"',':',';',',','/','-'};
		int[] count={0,0,0 , 0};
		int punct_count=0;
		int case_count=0;
		java.util.List punct_list = Arrays.asList(punct);
		for(int i=0; i< text.length();i++)
		{
			if(punct_list.contains(text.charAt(i)))	
			{

				punct_count++;
			}
			if(Character.isUpperCase(text.charAt(i)))
			{

				case_count++;
			}
		}
		count[0]= punct_count ;
		count[1]= case_count ;
		int len=text.length();
		count[2]= (text.split(" ")).length; 
		count[3]=len/count[2];
		return count;

	}
	public static int[] count_negative(ArrayList<String> text)
	{
		int pos=0;
		int neg=0;
		int i=0;
		int[] count={0,0,0,0,0,0,0,0,0,0} ; 

		for(i=0;i<text.size();i++)
		{
			text.set(i , text.get(i).toLowerCase()); 
			if(positive_words.contains(text.get(i)))
				count[0]++;
			if(negative_words.contains(text.get(i)))
				count[1]++;	
			
			if(text.get(i).contains("est")) count[6]++;

			if(swear_words.contains(text.get(i)))
				count[7]++;
			if(emotions.contains(text.get(i)))
				count[8]++;
			if(smileys.contains(text.get(i)))
				count[9]++;

		}
		//int[] count={pos,neg} ; 
		return count;

	}
	public static int[] tagText(String text) throws IOException
	{
		MaxentTagger tagger = new MaxentTagger("/home/navya/Downloads/stanford-postagger-2014-01-04/models/english-bidirectional-distsim.tagger");

		StringReader sr= new StringReader(text); // wrap your String
		BufferedReader br= new BufferedReader(sr);
		System.out.println(text);
		List<List<HasWord>> sentences =  tagger.tokenizeText(br);
		String ans="";
		for (List<HasWord> sentence : sentences) {
			ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
			ans =ans + (Sentence.listToString(tSentence, false));
		}
		//= Regex.Split(text, " +");
		String[]toks = ans.split("\\s+") ; 
		int[] count= new int[2];
		count[0]=0;
		count[1]=1;
		for(int i=0; i< toks.length ; i++)
		{
			String[] tags=toks[i].split("/");
			if(tags[1].equals("NNP")); 
			{
				count[0] +=1;

			}
			if(tags[1].equals("PRP")); 
			{
				count[1] +=1;

			}
		} 
		//	int[] count={0,0};

		//System.out.println(count[0]+"  "+count[1]);
		br.close();
		sr.close();
		return count;


	}


	public static void testdata()
	{

	}
	//you will mostly need to change only from line 462 .  ignore till line 462 . 
	public static void traindata( String train , String test, int index) throws IOException
	{
		//FileWriter fr = new FileWriter("/home/navya/Downloads/mypersonality_final/train_data.csv" , false);
		FileWriter fr = new FileWriter(train , false);
		BufferedWriter br = new BufferedWriter(fr);

		FileReader fr2= new FileReader("/home/navya/Downloads/mypersonality_final/mypersonality_final.csv");

		BufferedReader br2= new BufferedReader(fr2);
		String currentline="";
		currentline=br2.readLine() ; 
		String cur_user="" ; 
		int testflag=0;
		//HashMap<String ,int[]> pos_count= new HashMap<String ,int[]>();
		LinkedHashMap<String , ArrayList<String>> users= new LinkedHashMap<String ,  ArrayList<String>> ();
		HashMap<String , ArrayList<String>> network_features= new HashMap<String ,  ArrayList<String>> ();
		HashMap<String , ArrayList<String>> time_features= new HashMap<String ,  ArrayList<String>> ();
		HashMap<String , int[] > other_features= new HashMap<String , int[] >();
		int[] values={0,0,0,0,0,0,0};
		while ((currentline=br2.readLine())!=null)
		{





			//	 currentline= currentline.toLowerCase();
			String[] temp_tokens= currentline.split(",");
			int z=19;
			String[] tokens= new String[20];
			int ite= temp_tokens.length-1;
			while(z>1)
			{
				tokens[z]= temp_tokens[ite] ;
				z--;
				ite--;


			}
			tokens[0]=temp_tokens[0];
			tokens[1]=temp_tokens[1];
			for(int i=2; i<=ite ;i++)
			{

				tokens[1] += temp_tokens[i] ; 
			}

			
			String[] words = tokens[1].split(" ") ;
			int status_count=0;
			if(users.get(tokens[0]) ==null)
			{
				values= new int[6] ;
				for(int k=0;k<6;k++) values[k]=0;

				values[0]=1;
				other_features.put(tokens[0],values);
				ArrayList<String> words_user= new ArrayList<String> ();
				String label;
				if(tokens[index].equals("y"))
				{

					label="1";
				}
				else 
					label="0";
				words_user.add(label); 
				for (int i=0; i< words.length ; i++)
				{
					if(words[i].contains("http:"))
					{
						values = other_features.get(tokens[0]);
						values[5]++;
						other_features.put(tokens[0], values) ; 		
					}
					words_user.add(words[i]);

				}
				ArrayList<String> network= new ArrayList<String>();
				for(int iter=13; iter<19; iter++ )
				{
					network.add(tokens[iter]); 

				}

				network_features.put(tokens[0],network ) ; 
				ArrayList<String> time_user= new ArrayList<String> ();
				//System.out.println( "tie"+tokens[12]);
				String[] time_tokens=tokens[12].split(" ");

				time_user.add(time_tokens[0]+"&"+time_tokens[1]+"&"+time_tokens[2]); 
				time_features.put(tokens[0], time_user  ) ; 
				users.put(tokens[0],  words_user) ; 


			}
			else
			{

				values = other_features.get(tokens[0]);
				values[0]++;
				other_features.put(tokens[0], values) ; 
				ArrayList<String> words_user = users.get(tokens[0]);
				for (int i=0; i< words.length ; i++)
				{

					//System.out.println(words[i]);	
					//if(words[i].contains)
					int count_cap=0 ; 
					for(int y = 0; y <words[i].length(); y++){
						if(Character.isUpperCase(words[i].charAt(y))){
							count_cap++;
						}
					}
						if(count_cap > 0)
						{
							values= other_features.get(tokens[0]) ; 
							values[2] =values[2]+count_cap;
							other_features.put(tokens[0] ,values );
						}

						if(words[i].contains("http:"))
						{
							values = other_features.get(tokens[0]);
							values[5]++;
							other_features.put(tokens[0], values) ; 		
						}
						if(words[i].matches(".*[A-Z].*"))
						{
							values= other_features.get(tokens[0]) ; 
							values[1]++;
							other_features.put(tokens[0] ,values );

						}



						words_user.add(words[i])	;				 
					}
					ArrayList<String> time_user= time_features.get(tokens[0]); 
					// System.out.println("time"+tokens[12]);
					String[] time_tokens=tokens[12].split(" ");
					//System.out.println("hell"+ time_tokens[2]);
					time_user.add(time_tokens[0]+"&"+time_tokens[1]+"&"+time_tokens[2]); 
					time_features.put(tokens[0], time_user  ) ; 
					users.put(tokens[0],  words_user) ; 
				}

			}
			

			int tot=0;
			int flags=1;
			int testc=0;
			for (Entry<String, ArrayList<String>> entry : users.entrySet())
			{

				System.out.println(testc+"   "+entry.getKey());
				testc++;
				// System.out.println(entry.getKey());

				tot++;
				HashMap<String , Integer> count= new HashMap<String , Integer> ();
				String text="";

				for (int it=1 ; it < (entry.getValue()).size() ; it++)
				{
					text= text+entry.getValue().get(it)+" ";

					if(count.get(entry.getValue().get(it))==null)
					{

						count.put(entry.getValue().get(it),1);

						if(synonyms_list.get(entry.getValue().get(it))!=null)
						{
							if(count.get(synonyms_list.get(entry.getValue().get(it)))!=null)
								count.put(synonyms_list.get(entry.getValue().get(it)), count.get(synonyms_list.get(entry.getValue().get(it)))+1);
							else
								count.put(synonyms_list.get(entry.getValue().get(it)),1);	

						}

					}
					else
					{
						if(((count.get(entry.getValue().get(it))))==1)
						{


							values= other_features.get(entry.getKey()) ; 
							values[3]++;
							other_features.put(entry.getKey(),values );

						}
						count.put(entry.getValue().get(it),count.get(entry.getValue().get(it))+1);
					//	System.out.println("hell "+entry.getValue().get(it));
						if((synonyms_list.get(entry.getValue().get(it)))!=null)
						{
							if(count.get(synonyms_list.get(entry.getValue().get(it)))!=null)
								count.put(synonyms_list.get(entry.getValue().get(it)), count.get(synonyms_list.get(entry.getValue().get(it)))+1);
							else
								count.put(synonyms_list.get(entry.getValue().get(it)),1);	

						}
					}


				}
				if(count.get("*PROPNAME*")!=null || count.get("*PROPNAME*.")!=null)
				{
					
					
					if(count.get("*PROPNAME*.")!=null)
					{
						values= other_features.get(entry.getKey()) ; 

					values[4] +=count.get("*PROPNAME*.");
					
					
					other_features.put(entry.getKey() ,values );
					}
				}
				//int[] com= tagText(text);
				//System.out.println(com[0]+" "+com[1]);
				String line="";
				if(testflag==0)
				{
					line=entry.getValue().get(0)+" ";
				}
				else 
				{
					line="";
				}


				//this will find 10 features and returns their values .
				int[] meta_count= meta_features(text);
				text=text.replaceAll("\\.", " ");
				text=text.replaceAll("!", " ");
				HashMap<String , Integer[]> liwc = new  	HashMap<String , Integer[]>();
				liwc= LIWC(entry.getValue());
				//int[] sent_count= count_negative(entry.getValue()); 
				//meta_count will return  4  features  based on writing style 
				

				ArrayList<String> network=  network_features.get(entry.getKey());

				ArrayList<String> time=  time_features.get(entry.getKey());

				int[] time_fre= {0 , 0, 0, 0}; //time features based on time of the status 
				int [] day_fre={0,0}; // number of posts on weekends and weekdays 
				for (int j=0; j<time.size(); j++ )
				{
					//
					//System.out.println(time.get(j));
					String[] tokens= time.get(j).split("&"); 
					String[] toks_day=tokens[0].split("/");
					int month= Integer.parseInt(toks_day[0]);
					int date= Integer.parseInt(toks_day[1]);
					int year =  Integer.parseInt("20"+toks_day[2]);
					int day = getDay(year , month , date) ; 
					if(day==1)
					{
						day_fre[1]++;
					}
					else  day_fre[0]++;
					if (tokens[2].equals("AM"))
					{

						String[]  tokens_hour= tokens[1].split(":") ; 
						if(Integer.parseInt(tokens_hour[0]) <= 6)
						{
							time_fre[0]=time_fre[0]+1 ;

						}
						if(Integer.parseInt(tokens_hour[0]) > 6)
						{
							time_fre[1]=time_fre[1]+1 ;
						}

					}
					if (tokens[2].equals("PM"))
					{

						String[]  tokens_hour= tokens[1].split(":") ; 
						if(Integer.parseInt(tokens_hour[0]) <= 6)
						{
							time_fre[2]=time_fre[2]+1 ;


						}
						if(Integer.parseInt(tokens_hour[0]) > 6)
						{
							time_fre[3]=time_fre[3]+1 ;
						}

					}
				} 

				int it=0;
				//this will write the  50 features extracted
			
		for( it=0; it< ext.size(); it++)
				{
					if (count.get(ext.get(it))!=null)
					{
						line = line + (it+1)+":"+ count.get(ext.get(it))+" ";
					}
					else
					{
						line = line + (it+1)+":"+ 0 +" ";
			
					}
					
				} 


				//	int it;*/
				int 	length = ext.size();;
				
			/*	for(it=length;it <4+length ; it++)
				{
					line = line + (it+1)+":"+ time_fre[it-length]+" ";	
				}
			 length=4; */// 4 time features 
		
			
				//writing language features 
			Integer[] temp2 ;
		 temp2= liwc.get("language");
				for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length;  
				//writing affective features
			temp2= liwc.get("affective") ;  
				for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length; 
				
				//writing social features */
				temp2= liwc.get("social") ;
						
				for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				} 
				length= length + temp2.length;  
				//writing biology features */
	/*	temp2= liwc.get("biology") ;
				for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length;
		*/		
				//writing personal features
				temp2= liwc.get("personal") ;
								for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length; 
			
				
				//writing complexity features
				
				temp2= liwc.get("complexity") ;
								for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length;
				
				//writing smileys features
				temp2= liwc.get("smileys") ;
								for( it=length ; it< temp2.length + length ; it++)
				{
					line=line +(it+1)+":"+ temp2[it-length]+" ";
				}
				length= length + temp2.length;   
				
			//writing other features 
		
		/*		for( it=length; it <length +6  ; it++)
				{
					
					line = line + (it+1)+":"+ (other_features.get(entry.getKey()))[(it-length)] +" "; 
				}
				length=length+6;  
			*/
				line = line + (it+1)+":"+ day_fre[0]+" "+(it+2)+":"+ day_fre[1]+" ";
				it=it+2; 
				length=length+ 2;   // 2 features from day of the post */
				
				line = line + (it+1)+":"+ meta_count[0]+" "+(it+2)+":"+ meta_count[1]+" "+(it+3)+":"+ meta_count[2]+" "+(it+4)+":"+ meta_count[3]+" ";	
				
				length=length + 4 ; //  meta features 

				//writing network features 
				it=it+4 ; 
				
				//	int[] tags_count=tagText(text);
				//line = line + (it+1)+":"+ tags_count[0]+" "+(it+2)+":"+ tags_count[1]+" " ; 
				//length=length+2;
				 
	
			/*	for( it=length;it <length+network.size() ; it++)
				{

					if(it== length+network.size()-1)
					{
						line = line + (it+1)+":"+network.get(it - length);
					}
					else
					{
						line = line + (it+1)+":"+network.get(it-length)+" ";
					}
				}*/
				length= length+network.size();   
				br.write(line);
				br.newLine();	
				if(tot> 180 && flags==1)
				{
					//testflag=1;
					br.close();
					fr.close();

					fr = new FileWriter(test , false);
					br = new BufferedWriter(fr);
					flags=0;

				}
			}
			br2.close();
			fr2.close();
			br.close();
			fr.close();

		}
	
	public static void main(String[] args) throws IOException
	{
		/*getfeature_vectors("/home/navya/Downloads/mypersonality_final/ext_features");
		traindata( "/home/navya/Downloads/mypersonality_final/vectors2/ext_traindata","/home/navya/Downloads/mypersonality_final/vectors2/ext_testdata" ,7);
*/
	//	getfeature_vectors("/home/navya/Downloads/mypersonality_final/neu_features");
		//traindata( "/home/navya/Downloads/mypersonality_final/vectors2/neu_traindata","/home/navya/Downloads/mypersonality_final/vectors2/neu_testdata" ,8);
	//	getfeature_vectors("/home/navya/Downloads/mypersonality_final/agr_features");
		//traindata( "/home/navya/Downloads/mypersonality_final/vectors2/agr_traindata","/home/navya/Downloads/mypersonality_final/vectors2/agr_testdata" ,9);
	//	getfeature_vectors("/home/navya/Downloads/mypersonality_final/con_features");
	//	traindata( "/home/navya/Downloads/mypersonality_final/vectors2/con_traindata","/home/navya/Downloads/mypersonality_final/vectors2/con_testdata" ,10);
		getfeature_vectors("/home/navya/Downloads/mypersonality_final/opn_features");
		traindata( "/home/navya/Downloads/mypersonality_final/vectors2/opn_traindata","/home/navya/Downloads/mypersonality_final/vectors2/opn_testdata" ,11);

	}

}
