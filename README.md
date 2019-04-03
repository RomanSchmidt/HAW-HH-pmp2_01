# Java PMP2_01

```
PR08 die Javanisten
Author: Roman Schmidt, Stanislaw Brug
```

### Description
Class Complex with two variations Mutable and Immutable.

#### Mutable
Returns in each arithmetical function its own instance. Each Operation provides
change to own instance variables.

#### Immutable
Each operation returns a new Instance of Immutable. No changes possible to own
Instance.

## Arithmetical Operations by Complex Object
- plus
- minus
- divides
- multiply
- conjugate
- scale

## Properties of Complex Object
- real
- imag
- absolute

## Arithmetical Operations by MathUtils
No change of the Object
- angleDegrees
- angleRadiant
- cos
- sin
- tan
- exp
- phase
- reciprocal

## Converts
- MathUtils.getCartesianFromPolar
- MathUtils.getPolarFromCartesian
- Cartesian.getPolar
- Polar.getCartesian

## STD Functions
- equals
- hashCode

## Properties

### Structs
- Polar
- Cartesian

### Types
- cartesian
- polar

# cafebabe Task
Long.toHexString(0x100000000L, 0xcafebabe)
## Java
Will return the same due to limit of Hex and turn around to it self.
## Ruby
This one seems to wrap in all dynamically to its own Int-Object which does theoretical
have no limit so we will get 7700658878.