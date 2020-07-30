setwd("C:\\Users\\CS\\Desktop")
mydata <- read.csv("data.csv") 
mydata
names(mydata)
head(mydata,n=2)
tail(mydata ,n=2)
######basic graphics###############
plot(mydata$name,mydata$height)
plot(mydata$name,mydata$height,main="name vs height",xlab="names",
     ylab="height" ,col="red")
hist(mydata$height,breaks = 7,col = "red",main = "height frequancy")
d<-density(mydata$height)
plot(d)