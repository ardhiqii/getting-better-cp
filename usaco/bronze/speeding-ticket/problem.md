# USACO 2015 December Contest, Bronze — Problem 2. Speeding Ticket

Always the troublemaker, Bessie the cow has stolen Farmer John's tractor and
taken off down the road!

The road is exactly 100 miles long, and Bessie drives the entire length of the
road before ultimately being pulled over by a police officer, who gives Bessie
a ticket for exceeding the speed limit, for having an expired license, and for
operating a motor vehicle while being a cow. While Bessie concedes that the last
two tickets are probably valid, she questions whether the police officer was
correct in issuing the speeding ticket, and she wants to determine for herself
if she has indeed driven faster than the speed limit for part of her journey.

The road is divided into `N` segments, each described by a positive integer
length in miles, as well as an integer speed limit in the range `1…100` miles
per hour. As the road is 100 miles long, the lengths of all `N` segments add up
to 100. For example, the road might start with a segment of length 45 miles,
with speed limit 70, and then it might end with a segment of length 55 miles,
with speed limit 60.

Bessie's journey can also be described by a series of segments, `M` of them.
During each segment, she travels for a certain positive integer number of miles,
at a certain integer speed. For example, she might begin by traveling 50 miles
at a speed of 65, then another 50 miles at a speed of 55. The lengths of all
`M` segments add to 100 total miles. Farmer John's tractor can drive 100 miles
per hour at its fastest.

Given the information above, please determine the **maximum amount over the speed
limit** that Bessie travels during any part of her journey.

---

## Input Format (file: `speeding.in`)

- **Line 1:** `N` and `M`, separated by a space.
- **Next `N` lines:** Each contains two integers — a road segment's length and
  speed limit.
- **Next `M` lines:** Each contains two integers — a segment of Bessie's journey
  (length and driving speed).

---

## Output Format (file: `speeding.out`)

Output a single line containing the maximum amount over the speed limit Bessie
drove during any part of her journey. If she never exceeds the speed limit,
output `0`.

---

## Sample Input
```
3 3
40 75
50 35
10 45
40 76
20 30
40 40
```

## Sample Output
```
5
```

## Explanation

The road contains three segments: 40 miles at 75 mph, 50 miles at 35 mph, then
10 miles at 45 mph. Bessie drives for three segments: 40 miles at 76 mph, 20
miles at 30 mph, and 40 miles at 40 mph. During her first segment, she is
slightly over the speed limit, but her last segment is the worst infraction,
during part of which she is 5 mph over the speed limit.

---

*Problem credits: Austin Bannister and Brian Dean*
