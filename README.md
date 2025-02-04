# RestTemplate Study #

This repo is dedicated to understand the use of the components RestTemplate and WebClient in Spring environment.

### Concept ###

Component capable of communicating with APIs, simple and really basic use compared to another languages like Typescript and Python.

RestTemplate is capable of doing synchronous and simple connections. In contrast we have WebClient, the asynchronous version, that is way more simple to write and has built-in methods far more easily accessible than RestTemplate.

In my opinion WebClient is the best choice if you don't know any Components. The reason for that is that you write it a lot faster andyou can understand what you are doing as well it is <b>WAY</b> more flexible. The most frustrating examples when I was testing the Put method in RestTemplate and couldn't return any String, it is easy to implement this return, but with WebClient it is easier.

This paper doesn't contain any technical information about both components as I don't intend to compare the hardware use of it, the point is to show how are the different ways to communicate with RESTful applications using Java SpringBoot ecosystem.

# End #