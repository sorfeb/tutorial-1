# Pemrograman Lanjut
> [Deployed Website](https://eshop-sorfeb-adpro-tutorial-1.koyeb.app/)
> #### Soros Febriano (2206083445)
> #### Kelas B

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=bugs)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=coverage)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1) [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=sorfeb_tutorial-1&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=sorfeb_tutorial-1)

## Modul 1: Coding Standards
<details>
  <summary>Answers</summary>
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
</details>

## Modul 2: Continuous Integration, DevOps
<details>
  
<summary> Answers </summary>

  ### 1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
  
  There were several code quality issues that I fixed to improve my coding.
  
  - #### Unused Code
      **Issue:** Unused variables and imports
      **Fix:** Check each files for unused imports and variables, then delete them.
     
  - #### Inconsistent Formatting
     **Issue:** Incosistent spacings and indents
     **Fix:** Use the camelCase formatting for name variables and indets for function and method codes
     
  - #### Poor Test Coverage:
    **Issue:** Insufficient test coverage leaves the code vulnerable to bugs and regressions.
    **Fix:** Write unit tests to cover critical functionality and edge cases. Integrate automated testing into the CI/CD pipeline toensure tests are run regularly.

 ### 2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
My workflows have fulfilled several criterias of Continous Integration and Continous Deployment.

**CI Criteria:**
- Changes are automatically built and tested upon each push to version control. (yml files)
- Automated tests run to validate the changes. (jacoco, SonarCloud, JUnit)
  
**CD Criteria:**
- Are changes automatically deployed to production environments after passing CI. (Koyeb)
- Deployment process automated, reliable, and consistent. (Koyeb)
 
    
</details>

## Module 3 - Maintainability & OO Principles
<details>
  <summary>
    Answers
  </summary>

  ### 1. Explain what principles you apply to your project
  - #### Single Responsibility Principle (SRP)
  Pada CarController dan ProductController sekaligus juga di class model Product dan Car, setiap hal tersebut punya responsibilitynya masing-masing. Product bertanggung jawab untuk meng-handle product-related properties and behaviors, dan Car bertanggung jawab untuk meng-handle car-related properties and behaviors. Selain itu sebelumnya di CarController yang extends ProductController dan juga terletak di satu file ProductController, ini mengakibatkan akses endpoint yang tidak diinginkan, seperti misalnya apabila diakses endpoint localhost:8080/car/list dia malah mengakses CarListPage dimana ini aneh karena kita ingin menseparate responsibility antara CarController dan ProductController yang bertanggung jawab atas bagiannya masing-masing.
  
  - #### Open Closed Principle (OCP)
  class `Product` diextend oleh class `Car` karena mempunyai atribut yang sama seperti `productId`, `productName`, dan `productQuantity`. Akan tetapi, class `Car` mempunyai atribut tambahan sendiri, yaitu `color`. 
  
  - #### Liskov Substitution Principle (LSP)
  Sebeleum class `CarController` dan `ProductController` dipisah, class `CarController` dipakai menjadi subclass `ProductController`. Hal ini melanggar LSP karena proses-proses untuk memodifikasi Car lebih cocok diimplementasikan oleh class `CarController` saja, bukan turunan dari `ProductController`. Oleh karena itu, lebih baik kedua kelas tersebut dipisah. 
  
  - #### Interface Segregation Principle (ISP)
  Saya membuat kelas interface baru bernama `TemplateRepository` yang berisi fungsi-fungsi dasar untuk membuat atau memodifikasi data-data `Product` (Superclass dari `Car`). Hal ini menjadi pedoman bari fungsi-fungsi yang diimplementasi pada kelas `CarRepository` dan `ProductRepository` sesuai dengan kebutuhan masing-masing.
  
  - #### Dependency Inversion Principle (DIP)
  Kelas-kelas repository car dan product dependent kepada `CarService` atau `ProductService`, bukan kepada implementasi kelas service masing-masing.
  
  ### 2. Explain the advantages of applying SOLID principles to your project with examples.
  - Dengan membuat template repository, saya lebih mudah membuat kelas repository bagi model baru karena terdapat pedoman apa saja kelas yang harus diimplementasi bagi model baru.
  - Dengan memisahkan Controller menjadi CarController, ProductController, dan HomeController, kode menjadi lebih terorganisir karena tahu kelas mana yang harus diperbaiki (_easier debugging_)
  - Dengan membuat `Car` subclass `Product`, saya tidak mengulang atribut-atribut yang sama dua kali, karena pada hakikatnya `Car` memiliki beberapa atribut yang sama dengan `Product`.
  - Dengan mengubah dependensi para repository ke para interface, maka pemeliharaan kode lebih gampang karena sedikit pengubahan pada kode interface tersebut tidak akan berdampak fatal ke kode repository.
  - 
  ### 3. Explain the disadvantages of not applying SOLID principles to your project with examples.
  - Kode yang tidak mematuhi SOLID cenderung memiliki struktur yang kompleks dan sulit dipahami.
  - Kode yang tidak mematuhi SOLID cenderung kurang fleksibel dan sulit dimodifikasi. Ketika ada perubahan atau penambahan fitur, pengembang harus mengubah banyak bagian kode, yang meningkatkan risiko kesalahan dan waktu pengembangan yang lebih lama.
  -  Tanpa SOLID, ada kecenderungan untuk adanya duplikasi kode di berbagai bagian sistem. Hal ini tidak hanya membuat kode sulit dipelihara, tetapi juga meningkatkan risiko bug dan kesalahan konsistensi.
  -  Ketika tim pengembang bekerja pada proyek yang tidak mematuhi SOLID, akan sulit untuk berkolaborasi secara efektif. Perbedaan dalam gaya dan pendekatan pengembangan akan meningkatkan kompleksitas dan memperlambat progres proyek.

</details>

## Module 4 - Refactoring and TDD

<details>
  <summary>
    Answers
  </summary>

  ### 1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.
  
  #### Correctness
  1. Do I have **enough functional** tests to reassure myself that my application really **works, from the point of view of the user**?
     - I felt I had enough functional tests that I felt that my application works.
  2. *Am I testing all the edge cases* thoroughly?
     - All edge cases have been tested on the tests except for `null` situations for `OrderRepository`.
  3. Do I have tests that check whethter **all my components fit together** properly? Could some integrated tests do this, or are functional tests enough?
     - Yes the functional tests is enough to check the integration between components because the code has already integrated with each other.
     
  #### Maintanability
  1. Are my tests giving me the confidence to refactor my code, fearlessly and frequently?
     - Yes, by writing the tests I know what to refactor, add, or remove from my code because I know the positive and negative cases for the code.
  3. Are my tests helping me to drive out a good design? If I have a lot of integration tests but less unit tests, do I need to make more unit tests to get better feedback on my code design?
     - Yes the tests are helping to drive out a good design because now I know what is right and wrong results of the algorithm. Yes, because you need to make sure tests cover as much aspect of the code as you can. 
     
     
  #### Productive Workflow
  1. Are my feedback cycles as fast as I would like them? When do I get warned about bugs, and is there any practical way to make that happen sooner?
     - Yes, because the testing library tells me errors and bugs after running the tests. If I want it to happen sooner, I could just review my test code algorithms and implement it when writing new features.
  2. Is there some way that I could write faster integration tests that would get me feedback quicker?
     - Only focus on writing tests that are used often and integrated or prone to errors and bugs. 
  3. Can I run a subset of the full test suite when I need to?
     - Yes, you can select tests to run during situations when you have a feeling that the test will fail or prone to error or you know other tests are confident enough to pass.
  4. Am I spending too much time waiting for tests to run, and thus less time ina productive flow state?
     - Yes and no. You can implement code while the tests running, but if you have reached *coder's block* after not knowing what to do, then maybe you need to wait the tests to run to have a thorough explanation.
       
  ### 2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
  - FIRST
    - My tests are already integrated with the CI/CD pipelene and separated into unit tests and functional tests, allowing faster test runs without interrupting workflow.
  - ISOLATED/INDEPENDENT
    - My tests are already independent thanks to setUp and tearDown codes avoiding interference to state of functions.
  - REPEATABLE
    - My tests are able to run repeatedly thanks to JUnit and fulfillment of the Isolated/Indepent aspect. 
  - SELF-VALIDATING
    - By using `org.junit.jupiter.api.Assertions.*;` library, my tests are already self-validating and contains human-readable assertions.
  - THOROUGH/TIMELY
    - My tests are designed with happe and unhappy paths, covering different scenarios, and also made before coding new features.
  
</details>

