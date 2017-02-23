/**
 * 
 */
package alg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author ak
 *
 */
class Movie implements Comparable <Movie>
{
	@Override
	public String toString ()
	{
		return "Movie [movieId=" + movieId + ", rating=" + rating + "]";
	}

	int movieId;
	float rating;
	boolean visited;
	List <Movie> similarMovies; // Similarity is bidirectional

	public Movie (int movieId, float rating)
	{
		this.movieId = movieId;
		this.rating = rating;
		similarMovies = new ArrayList <Movie> ();
	}

	public int getId ()
	{
		return movieId;
	}

	public float getRating ()
	{
		return rating;
	}

	public void addSimilarMovie (Movie movie)
	{
		similarMovies.add (movie);
		movie.similarMovies.add (this);
	}

	public List <Movie> getSimilarMovies ()
	{
		return similarMovies;
	}

	/*
	 * Implement a function to return top rated movies in the network of movies
	 * reachable from the current movie eg:
	 * 			A(Rating 1.2)
	 * 				 / \
	 * 		   B(2.4)  C(3.6)
	 * 				 \ /
	 * 			   D(4.8)
	 * In the above example edges represent similarity and the number is
	 * rating. getMovieRecommendations(A,2)should return C and D (sorting order
	 * doesn't matter so it can also return D and C)
	 * getMovieRecommendations(A,4) should return A, B, C, D (it can also return
	 * these in any order eg: B,C,D,A) getMovieRecommendations(A,1) should
	 * return D. Note distance from A to D doesn't matter, return the highest
	 * rated.
	 * 
	 * @param movie
	 * 
	 * @param numTopRatedSimilarMovies number of movies we want to return
	 * 
	 * @return List of top rated similar movies
	 */
	public static List <Movie> getMovieRecommendations (Movie movie,
			int numTopRatedSimilarMovies)
	{
		long start = System.currentTimeMillis();
		List <Movie> movies = new ArrayList <Movie> ();
		int time = 0;
		if (movie != null)
		{
			SortedSet <Movie> set = new TreeSet <Movie> ();
			time = dfsGet (movie, set, numTopRatedSimilarMovies);
			for (Movie m: set)
			{
				movies.add (m);
			}
		}
		Logger.log("O()={}: k={}, actualTime: {}", time, numTopRatedSimilarMovies,
			(System.currentTimeMillis() - start));
		return movies;
	}
	/**
	 * BFS traversal
	 * @param movie
	 * @param set
	 * @param k
	 * @return
	 */
	private static int bfsGet (Movie movie, SortedSet <Movie> set, int k)
	{
		int time = 0;
		//use queue to prevent stack overflow (use heap to replace stack memory usage)
		Queue <Movie> q = new LinkedList <Movie> ();
		q.add(movie);
		while (!q.isEmpty())
		{
			Movie current = q.poll();
			for (Movie m: current.similarMovies)
			{
				time ++;
				if (m.visited)
				{//pass visited node
					continue;
				}
				if (set.size () < k)
				{
					set.add (m);
					time += (int) (Math.log(set.size()) / Math.log(2));
				}
				else if (!set.contains(m) && set.first ().rating < m.rating)
				{
					set.remove (set.first ());
					set.add (m);
					time += (int) (Math.log(set.size()) / Math.log(2));
				}
				m.visited = true;
				//Logger.log("print movie: {}", m);
				q.add(m);
			}
		}
		return time;
	}
	

	private static int dfsGet (Movie movie, SortedSet <Movie> set, int k)
	{
		int time = 0;
		//use deque to prevent stack overflow and provides element in/out function at both ends
		Deque <Movie> q = new ArrayDeque <Movie> ();
		q.add(movie);
		while (!q.isEmpty())
		{
			Movie current = q.pop();
			for (Movie m: current.similarMovies)
			{
				time ++;
				if (m.visited)
				{
					continue;
				}
				if (set.size () < k)
				{
					set.add (m);
					time += (int) (Math.log(set.size()) / Math.log(2));
				}
				else if (!set.contains(m) && set.first ().rating < m.rating)
				{
					set.remove (set.first ());
					set.add (m);
					time += (int) (Math.log(set.size()) / Math.log(2));
				}
				m.visited = true;
				Logger.log("print movie: {}", m);
				q.push(m);
			}
		}
		return time;
	}

	@Override
	public int compareTo (Movie o)
	{
		if (getRating () - o.getRating () > 0)
		{
			return 1;
		}
		else if (getRating () - o.getRating () == 0)
		{
			return 0;
		}
		else return -1;
	}
}

public class Graph
{

	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		int movieId = 0;
		Movie m1 = new Movie (movieId ++, 1.2f);
		Movie m2 = new Movie (movieId ++, 2.4f);
		Movie m3 = new Movie (movieId ++, 3.6f);
		Movie m4 = new Movie (movieId ++, 4.8f);
		Movie m5 = new Movie (movieId ++, 3.2f);
		Movie m6 = new Movie (movieId ++, 5.8f);
		Movie m7 = new Movie (movieId ++, 2.7f);
		Movie m8 = new Movie (movieId ++, 3.8f);
		m1.addSimilarMovie (m2);
		m1.addSimilarMovie (m3);

		m2.addSimilarMovie (m1);
		m2.addSimilarMovie (m3);

		m3.addSimilarMovie (m1);
		m3.addSimilarMovie (m4);
		
		m4.addSimilarMovie (m2);
		m4.addSimilarMovie (m3);
		
		m5.addSimilarMovie (m4);
		m5.addSimilarMovie (m6);
		m6.addSimilarMovie (m5);
		m6.addSimilarMovie (m7);
		m7.addSimilarMovie (m6);
		m7.addSimilarMovie (m8);
		m8.addSimilarMovie (m7);
		m8.addSimilarMovie (m4);
		

		Random rating = new Random ();

		Movie currentMovie = m1;
		while (movieId < 100) {
			Movie newMovie = new Movie (movieId++, (float)rating.nextFloat() * 5);
			currentMovie.addSimilarMovie (newMovie);
			newMovie.addSimilarMovie(currentMovie);
			currentMovie = newMovie;
		}
		
		Logger.log(Movie.getMovieRecommendations (m1, 3));
	}

}
