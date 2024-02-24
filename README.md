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

