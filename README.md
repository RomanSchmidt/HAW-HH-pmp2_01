# Java PMP2_01

```
PR08 die Javanisten
Author: Roman Schmidt, Stanislaw Brug
```

# Aufgabe 1.1
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

# Aufgabe 1.2
## cafebabe Task
Long.toHexString(0x100000000L, 0xcafebabe)
# Aufgabe 1.4
### Java
Will return the same due to limit of Hex and turn around to it self.
### Ruby
This one seems to wrap in all dynamically to its own Int-Object which does theoretical
have no limit so we will get 7700658878.

# Aufgabe 2
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

### Aufgabe 2.1
Minuszahlen werden einen "Minusrest" zurück geben. Die richtige Berechnung wäre z.B. "!= 0".
### Aufgabe 2.2
    Siehe Aufgabe 3.3
### Aufgabe 2.3
Die erste Bitwise-XOR-Operation führt dazu, dass die ninäre zahl 11111000000 mit der 11111010001 verrechnet wird.
Das Ergebniss ist 10001. Damit werden die ersten 0-Werte weg geschnitten. Wenn die Operationen nach einander ausgeführt
werden, wird danach wieder mit den richtigen werten gerechnet und es findet wieder eine normale Vertauschung von
x und y statt. Da diese aber hintereinander stehen, wird scheinbar die 10001 weitergeführt und nach dem XOR mit 11111010001
führt es zu 0. Daher findet keine korrekte vertauschung mehr statt, sondern die Einszen wurden hier gekürzt
und es wird mit falschen Wert weiter vertauscht, so dass man im Endergebniss für x eine 0 bekommt und in y den Wert
von Startwert von x.
Wenn man diese Oprationen, wie gesagt, nach einander ausführen, würde nichts ausser eine Vertauschung von x und y
stattfinden.

# Aufgabe 3
### Aufgabe 3.1.1
in de.task.Task3

### Aufgabe 3.1.2
Quelle: https://stackoverflow.com/questions/22644079/how-to-convert-a-double-number-to-binary-number-in-java
System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(Math.E)));

### Aufgabe 3.2
In Java gibt es bis auf char eigentlich keine unsigned Datentypen. Über die explizite Typumwandlung (cast) lässt sich byte jedoch als vorzeichenloser Datentyp nutzen. Bei einer expliziten Typumwandlung nach byte lässt sich also der Wertebereich 0-255 in 8 Bit Kodieren.
Im Beispiel wird das Integer -1 nach byte gecastet. Das hat zur Folge, dass von den 32 Bit des Integers die vorderen 24 einfach verworfen werden.

Int i = -1	entspricht binär: 11111111111111111111111111111111
(byte) -1	entspricht binär: 11111111	entspricht jedoch dezimal: 255

Bei einem cast nach char werden aus den 8 Bit des byte 16 Bit generiert. Es werden also vor die 8 Einsen wieder 8 Einsen angefügt.
(byte) -1		entspricht binär: 11111111
(char) (byte) -1		entspricht binär: 1111111111111111

Der höchste mögliche Wert in unsigned 8 Bit wird also übersetzt zum höchstmöglichen Wert in unsigned 16 Bit. Beim Cast nach int wird jedoch mit Nullen aufgefüllt.
(Int) (char) (byte) -1	entspricht binär: 00000000000000001111111111111111
entspricht dezimal: 65535
Die Ausgabe 65535 entspricht der generierten Zahl dezimal.

Quelle: http://openbook.rheinwerk-verlag.de/javainsel/22_001.html: 22.1.5 Vorzeichenlos arbeiten

### Aufgabe 3.3
Die Ausgabe des Programms lautet:
Ha169
Der Grund dafür ist, dass („H“ + „a“) als String-Verkettung ausgeführt wird und (`H` + `a`) als Addition der hexadezimal Werte der Unicode-Tabelle.
0x48 + 0x61 = 0xA9	entspricht dezimal: 169