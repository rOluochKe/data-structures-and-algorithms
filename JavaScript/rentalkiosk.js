class Movie {
  constructor(title, available) {
    this.title = title;
    this.available = available;
  }
}

class RentalKiosk {
  constructor() {
    this.movies = [
      new Movie("Movie1", true),
      new Movie("Movie2", true),
      new Movie("Movie3", true),
    ];
    this.rentedMovies = [];
  }

  rentMovie(title) {
    let movieIndex = this.movies.findIndex((movie) => movie.title === title);
    if (movieIndex !== -1 && this.movies[movieIndex].available) {
      this.movies[movieIndex].available = false;
      this.rentedMovies.push(title);
      console.log("Rented Movies:", this.rentedMovies);
    } else {
      console.log("Movie not available for rent.");
    }
  }

  checkInMovie(title) {
    let rentedIndex = this.rentedMovies.indexOf(title);
    if (rentedIndex !== -1) {
      this.rentedMovies.splice(rentedIndex, 1);
      let movieIndex = this.movies.findIndex((movie) => movie.title === title);
      if (movieIndex !== -1) {
        this.movies[movieIndex].available = true;
      }
      console.log("Returned Movies:", title);
    } else {
      console.log("Movie is not rented.");
    }
  }
}

let kiosk = new RentalKiosk();
kiosk.rentMovie("Movie1");
kiosk.rentMovie("Movie2");
kiosk.checkInMovie("Movie1");
