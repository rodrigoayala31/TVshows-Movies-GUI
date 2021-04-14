/**
 * @author Rodrigo Ayala
 * @assignment CSC 202-Program Project 2
 * @version 04/02/2020
 * 
 * Description: This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 * 
 * Cite Assistance (who and what):
 *
 *I did not get and give assistance for this project.
 *
 */
import javax.swing.JOptionPane;

public class Episode extends VideoItem{

	private TVSeries series;
	private int episodeNumber;
	private int seasonNumber;
	
	public Episode(TVSeries series, String rating, int length, int seasonNumber, int episodeNumber, String title, int numDownloads, double ranking, int numResponses) {
		super(title, rating, length, numDownloads, ranking, numResponses);
		this.series = series;
		
		if (seasonNumber < 1 || seasonNumber > series.getNumSeasons()) {
			throw new IllegalArgumentException("Invalid season number");
		}
		else {
			this.seasonNumber = seasonNumber;
		}
		
		if (episodeNumber < 1 || episodeNumber > series.getNumEpisodesInSeason(seasonNumber)) {
			throw new IllegalArgumentException("Invalid episode number");
		}
		else {
			this.episodeNumber = episodeNumber;
		}
	}
	
	//return the episode number
	public int getEpisodeNum() {
		return this.episodeNumber;
	}
	
	//return the tv series object
	public TVSeries getSeries() {
		return this.series;
	}
	
	//return the season number
	public int getSeason() {
		return this.seasonNumber;
	}
	
	//return the number of episodes left in the season
	public int episodesLeftThisSeason() {
		return series.getNumEpisodesInSeason(seasonNumber) - getEpisodeNum();
	}
	
	//return a string representation of the episode with title of the series, season number and episode number
	public String toString() {
		return "\"" + series.getTitle() + "\" Season " + getSeason() + ", Episode: " + getEpisodeNum() + " ";
	}
	
	@Override
	public void setRating(String rating) {
		
		if (rating.equals("TV-MA") || rating.equals("TV-14") || rating.equals("TV-PG") || rating.equals("TV-G")) {
			super.setRating(rating);
		}
		else {
			throw new IllegalArgumentException("Invalid rating.");
		}
	}
	
	@Override
	public String getFullTitle() {
		return toString() + super.getFullTitle();
	}
	
	@Override
	public String getItemDetails() {
		return "\"" + series.getTitle() + "\"\n Season " + getSeason() + ", Episode " + getEpisodeNum() + "\n" + super.getFullTitle() + "\n" + super.getItemDetails();  
	}
	
	@Override
	public void download() {
		super.download();
		
		if (episodesLeftThisSeason() >= 1) {
			JOptionPane.showMessageDialog(null, episodesLeftThisSeason() + " episodes left this season.");
		}
		else {
			JOptionPane.showMessageDialog(null, "No episodes left in this season.");
		}
		
	}
	
}
