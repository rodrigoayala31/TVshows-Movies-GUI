/**
 * @author Rodrigo Ayala
 * @assignment CSC 202-Program Project 2
 * @version 04/02/2020
 * 
 * Description: This class represents a movie.
 * 
 * Cite Assistance (who and what):
 *
 *I did not get and give assistance for this project.
 *
 */
import java.util.*;

public class Movie extends VideoItem{
	
	public Movie(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {
		super(title, rating, length, numDownloads, ranking, numResponses);
	}
	
	//return a string representation of the movie showing the title
	public String toString() {
		return "\"" + super.getTitle() + "\"";
	}
	
	@Override
	public void setRating(String rating) {
		
		if (rating.equals("G") || rating.equals("PG") || rating.equals("PG-13") || rating.equals("R")) {
			super.setRating(rating);
		}
		else {
			throw new IllegalArgumentException("Invalid rating.");
		}
	}
	
	@Override
	public String getItemDetails() {
		return toString() + "\n" + super.getItemDetails();
	}
}

