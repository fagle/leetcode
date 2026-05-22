## LeetCode 题解

个人 LeetCode 刷题仓库，主要包含 Java、C++ 和 MySQL 题解。

### 目录结构

```text
.
├── src/main/java/me/nubi/leetcode      Java 题解，按题号分包
├── src/test/java/me/nubi/leetcode      Java 测试，按题号分包
├── cppsrc                              C++ 源码
├── CppSolution                         C++ 的 Visual Studio 工程
├── mysql                               MySQL 题解和笔记
├── gradle                              Gradle Wrapper 文件
├── build.gradle                        Java 构建配置
├── gradlew                             Linux/macOS/Git Bash 使用的 Gradle Wrapper
└── gradlew.bat                         Windows 使用的 Gradle Wrapper
```

### Java

Java 部分使用标准 Gradle 项目结构。LeetCode 题解按题号分包：

```text
src/main/java/me/nubi/leetcode/q001/Solution.java
src/test/java/me/nubi/leetcode/q001/Q001Test.java
```

如果是 LeetCode 设计类题目，提交类名有特殊要求，就在对应题号包里保留原类名。比如第 146 题保留为 `q146/LRUCache.java`。

不绑定具体题号的算法笔记放在 `src/main/java/me/nubi/leetcode/algorithms`。

Windows 下运行 Java 测试：

```powershell
.\gradlew.bat test
```

### C++

`cppsrc` 存放 C++ 源码。`CppSolution` 存放 Visual Studio 解决方案和工程文件，工程文件引用 `cppsrc` 里的源码。

### MySQL

MySQL 题解放在 `mysql/` 下，按题号拆分，例如 `q175.sql`。新增数据库题时，保持一题一个 SQL 文件。

### 生成文件

不要提交本地构建产物、IDE 配置目录和 Gradle 缓存目录，例如 `build/`、`.gradle/`、`.gradle-user-home/`、`.gradle-test-home/`。
