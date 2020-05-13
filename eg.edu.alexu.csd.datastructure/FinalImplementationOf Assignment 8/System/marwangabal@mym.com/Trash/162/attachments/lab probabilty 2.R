library(datasets)
library(dplyr)
data("iris")
iris
names(iris)
head(iris)
A=select(iris,'Sepal.Length','Sepal.Width','Species')
A


b= head(filter(iris, Species == "setosa"))
c=head(filter(iris, Species == "versicolor"))
d=head(filter(iris, Species == "virginica"))
b
c
d
average = mean(iris$Sepal.Length)

filter(iris, Sepal.Length > average)

x = iris[order(-iris['Petal.Width']),]

head(iris[order(-iris['Petal.Width']),], 5)
