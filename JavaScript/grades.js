// Create a grades object to store student grades and implement functions for adding a grade and displaying the average

const grades = {
  studentGrades: [],

  addGrade: function (grade) {
    this.studentGrades.push(grade);
  },

  displayAverage: function () {
    const totalGrades = this.studentGrades.reduce(
      (total, grade) => total + grade,
      0
    );
    const average = totalGrades / this.studentGrades.length;
    return average;
  },
};

// Example usage:
grades.addGrade(85);
grades.addGrade(90);
grades.addGrade(88);

console.log("Student's average grade:", grades.displayAverage());
