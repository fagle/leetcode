#pragma once

#include <exception>
#include <functional>
#include <iostream>
#include <stdexcept>
#include <string>
#include <vector>

namespace testlite {

struct TestCase {
    const char* name;
    void (*run)();
};

inline std::vector<TestCase>& Registry() {
    static std::vector<TestCase> tests;
    return tests;
}

struct Registrar {
    Registrar(const char* name, void (*run)()) {
        Registry().push_back({name, run});
    }
};

class AssertionFailure : public std::runtime_error {
public:
    explicit AssertionFailure(const std::string& message)
        : std::runtime_error(message) {
    }
};

inline void Assert(bool condition, const char* expression, const char* file, int line) {
    if (condition) return;
    throw AssertionFailure(std::string(file) + ":" + std::to_string(line) + ": assertion failed: " + expression);
}

inline int RunAllTests() {
    int failed = 0;
    for (const auto& test : Registry()) {
        try {
            test.run();
            std::cout << "[PASS] " << test.name << std::endl;
        } catch (const std::exception& error) {
            ++failed;
            std::cerr << "[FAIL] " << test.name << ": " << error.what() << std::endl;
        } catch (...) {
            ++failed;
            std::cerr << "[FAIL] " << test.name << ": unknown exception" << std::endl;
        }
    }

    std::cout << Registry().size() - failed << "/" << Registry().size() << " tests passed" << std::endl;
    return failed == 0 ? 0 : 1;
}

} // namespace testlite

namespace vl {
}

#define TESTLITE_JOIN_IMPL(A, B) A##B
#define TESTLITE_JOIN(A, B) TESTLITE_JOIN_IMPL(A, B)

#define TEST_CASE(NAME) \
    static void NAME(); \
    namespace { testlite::Registrar TESTLITE_JOIN(test_registrar_, NAME)(#NAME, &NAME); } \
    static void NAME()

#define TEST_ASSERT(CONDITION) ::testlite::Assert(static_cast<bool>(CONDITION), #CONDITION, __FILE__, __LINE__)
#define TEST_PRINT(MESSAGE) do { std::cout << MESSAGE << std::endl; } while (0)
#define TEST_ERROR(STATEMENT) \
    do { \
        bool testlite_caught_exception = false; \
        try { STATEMENT; } \
        catch (...) { testlite_caught_exception = true; } \
        TEST_ASSERT(testlite_caught_exception); \
    } while (0)
#define TEST_EXCEPTION(STATEMENT, EXCEPTION, ASSERT_FUNCTION) \
    do { \
        bool testlite_caught_exception = false; \
        try { STATEMENT; } \
        catch (const EXCEPTION& e) { testlite_caught_exception = true; ASSERT_FUNCTION(e); } \
        TEST_ASSERT(testlite_caught_exception); \
    } while (0)
