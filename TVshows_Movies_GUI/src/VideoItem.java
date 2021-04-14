
/**
 * @author Rodrigo Ayala
 * @assignment CSC 202-Program Project 2
 * @version 04/02/2020
 * 
 * Description: Represents a video content item for on-line downloading.
 * Includes attributes common to movies and tv-episodes
 * 
 * Citations of Assistance (who and what):
 * 
 * I did not get and give assistance for this project.
 */
import java.util.*;

public abstract class VideoItem {

	// maximum ranking value
	public final static int MAX_RANKING = 10;

	private String title;
	private int lengthMin;
	private String rating; // "R", "G", etc for movies, "TV-12", "TV-7", etc for
							// series
	private int numDownloads;
	private double ranking;
	private int numResponses;

	/**
	 * Constructs a video item object. 
	 * @param title-
	 *            the title of this video item
	 * @param rating-
	 *            the rating (R, TV-13, etc) of this video item
	 * @param length-
	 *            the length of this video item in minutes
	 * @param numDownloads-
	 *            the number of times this video item has been downloaded
	 * @param ranking-
	 *            the rank of the item 0-10 by responders
	 * @param numResponses-
	 *            the number of people who have ranked this video item
	 */
	public VideoItem(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {

		this.title = title;
		this.rating = rating;
		this.lengthMin = length;
		this.numDownloads = numDownloads;
		setRanking(ranking, numResponses);

	}

	/**
	 * Provides the title of this video
	 * @return the title of this video item
	 */
	public String getTitle() {
		return title ;
	}

	/**
	 * Provides the rating (PG, etc.) for this video item
	 * @return the rating for this video item
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Provides the "full" title of this video item, including the series if a TV series
	 *         episode, surrounded by quotes
	 * @return the "full" title of this video item
	 */
	public String getFullTitle() {
		String str = "\"" + title + "\"";
		return str;
	}

	/**
	 * Provides the details of this video item (ranking, rating, length, number
	 * of downloads) excluding the title
	 * @return the details of this video item excluding the title
	 */
	public String getItemDetails() {
		String text = "";
		text += getRankingString();
		text += "\n\trated: " + rating;
		text += "\n\tlength: " + lengthMin;
		text += "\n\tdownloads: " + numDownloads;
		return text;
	}

	/**
	 * Provides the ranking of this video 0-10 to the nearest tenth
	 * @return the ranking of this video item
	 */
	public double getRanking() {
		double rank = Math.round(ranking * 10) / 10.0;
		return rank;
	}

	/**
	 * Provides the length of this video in minutes
	 * @return the length of this video item
	 */
	public int getLengthMin() {
		return lengthMin;
	}

	/**
	 * Provides the number of times this video item has been downloaded
	 * @return the number of times downloaded
	 */
	public int getNumDownloads() {
		return numDownloads;
	}

	/**
	 * Increments the downloads counter of this video item
	 */
	public void download() {
		numDownloads++;
	}

	/**
	 * Provides a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING. For example,
	 *         ***      (3/10)
	 * @return a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING
	 */
	//TODO getRankingString
	
	public String getRankingString() {
		
		long newRanking = Math.round(ranking);
		String asterisks = "";
		
		for (int i = 0; i < newRanking; i++) {
			asterisks = asterisks + "*";
		}
		
		for (int i = 0; i < 10 - newRanking; i++) {
			asterisks = asterisks + " ";
		}
		
		return asterisks + "(" + newRanking + "/" + MAX_RANKING + ") based on " + numResponses + " responses"; 
	}
	
	

	/**
	 * Sets the rating (PG, etc) for this video item
	 * 
	 * @param rating
	 *            - the rating to be stored for this video item
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Sets the rank and number of responses creating that rank
	 * 
	 * @param rank
	 *            - the ranking of this video item
	 * @param numResponses
	 *            - the number of times this video item has been ranked
	 * @throws IllegalArgumentException
	 *             if the rank is invalid or the number of responses is negative
	 */
	// TODO setRanking
	
	public void setRanking(double ranking, int numResponses) {
		
		if (ranking < 0 || ranking > 10) {
			throw new IllegalArgumentException("Invalid rank data.");
		}
		if (numResponses <= 0) {
			throw new IllegalArgumentException("Invalid number of responses.");
		}
		else {
			this.ranking = ranking;
			this.numResponses = numResponses;
		}
	}

	
	/**
	 * Updates the ranking for this video item to include this new rank if the
	 * new rank data is valid
	 * 
	 * @param newRank
	 *            - another rank to be included in this video item's rank
	 * @throws IllegalArgumentException
	 *             if the new rank data is invalid
	 */
	// TODO processAnotherRanking
	
	public void processAnotherRanking(int additionalRanking) {
		
		if (additionalRanking < 0 || additionalRanking > 10) {
			throw new IllegalArgumentException("Invalid rank data.");
		}
		else {
			ranking = (ranking * numResponses + additionalRanking) / (numResponses + 1);
			numResponses = numResponses + 1;
		}
	}
	

	/**
	 * Provides a String representation of this video item including its title
	 * and ranking to the nearest tenth
	 * @return a String representation of this video item
	 */
	@Override
	public String toString() {
		String str = "\"" + title + "\" ranking " + getRanking();
		return str;
	}

}
