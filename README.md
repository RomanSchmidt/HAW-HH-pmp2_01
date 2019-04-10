# Java PMP2_01

```
PR08 die Javanisten
Author: Roman Schmidt, Stanislaw Brug
```

# Task1
### Description
```
Class Complex with two variations Mutable and Immutable.
```

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

# Subtasks
## cafebabe Task
Long.toHexString(0x100000000L, 0xcafebabe)
### Java
Will return the same due to limit of Hex and turn around to it self.
### Ruby
This one seems to wrap in all dynamically to its own Int-Object which does theoretical
have no limit so we will get 7700658878.

# Task2
### Description
```
Mandel + Julia = Complex
```
### Packages
#### de.file
- utility class Manager with all file management methods
- utility class Parser as a domain for the parsing function
### de.mandelbrot
- Julia class to make sure the complex is within the julia set.
- Mandel class to make sure the complex is within the julia set.
### task
The while set logic from task 2.

##Subtasks
###1
Minuszahlen werden einen "Minusrest" zurück geben. Die richtige Berechnung wäre z.B. "!= 0".
###2

###3
Die erste Bitwise-XOR-Operation führt dazu, dass die ninäre zahl 11111000000 mit der 11111010001 verrechnet wird.
Das Ergebniss ist 10001. Damit werden die ersten 0-Werte weg geschnitten. Wenn die Operationen nach einander ausgeführt
werden, wird danach wieder mit den richtigen werten gerechnet und es findet wieder eine normale Vertauschung von
x und y statt. Da diese aber hintereinander stehen, wird scheinbar die 10001 weitergeführt und nach dem XOR mit 11111010001
führt es zu 0. Daher findet keine korrekte vertauschung mehr statt, sondern die Einszen wurden hier gekürzt
und es wird mit falschen Wert weiter vertauscht, so dass man im Endergebniss für x eine 0 bekommt und in y den Wert
von Startwert von x.
Wenn man diese Oprationen, wie gesagt, nach einander ausführen, würde nichts ausser eine Vertauschung von x und y
stattfinden.