**MathBenchmark**

A very simple demonstration on jmh benchmark, comparing performance of division operation using two methods:
1. Direct division. i.e. divisor / divident = quotient
2. Multiplication. Only division by 10, 100, 1000, 10000 are supported. E.g.: x / 1000 = x * 10^-3

To run the benchmark:
1. Run 'gradle clean build'
2. Run 'gradle jmh'

Here is a sample output on my computer 

    >sysctl -n machdep.cpu.brand_string
    Intel(R) Core(TM) i7-6920HQ CPU @ 2.90GHz

**Result "multiplicationDivisionBenchmark":**

    4939969634523674.000 ±(99.9%) 48625679101920.000 ops/s [Average] 
    (min, avg, max) = (4755700978580218.000, 4939969634523674.000, 5022678090383719.000), stdev = 86432101907545.440
    CI (99.9%): [4891343955421754.000, 4988595313625594.000] (assumes normal distribution)

**Result "normalDivisionBenchmark":**
    
    4942193336877352.000 ±(99.9%) 60349158514116.000 ops/s [Average]   
    (min, avg, max) = (4480363882386684.500, 4942193336877352.000, 5039294121505138.000), stdev = 107270576268839.600
    CI (99.9%): [4881844178363236.000, 5002542495391468.000] (assumes normal distribution)
