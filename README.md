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
  <li>
I felt more confident about my coding knowing that I had several tests for each function/feature that I made to make them more secure and functional. There is no real answer on how many unit tests should be made. The number of unit tests depends on the complexity of the function and also the number of scenarios that wanted to be tested. 

Having 100% code coverage does not mean that your code is free of bugs or errors. It only means your tests have covered most of your code have been tested, but not the edge cases, logic and complexity, system-level issues, and etc.
  </li>
  <li>
    Potential clean code issues:
    <ul>
      <li>Copying the setup procedures and instance variables mean that you need to rewrite the exact same code. That leads to a problem called Code Duplication.</li>
      <li>Creating multiple tests with similar procedures and instance variables decreases the readability and maintainability that will lead errors.</li>
    </ul>
    It is suggested to write the setup procedure and instance variables into reusable methods or functions make it reusable for more scenarios. Setup and teardown procedures are better to be automated reduce inefficiency and increase maintainability.
  </li>
</ol>
