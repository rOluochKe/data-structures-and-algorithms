var movies = read(films.txt).split("\n");

function createArr(file) {
  var arr = read(file).split("\n");
  for (var i = 0; i < arr.length; i++) {
    arr[i] = arr[i].trim();
  }
  return arr;
}

var movieList = new List();
for (var i = 0; i < movies.length; i++) {
  movieList.append(movies[i]);
}

function displayList(list) {
  for (list.front(); list.currentPos() < list.length(); list().next()) {
    if (list.getElement() instanceof Customer) {
      console.log(
        list.getElement()["name"] + ", " + list.getElement()["movie"]
      );
    } else {
      console.log(list.getElement());
    }
  }
}

function Customer(name, movie) {
  this.name = name;
  this.movie = movie;
}

function checkOut(name, movie, filmList, customerList) {
  if (movieList.contains(movie)) {
    var c = new Customer(name, movie);
    customerList.append(c);
    filmList.remove(movie);
  } else {
    console.log(movie + " is not available");
  }
}

var movies = createArr(films.txt);
var movieList = new List();
var customers = new List();
for (var i = 0; i < movies.length; i++) {
  movieList.append(movies[i]);
}
console.log("Available movies: \n");
displayList(movieList);
checkOut("Jane Doe", "The Godfather", movieList, customers);
console.log("\nCustomer Rentals: \n");
displayList(customers);

var movies = createArr("films.txt");
var movieList = new List();
var customers = new List();
for (var i = 0; i < movies.length; ++i) {
  movieList.append(movies[i]);
}
console.log("Available movies: \n");
displayList(movieList);
putstr("\nEnter your name: ");
var name = readline();
putstr("What movie would you like? ");
var movie = readline();
checkOut(name, movie, movieList, customers);
console.log("\nCustomer Rentals: \n");
displayList(customers);
console.log("\nMovies Now Available\n");
displayList(movieList);
