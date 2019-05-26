/**
 * 
 */
package com.tcs.ilp.ghy.G06.beans;


/**
* The descriptive text that explaining the purpose and use of the class.
      * @author : 
      * @version : 1     
      * @Class name :UpcominMovie
      * @Creation Date :	
     * @ History : UpcominMovie class is created for accepting the upcoming movie details  
*/
public class UpcominMovie {
	
	public UpcominMovie(int movieId, String movieName, String movieLanguage,
			String date, String month, String year) {
		
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.date = date;
		this.month = month;
		this.year = year;
	}

	private int movieId=0;
	private String movieName=null;
	private String movieLanguage=null;
	private String date=null;
	private String month=null;
	private String year=null;
	private String calenderDate=null;
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public UpcominMovie() {
		// TODO Auto-generated constructor stub
	}

	public void setMovieId(int movieId){
		this.movieId = movieId;
	
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public int getMovieId() {
		return movieId;
	}

 	public String getMovieName() {
		return movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public String getCalenderDate() {
		calenderDate=this.date+"-"+this.month+"-"+this.year;
		return calenderDate;
	}

	public void setCalenderDate(String calenderDate) {
		this.calenderDate = calenderDate;
	}
	

	/**
	 * 
	 */


	/**
	 * @param args
	 */
	

}
