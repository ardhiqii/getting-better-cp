# USACO 2019 February Contest, Bronze — Problem 3. Measuring Traffic

The highway adjacent to Farmer John's farm has recently seen a dramatic increase
in traffic, or at least so it seems to Farmer John. To be sure, he wants to
measure the traffic flow on the highway with a set of **sensors**, each capable of
measuring the rate of flow of traffic on a segment of road.

Unfortunately, while walking through the barn one day, Farmer John trips and
drops his box of sensors into a large vat of milk, after which they no longer
work as well. Instead of producing a single exact reading of traffic flow rate,
each sensor now outputs a **range** of possible values. For example, a sensor might
output the range `[7, 13]`, indicating that the rate of traffic flow on a
segment of road is no less than 7, and no greater than 13.

The highway runs for `N` miles next to the farm, and traffic on the highway only
flows in one direction, from mile 1 towards mile `N`. Farmer John wants to
install `N` sensors — one for each 1-mile segment of the highway.

- In some segments, there are **on-ramps** that allow traffic to enter the highway;
  Farmer John installs his sensor on the on-ramp to measure (approximately) the
  amount of incoming traffic.
- In some segments there are **off-ramps** that allow traffic to exit the highway;
  Farmer John installs his sensor on the off-ramp.
- Each segment contains **at most one ramp**. If there is no on-ramp or off-ramp,
  Farmer John installs a sensor on the main highway itself.

Given the readings from Farmer John's `N` sensors, determine the **most specific
possible ranges** that describe:
1. The rate of traffic flow initially on the highway **prior to mile 1**.
2. The rate of traffic flow continuing on the highway **past mile N**.

These ranges should be consistent with all `N` sensor readings.

---

## Input Format (file: `traffic.in`)

The first line contains `N` (`1 ≤ N ≤ 100`).

Each of the next `N` lines describes a 1-mile segment, in order from mile 1 to
mile `N`. Each line contains:
- A string: `"on"`, `"off"`, or `"none"`
- Two integers in the range `0…1000`: the lower and upper endpoints of the
  sensor range.

At least one segment will be designated as `"none"`.

---

## Output Format (file: `traffic.out`)

- **Line 1:** Two integers — the range of traffic flow prior to mile 1.
- **Line 2:** Two integers — the range of traffic flow after mile N.

A valid solution is always guaranteed to exist.

---

## Sample Input
\```
4
on 1 1
none 10 14
none 11 15
off 2 3
\```

## Sample Output
\```
10 13
8 12
\```

## Explanation

Segments 2 and 3 tell us the flow rate is in the range `[11, 14]` (intersection of
`[10, 14]` and `[11, 15]`).

- **Mile 1:** 1 unit enters → prior to mile 1, flow rate is `[10, 13]`.
- **Mile 4:** 2–3 units exit → after mile N, flow rate is `[8, 12]`.

---

*Problem credits: Brian Dean*