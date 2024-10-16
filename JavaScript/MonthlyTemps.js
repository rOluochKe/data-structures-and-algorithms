// Modify the weeklyTemps object to store a month's worth of data using a two-dimensional array

function MonthlyTemps() {
  this.dataStore = []; // Two-dimensional array to store data for each week
  this.add = add;
  this.weekAverage = weekAverage;
  this.monthAverage = monthAverage;
  this.allWeeksAverage = allWeeksAverage;
}

function add(week, temp) {
  if (!this.dataStore[week]) {
    this.dataStore[week] = [];
  }
  this.dataStore[week].push(temp);
}

function weekAverage(week) {
  const temps = this.dataStore[week];
  const total = temps.reduce((acc, temp) => acc + temp, 0);
  return total / temps.length;
}

function monthAverage() {
  let total = 0;
  let count = 0;
  this.dataStore.forEach((week) => {
    if (week) {
      total += week.reduce((acc, temp) => acc + temp, 0);
      count += week.length;
    }
  });
  return total / count;
}

function allWeeksAverage() {
  let averages = [];
  this.dataStore.forEach((week) => {
    if (week) {
      const total = week.reduce((acc, temp) => acc + temp, 0);
      const average = total / week.length;
      averages.push(average);
    }
  });
  return averages;
}

var monthlyTemps = new MonthlyTemps();

monthlyTemps.add(0, 52);
monthlyTemps.add(0, 55);
monthlyTemps.add(0, 61);
monthlyTemps.add(0, 65);
monthlyTemps.add(0, 55);
monthlyTemps.add(0, 50);
monthlyTemps.add(0, 52);
monthlyTemps.add(0, 49);

console.log("Specific week average:", monthlyTemps.weekAverage(0));
console.log("Monthly average:", monthlyTemps.monthAverage());
console.log("All weeks averages:", monthlyTemps.allWeeksAverage());
