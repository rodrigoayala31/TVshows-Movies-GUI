/**
 * @author Rodrigo Ayala
 * @assignment CSC 202-Program Project 2
 * @version 04/02/2020
 * 
 * Description: This class represents a TV series with a title
 * and the number of episodes per season
 * 
 * Cite Assistance (who and what):
 *
 *I did not get and give assistance for this project.
 *
 */
public class TVSeries {
	
	private String title;
	private int[] numEpisodesInSeason;
	
	public TVSeries(String title, int[] numEpisodesInSeason){
		
		this.numEpisodesInSeason = numEpisodesInSeason;
		this.title = title;
	}
	
	//return title of the tv series
	public String getTitle() {
		return this.title;
	}
	
	//return the number of seasons in the series
	public int getNumSeasons() {
		return this.numEpisodesInSeason.length;
	}
	
	//return the number of episodes of a particular season
	// param season number
	public int getNumEpisodesInSeason(int seasonNumber) {
		
		if (seasonNumber < 1 || seasonNumber > (getNumSeasons())) {
			throw new IllegalArgumentException("Season number invalid.");
		}
		else {
			return this.numEpisodesInSeason[seasonNumber - 1];
		}	
	}
	//return a String representation of the series with title, season number and number of episodes in the season
	public String toString() {
		String result = "\"" + getTitle() + "\" TV Series \n";
		
		for (int i = 0; i < getNumSeasons(); i++) {
			result = result + "        Season " + (i + 1) + " has " + this.numEpisodesInSeason[i] + " episodes. " +  "\n";
		}
		return result;
	}
	
}
