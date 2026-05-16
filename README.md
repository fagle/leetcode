## LeetCode Solutions

Personal LeetCode practice repository with Java, C++, and MySQL solutions.

### Layout

```text
.
├── src/main/java/me/nubi/leetcode      Java solutions by problem package
├── src/test/java/me/nubi/leetcode      Java unit tests by problem package
├── cppsrc                              C++ source files
├── CppSolution                         Visual Studio project for C++
├── mysql                               MySQL solutions and notes
├── gradle                              Gradle wrapper files
├── build.gradle                        Java build configuration
├── gradlew                             Gradle wrapper for Linux/macOS/Git Bash
└── gradlew.bat                         Gradle wrapper for Windows
```

### Java

This repository uses the standard Gradle Java layout. LeetCode Java solutions
are grouped by problem number:

```text
src/main/java/me/nubi/leetcode/q001/Solution.java
src/test/java/me/nubi/leetcode/q001/Q001Test.java
```

For LeetCode design problems where the submitted class name matters, keep that
class name inside the problem package. For example, problem 146 keeps
`q146/LRUCache.java`.

Shared algorithm notes that are not tied to a LeetCode problem live under
`src/main/java/me/nubi/leetcode/algorithms`.

Run Java tests on Windows:

```powershell
.\gradlew.bat test
```

### C++

`cppsrc` contains the C++ source files. `CppSolution` contains the Visual Studio
solution/project files that reference files from `cppsrc`.

### MySQL

MySQL answers are split by problem number in `mysql/`, for example `q175.sql`.
Keep one LeetCode problem per SQL file when adding new database solutions.

### Generated Files

Do not commit local build output, IDE folders, or Gradle cache directories such
as `build/`, `.gradle/`, `.gradle-user-home/`, and `.gradle-test-home/`.
