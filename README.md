<h2>Reflection 1</h2>

The source code of my edit-product and delete-product features are functional but it was hard to read and to debug because of clean code principles and secure coding principles that I haven't implemented. The following are the principles that I implemented after realizing my mistake to make a better program: 
<h3>Clean Code Principles:</h3>
<ol>
  <li>Meaningful Variable and Function Names:</li>
  I changed my all of variable names and function names to be more descriptive while also keeping it concise. This allows me to directly understand what is the objective of the function and also the use of the variable quickly.

  <li>Single Responsibility Principle</li>
  I made sure that each of my functions or methods only does one job and it does it's job well. For example: findById() function that finds the specific Product object inside an ArrayList that matched the ID String.

  <li>Consistent Formatting and Indentation</li>
  I consistently added indents or spacing accordingly to function logics, variable names, methods, and etc to make it easier to read.
</ol>
<h3>Secure Coding Principles</h3>
<ol>
  <li>Secure Coding Libraries and Frameworks</li>
  Using secure libraries for functions or methods
  <li>Input Validation</li>
  I made sure there are no negative values for quantities and also made sure all of each variables are only bound to one type.
</ol>
After implementing those principles and practices, I overcame the problems, bugs, and errors that arises like: null Products, hard to read codes, and also functions with flawed logic. Further testing and debugging also improved my coding like: disable autogenerate UUID (Product ID) if Product ID is already available and also return Exception if quantity is negative.

<hr>

<h2>Reflection 2</h2>
<ol>
<li> After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? </li>
<li> Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. 
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! Please write your reflection inside the repository's README.md file. </li>
</ol>
