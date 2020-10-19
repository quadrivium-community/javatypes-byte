# Handling unsigned bytes in Java

In Java there is no unsigned concept, all integer primitive types are signed, including the byte primitive type.

Signed integer numbers are stored in memory in two's complement binary form. It all
depends on how many memory bytes/bits are used to store the number. Taking a scenario
where numbers are stored in **N** bits, then numbers from zero up to **(2^(N-1))-1** are stored directly
with no conversion, **bigger positive numbers cannot be stored**. Negative numbers are stored
by decrementing from zero, thus -1 value is always **(2^N)-1**. The lowest negative number that (N-1)
can be represented is **-2^(N-1)**.

For the byte case we have 8 bits, even though unsigned values for a byte range from zero up to 255, 
in Java it’s regarded as signed, thus they range from -128 up to 127. 
Notice -1 value is stored by decrementing zero so it will be stored as 255, -2 is stored as 254, and so on.

Problems arise when integers are type casted to bytes. 
This is a narrowing primitive conversion, for integers it works by copying the less significant bits. 
In this case, the eight less significant bits from the integer are copied to the byte. If the copied value is above 127 we end up with a negative byte value. 
Narrowing conversions may change the number and the signal.

The problem is not so much what is stored on the byte type but how it’s interpreted. 
The conversion of an integer value from 128 up to 255 to a byte results in what Java views as a negative number.
Converting back the byte to the original unsigned byte value it ́s easy. If Java sees it as a positive number (or zero), no conversion is required. 
If it’s negative, the original unsigned value can be obtained by adding 256.

Source: https://www.dei.isep.ipp.pt/~asc/tiny-papers/java-unsigned-bytes.pdf

## The reason

The reason for this approach is the optimization of hardware binary computations.
For example, in scope of the byte type we could add two binary numbers 10000000 (-128) and 01111111 (127). 
The result is of XOR operation will be the 11111111, which is regularly decimal 255, but for the byte it is interpreted as -1, what is correct.
The inverted logic of the byte gives the optimization for the hardware.
