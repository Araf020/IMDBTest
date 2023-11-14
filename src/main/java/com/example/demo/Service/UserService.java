package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Filter.SearchFilter;
import com.example.demo.Model.Actor;
import com.example.demo.Model.Movie;
import com.example.demo.Model.User;
import com.example.demo.Repository.MovieRepo;
import com.example.demo.Repository.UserRepo;

@Service
public class UserService {
    
    private UserRepo userRepo;
    private MovieRepo movieRepo;
    public UserService(UserRepo userRepo,MovieRepo movieRepo)
    {
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
    }

    public User register(String email, String password)
    {
        User usr = new User();
        usr.setEmailAddress(email);
        usr.setPassword(password);
        return userRepo.save(usr);
    }


    public Movie getMovieDetailsById(Long movieId)
    {
        return movieRepo.findById(movieId).get();
    }


    public boolean addMovieTofavouriteList(Long userId, Long movieId)
    {
        Movie movie = movieRepo.findById(movieId).get();
        User usr = userRepo.findById(userId).get();

        movie.setUser(usr);
        try{
            movieRepo.save(movie); 
            return true; 
        }
        catch(Exception e)
        {
           throw e;
        }      


    }

    public boolean removeFromFavouriteList(Long userId, Long movieId)
    {
        User usr = userRepo.findById(userId).get();
        return usr.removeFromFavouriteList(movieId);

    }

    public User getUserDetails(Long userId)
    {
        return userRepo.findById(userId).get();
    }


    private List<Movie> searchFavMovieByTitle(Long UserId, String title)
    {
        List<Movie> favList= getUserFavList(UserId);
        List<Movie> result = new ArrayList<>();
        for (Movie  mv : favList) {
            if(mv.getTitle().equals(title))
                result.add(mv);
        }
        return result;
    }

    private List<Movie> searchFavMovieByCategory(Long userId, String cat) 
    {
        List<Movie> favList= getUserFavList(userId);
        List<Movie> result = new ArrayList<>();
        for (Movie  mv : favList) {
            if(mv.getCategory().equals(cat))
                result.add(mv);
        }
        return result;
    }

    private List<Movie> searchByCast(Long userId, String castName)
    {
         List<Movie> favList= getUserFavList(userId);
        List<Movie> result = new ArrayList<>();

        for (Movie  mv : favList) {
            List<Actor> casts  = mv.getCastList();
            for (Actor cast : casts) {
                if(cast.getActorname().contains(castName))
                    result.add(mv);
            }
            

        }
        return result;
    }

    public List<Movie> getUserFavList(Long userId)
    {
        List<Movie> favList= userRepo.findById(userId).get().getFavouriteMovies();
        return favList;
    }

    public List<Movie>  searchMovie(SearchFilter filter, Long userId)
    {
        if(filter.searchByTitle)
        {
            return searchFavMovieByTitle(userId, filter.title);
        }
        else if(filter.searchByCategory)
           return searchFavMovieByCategory(userId, filter.category);

        else
            return searchByCast(userId,filter.castName);


    }




}
