############ Variable Assignment ##############
## The difference between '=' and '<-' assignment operators

# '=' objects will be defined within the scope of their functions
x = 1 
x
# '<-' objects will be defined within the scope of user workspace
y <- "Welcome R!"
y

##### Build-in functions samples #######
ls() # list objects in current workspace
rm(x) # remove object from current workspace
sqrt(16)
help(sqrt) # return information about the specified function
?sqrt # do the same as help()

# sequences
# sequence of numbers 1 to 10
x <- 1:10
seq(1, 10)
# seq(start, end, increment rate)
seq(1, 10, by = 2) 
# sequence of 6 numbers start from 8 and end at 20
seq(8, 20, length = 6)

#others
mean(x)
var(x)
# gets structure type about an object
str(x) 
# provide a collection of summary information about the object
summary(x) 

# repeat
rep(0,100) # repeats number 0 for 100 times
rep(1:3, 6) # repeats the sequence '1 2 3' 6 times

# Ex

##################### Data Types ##########################
#1# Vectors
# sequence of data elements of the same basic type.
a <- c(1,2,3)
a
b <- c("x","y","z")
b
c <- c("a", 3) # both are characters
c
str(c) 
str(a)

# Vector Arithmetics
x <- c(2,4,6)
y <- c(1,3,5)

x + y; x*5; y^2 # ';' needed to write multiple commands in one line

# vector index starts at 1 not 0
x[1]
x[-1] # removes the first element that's how a negative index work
x[5] # NA : Not defined cause it's out of range

#2# Matrix
# A two dimentinal array of data elements of the same basic type
A <- matrix(c(1,2,3,4,5,6), nrow = 2, ncol = 3, byrow = F)
B <- matrix(c(1,2,3,4), nrow = 2, byrow = T)
A[2,3]
t(A) # Transpose
solve(B) #inverse for square matrics

#3# Data Frames
# Store different object types organized in a set or rows and columns
# much like table data structure

df <- data.frame(c(1,2,3), c("x","y","z"), c(1.3,0.5,2.2))
df
str(df)
names(df) <- c("no.","name","degree")
df
