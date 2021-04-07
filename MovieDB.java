import java.util.Scanner;
public class MovieDB {

	public static void main(String args[]) {
		int[] movierating = new int[10];
		Movie[] movies = new Movie[10];
		String[] comments = new String[10];
		int[] commentlikes = new int[10];
		int ID = 1;
		boolean exit = false;
		int firstmenusel;
		int secmenusel;
		String username;
		String password;
		Scanner input = new Scanner(System.in);
		//Rating = Maturity level, userrating = Rating given by user (1-10), movierating = ratings array given by users
		String title, description, actors, director, year, rating, comment;
		double boxoffice;
		boolean found = false;
		int exitinput, userrating, likes, commentsel;
		
		//Loop until menu exited
		do {
			//Display Main Menu
			
			System.out.println("Main Menu");
			System.out.println("1) Admin Menu");
			System.out.println("2) User Menu");
			System.out.println("3) Display all movies");
			System.out.println("4) Exit");
			
			firstmenusel = input.nextInt();
			while (firstmenusel < 1 || firstmenusel > 4) {
				System.out.println("Please enter a valid selection");
				firstmenusel = input.nextInt();
			}
			switch(firstmenusel) {
			//Admin Menu
			case 1:
				System.out.println("Please Enter the Username");
				username = input.next();
				System.out.println("Please enter the password");
				password = input.next();
				if (username.equals("admin") && password.equals("password")) {
					//Admin Menu display
					System.out.println("Admin Menu");
					System.out.println("1) Add New Movie");
					System.out.println("2) Update Movie");
					System.out.println("3) Delete Movie");
					System.out.println("4) Return to Main Menu");
					secmenusel = input.nextInt();
					while (secmenusel < 1 || secmenusel > 4) {
						System.out.println("Please enter a valid selection");
						secmenusel = input.nextInt();
					}
					//Admin Menu selection
					switch(secmenusel) {
					case 1:
						System.out.println("Enter title");
						title = input.next();
						System.out.println("Enter a description");
						description = input.nextLine();
						input.nextLine();
						System.out.println("Enter 3 (Or less) Actors");
						actors = input.nextLine();
						//input.nextLine();
						System.out.println("Enter the Director's name");
						director = input.nextLine();
						//input.nextLine();
						System.out.println("Enter the year of release");
						year = input.next();
						//input.nextLine();
						System.out.println("Enter the movie's MPAA Rating");
						rating = input.next();
						//input.nextLine();
						System.out.println("Enter the movie's box office gross");
						boxoffice = input.nextDouble();
						
						found = false;
						//Loop through Movie array
						for (int i = 0; i < movies.length; i++) {
							//If this is a valid element
							if (movies[i] == null) {
								movies[i] = new Movie(ID++, title, description, actors, director, year, rating, boxoffice);
								found = true;
								break;
							}
						}
						if (!found) {
							System.out.println("Database full!");
						}
					//End Admin case 1
					break;
					case 2:
						for(int i = 0; i < movies.length; i++) {
							//Print movie titles
							if (movies[i] != null) {
								System.out.println((i) + " " + movies[i].getTitle());
								break;
							}
						}
						System.out.println("Please select a movie to edit: ");
						int moviesel = input.nextInt();
						System.out.println("Enter title");
						title = input.next();
						System.out.println("Enter a description");
						description = input.nextLine();
						input.nextLine();
						System.out.println("Enter 3 (Or less) Actors");
						actors = input.nextLine();
						System.out.println("Enter the Director's name");
						director = input.nextLine();
						System.out.println("Enter the year of release");
						year = input.next();
						System.out.println("Enter the movie's MPAA Rating");
						rating = input.next();
						System.out.println("Enter the movie's box office gross");
						boxoffice = input.nextDouble();
						for (int i = 0; i < movies.length; i++) {
							//If it's an existing movie
							if (movies[i] != null) {
								movies[i] =  new Movie(ID++, title, description, actors, director, year, rating, boxoffice);
								break;
							}
						}
								
							
					break;
					case 3:
						System.out.println("Current movies in database:");
						//Loop through array
						for(int i = 0; i < movies.length; i++) {
							//Print movie titles
							if (movies[i] != null) {
								System.out.println((i) + " " + movies[i].getTitle());
							}
						}
						// Select movie 
						System.out.println("Please enter movie ID to remove:");
						int i = input.nextInt();
						if (movies[i] != null) {
							System.out.println(movies[i].getTitle() + " will be deleted, press 1 to confirm.");
							int removeconfirm = input.nextInt();
							if(removeconfirm == 1) {
								movies[i] = null;
								System.out.println("Movie successfully removed.");
							}
							else {
								
							}
						}
					//End admin Case 3
					break;
					case 4:
						break;
					}
				}
				else {
					
				}
			break;
			//User Menu
			case 2:
				System.out.println("User Menu");
				System.out.println("1) Search Movies");
				System.out.println("2) Rate Movie");
				System.out.println("3) Add Comment to movie");
				System.out.println("4) Like a Comment");
				System.out.println("5) Return to main menu");
				secmenusel = input.nextInt();
				while (secmenusel < 1 || secmenusel > 5) {
					System.out.println("Please enter a valid selection");
					secmenusel = input.nextInt();
				}
				switch(secmenusel) {
				
					case 1:
						for (int i = 0; i < movies.length; i++) {
							if (movies[i] != null) {
								movies[i].getTitle();
								System.out.println("Please enter the search term: ");
								String searchterm = input.next();
								if(movies[i].getTitle().equals(searchterm)) {
									System.out.println("Movies matching search term: ");
									System.out.println((i + 1) + " " + movies[i].getTitle());
									break;
								}
								else {
									System.out.println("No movies found matching search term");
									break;
								}
							}
						}
					break;
					case 2:
						for (int i = 0; i < movies.length; i++) {
							if (movies[i] != null) {
								System.out.println("Current movies available to rate: ");
								System.out.println((i) + " " + movies[i].getTitle());
								System.out.println("Please select a movie number to rate");
								int moviesel = input.nextInt();
								System.out.println("Please enter a rating (1-10) for " + movies[moviesel].getTitle());
								userrating = input.nextInt();
								if (userrating < 1 || userrating > 10) {
									System.out.println("Please enter a valid rating 1-10: ");
									userrating = input.nextInt();
									break;
								}
								else {
									movierating[moviesel] = userrating;
									System.out.println("Rating successfully added");
									break;
								}
							}
						}
					
					//End Rate Movie
					break;
					case 3:
						for (int i = 0; i < movies.length; i++) {
							if (movies[i] != null) {
								System.out.println("Current movies available for comment: ");
								System.out.println((i) + " " + movies[i].getTitle());
								System.out.println("Please select a movie number on which to comment");
								int moviesel = input.nextInt();
								System.out.println("Please enter a comment for " + movies[moviesel].getTitle());
								comment = input.next();
								comments[moviesel] = comment;
								System.out.println("Comment successfully added.");
								break;
							}
						}
					//End add comment
					break;
					case 4:
					 for (int i = 0; i < movies.length; i++) {
						 if(movies[i] != null) {
							 int count = 0;
							 System.out.println("Select a movie number to view/like comments of: ");
							 System.out.println((i) + " " + movies[i].getTitle());
							 int moviesel = input.nextInt();
							 System.out.println((i) + " " + comments[moviesel] + " Likes: " + commentlikes[i]); 
							 System.out.println("Please select a comment to like.");
							 commentsel = input.nextInt();
							 commentlikes[commentsel] = count + 1;
							 System.out.println("Comment successfully liked!");
							 break;
							 
						 }
					 }
					//End like comment
					break;
					case 5:
					//Return to main menu
					break;
				
				}
			break;
			//Display all Movies
			case 3:
				System.out.println("Current movies in database:");
				//Loop through array
				for(int i = 0; i < movies.length; i++) {
					//Print movie titles
					if (movies[i] != null) {
						System.out.println((i + 1) + " " + movies[i].getTitle());
					}
				}
				break;
			//Exit Menu
			case 4:
				System.out.println("Are you sure you want to exit? Enter 1 to exit");
				exitinput = input.nextInt();
				if (exitinput == 1) {
					System.out.println("Goodbye");
					exit = true;
				}
				else {
					
				}
			break;	
			}
			//break;
		//Exit Do While loop
		}while(!exit);
	}

	
}

class Movie{
	public Scanner input = new Scanner(System.in);
	private String title, description, actors, director, year, rating;
	private double boxoffice;
	private int ID, userrating;

	public Movie(int ID, String title, String description, String actors, String director, String year, String rating, double boxoffice) {
		//this.nextID = nextID;
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.actors = actors;
		this.director = director;
		this.year = year;
		this.rating = rating;
		this.boxoffice = boxoffice;
	}
	
	public String getTitle() {
		return title;
	}
	public void addRating(int userrating) {
		this.userrating = userrating;
		
	}
}
class Comments{
	public Scanner input = new Scanner(System.in);
	private String comment;
	private int likes;
	
	public void addComment(String comment) {
		this.comment = comment;
	}
	public void addLike(int likes) {
		this.likes = likes;
	}
}