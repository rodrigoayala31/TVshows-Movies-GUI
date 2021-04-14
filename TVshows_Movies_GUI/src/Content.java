/**
 * @author Rodrigo Ayala
 * @assignment CSC 202-Program Project 2
 * @version 04/02/2020
 * 
 * Description: Content.java implements a collection of VideoItems for on-line posting.
 * It provides methods to search for a video item given a phrase in its title and to
 * find the top-ranked item.
 * 
 * Citations of Assistance (who and what):
 * 
 * I did not get and give assistance for this project.
 * 
 */

import java.util.ArrayList;

public class Content {

	private String name; // the name of the content
	private ArrayList<VideoItem> items; // the items

	
	/**Creates a Content object with hard coded items */
	public Content(String name) {
		this.name = name;		
	    
		// Movies and TV Series
		items = new ArrayList<VideoItem>();
		items.add(new Movie("Amadeus", "PG", 160, 100,8, 45));
		items.add(new Movie("Forrest Gump", "PG-13", 142, 45, 8.7, 30)); 
		
		int[] sherlockNumEpisodesPerSeason =  {3, 4}; // array of 2 integers, 3 and 3
		TVSeries sherlock = new TVSeries("Sherlock", sherlockNumEpisodesPerSeason);		
		
		items.add(new Episode(sherlock, 
					"TV-14", 90, 1, 1, "A Study in Pink", 56, 6, 20));
		items.add(new Episode(sherlock, "TV-14", 90, 1, 2,				
				"The Blind Banker", 35, 5.5, 2));
		
		
		items.add(new Movie("Invictus", "PG-13", 134, 18, 5.5, 3));
		
		int[] ncisLANumEpisodesPerSeason =  {23,23,24,24,19,25,24,24,24,24,24,24,24,24}; 
		TVSeries ncisLA = new TVSeries("NCIS-LA", ncisLANumEpisodesPerSeason);		
		
		items.add(new Episode(ncisLA, "TV-14", 41, 7, 5, "Blame it on Rio", 123, 10, 20));
		items.add(new Episode(ncisLA, "TV-14", 43, 7, 6, "Unspoken", 111, 5.5, 2));
		
		items.add(new Movie("Schindler's List", "R", 195, 76, 5.5, 3));
		
		items.add(new Movie("Emoji Movie", "PG", 86, 42, 1.5, 8));
		
		items.add(new Movie("Solomon Kane", "R", 104, 69, 5.5, 3));
		
		items.add(new Movie("Lincoln", "PG-13", 149, 85, 5.5, 3));
		
		items.add(new Episode(ncisLA, "TV-14", 40, 14, 22, "Beastmaster", 34, 5.5, 2));
		
		items.add(new Episode(ncisLA, "TV-14", 41, 14, 23, "Rendezvous", 111, 5.5, 2));
		
		int[] thirteenNumEpisodesPerSeason =  {13}; 
		TVSeries thirteen = new TVSeries("13 Reasons Why", thirteenNumEpisodesPerSeason);		
		
		items.add(new Episode(thirteen, "TV-14", 48, 1, 1, "Tape 1, Side A", 26, 6, 10));
		items.add(new Episode(thirteen, "TV-14", 55, 1, 2, "Tape 1, Side B", 21, 6, 11));
		items.add(new Episode(thirteen, "TV-14", 51, 1, 3, "Tape 2, Side A", 19, 6, 9));
		
	}
	
	/**
	 *@return a short string description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.size(); i++) {
			result += items.get(i).toString() + "\n";
		}
		return result;
	}

	/**
	 *@return an array of all of the video items
	 */
	
	public ArrayList<VideoItem> getItems() {
		return items;
	}

	/**
	 * Provides the name of the collection of video items
	 *@return the name of the collection of video items
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * searches for a video item with a title that contains
	 * the identified search phrase
	 * @param searchPhrase - the phrase which is being searched for
	 * @return the first video item with the searchPhrase in its title
	 */
	// TODO findVideoItem
	
	public VideoItem findVideoItem(String searchPhrase) {
		
		VideoItem returnVideo = null;
		
		for (int i = 0; i < items.size(); i++) {
			String copyTitle = items.get(i).getTitle();
			if (copyTitle.toLowerCase().contains(searchPhrase.toLowerCase())) {
				returnVideo = items.get(i);
			}
		}
		return returnVideo;
	}
	

	/**
	 * finds the video item with the highest rank
	 * @return the VideoItem with the highest rank or the first encountered
	 * if more than one item has the same highest rank
	 */
	//TODO topRanked
	
	public VideoItem topRanked() {
		
		double maxRank = 0;
		VideoItem maxRankVideo = null;
		
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getRanking() > maxRank) {
				maxRank = items.get(i).getRanking();
				maxRankVideo = items.get(i);
			}
		}
		return maxRankVideo;
	}
	
}
